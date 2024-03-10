package com.abhi.coding.algorithms.dynamicprogramming;

/**
 * In a given integer array and a capacity of knapsack, find the maximum profit possible.
 * And now it is allowed to choose any single item multiple times
 */
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] itemWeight = {2, 4, 5, 7, 3};
        int[] itemValue = {3, 10, 4, 15, 8};
        int capacity = 6;
        System.out.println("Unbounded Knapsack Problem Output: " + unboundedKnapsack(itemWeight, itemValue, capacity, itemWeight.length));
    }

    public static int unboundedKnapsack(int[] itemWeight, int[] itemValue, int capacity, int n) {
        int[][] t = new int[n + 1][capacity + 1];
        for (int i = 0; i < n + 1; i++) {
            t[i][0] = 0;
        }
        for (int j = 0; j < capacity + 1; j++) {
            t[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                if (itemWeight[i - 1] <= j) {
                    // As in unbounded knapsack, we have the flexibility to choose the same item multiple
                    // so, we processed the item at ith level multiple times to find the maximum profit
                    t[i][j] = Math.max(itemValue[i - 1] + t[i][j - itemWeight[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][capacity];
    }
}

package com.abhi.coding.algorithms.dynamicprogramming;

import java.util.Arrays;

public class KnapsackMemoization {
    static int[][] t;

    public static void main(String[] args) {
        //input
        int[] itemWeight = {2, 4, 1, 7, 3};
        int[] itemValue = {10, 4, 7, 1, 8};
        int capacity = 6;

        //Memset
        t = new int[itemWeight.length + 1][capacity + 1];
        Arrays.stream(t).forEach(row -> Arrays.fill(row, -1));

        long startTime = System.currentTimeMillis();
        int knapsackOutput = knapsack(itemWeight, itemValue, capacity, itemWeight.length);
        System.out.println("Memoization Solution Execution time: " + (System.currentTimeMillis() - startTime));
        System.out.println("0/1 Knapsack Problem Output: \nMax Profit: " +
                +knapsackOutput);
    }

    /**
     * @param itemWeight
     * @param itemValue
     * @param capacity
     * @param n
     * @return
     */
    private static int knapsack(int[] itemWeight, int[] itemValue, int capacity, int n) {
        // Boundary Condition
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (t[n][capacity] != -1) {
            return t[n][capacity];
        }

        if (itemWeight[n - 1] <= capacity) {
            return t[n][capacity] = Math.max(itemValue[n - 1] + knapsack(itemWeight, itemValue, capacity - itemWeight[n - 1], n - 1),
                    knapsack(itemWeight, itemValue, capacity, n - 1));
        } else {
            return t[n][capacity] = knapsack(itemWeight, itemValue, capacity, n - 1);
        }
    }
}

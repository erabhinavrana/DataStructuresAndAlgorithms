package com.abhi.coding.algorithms.dynamicprogramming;

public class Knapsack {

    public static void main(String[] args) {
        int[] itemWeight = {2, 4, 1, 7, 3};
        int[] itemValue = {10, 4, 7, 1, 8};
        int capacity = 6;

        long startTime = System.currentTimeMillis();
        int knapsackOutput = knapsack(itemWeight, itemValue, capacity, itemWeight.length);
        System.out.println("Recursive Solution Execution time: " + (System.currentTimeMillis() - startTime));
        System.out.println("0/1 Knapsack Problem Output: \nMax Profit: " +
                +knapsackOutput);
    }

    private static int knapsack(int[] itemWeight, int[] itemValue, int capacity, int n) {
        // Base condition
        if (n == 0 || capacity == 0) {
            return 0;
        }

        // Choice Diagram
        if (itemWeight[n - 1] <= capacity) {
            return Math.max((itemValue[n - 1] + knapsack(itemWeight, itemValue, capacity - itemWeight[n - 1], n - 1)),
                    knapsack(itemWeight, itemValue, capacity, n - 1));
        } else {
            return knapsack(itemWeight, itemValue, capacity, n - 1);
        }
    }
}

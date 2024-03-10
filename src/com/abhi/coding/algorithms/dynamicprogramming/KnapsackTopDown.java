package com.abhi.coding.algorithms.dynamicprogramming;

public class KnapsackTopDown {
    public static void main(String[] args) {
        int[] itemWeight = {2, 4, 1, 7, 3};
        int[] itemValue = {5, 8, 3, 1, 6};
        int capacity = 6;
        long startTime = System.currentTimeMillis();
        int knapsackOutput = knapsack(itemWeight, itemValue, capacity, itemWeight.length);
        System.out.println("Top-Down Solution Execution time: " + (System.currentTimeMillis() - startTime));
        System.out.println("0/1 Knapsack Problem Output: \nMax Profit: " +
                +knapsackOutput);
    }

    private static int knapsack(int[] itemWeight, int[] itemValue, int capacity, int n) {
        int[][] t = new int[n + 1][capacity + 1];
        // Initialization would be equivalent to the base condition of the recursive solution
        // Here i represents the weight array index and the j represents the capacity
//        for(int i=0; i< n+1; i++){
//            for (int j = 0; j < capacity + 1; j++) {
//                if (i == 0 || j == 0) {
//                    t[i][j] = 0;
//                }
//            }
//        }

        // convert the choice diagram to the iterative expression
//        if (itemWeight[n-1] <= capacity) {
//            return Math.max(itemValue[n-1] + knapsack(itemWeight, itemValue, capacity-itemWeight[n-1], n-1),
//                    knapsack(itemWeight, itemValue, capacity, n-1));
//        }else {
//            return knapsack(itemWeight, itemValue, capacity, n-1);
//        }

        // iterative version
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                //Initialization
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                    continue;
                }
                // Iterative representation of Choice Diagram
                if (itemWeight[i - 1] <= j) {
                    t[i][j] = Math.max(itemValue[i - 1] + t[i - 1][j - itemWeight[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][capacity];
    }
}

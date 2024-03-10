package com.abhi.coding.algorithms.dynamicprogramming.knapsackvariations;

/**
 * In a given integer array, is there any subset equals to the provided sum;
 * if yes then return the count of subset in the given array whose sum is equal to the provided sum
 */
public class SubsetSumCount {
    public static void main(String[] args) {
        int[] itemWeight = {2, 4, 1, 6, 3};
        int sum = 11;
        System.out.println("Subset Sum Count Problem Output: " + subsetSumCount(itemWeight, sum));
    }

    private static int subsetSumCount(int[] input, int w) {
        // Initialization
        int[][] t = new int[input.length + 1][w + 1];
        for (int i = 0; i < input.length + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        // Convert the choice diagram into Iterative
        for (int i = 1; i < input.length + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (input[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - input[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[input.length][w];
    }
}

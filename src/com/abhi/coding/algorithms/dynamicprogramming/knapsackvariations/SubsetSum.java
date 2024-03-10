package com.abhi.coding.algorithms.dynamicprogramming.knapsackvariations;

/**
 * In a given integer array, is there any subset equals to the provided sum;
 * if yes then return true otherwise return false
 */
public class SubsetSum {
    public static void main(String[] args) {
        int[] input = {2, 4, 1, 6, 3};
        int sum = 16;
        System.out.println("Subset sum problem output: " + subsetSum(input, sum));
    }

    /**
     * Subset sum solution using : Top-Down Approach
     *
     * @param input
     * @param sum
     * @return
     */
    private static boolean subsetSum(int[] input, int sum) {
        boolean[][] t = new boolean[input.length + 1][sum + 1];
        // This is an initialization of a Top-Down Matrix
        for (int i = 0; i < input.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = true;
                } else t[i][j] = i != 0;
            }
        }

        // This is to convert the choice diagram into an iterative expression
        for (int i = 1; i < input.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (input[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - input[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[input.length][sum];
    }
}

package com.abhi.coding.algorithms.dynamicprogramming.knapsackvariations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a given array of integer, find out the minimum subset sum difference
 */
public class MinimumSubsetSumDiff {
    public static void main(String[] args) {
        int[] input = {1, 2, 7};
        System.out.println("Minimum Subset Sum Difference Output: " + minimumSubsetSumDiff(input));
    }

    private static int minimumSubsetSumDiff(int[] input) {
        int sum = Arrays.stream(input).sum();

        // Run the subset sum algorithm to pick the possible subset sum for range vector
        boolean[][] t = new boolean[input.length + 1][sum + 1];
        for (int i = 0; i < input.length + 1; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i < input.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (input[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - input[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // Initialize the range vector with possible subset sum
        List<Integer> subsetSumRange = new ArrayList<>();
        for (int j = 0; j < sum / 2; j++) {
            if (t[input.length][j]) {
                subsetSumRange.add(j);
            }
        }

        // Calculate the minimum subset sum difference
        final int[] minimumSubsetSumDiff = {Integer.MAX_VALUE};
        subsetSumRange.forEach(i -> minimumSubsetSumDiff[0] = Math.min(minimumSubsetSumDiff[0], (sum - (2 * i))));
        return minimumSubsetSumDiff[0];
    }

}

package com.abhi.coding.algorithms.dynamicprogramming.knapsackvariations;

import java.util.Arrays;

/**
 * In a given integer array, find out the count of subsets whose difference would be equal to the
 * given number
 * Or
 * This problem is also known as Target Sum Count, where we need to assign the +/- sign in such a way
 * so that the sum of subset would come to give sum. Which actually nothing but a diff of subset after assigning
 * a sign
 */
public class SubsetSumDiffCount {
    public static void main(String[] args) {
        int[] input = {2, 4, 1, 6, 3};
        int diff = 2;
        System.out.println("Subset Sum Difference Count Output: " + subsetSumDiffCount(input, diff));
    }

    private static int subsetSumDiffCount(int[] input, int diff) {
        /*
            For a given difference of two subset sum, then mathematically
            if S1 - S2 = Diff then S1 + S2 = Sum (Total sum of a given input Array)
            So we can derive this from above two equations
            S1 = (Diff + Sum)/2

            Now if we know the sum of one subset, then we can easily get the count of subset available in the given array
            for that sum. By using SubsetSumCount Algorithm.

            And that would be the answer of our question
         */
        int inputSum = Arrays.stream(input).sum();
        if ((diff + inputSum) % 2 != 0) {
            return 0;
        }
        int sum = (diff + inputSum) / 2;

        int[][] t = new int[input.length + 1][sum + 1];
        for (int i = 0; i < input.length + 1; i++) {
            t[i][0] = 1;
        }

        // Convert the choice diagram into Iterative
        for (int i = 1; i < input.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (input[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - input[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[input.length][sum];
    }
}

package com.abhi.coding.algorithms.dynamicprogramming.knapsackvariations;

/**
 * In a given input integer array, is there an equal sum partition is possible
 * If yes, then return true else return false
 */
public class EqualSumPartition {
    public static void main(String[] args) {
        int[] itemWeight = {2, 4, 1, 7};
        System.out.println("Equal Sum Partition Output: " + equalSumPartition(itemWeight));
    }

    private static boolean equalSumPartition(int[] itemWeight) {
        int sum = 0;
        for (int value : itemWeight) {
            sum += value;
        }

        if (sum % 2 != 0) {
            return false;
        } else {
            return subsetSum(itemWeight, sum / 2);
        }
    }

    private static boolean subsetSum(int[] itemWeight, int sum) {
        boolean[][] t = new boolean[itemWeight.length + 1][sum + 1];
        for (int i = 0; i < itemWeight.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = true;
                } else t[i][j] = i != 0;
            }
        }

        for (int i = 1; i < itemWeight.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (itemWeight[i - 1] <= j) {
                    t[i][j] = t[i][j - itemWeight[i - 1]] || t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[itemWeight.length][sum];
    }
}

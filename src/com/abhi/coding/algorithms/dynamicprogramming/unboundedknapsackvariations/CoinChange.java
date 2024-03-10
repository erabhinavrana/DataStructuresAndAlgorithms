package com.abhi.coding.algorithms.dynamicprogramming.unboundedknapsackvariations;

/**
 * Coin Change Problem Maximum Number of ways
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins does not matter.
 * <p>
 * Example:
 * for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;
        System.out.println("Coin Change Max Possible ways output: " + coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        // Declarations and Initialization
        int[][] t = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[coins.length][amount];
    }
}

package com.abhi.coding.algorithms.dynamicprogramming.unboundedknapsackvariations;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;

/**
 * Coin Change Problem Minimum Numbers of coins
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 * <p>Example:
 * <p>
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 */
public class CoinChangeV2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;
        System.out.println("Coin Change output - Minimum Number of Coins: " + coinChange(coins, sum));
    }

    /**
     * 1. Declare an int array of size; row = coins array Length+1 and column = amount +1
     * int[][] t = new int[coins.length+1][amount+1];
     * <p>
     * 2. Initialize the dp array with default values
     * Case: When a coin array is empty, and we need an amount equal to column
     * then minimum number of coins needed is equivalent to INT_MAX-1
     * loop j=0 to amount+1; t[0][j] = INT_MAX-1;
     * <p>
     * Case: When a coin array is not empty, and we need an amount equal to 0
     * then, minimum number of coins needed is 0
     * Loop i=1 to coin array length +1; t[i][0] = 0;
     * <p>
     * Case: Only in this specific type of problem we need to initialize the second row as well.
     * Loop i=1; j=1 to amount+1;
     * Condition: if(j % coin[i-1] == 0) then t[1][j] = j/coin[i-1];
     * Else: t[1][j] = INT_MAX-1;
     * <p>
     * 3. Convert the choice diagram to iterative expression
     * Loop i=2 to coin array length +1; Loop j=1 to amount+1;
     * Condition:
     * if(coin[i-1] <= j)
     * then t[i][j] = MIN(t[i-1][j], t[i][j-coin[i-1]]+1)
     * Else:
     * t[i][j] = t[i-1][j];
     * <p>
     * 4. The Final answer would be
     * t[coin.length][amount]
     *
     * @param coins
     * @param amount
     * @return
     */
    private static int coinChange(int[] coins, int amount) {
        // Declaration & Initialization
        int[][] t = new int[coins.length + 1][amount + 1];

        for (int j = 0; j < amount + 1; j++) {
            t[0][j] = MAX_VALUE - 1;
        }

        for (int j = 1; j < amount + 1; j++) {
            if (j % coins[0] == 0) {
                t[1][j] = j / coins[0];
            } else {
                t[1][j] = MAX_VALUE - 1;
            }
        }

        for (int i = 2; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = min(1 + t[i][j - coins[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[coins.length][amount];
    }
}

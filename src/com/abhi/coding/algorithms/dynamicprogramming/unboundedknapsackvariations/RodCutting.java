package com.abhi.coding.algorithms.dynamicprogramming.unboundedknapsackvariations;


import static java.lang.Math.max;

/**
 * In a given array for the length of the rod pieces, and it's respective price for a given rod.
 * Cut the given rod in allowed pieces, so that we got maximum profit
 */
public class RodCutting {
    public static void main(String[] args) {
        int[] input = {1, 2, 4, 7};
        int[] price = {2, 6, 5, 8};
        int N = 5;
        System.out.println("RodCutting Maximum Profit Output: " + rodCutting(input, price, N));
    }

    /**
     * 1. Create a DP array name t of size; column = Length of an array of Rod piece + 1 & Row = Max allowed pieces + 1
     * <p>
     * 2. Initialize an DP array;
     * 2.1 Case: When max allowed pieces are 0, so no matter whatever piece value, profit will always be 0
     * For i = 0 to ROD_PIECE_ARR_LENGTH +1; t[i][0] = 0;
     * 2.2 Case: When the given array of rod piece is empty then whatever allowed piece, the final profit would be 0
     * 2.2.1 For j = 0 to MAX_ROD_SIZE + 1; t[0][j] = 0;
     * <p>
     * 3. Loop i = 1 to ROD_PIECE_ARR_LENGTH +1; & j = 1 to MAX_ROD_SIZE + 1;
     * <p>
     * 4. If piece size is greater than the allowed then move to another option
     * 4.1 t[i][j] = t[i-1][j]
     * <p>
     * 5. If piece size is less than or equal to the allowed then consider it one or many times depends upon the value
     * 5.1 t[i][j] = MAX(value[i-1][j] + t[i][j-inputArr[i-1]], t[i-1][j])
     * <p>
     * 6. Finally, the output would be
     * 6.1 t[ROD_PIECE_ARR_LENGTH][MAX_ROD_SIZE]
     *
     * @param input
     * @param price
     * @param N
     * @return
     */
    private static int rodCutting(int[] input, int[] price, int N) {
        int[][] t = new int[input.length + 1][N + 1];
        for (int i = 0; i < input.length + 1; i++) {
            t[i][0] = 0;
        }
        for (int j = 0; j < N + 1; j++) {
            t[0][j] = 0;
        }

        for (int i = 1; i < input.length + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (input[i - 1] <= j) {
                    t[i][j] = max(price[i - 1] + t[i][j - input[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[input.length][N];
    }

}

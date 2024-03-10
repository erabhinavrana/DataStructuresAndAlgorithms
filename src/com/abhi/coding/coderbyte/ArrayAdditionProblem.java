package com.abhi.coding.coderbyte;

import java.util.Arrays;

/**
 * Have the function ArrayAdditionI(arr) take the array of numbers stored in arr
 * and return the string true if any combination of numbers in the array can be
 * added up to equal the largest number in the array, otherwise return the string
 * false.
 * For example: if arr contains [4, 6, 23, 10, 1, 3] the output should
 * return true because 4 + 6 + 10 + 3 = 23.
 * The array will not be empty, will not contain all the same elements, and may contain negative numbers.
 * Examples:
 * Input: [5, 7, 16, 1, 2]
 * Output: false
 * Input: [3, 5, -1, 8, 12]
 * Output: true
 */
public class ArrayAdditionProblem {

    public static void main(String[] args) {
        int[] input = {5, 7, 16, 1, 2};
        System.out.println("Array Addition Problem Output: " + arrayAdditionProblem(input));
    }

    /**
     * input = {5, 7, 16, 1, 2}
     * after sorting = {1, 2, 5, 7, 16}
     * <p>
     * input = {3, 5, -1, 8, 12}
     * after sorting = {-1, 3, 5, 8, 12}
     *
     * @param input
     * @return
     */
    private static String arrayAdditionProblem(int[] input) {
        Arrays.sort(input);
        return String.valueOf(knapsackProblemVariation(input, input[input.length - 1], input.length - 1));
    }

    static boolean knapsackProblemVariation(int[] input, int largest, int length) {
        if (largest == 0) {
            return true;
        }

        if (length == 0) {
            return false;
        }

        return knapsackProblemVariation(input, largest - input[length - 1], length - 1)
                || knapsackProblemVariation(input, largest, length - 1);
    }
}

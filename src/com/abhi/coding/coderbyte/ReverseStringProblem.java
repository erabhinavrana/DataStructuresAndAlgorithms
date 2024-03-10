package com.abhi.coding.coderbyte;

/**
 * The challenge here is to reverse a given string.
 * The string can consist of whitespace and special symbols.
 */
public class ReverseStringProblem {
    public static void main(String[] args) {
        String inputStr = "te%st str^in!g$ &";
        System.out.println("Reverse String Problem: " + firstReverse(inputStr));
    }

    static String firstReverse(String inputStr) {

        int start = 0;
        int end = inputStr.length() - 1;
        char[] input = inputStr.toCharArray();

        while (start < end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;

            start++;
            end--;
        }

        return String.valueOf(input);
    }
}

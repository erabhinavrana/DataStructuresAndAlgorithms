package com.abhi.coding.coderbyte;

/**
 * Check if Valid Number of Parenthesis Problem
 * You are given a string with the symbols ( and ),
 * and you need to write a function that will determine if the parenthesis are correctly nested in the string,
 * which means every opening ( has a closing ).
 */
public class ParenthesisCheckProblem {
    public static void main(String[] args) {
        String inputStr = "(sample)str(ing()";
        System.out.println("Valid Number of Parenthesis Problem output: " + validNumberOfParenthesis(inputStr));
    }

    static boolean validNumberOfParenthesis(String inputStr) {
        char[] inputStrChar = inputStr.toCharArray();
        int count = 0;
        int start = 0;
        int end = inputStrChar.length - 1;
        while (start <= end) {
            if (inputStrChar[start] == '(' || inputStrChar[end] == '(') {
                count++;
            }
            if (inputStrChar[end] == ')' || inputStrChar[start] == ')') {
                count--;
            }
            start++;
            end--;
        }

        return count == 0;
    }
}

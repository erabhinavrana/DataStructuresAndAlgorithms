package com.abhi.coding.coderbyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Have the function FormattedNumber(strArr) take the strArr parameter being passed, which will only contain a single element,
 * and return the string true if it is a valid number that contains only digits with properly placed decimals and commas,
 * otherwise return the string false. For example: if strArr is ["1,093,222.04"] then your program should return the string true,
 * but if the input were ["1,093,22.04"] then your program should return the string false.
 * The input may contain characters other than digits.
 */
public class FormattedNumberProblem {
    public static void main(String[] args) {
        String input = "1,093,222.04";
        System.out.println("Formatted Number Problem Output: " + formattedNumber(input));
    }

    /**
     * This method takes the input string and checks if it is a valid number that contains only digits with properly placed decimals and commas.
     * Example: 1,093,222.04 -> true
     * Example: 1,093,22.04 -> false
     *
     * @param input
     * @return
     */
    private static String formattedNumber(String input) {
        Pattern pattern = Pattern.compile("^[0-9]{1,3}(,[0-9]{3})*(\\.[0-9]+)?$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches() ? "true" : "false";
    }

    //explain this regular expression in details
    //^[0-9]{1,3}(,[0-9]{3})*(\\.[0-9]+)?$
    //^ asserts the start of the string
    //[0-9]{1,3} matches a digit (equal to [0-9]) {1,3} Quantifier — Matches between 1 and 3 times, as many times as possible, giving back as needed (greedy)
    //(,[0-9]{3})* matches the comma and 3 digits 0 or more times
    //(\\.[0-9]+)? matches the decimal and 1 or more digits 0 or 1 time
    //$ asserts the end of the string
    //So, the regular expression matches a string that starts with 1 to 3 digits,
    // followed by 0 or more occurrences of a comma and 3 digits, and 0 or 1 occurrence of a decimal and 1 or more digits.
}

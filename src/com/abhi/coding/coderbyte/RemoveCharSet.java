package com.abhi.coding.coderbyte;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * An array of characters and a string B is given.
 * Write a function to return the string B with all the characters from the array removed.
 */
public class RemoveCharSet {
    public static void main(String[] args) {
        char[] input = {'a', 'e', 'i', 'o', 'u'};
        String inputStr = "Hello, Welcome to the CoderByte World!";
        System.out.println("Remove Character Problem: " + removeCharSet(input, inputStr));
    }

    static String removeCharSet(char[] input, String str) {
        Set<Character> characterSet = IntStream.range(0, input.length).boxed().map(i -> input[i]).collect(Collectors.toSet());

        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!characterSet.contains(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}

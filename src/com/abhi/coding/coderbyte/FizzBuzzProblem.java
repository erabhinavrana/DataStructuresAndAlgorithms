package com.abhi.coding.coderbyte;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Print all the numbers from 1 to 100.
 * However, for any number divisible by three, print the word “Fizz,”
 * for any number divisible by five, print the word “Buzz,”
 * and for any number divisible by both three and five, print the word “FizzBuzz.”
 */
public class FizzBuzzProblem {
    static IntPredicate fizz = input -> input % 3 == 0;
    static IntPredicate buzz = input -> input % 5 == 0;

    public static void main(String[] args) {
        List<String> resultList = new ArrayList<>();

        IntStream.range(1, 100).forEach(i -> {
            if (fizz.and(buzz).test(i)) {
                resultList.add("FizzBuzz");
            } else if (fizz.test(i)) {
                resultList.add("Fizz");
            } else if (buzz.test(i)) {
                resultList.add("Buzz");
            } else
                resultList.add(String.valueOf(i));
        });
        System.out.printf("Fizz Buzz Problem output: %s%n", resultList);
    }

}

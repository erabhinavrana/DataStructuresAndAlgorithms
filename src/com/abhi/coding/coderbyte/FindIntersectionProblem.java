package com.abhi.coding.coderbyte;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Given an array of strings, where each string is a sorted list of numbers separated by commas.
 * Return a comma-separated string of numbers common in both the strings of the array.
 */
public class FindIntersectionProblem {
    public static void main(String[] args) {
        String[] inputArr = {"11, 12, 14, 16, 20", "11, 12, 13, 18, 21"};
        System.out.println("Find Intersection Problem Output: " + findIntersection(inputArr));
    }

    static String findIntersection(String[] inputArr) {

        if (inputArr == null || inputArr.length != 2) {
            return null;
        }

        String[] firstStr = inputArr[0].split(",");
        String[] secondStr = inputArr[1].split(",");

        Set<Integer> resultSet = new TreeSet<>();
        int startPointA = 0;
        int startPointB = 0;

        while (startPointA < firstStr.length) {
            if (startPointB == secondStr.length) {
                startPointB = 0;
                startPointA++;
                continue;
            }
            if (firstStr[startPointA].equals(secondStr[startPointB])) {
                resultSet.add(Integer.valueOf(firstStr[startPointA].trim()));
                startPointA++;
            }
            startPointB++;
        }
        return resultSet.stream().map(Object::toString).collect(Collectors.joining(","));
    }
}

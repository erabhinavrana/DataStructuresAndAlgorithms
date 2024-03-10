package com.abhi.coding.coderbyte;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCachingProblem {
    public static void main(String[] args) {
        String[] inputArr = {"A", "B", "C", "B", "E", "F", "A", "D", "C", "B", "D", "E", "F", "A", "D"};
        int cacheSize = 5;
        System.out.println("LRU Caching Problem: " + LRUCache(inputArr, cacheSize));
    }

    private static String LRUCache(String[] input, int maxSize) {

        Deque<String> deque = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();

        for (String s : input) {
            if (!hashSet.contains(s)) {
                if (deque.size() == maxSize) {
                    hashSet.remove(deque.removeLast());
                }
            } else {
                deque.remove(s);
            }
            deque.push(s);
            hashSet.add(s);
        }

        return String.join("-", deque);

    }
}

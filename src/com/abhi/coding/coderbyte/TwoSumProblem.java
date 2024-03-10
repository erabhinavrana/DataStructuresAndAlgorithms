package com.abhi.coding.coderbyte;

import java.util.HashMap;

/**
 * An array and a number A is given. Determine if any two numbers within the array sum to A.
 */
public class TwoSumProblem {
    public static void main(String[] args) {
        int[] input = {1, 5, 2, 8, 4, 7};
        int inputNum = 15;
        System.out.println("Two Sum Problem Output: " + twoSumCheckUsingHashMap(input, inputNum));
    }

    /**
     * input = [1,5,2,8,4,7], num = 15
     * input[0] = 1, num - input[0] = 14, hashMap does not contain 14, so add 1 to hashMap
     * input[1] = 5, num - input[1] = 10, hashMap does not contain 10, so add 5 to hashMap
     * input[2] = 2, num - input[2] = 13, hashMap does not contain 13, so add 2 to hashMap
     * input[3] = 8, num - input[3] = 7, hashMap does not contain 7, so add 8 to hashMap
     * input[4] = 4, num - input[4] = 11, hashMap does not contain 11, so add 4 to hashMap
     * input[5] = 7, num - input[5] = 8, hashMap contains 8, so return true
     *
     * @param input
     * @param num
     * @return
     */
    static boolean twoSumCheckUsingHashMap(int[] input, int num) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i : input) {
            if (hashMap.containsKey(num - i)) {
                return true;
            }
            hashMap.put(i, true);
        }
        return false;
    }

}

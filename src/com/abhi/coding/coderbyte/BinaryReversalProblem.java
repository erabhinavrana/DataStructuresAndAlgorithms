package com.abhi.coding.coderbyte;

/**
 * Have the function BinaryReversal(str) take the str parameter being passed, which will be a positive integer,
 * take its binary representation (padded to the nearest N * bits),
 * reverse that string of bits, and then finally return the new reversed string in decimal form.
 * For example: if str is "47" then the binary version of this integer is 101111, but we pad it to be 00101111.
 * Your program should reverse this binary string which then becomes 11110100
 * and the finally return the decimal version of this string, which is 244.
 */
public class BinaryReversalProblem {
    public static void main(String[] args) {
        String input = "213";
        System.out.println("Binary Reversal Problem Output: " + binaryReversal(input));
    }

    /**
     * This method takes the input string and converts it to binary representation.
     * Then it reverses the binary representation and returns the decimal representation of the reversed binary string.
     * <p>
     * Example: 213 -> 11010101 -> 10101011 -> 171
     * i = 0 then bit = 1, result = 0 | (1 << 7) = 10000000
     * i = 1 then bit = 0, result = 10000000 | (0 << 6) = 10000000
     * i = 2 then bit = 1, result = 10000000 | (1 << 5) = 10100000
     * i = 3 then bit = 0, result = 10100000 | (0 << 4) = 10100000
     * i = 4 then bit = 1, result = 10100000 | (1 << 3) = 10101000
     * i = 5 then bit = 0, result = 10101000 | (0 << 2) = 10101000
     * i = 6 then bit = 1, result = 10101000 | (1 << 1) = 10101010
     * i = 7 then bit = 1, result = 10101010 | (1 << 0) = 10101011
     * result = 10101011 = 171
     *
     * @param number
     * @return
     */
    private static String binaryReversal(String number) {
        int a = Integer.parseInt(number);
        int reminder = Integer.toBinaryString(a).length() % 8;
        int nearestPadding = Integer.toBinaryString(a).length();
        if (reminder != 0)
            nearestPadding += (8 - reminder);

        int result = 0;
        for (int i = 0; i < nearestPadding; i++) {
            int bit = (a >> i) & 1;
            result = result | (bit << (nearestPadding - 1 - i));
        }
        return String.valueOf(result);
    }
}

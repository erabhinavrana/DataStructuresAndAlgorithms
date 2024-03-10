package com.abhi.coding.coderbyte;

/**
 * The function SeatingStudents(arr) read the array of integers stored in arr which will be in the following format: [K, r1, r2, r3, ...]
 * where K represents the number of desks in a classroom, and the rest of the integers in the array will be in sorted order and will represent the desks
 * that are already occupied. All the desks will be arranged in 2 columns,
 * where desk #1 is at the top left, desk #2 is at the top right, desk #3 is below #1, desk #4 is below #2, etc.
 * Your program should return the number of ways 2 students can be seated next to each other.
 * This means 1 student is on the left and 1 student on the right, or 1 student is directly above or below the other student.
 */
public class SeatingStudentProblem {
    public static void main(String[] args) {
        int[] arr = {12, 2, 6, 7, 11};
        System.out.println(seatingStudents(arr));
    }

    private static int seatingStudents(int[] arr) {
        int k = arr[0];
        int[] occupied = new int[arr.length - 1];
        System.arraycopy(arr, 1, occupied, 0, arr.length - 1);
        int count = 0;
        for (int i = 1; i <= k; i++) {
            if (isSeatAvailable(i, occupied)) {
                if (i % 2 != 0 && (i + 1 <= k && isSeatAvailable(i + 1, occupied))) {
                    count++;

                }
                if (i + 2 <= k && isSeatAvailable(i + 2, occupied)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSeatAvailable(int i, int[] occupied) {
        for (int k : occupied) {
            if (i == k) {
                return false;
            }
        }
        return true;
    }
}

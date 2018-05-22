package com.interviewbit.solutions.Arrays;

public class AddOneToNumber {

    public static void main(String[] args) {
        //int[] input = {9, 9, 9};
        //int[] input = {1, 2, 3};
        int[] input = {0, 3, 7, 6, 4, 0, 5, 5, 5};

        Solution solution = new Solution();
        int[] result = solution.plusOne(input);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    private static class Solution {
        public int[] plusOne(int[] A) {
            int carryOver = 0;
            for (int i = A.length - 1; i >= 0; i--) {
                A[i] += 1;
                if (A[i] == 10) {
                    A[i] = 0;
                    carryOver = 1;
                } else {
                    carryOver = 0;
                }
                if (carryOver != 1) {
                    return removeZeros(A);
                }
            }
            if (carryOver >= 1) {
                int[] result = new int[A.length + 1];
                result[0] = 1;
                for (int i = 0; i < A.length; i++) {
                    result[i + 1] = A[i];
                }
                return result;
            }
            return A;
        }

        private int[] removeZeros(int[] A) {
            int zeroCount = 0;
            for (int i = 0; i < A.length; i++) {
                if (A[i] == 0) {
                    zeroCount++;
                } else {
                    break;
                }
            }
            int[] result = new int[A.length - zeroCount];
            for (int i = 0; i < result.length; i++) {
                result[i] = A[i + zeroCount];
            }
            return result;
        }
    }
}

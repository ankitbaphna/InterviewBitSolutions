package com.interviewbit.solutions.Arrays;

public class MaxSumContiguousSubarray {

    public static void main(String[] args) {
        int[] input = {-20, -163};

        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(input));
    }

    private static class Solution {
        public int maxSubArray(final int[] A) {
            int maxSoFar = Integer.MIN_VALUE;
            int tempSum = 0;
            for (int i = 0; i < A.length; i++) {
                tempSum += A[i];
                if (tempSum > maxSoFar) {
                    maxSoFar = tempSum;
                }
                if (tempSum < 0) {
                    tempSum = 0;
                }
            }
            return maxSoFar;
        }
    }
}

package com.interviewbit.solutions.Arrays;

public class Numrange {

    public static void main(String[] args) {
        int[] input = {10, 5, 1, 0, 2};

        Solution solution = new Solution();
        System.out.println(solution.numRange(input, 6, 8));
    }

    public static class Solution {
        int numRange(int[] A, int B, int C) {
            int count = 0;
            for (int i = 0; i < A.length; i++) {
                int sum = 0;
                for (int j = i; j < A.length; j++) {
                    sum += A[j];
                    if (sum >= B && sum <= C) {
                        count++;
                    }
                    if (sum > C) {
                        break;
                    }
                }
            }
            return count;
        }
    }
}

package com.interviewbit.solutions.OthersPractice;

//Find the contiguous sub-array with maximum sum.
//http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class Kadane {

    public static void main(String[] args) {
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};

        int sum = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (maxSoFar <= sum) {
                maxSoFar = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("maxSoFar = " + maxSoFar);
    }

}

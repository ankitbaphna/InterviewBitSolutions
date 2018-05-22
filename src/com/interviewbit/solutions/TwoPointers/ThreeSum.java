package com.interviewbit.solutions.TwoPointers;

import java.util.Arrays;

public class ThreeSum {

    public static void main(String[] args) {
        //int[] input = {12, 3, 4, 1, 6, 9};
        int[] input = {10, -6, 3, 4, -8, -5};
        //int target = 24;
        int target = 3;

        Arrays.sort(input);

        //Sum = target
        /*for (int i = 0; i < input.length; i++) {
            int start = i+1;
            int end = input.length - 1;
            int tempTarget = target - input[i];

            while (start < end) {
                if (input[start] + input[end] < tempTarget) {
                    start++;
                } else if(input[start] + input[end] > tempTarget) {
                    end--;
                } else {
                    System.out.println(input[i] + "," + input[start] + "," + input[end]);
                    return;
                }
            }
        }*/

        //Closest to target
        int currentDiff = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            int start = i+1;
            int end = input.length - 1;

            while (start < end) {

                int sum = input[i] + input[start] + input[end];
                int diff = Math.abs(sum - target);

                if(diff == 0) {
                    System.out.println("result " + sum);
                    return;
                    //return sum;
                }

                if (diff < currentDiff) {
                    currentDiff = diff;
                    result = sum;
                }
                if (sum <= target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        System.out.println("result = " + result);
    }

}

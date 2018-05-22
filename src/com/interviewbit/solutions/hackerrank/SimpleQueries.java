package com.interviewbit.solutions.hackerrank;

import java.util.Arrays;

public class SimpleQueries {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] maxes = {2,4};
        int[] result = counts(nums, maxes);
        System.out.println("result = " + result.toString());
    }

    static int[] counts(int[] nums, int[] maxes) {
        /*int[] result = new int[maxes.length];
        for (int i = 0; i < maxes.length ; i++) {
            int count = 0;
            for (int j=0; j < nums.length ; j++) {
                if(nums[j] <= maxes[i]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;*/

        int[] result = new int[maxes.length];
        Arrays.sort(nums);

        for(int i=0; i<maxes.length ; i++) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end-start)/2;
                if(nums[mid] == maxes[i]) {
                    result[i] = nums.length - mid;
                    break;
                } else if(nums[mid] > maxes[i]) {
                    end = mid - 1;
                } else {
                    result[i] = end+1;
                    start = mid + 1;
                }
            }
        }
        return result;
    }
}

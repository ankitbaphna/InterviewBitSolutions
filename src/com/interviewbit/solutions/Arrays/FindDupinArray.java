package com.interviewbit.solutions.Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDupinArray {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(4);
        input.add(1);
        input.add(4);
        input.add(1);

        Solution solution = new Solution();
        System.out.println(solution.repeatedNumber(input));
    }

    public static class Solution {
        // DO NOT MODIFY THE LIST

        /*check for sign of A[abs(A[i])] ;
        if positive then
            make it negative by   A[abs(A[i])]=-A[abs(A[i])];
        else  // i.e., A[abs(A[i])] is negative
          this   element (ith element of list) is a repetition
        */

        public int repeatedNumber(final List<Integer> a) {
            Integer[] array = a.toArray(new Integer[a.size()]);

            for(int i = 0; i< array.length; i++) {
                if(array[Math.abs(array[i]) -1] < 0  ) {
                    return Math.abs(array[i]);
                } else {
                    array[Math.abs(array[i]) - 1]  = -1 * array[Math.abs(array[i]) - 1];
                }
            }
            return 0;
        }
    }

}

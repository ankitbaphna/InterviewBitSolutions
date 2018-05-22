package com.interviewbit.solutions.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

    public static void main(String[] args) {
        int[] input = {3, 30, 34, 5, 9};
        //int[] input = {0, 0, 0, 0, 0};

        Solution solution = new Solution();
        System.out.println(solution.largestNumber(input));
    }

    public static class Solution {
        public String largestNumber(final int[] A) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < A.length; i++) {
                list.add(String.valueOf(A[i]));
            }
            MyComparator myComparator = new MyComparator();
            Collections.sort(list, myComparator);
            StringBuilder result = new StringBuilder(list.size());
            boolean canAddZero = false;
            for (String s : list) {
                if (Integer.valueOf(s) != 0) {
                    canAddZero = true;
                }
                if (canAddZero) {
                    result.append(s);
                }
            }
            return (result.length() != 0) ? result.toString() : "0";
        }
    }

    public static class MyComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            String s1 = (String) o1;
            String s2 = (String) o2;
            return (s2+s1).compareTo(s1+s2);
        }
    }
}

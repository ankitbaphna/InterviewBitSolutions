package com.interviewbit.solutions.Strings;

public class Atoi {

    public static void main(String[] args) {
        String a = " 9 2704";
        Solution solution = new Solution();
        System.out.println("" + solution.atoi(a));
    }

    public static class Solution {
        public int atoi(final String a) {

            if (a == null || a.length() < 1) {
                return 0;
            }

            char sign = '+';

            int i = 0;
            //skip front spaces
            while (a.charAt(i) == ' ') {
                i++;
            }
            if (a.charAt(i) == '-') {
                sign = '-';
                i++;
            } else if (a.charAt(i) == '+') {
                i++;
            }
            //If it's too big - overflow
            double result = 0;

            while (i < a.length() && a.charAt(i) >= '0' && a.charAt(i) <= '9') {
                result = result * 10 + (a.charAt(i) - '0');
                i++;
            }

            if (sign == '-') {
                result = -result;
            }

            // handle max and min for overflows
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            return (int) result;
        }
    }

}

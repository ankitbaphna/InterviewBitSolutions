package com.interviewbit.solutions.Strings;

public class PalindromeString {

    public static void main(String[] args) {
        String input = "1a2";

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(input) + " ");
    }

    public static class Solution {
        public int isPalindrome(String input) {
            char[] chars = input.toLowerCase().trim().toCharArray();

            int start = 0;
            int end = chars.length - 1;

            while (start < end) {
                while (start < end && !Character.isLetter(chars[start]) && !Character.isDigit(chars[start])) {
                    start++;
                }
                while (start < end && !Character.isLetter(chars[end]) && !Character.isDigit(chars[end])) {
                    end--;
                }
                if (chars[start] != chars[end]) {
                    return 0;
                }
                start++;
                end--;
            }

            return 1;
        }
    }
}

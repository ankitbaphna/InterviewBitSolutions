package com.interviewbit.solutions.Strings;

public class MinCharsToPalindrome {

    public static void main(String[] args) {
        //String input = "adpooefxzbcoejuvpvaboygp";
        String input = "zrzbmnmgqoo";

        Solution solution = new Solution();
        System.out.println(solution.solve(input) + "");
    }

    public static class Solution {
        public int solve(String a) {
            if(a.length() == 0 || a.length() == 1) {
                return 0;
            }
            int result = 0;
            char[] chars = a.toCharArray();
            int start = 0;
            int end = chars.length-1;
            boolean foundMatch = false;

            while (start < end) {
                if(chars[start] != chars[end]) {
                    result++;
                    foundMatch = false;
                } else {
                    foundMatch = true;
                }
                start++;
                end--;
            }
            return foundMatch ? result : a.length()-1;
        }
    }
}

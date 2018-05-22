package com.interviewbit.solutions.Strings;

public class LengthofLastWord {

    public static void main(String[] args) {
        String input = " ";

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord(input) + " ");
    }

    public static class Solution {
        public int lengthOfLastWord(final String a) {
            int result = 0;
            char[] chars = a.toCharArray();
            boolean sendResult = false;

            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] != ' ') {
                    result++;
                    sendResult = true;
                } else {
                    if (sendResult == true) {
                        return result;
                    }
                }
            }
            return result;
        }
    }

}

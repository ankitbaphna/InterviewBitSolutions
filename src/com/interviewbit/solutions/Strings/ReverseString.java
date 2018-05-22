package com.interviewbit.solutions.Strings;

public class ReverseString {

    public static void main(String[] args) {
        String input = "ankrqzzcel dyaiug y rkicv t";

        Solution solution = new Solution();
        System.out.println("["+solution.reverseWords(input)+"]");
    }

    public static class Solution {
        public String reverseWords(String a) {
            if (a.length() == 0){
                return "";
            }
            StringBuilder result = new StringBuilder();
            char[] chars = a.toCharArray();
            StringBuilder tempWord = new StringBuilder();
            for (int i = chars.length-1; i >= 0; i--) {

                if(chars[i] != ' ') {
                    tempWord.append(chars[i]);
                } else {
                    if(tempWord.charAt(tempWord.length()-1) != ' ' && tempWord.length() > 0) {
                        result.append(tempWord.reverse().toString());
                        result.append(" ");
                        tempWord = new StringBuilder();
                    }
                }
            }
            result.append(tempWord.reverse().toString());
            if(result.charAt(result.toString().length()-1) == ' ') {
                result.deleteCharAt(result.toString().length() - 1);
            }
            return result.toString();
        }


    }

}

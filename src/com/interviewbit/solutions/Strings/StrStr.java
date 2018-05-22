package com.interviewbit.solutions.Strings;

public class StrStr {
    public static void main(String[] args) {
        String haystack = "bbbbbbbbab";
        String needle = "baba";

        Solution solution = new Solution();
        System.out.println(solution.strStr(haystack, needle));
    }

    public static class Solution {
        public int strStr(final String haystack, final String needle) {
            int result = -1;
            if (haystack.length() == 0 ||
                    needle.length() == 0
                    || needle.length() > haystack.length()){
                return -1;
            }

            int i = 0;
            char needleFirstChar = needle.charAt(0);
            while (needleFirstChar == ' ' && i < needle.length()){
                needleFirstChar = needle.charAt(i);
                i++;
            }
            for (int j = 0; j < haystack.length(); j++) {
                boolean matching = false;
                if(haystack.charAt(j) == needleFirstChar){
                    for (int k = 0; k < needle.length(); k++) {
                        if((j+k) < haystack.length() && haystack.charAt(j+k) == needle.charAt(k)){
                            matching = true;
                        } else {
                            matching = false;
                            break;
                        }
                    }
                }
                if (matching == true){
                    return j;
                }
            }
            return result;
        }
    }
}

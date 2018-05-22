package com.interviewbit.solutions.Hashing;

import java.util.HashMap;

public class WindowString {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        Solution solution = new Solution();
        System.out.println("solution.minWindow(s, t) = " + solution.minWindow(s, t));
    }

    public static class Solution {
        public String minWindow(String S, String T) {
            if(S == null | T == null || S.length() == 0 || T.length() == 0 || S.length() < T.length()) {
                return "";
            }

            HashMap<Character, Integer> mapT = new HashMap<>();
            for (int i = 0; i < T.length(); i++) {
                char c = T.charAt(i);
                if (!mapT.containsKey(c))
                    mapT.put(c, 1);
                else
                    mapT.put(c, mapT.get(c) + 1);
            }

            HashMap<Character, Integer> found = new HashMap<>();
            int foundCounter = 0;
            int start = 0;
            int end = 0;
            int min = Integer.MAX_VALUE;
            String result = "";
            while (end < S.length()) {
                char c = S.charAt(end);
                if (mapT.containsKey(c)) {
                    if (found.containsKey(c)) {
                        if (found.get(c) < mapT.get(c)) {
                            foundCounter++;
                        }
                        found.put(c, found.get(c) + 1);
                    } else {
                        found.put(c, 1);
                        foundCounter++;
                    }
                }
                if (foundCounter == T.length()) {
                    char sc = S.charAt(start);
                    while (!found.containsKey(sc) || found.get(sc) > mapT.get(sc)) {
                        if (found.containsKey(sc) && found.get(sc) > mapT.get(sc))
                            found.put(sc, found.get(sc) - 1);
                        start++;
                        sc = S.charAt(start);
                    }
                    if (end - start + 1 < min) {
                        result = S.substring(start, end + 1);
                        min = end - start + 1;
                    }
                }
                end++;
            }
            return result;
        }
    }
}

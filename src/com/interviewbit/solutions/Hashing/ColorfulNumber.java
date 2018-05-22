package com.interviewbit.solutions.Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ColorfulNumber {
    public static void main(String[] args) {
        int N = 99;
        Solution solution = new Solution();
        System.out.println(solution.colorful(N));
    }

    public static class Solution {

        public int colorful(int a) {
            String s = Integer.toString(a);
            List<String> hashSet = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i+1; j <= s.length() ; j++) {
                    hashSet.add(s.substring(i,j));
                }
            }
            HashSet<Integer> intHash = new HashSet<>();
            for (String stringInt : hashSet) {
                int product = 1;
                for (int i = 0; i < stringInt.length(); i++) {
                    product *= (stringInt.charAt(i) - '0');
                }
                if(intHash.contains(product)) {
                    return 0;
                } else {
                    intHash.add(product);
                }
            }
            return 1;
        }
    }
}

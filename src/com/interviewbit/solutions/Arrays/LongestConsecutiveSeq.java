package com.interviewbit.solutions.Arrays;

import java.util.HashSet;

public class LongestConsecutiveSeq {

    public static void main(String[] args) {
        int[] input = {100, 4, 200, 1, 3, 2};

        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(input));
    }

    public static class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int longestConsecutive(final int[] A) {
            int result = 1;

            HashSet<Integer> hashSet = new HashSet<>();
            for (int i : A) {
                hashSet.add(i);
            }

            for (int i = 0; i < A.length; i++) {
                int lower = A[i] - 1;
                int higher = A[i] + 1;
                int count = 1;

                while (hashSet.contains(lower)) {
                    hashSet.remove(lower);
                    lower--;
                    count++;
                }

                while (hashSet.contains(higher)) {
                    hashSet.remove(higher);
                    higher++;
                    count++;
                }

                result = Math.max(count, result);
            }

            return result;
        }
    }
}

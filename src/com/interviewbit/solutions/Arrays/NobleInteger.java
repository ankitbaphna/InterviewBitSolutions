package com.interviewbit.solutions.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NobleInteger {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();

        Solution solution = new Solution();
        System.out.println(solution.solve(input));
    }

    public static class Solution {
        public int solve(ArrayList<Integer> A) {
            int result = -1;
            //Sort
            Collections.sort(A, Comparator.naturalOrder());
            int size = A.size();

            for (int j = 0; j < A.size() - 1; j++) {
                if (A.get(j) == A.get(j + 1)) {
                    continue;
                }

                if (A.get(j) == size - j - 1) {
                    return 1;
                }
            }
            if (A.get(size - 1) == 0)
                return 1;
            return result;
        }
    }
}

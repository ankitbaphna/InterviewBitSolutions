package com.interviewbit.solutions.TwoPointers;

import java.util.ArrayList;

public class RemoveDuplicatesinArray {

    public static void main(String[] args) {
        int[] input = {5000, 5000, 5000};
        ArrayList<Integer> x = new ArrayList<>();
        for (int i :
                input) {
            x.add(i);
        }

        Solution solution = new Solution();
        int result = solution.removeDuplicates(x);
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
    }

    public static class Solution {
        public int removeDuplicates(ArrayList<Integer> A) {
            int index = 1;
            int n = A.size();

            if (A == null || A.size() == 0)
                return 0;

            for (int i = 1; i < n; i++) {

                if (A.get(i).intValue() != A.get(i - 1).intValue()) {
                    int temp = A.get(index);
                    A.set(index, A.get(i));
                    index++;
                }
            }

            return index;
        }
    }
}

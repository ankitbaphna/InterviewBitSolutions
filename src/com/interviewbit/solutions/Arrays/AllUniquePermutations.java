package com.interviewbit.solutions.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AllUniquePermutations {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = {1, 1, 2};
        for (int i : array) {
            list.add(i);
        }
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.permute(list);
        for (ArrayList<Integer> temp : result) {
            for (int i : temp) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public static class Solution {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();

        public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
            Collections.sort(a);
            computePermutations(a, 0);
            for (ArrayList<Integer> list : set) {
                result.add(list);
            }
            return result;
        }

        private void computePermutations(ArrayList<Integer> array, int index) {
            if (index >= array.size()) {
                set.add(new ArrayList<>(array));
            }
            for (int i = index; i < array.size(); i++) {
                if (i > index && array.get(i) == array.get(i - 1)) {
                    continue;
                }

                Collections.swap(array, index, i);
                computePermutations(array, index + 1);
                Collections.swap(array, index, i);
            }
        }
    }
}

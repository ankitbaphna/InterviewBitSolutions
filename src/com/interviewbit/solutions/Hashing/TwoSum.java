package com.interviewbit.solutions.Hashing;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        /*input.add(2);
        input.add(2);
        input.add(7);
        input.add(6);*/

        int[] x ={4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        for (int i : x){
            input.add(i);
        }
        int target = -3;

        Solution solution = new Solution();
        ArrayList<Integer> result = solution.twoSum(input, target);
        for (int i :
                result) {
            System.out.println(i);
        }
    }

    public static class Solution {
        public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
            ArrayList<Integer> list = new ArrayList<>();
            if (a == null || a.size() == 0) {
                return list;
            }
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < a.size(); i++) {
                int compliment = b - a.get(i);
                if(map.containsKey(compliment)) {
                    list.add(map.get(compliment) + 1);
                    list.add(i + 1);
                    return list;
                } else {
                    if(!map.containsKey(a.get(i))) {
                        map.put(a.get(i), i);
                    }
                }
            }

            return list;
        }
    }
}

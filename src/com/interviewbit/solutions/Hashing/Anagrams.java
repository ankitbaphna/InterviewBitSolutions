package com.interviewbit.solutions.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("cat");
        a.add("dog");
        a.add("god");
        a.add("atc");
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> result = solution.anagrams(a);
        for(int i = 0; i < result.size(); i++){
            System.out.print("[");
            for(int j : result.get(i)) {
                System.out.print((j) + " ");
            }
            System.out.println("]");
        }

    }

    public static class Solution {
        public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

            for(int i = 0; i < a.size(); i++) {
                char[] chars = a.get(i).toCharArray();
                Arrays.sort(chars);
                String sortedString = String.valueOf(chars).trim();
                if(map.containsKey(sortedString)) {
                    map.get(sortedString).add(i+1);
                } else {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(i+1);
                    map.put(sortedString, arrayList);
                }
            }

            for (ArrayList<Integer> values:
                 map.values()) {
                result.add(values);
            }
            return result;
        }
    }

}

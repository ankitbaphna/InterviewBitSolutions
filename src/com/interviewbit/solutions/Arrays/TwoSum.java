package com.interviewbit.solutions.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] input = {21, 7, 2, 15};
        int target = 9;
        //a+b = 9

        //print index of elements
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            int compliment = target - input[i];
            if (hashMap.containsKey(compliment)) {
                System.out.println(hashMap.get(compliment) +"," + i);
            }
            hashMap.put(input[i], i);
        }

        //print elements
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            int compliment = target -  input[i];
            if(hashSet.contains(compliment)) {
                System.out.println(input[i] + "," + compliment);
            }
            hashSet.add(input[i]);
        }

        //No extra space if array is sorted
        Arrays.sort(input);
        int start = 0;
        int end = input.length-1;
        while (start < end) {
            if(input[start] + input[end] < target){
                start++;
            } else if(input[start] + input[end] > target) {
                end--;
            } else if(input[start] + input[end] == target) {
                System.out.println(input[start] + " and " + input[end]);
                return;
            }
        }

    }
}

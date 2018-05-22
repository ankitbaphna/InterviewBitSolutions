package com.interviewbit.solutions.OthersPractice;

import java.util.HashSet;

public class Combinations_AllSubsets {

    public static void main(String[] args) {
        String input = "AAABC";
        //allPossibleCombinations(input, "");
        HashSet<String> result = getAllPossibleCombinations(input, "", new HashSet<>());
        for (String s
                :
             result) {
            System.out.println(s);
        }
    }

    //Prints all the possible combinations\subsets
    public static void allPossibleCombinations(String s, String combined) {
        System.out.println(combined + " ");
        int n = s.length();
        for (int i = 0; i < n; i++) {
            allPossibleCombinations(s.substring(i+1),
                    combined + s.charAt(i));
        }
    }

    //Return all the possible combinations\subsets
    public static HashSet<String> getAllPossibleCombinations(String s, String combined,
                                                             HashSet<String> result) {
        result.add(combined);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            getAllPossibleCombinations(s.substring(i+1),
                    combined + s.charAt(i), result);
        }
        return result;
    }
}

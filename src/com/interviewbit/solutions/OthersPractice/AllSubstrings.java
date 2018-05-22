package com.interviewbit.solutions.OthersPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AllSubstrings {

    public static void main(String[] args) {
        String input = "MAN";
        //printAllSubsets(input);

        Collection<String> result = getSubstrings(input);
        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    private static void printAllSubsets(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j <= input.length(); j++) {
                System.out.println(input.substring(i,j));
            }
        }
    }

    private static Collection<String> getSubstrings(String s) {
        List<String> result = new ArrayList<>();

        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            StringBuilder sBuilder = new StringBuilder();
            for (int j = i; j < sLength; j++) {
                sBuilder.append(s.charAt(j));
                result.add(sBuilder.toString());
            }
        }

        return result;
    }
}

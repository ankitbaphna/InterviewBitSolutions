package com.interviewbit.solutions.hackerrank;

import java.util.HashSet;

public class FirstRepeatedWord {

    public static void main(String[] args) {
        String s =  "He :::: had :::: had a quite.";
        String result = firstRepeatedWord(s);
        System.out.println("result = " + result);
    }

    static String firstRepeatedWord(String s) {
        String result = "";
        s = s.replace(":", " ");
        s = s.replace(";", " ");
        s = s.replace("-", " ");
        s = s.replace(".", " ");
        s = s.replace(",", " ");

        String[] sArray = s.split(" ");
        HashSet<String> map = new HashSet<>();
        for (String word :
                sArray) {
            if (map.contains(word)) {
                if (!word.equals("")) {
                    return word;
                }
            } else {
                map.add(word);
            }
        }
        return result;
    }
}

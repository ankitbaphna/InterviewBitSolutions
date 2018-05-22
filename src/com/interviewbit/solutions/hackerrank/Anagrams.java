package com.interviewbit.solutions.hackerrank;

import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            String input = scanner.next();
            if(input.length() % 2 != 0) {
                System.out.println("-1");
            } else {
                int result = diff(input.substring(0, input.length()/2), input.substring(input.length()/2));
                System.out.println(result);
            }
        }
    }

    public static int diff(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] s1Chars = s1.toCharArray();
        for (char c :
                s1Chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        char[] s2Chars = s2.toCharArray();
        int result = 0;
        for (char c :
                s2Chars) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }

        for (char c :
                map.keySet()) {
            if (map.get(c) > 0) {
                result += map.get(c);
            }
        }
        return result;
    }
}

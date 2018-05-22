package com.interviewbit.solutions.Backtracking;

import java.util.HashMap;

/*
Game of squares
Two players
Turn: Subtracting a perfect square from the current state
State: Always a non-negative integer

50
41
37
21
*/

public class SquareGame {

    public static void main(String[] args) {
        int result = helper(50, new HashMap<>());
        System.out.println("result = " + result);
    }

    private static int helper(int input, HashMap<Integer, Integer> map) {
        if (input == 0) {
            return -1;
        } else if (map.containsKey(input)) {
            return map.get(input);
        } else {
            for (int i = 1; i <= Math.sqrt(input); i++) {
                int newInput = input - i*i;
                int result = helper(newInput, map);
                map.put(newInput, result);
                if (result == -1) {
                    return i;
                }
            }
        }
        return -1;
    }
}

package com.bookElementsOfProgramming.primitive;

public class ParityOfWord {

    public static void main(String[] args) {
        checkParity(17);
    }

    private static void checkParity (int input) {
        int result = 0;
        while (input != 0) {
            input = input & (input-1);
            result ^= 1;
        }
        System.out.println("result = " + result);
    }
}

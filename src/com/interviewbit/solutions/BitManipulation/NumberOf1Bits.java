package com.interviewbit.solutions.BitManipulation;

public class NumberOf1Bits {

    public static void main(String[] args) {
        int result = numSetBits(11);
        System.out.println("result = " + result);
    }

    static int numSetBits (long i) {
        int result = 0;
        while (i != 0) {
            i = i & (i-1);
            result++;
        }
        return result;
    }
}

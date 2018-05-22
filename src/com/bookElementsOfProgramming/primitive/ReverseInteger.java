package com.bookElementsOfProgramming.primitive;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println("reverseInt(-12345) = " + reverseInt(-12345));
    }

    private static long reverseInt (int input) {
        long result = 0;
        long xRemaining = Math.abs(input);

        while (xRemaining != 0) {
            result = result*10 + xRemaining%10;
            xRemaining = xRemaining/10;
            System.out.println("result = " + result + " xRemain " + xRemaining);
        }
        return input < 0 ? -result : result;
    }
}

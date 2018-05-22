package com.bookElementsOfProgramming.primitive;

public class IntegerPalindrome {

    public static void main(String[] args) {
        boolean result = isPalindrome(5555);
        System.out.println("result = " + result);
    }

    private static boolean isPalindrome (int input) {
        input = Math.abs(input); //ignore the sign..ask condition..can return false from here as well
        int numDigits = (int) Math.log10(input) + 1;
        System.out.println("numDigits = " + numDigits);

        int msdMask = (int) (Math.pow(10, numDigits-1));
        System.out.println("msdMask = " + msdMask);
        for (int i = 0; i < numDigits / 2; i++) {
            if (input/msdMask != input%10) {
                return false;
            }
            input = input % msdMask;
            input = input/10;
            msdMask = msdMask/100;
            System.out.println("input = " + input + " mask " + msdMask);
        }
        return true;
    }
}

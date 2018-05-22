package com.bookElementsOfProgramming.strings;

public class PalindromeCheck {

    public static void main(String[] args) {
        String input = "teiet";
        for (int i = 0, j = input.length()-1; i < j; i++, j--) {
            if (input.charAt(i) != input.charAt(j)) {
                System.out.println("false = " + false);
                return;
            }
        }
        System.out.println("true = " + true);
    }
}

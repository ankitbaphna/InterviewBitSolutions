package com.bookElementsOfProgramming.arrays;

public class IncreaseInteger {

    public static void main(String[] args) {
        int[] input = {8,9,9};

        //Better to have dynamic array list for result to incorporate extra length
        int index = input.length-1;
        for (int i = index; i >= 0 && input[i] != 10 ; i--) {
            input[i] += 1 ;
            if (input[i] > 9) {
                input[i] %= 10;
            }
        }


        for (int i = 0; i < input.length; i++) {
            System.out.println("input = " + input[i]);
        }
    }
}

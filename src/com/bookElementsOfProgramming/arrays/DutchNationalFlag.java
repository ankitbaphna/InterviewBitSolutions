package com.bookElementsOfProgramming.arrays;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] input = {0,0,2,1,1,2,0,0,2,1};

        int zeros = 0;
        int ones = 0;
        int twos = input.length-1;

        while (ones <= twos) {
            if (input[ones] == 0) {
                swap(input, zeros, ones);
                zeros++;
                ones++;
            } else if ((input[ones] == 2)) {
                swap(input, ones, twos);
                twos--;
            } else {
                ones++;
            }
        }


        for (int i = 0; i < input.length; i++) {
            System.out.println("input = " + input[i]);
        }
    }

    private static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
}

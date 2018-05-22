package com.bookElementsOfProgramming.arrays;

public class DeleteDupsFromSorted {

    public static void main(String[] args) {
        int[] input = {1,1,1,2,3,4,5,5,5,5,6};

        int writeIndex = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[writeIndex-1] != input[i]) {
                input[writeIndex] = input[i];
                writeIndex++;
            }
        }

        for (int i = 0; i < input.length; i++) {
            System.out.println("input = " + input[i]);
        }
    }
}

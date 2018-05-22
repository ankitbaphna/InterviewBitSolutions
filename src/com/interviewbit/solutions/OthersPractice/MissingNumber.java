package com.interviewbit.solutions.OthersPractice;

public class MissingNumber {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 10};

        int result = 0;
        for (int i = 1; i <= input.length; i++) {
            result = result^i^input[i-1];
        }
        System.out.println("result = " + (result^(input.length+1)));
    }
}

package com.interviewbit.solutions.Arrays;

public class BuySellOneTime {

    public static void main(String[] args) {
        int[] input = {100, 80, 120, 130, 70, 60, 100, 125};

        int currentMin = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < input.length; i++) {
            currentMin = Math.min(currentMin, input[i]);
            profit = Math.max(profit, input[i] - currentMin);
        }
        System.out.println("currentMin = " + currentMin);
        System.out.println("profit = " + profit);
    }
}

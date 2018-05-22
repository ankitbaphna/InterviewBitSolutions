package com.interviewbit.solutions.Arrays;

//https://www.youtube.com/watch?v=Taq95cvRom8
public class BuySellMultipleTimes {

    public static void main(String[] args) {
        int[] input = {100, 180, 260, 310, 40, 535, 695};
        int profit = 0;
        for (int i = 1; i < input.length; i++) {
            int currentProfit = input[i] - input[i-1];
            if (currentProfit > 0) {
                profit += currentProfit;
            }
        }
        System.out.println("profit = " + profit);
    }
}

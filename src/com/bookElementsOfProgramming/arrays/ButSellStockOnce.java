package com.bookElementsOfProgramming.arrays;

public class ButSellStockOnce {

    public static void main(String[] args) {
        int[] input = {310, 315, 275, 295, 260, 270, 290, 255, 250};

        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;
        for (int i = 0; i < input.length; i++) {
            maxProfit = Math.max(input[i] - minSoFar, maxProfit);
            minSoFar = Math.min(input[i], minSoFar);
        }
        System.out.println("maxProfit = " + maxProfit);
    }
}

package com.bookElementsOfProgramming.arrays;

import java.util.ArrayList;
import java.util.List;

public class BuySellStockTwice {

    public static void main(String[] args) {
        int[] input = {12,11,13,9,12,8,14,13,15};

        int maxTotalProfit = 0;
        int minSoFar = Integer.MAX_VALUE;
        List<Integer> firstBuySellProfits = new ArrayList<>();

        //Forward phase: Record max profit if we sell on that day
        for (int i = 0; i < input.length; i++) {
            minSoFar = Math.min(minSoFar, input[i]);
            maxTotalProfit = Math.max(maxTotalProfit, input[i] - minSoFar);
            firstBuySellProfits.add(maxTotalProfit);
        }

        //Backward phase: Max profit if we made 2nd buy this day
        int maxSoFar = Integer.MIN_VALUE;
        for (int i = input.length-1; i >= 0 ; i--) {
            maxSoFar = Math.max(maxSoFar, input[i]);
            maxTotalProfit = Math.max(maxTotalProfit, maxSoFar-input[i] + firstBuySellProfits.get(i));
        }
        System.out.println("maxTotalProfit = " + maxTotalProfit);
    }
}

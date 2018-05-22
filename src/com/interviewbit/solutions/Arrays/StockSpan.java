package com.interviewbit.solutions.Arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by saitejatokala on 21/11/15.
 * http://www.geeksforgeeks.org/the-stock-span-problem/
 * Question:
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we
 * need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before
 * the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for
 * corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 *
 * Solution 1:
 * We see that S[i] on day i can be easily computed if we know the closest day preceding i, such that the price
 * is greater than on that day than the price on day i. If such a day exists, let’s call it h(i), otherwise,
 * we define h(i) = -1.
 * The span is now computed as S[i] = i – h(i). See the following diagram.
 */
public class StockSpan {

    public static int[] stockSpan(int[] prices){
        Stack<Integer> stack = new Stack<>();
        int[] stockSpan = new int[prices.length];
        stockSpan[0] = 1;
        stack.push(0);
        for (int i = 1; i < prices.length ; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] < prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stockSpan[i] = i + 1;
            } else {
                stockSpan[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return stockSpan;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] result = stockSpan(prices);
        System.out.print(Arrays.toString(result));
    }
}

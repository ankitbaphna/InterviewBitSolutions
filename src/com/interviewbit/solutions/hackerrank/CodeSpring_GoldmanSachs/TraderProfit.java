package com.interviewbit.solutions.hackerrank.CodeSpring_GoldmanSachs;

import java.util.Scanner;

/**
 * Mike is a stock trader and makes a profit by buying and selling stocks. He buys a stock at a lower price and sells it at a higher price to book a profit. He has come to know the stock prices of a particular stock for  upcoming days in future and wants to calculate the maximum profit by doing the right transactions (single transaction = buying + selling). Can you help him maximize his profit?

 Note: A transaction starts after the previous transaction has ended. Two transactions can't overlap or run in parallel.

 The stock prices are given in the form of an array  for  days.

 Given the stock prices and a positive integer , find and print the maximum profit Mike can make in at most transactions.

 For example,  stock prices are given as , and . For one transaction, maximum profit is  when stock is purchased on day  and sold on day .

 Input Format

 The first line of input contains an integer  denoting the number of queries.

 The first line of each test case contains a positive integer , denoting the number of transactions.

 The second line of each test case contains a positive integer , denoting the length of the array .

 The third line of each test case contains  space-separated positive integers, denoting the prices of each day in the array .

 Constraints

 Output Format

 For each query print the maximum profit earned by Mike on a new line.

 Sample Input 0

 3
 2
 6
 10 22 5 75 65 80
 3
 4
 20 580 420 900
 1
 5
 100 90 80 50 25
 Sample Output 0

 87
 1040
 0
 Explanation 0

 Output 1: Mike earns  as sum of  and  i.e. Buy at price , sell at , buy at  and sell at
 Output 2: Mike earns  as sum of  and  i.e. Buy at price , sell at , buy at  and sell at
 Output 3: Mike cannot make any profit as selling price is decreasing day by day. Hence, it is not possible to earn anything.
 */

public class TraderProfit {

    static int traderProfit(int k, int n, int[] A) {
        if (k == 0 || A.length == 0) {
            return 0;
        }
        int T[][] = new int[k+1][A.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -A[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], A[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - A[j]);
            }
        }
        return T[k][A.length-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int k = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }
}

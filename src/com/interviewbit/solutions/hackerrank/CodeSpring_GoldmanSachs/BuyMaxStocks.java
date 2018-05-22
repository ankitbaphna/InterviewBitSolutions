package com.interviewbit.solutions.hackerrank.CodeSpring_GoldmanSachs;

import java.util.Scanner;

/**
 * In a stock market, there is a product with its infinite stocks. The stock prices are given for  days, where denotes the price of the stock on the  day. There is a rule that a customer can buy at most  stock on the  day. If the customer has an amount of  dollars initially, find out the maximum number of stocks they can buy?

 For example, for  days the price of a stock is given as . You can buy  stock worth  on day ,  stocks worth  each on day  and  stocks worth  each on day . If , you can buy all the stocks (total ) for .

 Input Format

 The first line contains an integer  denoting the number of days.
 The next line contains  space-separated integers where  integer denotes the price of the stock on the  day. Next line contains a positive integer  which is the initial amount with the customer.

 Constraints

 Output Format

 Print the maximum number of stock that a customer can buy.

 Sample Input 0

 3
 10 7 19
 45
 Sample Output 0

 4
 Explanation 0

 The customer can purchase  stock on day ,  stock on day  and  stock on day  for ,  and respectively.
 Hence, total amount is  and number of stocks purchased is .
 */
public class BuyMaxStocks {

    static int buyMaximumProducts(int n, int k, int[] a) {

        return 0;
    }

    static int helper (int[] a, int sum, int k, int result, int level) {
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int k = in.nextInt();
        int result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }
}

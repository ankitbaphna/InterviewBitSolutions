package com.interviewbit.solutions.Arrays;


import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/**
 * A time series is a series of data points indexed in time order. They are commonly used in the financial world, especially in stock markets.

 In this challenge you are working with a time series of stock prices. You are given  historical records  where the stock at time  had a price . You have to answer  types of  queries of the form :

 For type , given a value , when was the first time that the price of the stock was at least ?
 For type , given a value , what's the maximum price of the stock at a time greater or equal to ?
 If for any of these queries the answer is not defined, i.e. there are no historical records that match the query, the answer is .

 Input Format

 In the first line, there are two space-separated integers  and  denoting the number of historical records and the number of queries, respectively.
 The second line contains  space-separated integers denoting the time-stamps .
 The next line contains  space-separated integers denoting the price of stock , where  value corresponds to the  time-stamp.
 Next,  lines follow and each of them describes a single query. Each query is given as two space-separated integers. The first of them is either  or  and denotes the type of the query followed by a single integer  denoting the value to be queried.

 Constraints

 for
 Output Format

 For each of the  queries, print the answer on a new line. If the answer is not defined, print .

 Sample Input 0

 5 5
 1 2 4 8 10
 5 3 12 1 10
 1 10
 1 4
 2 8
 2 3
 1 13
 Sample Output 0

 4
 1
 10
 12
 -1
 Explanation 0

 In the sample, there are  data records and  queries to answer. At time  the price was , at time  the price was , at time  the price was , at time  the price was , and finally, at time  the price was .

 In the first query, we are asked for the minimum time at which the price was at least . The answer is  because at this time the price was  and there is no earlier time with a price at least .

 In the second query, we are asked for the minimum time at which the price was at least . The answer is  because the price at this time was  which is greater than .

 In the third query, we are asked for the maximum price at time  or greater. The answer is  because there are two data records with time at least  and the highest price among them is .

 In the fourth query, we are asked for the maximum price at time  or greater. The answer here is .

 In the last query, we are asked for the minimum time at which the price was at least . Since there is no data record with price  or greater, the answer is .
 */

public class TimeSeriesQueries {

    static class TimeSeries{
        int time;
        int price;

        public TimeSeries(int time, int price) {
            this.time = time;
            this.price = price;
        }
    }

    static class TimeSeriesComparator implements Comparator<TimeSeries> {
        @Override
        public int compare(TimeSeries o1, TimeSeries o2) {
            return Integer.compare(o1.price, o2.price);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] t = new int[n];
        Stack<Integer> maxTillNowStack = new Stack<>();
        Stack<Integer> maxTillNowStackCopy;

        for(int t_i = 0; t_i < n; t_i++){
            t[t_i] = in.nextInt();
        }
        int[] p = new int[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextInt();
            if(!maxTillNowStack.isEmpty()) {
                maxTillNowStack.push(Math.max(p[p_i], maxTillNowStack.peek()));
            } else {
                maxTillNowStack.push(p[p_i]);
            }
        }
        maxTillNowStackCopy = (Stack<Integer>) maxTillNowStack.clone();

        for(int a0 = 0; a0 < q; a0++){
            int _type = in.nextInt();
            int v = in.nextInt();

            if(_type == 1 /*by time*/) {
                int result = -1;
                while (!maxTillNowStack.isEmpty()) {
                    int top = maxTillNowStack.pop();
                    if(top < v) {
                        result = maxTillNowStack.isEmpty() ? -1 : t[result];
                        System.out.println(result);
                        break;
                    }
                    result++;
                }
                if(maxTillNowStack.isEmpty() && p[0] > v) {
                    System.out.println(t[0]);
                } else if (maxTillNowStack.isEmpty()) {
                    System.out.println(-1);
                }
            } else /*by value*/{
                int index = minIndexOfTimeGreaterThan(t, v);
                int max = p[index];
                for (int i = index; i < p.length; i++) {
                    max = Math.max(max, p[i]);
                }
                System.out.println(max);
            }
            maxTillNowStack = maxTillNowStackCopy;
        }
        in.close();
    }

    private static int minIndexOfTimeGreaterThan (int[] timeArray, int time) {
        int start = 0;
        int end = timeArray.length-1;
        int mid = 0;
        while (start <= end) {
            mid = (start+end)/2;
            if (time == timeArray[mid]) {
                return mid;
            }
            if (time < timeArray[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return mid+1;
    }
}

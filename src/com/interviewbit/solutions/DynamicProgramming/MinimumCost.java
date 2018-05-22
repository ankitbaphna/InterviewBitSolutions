package com.interviewbit.solutions.DynamicProgramming;

/**
 * https://www.youtube.com/watch?v=lBRtnuxg-gU
 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
 */
public class MinimumCost {

    public static void main(String[] args) {

        int cost[][] = {{1,2,3},
                        {4,8,2},
                        {1,5,3}};
        int result = minCostRecursion(cost, 2, 2);

        System.out.println("minCostRecursion = " + result);

        result = minCost(cost, 2, 2);
        System.out.println("minCost = " + result);
    }

    //Non Recursive
    //Better complexity
    private static int minCost(int[][] cost,int m,int n){

        int temp[][] = new int[m+1][n+1];
        int sum = 0;
        for(int i=0; i <= n; i++){
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }
        sum = 0;
        for(int i=0; i <= m; i++){
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }

        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                temp[i][j] = cost[i][j] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);
            }
        }
        return temp[m][n];
    }

    //Not good since many paths are recalculated again and again
    private static int minCostRecursion(int[][] cost, int m, int n)
    {
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return cost[m][n];
        else
            return cost[m][n] + min(minCostRecursion(cost, m-1, n-1),
                    minCostRecursion(cost, m-1, n),
                    minCostRecursion(cost, m, n-1));
    }

    private static int min(int x, int y, int z) {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
}

package com.interviewbit.solutions.DynamicProgramming;

/**
 * Count all the possible paths from top left to bottom right
 * of a mXn matrix with the constraints that from each cell you can either move only to right or down
 * https://www.youtube.com/watch?v=GO5QHC_BmvM
 */
public class TotalWays {

    public static void main(String[] args) {
        //System.out.println("countTotalWaysNoObstruction = " + countTotalWaysNoObstruction(3, 3));
        System.out.println("countPathsNoObstruction = " + countPathsNoObstruction(3, 3));
    }

    //Better complexity
    //Non Recursive
    private static int countPathsNoObstruction(int rows, int columns){
        int T[][] = new int[rows][columns];
        for(int i=0; i < rows; i++){
            T[i][0] = 1; //traverse thru 1st column..only 1 way
        }

        for(int i=0; i < columns; i++){
            T[0][i] = 1; //traverse thru 1st row...only 1 way
        }
        for(int i=1; i < rows; i++){
            for(int j=1; j < columns; j++){
                T[i][j] = T[i-1][j] + T[i][j-1]; //add diagonal entry if that's allowed
            }
        }
        return T[rows-1][columns-1];
    }

    private static int countTotalWaysNoObstruction(int totalRows, int totalColumns) {
        if (totalColumns == 1 || totalRows == 1) {
            return 1;
        } else {
            return countTotalWaysNoObstruction(totalRows-1, totalColumns)
                    + countTotalWaysNoObstruction(totalRows, totalColumns-1);
            // + countTotalWaysNoObstruction(totalRows-1,totalColumns-1); //If diagonal is allowed
        }
    }
}

package com.interviewbit.solutions.DynamicProgramming;

//http://www.geeksforgeeks.org/longest-common-subsequence/
/*
Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence
        that appears in the same relative order, but not necessarily contiguous.
        For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
        So a string of length n has 2^n different possible subsequences.

        LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
        LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.*/
public class LongestCommonSubsequence {

    public static void main(String[] args)
    {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("lcs = " + lcs(s1, s2));
    }


    //Tricky to make OFF by 1 error here
    private static int lcs(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int rows = c1.length;
        int columns = c2.length;

        int[][] LCS = new int[rows+1][columns+1];

        for (int row = 0; row <= rows; row++) { //Conditions are equals
            for (int column = 0; column <= columns; column++) {
                if (row == 0 || column == 0) {
                    LCS[row][column] = 0;
                } else if (c1[row-1] == c2[column-1]) { //Not c1[row]==c2[column]
                    LCS[row][column] = LCS[row-1][column-1] + 1;
                } else {
                    LCS[row][column] = Math.max(LCS[row-1][column], LCS[row][column-1]);
                }
            }
        }
        //printing the matrix
        for (int i=0; i<= rows; i++)
        {
            for (int j=0; j<= columns; j++)
            {
                System.out.print(LCS[i][j] + " ");
            }
            System.out.println();
        }

        printLCS(LCS, c1, c2);

        return LCS[rows][columns];
    }

    private static void printLCS(int[][] lcs, char[] c1, char[] c2) {
        //better to take length of string since that is what we are gonna compare
        int rows = c1.length;
        int columns = c2.length;

        while (rows > 0 && columns > 0) {
            if (c1[rows-1] == c2[columns-1]) {
                System.out.println(c1[rows - 1]);
                rows--;
                columns--;
            } else if (lcs[rows-1][columns] > lcs[rows][columns-1]) {
                rows--;
            } else {
                columns--;
            }
        }

    }
}

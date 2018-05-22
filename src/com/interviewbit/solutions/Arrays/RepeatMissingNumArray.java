package com.interviewbit.solutions.Arrays;

public class RepeatMissingNumArray {

    public static void main(String[] args) {
        int[] input = {3 ,1, 2, 5, 3};
        Solution solution = new Solution();
        System.out.println(solution.repeatedNumber(input)[0] + "," + solution.repeatedNumber(input)[1]);
    }

    public static class Solution {

        public int[] repeatedNumber(final int[] A) {
            int result[] = new int[2];

            int n = A.length;

            int sumArray = 0;
            long squareSum = 0;

            for (int j = 0; j < n; j++) {
                sumArray += A[j];
                squareSum += (long)(A[j]*A[j]);
            }
            int sumExpected = (n*(n+1))/2;
            int diff = sumArray - sumExpected; //A-B

            long squareExpected = ((long)(n*(n+1)*(2*n+1)))/6;
            long sqDiff = squareSum - squareExpected; //(A+B)(A-B)

            //(A+B)(A-B) = diff (A+B) = sqDiff
            //A-B = diff
            //A+B = sqDiff/diff
             int x = (((int)sqDiff/diff) + diff)/2;
             int y = x-diff;
             result[0] = x;
             result[1] = y;

            return result;
        }
    }
}


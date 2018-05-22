package com.interviewbit.solutions.Arrays;

public class SpiralOrderMatrixI {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[] result = solution.spiralOrder(input);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] spiralOrder(final int[][] A) {
            int[] result = new int[A.length * A[0].length];
            int dir = 0;
            int t = 0, l = 0, b = A.length, r = A[0].length;
            //System.out.print(b + " " + r);
            //int value = A;
            int index = 0;
            while (l < r && t < b) {

                if (dir == 0) {
                    for (int i = l; i < r; i++) {
                        // System.out.print(t + " " +  i);
                        //B[t][i] = value;
                        result[index++] = A[t][i];
                    }
                    t++;
                    dir++;
                } else if (dir == 1) {
                    for (int i = t; i < b; i++) {
                        //System.out.print(value + " ");
                        //B[i][r] = value;
                        result[index++] = A[i][r-1];
                    }
                    r--;
                    dir++;
                } else if (dir == 2) {
                    for (int i = r; i > l; i--) {
                        //System.out.print(value + " ");
                        //B[b][i] = value;
                        result[index++] = A[b-1][i-1];
                    }
                    b--;
                    dir++;
                } else if (dir == 3) {
                    for (int i = b; i > t; i--) {
                        //System.out.print(value + " ");
                        //B[i][l] = value;
                        result[index++] = A[i-1][l];
                    }
                    l++;
                    dir = 0;
                    //value--;
                }
            }
            return result;
        }
    }

}

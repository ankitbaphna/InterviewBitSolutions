package com.interviewbit.solutions.Arrays;

public class PrettyPrint {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] result = solution.prettyPrint(4);

        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result[0].length; column++) {
                System.out.print(result[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static class Solution {
        public int[][] prettyPrint(int A) {
            int[][] B = new int[2 * A - 1][2 * A - 1];
            int dir = 0;
            int t = 0, l = 0, b = 2 * A - 2, r = 2 * A - 2;
            int value = A;
            while (l <= r && t <= b) {

                if (dir == 0) {
                    for (int i = l; i <= r; i++) {
                        //System.out.print(value + " ");
                        B[t][i] = value;
                    }
                    t++;
                    dir++;
                } else if (dir == 1) {
                    for (int i = t; i <= b; i++) {
                        //System.out.print(value + " ");
                        B[i][r] = value;
                    }
                    r--;
                    dir++;
                } else if (dir == 2) {
                    for (int i = r; i >= l; i--) {
                        //System.out.print(value + " ");
                        B[b][i] = value;
                    }
                    b--;
                    dir++;
                } else if (dir == 3) {
                    for (int i = b; i >= t; i--) {
                        //System.out.print(value + " ");
                        B[i][l] = value;
                    }
                    l++;
                    dir = 0;
                    value--;
                }

            }
            return B;
        }
    }
}

package com.interviewbit.solutions.Backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesis {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> result = solution.generateParenthesis(3);
        System.out.println("result = " + result);
    }

    public static class Solution {
        ArrayList<String> result = new ArrayList<String>();
        public ArrayList<String> generateParenthesis(int a) {

            helper(0, 0, a, "");
            return result;
        }

        private void helper( int openCount, int closeCount,
                             int total, String tempResult) {
            if(openCount == total && closeCount == total) {
                result.add(tempResult);
                return ;
            }
            if(openCount < total) {
                helper(openCount+1,closeCount, total, tempResult+"(");
            }
            if(closeCount < openCount) {
                helper( openCount,closeCount+1, total, tempResult+")");
            }
        }
    }
}

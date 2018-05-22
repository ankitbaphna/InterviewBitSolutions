package com.interviewbit.solutions.Backtracking;

import java.util.ArrayList;

public class NQueens {

    private static ArrayList<ArrayList<String>> resultPositions;

    static class Position {
        int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }

    public static void main(String[] args) {
        int total = 4;
        resultPositions = new ArrayList<>();
        Position[] result = new Position[total];
        boolean hasSolution = findNQueens(total, 0, result);
        //System.out.println("hasSolution = " + hasSolution);
        /*for (Position po : result) {
            System.out.println(po);
        }*/
        for (ArrayList<String> list: resultPositions) {
            for (String s: list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    /**
     * @param total  Total x total grid
     * @param row    currently processing this row
     * @param result out result param
     * @return if solution exists
     */
    private static boolean findNQueens(int total, int row, Position[] result) {
        if (row == total) {
            ArrayList<String> tempResult = new ArrayList<>(total);
            StringBuilder dotString = new StringBuilder(total);
            for (int i = 0; i < total; i++) {
                dotString.append(".");
            }
            for (Position pos: result) {
                String temp = dotString.toString();
                char[] chars = temp.toCharArray();
                chars[pos.col] = 'Q';
                tempResult.add(String.valueOf(chars));
            }
            resultPositions.add(tempResult);
            //return true;
        }
        for (int col = 0; col < total; col++) {
            boolean foundSafe = true; //Default is true..important

            //Check if this row or col is under attack by previous queens
            for (int queen = 0; queen < row; queen++) {
                if (result[queen].col == col || result[queen].row - result[queen].col == row - col ||
                        result[queen].row + result[queen].col == row + col) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                result[row] = new Position(row, col);
                //now recurse
                if (findNQueens(total, row + 1, result)) {
                    return true;
                }
            }
        }
        return false;
    }
}

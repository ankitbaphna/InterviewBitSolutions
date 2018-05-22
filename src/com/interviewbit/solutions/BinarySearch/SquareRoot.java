package com.interviewbit.solutions.BinarySearch;

public class SquareRoot {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution = " + solution.sqrt(2147483647 /*Int max*/));
    }

    public static class Solution {
        public int sqrt(int a) {
            long start = 0;
            long end = a / 2 + 1;
            while(start <= end){
                long mid = (start + end) / 2;
                if(mid *  mid == a) {
                    return (int) mid;
                }
                if(mid *  mid < a) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return (int)end;
        }
    }

}

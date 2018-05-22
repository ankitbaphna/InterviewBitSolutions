package com.interviewbit.solutions.BinarySearch;

import java.util.ArrayList;

public class MatrixSearch {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> listInput = new ArrayList<>();

        ArrayList<Integer> r1 = new ArrayList<>();
        r1.add(1);
        r1.add(3);
        r1.add(5);
        r1.add(6);
        listInput.add(r1);

        ArrayList<Integer> r2 = new ArrayList<>();
        r2.add(10);
        r2.add(11);
        r2.add(16);
        r2.add(20);
        listInput.add(r2);

        ArrayList<Integer> r3 = new ArrayList<>();
        r3.add(23);
        r3.add(30);
        r3.add(34);
        r3.add(50);
        listInput.add(r3);

        Solution solution = new Solution();

        int result = solution.searchMatrix(listInput, 3);
        System.out.println("result = " + result);
    }

    public static class Solution {
        public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
            if(a == null || a.size() == 0 || a.get(0).size() == 0) {
                return 0;
            }
            int totalRow = a.size();
            int totalColumns = a.get(0).size();

            int start = 0;
            int end = totalRow * totalColumns -1;

            while(start <= end){
                int mid = start + (end - start)/2;
                int midX = mid / totalColumns;
                int midY = mid % totalColumns;

                if(a.get(midX).get(midY) == b){
                    return 1;
                } else if(a.get(midX).get(midY) < b) {
                    start = mid + 1;
                } else if(a.get(midX).get(midY) > b) {
                    end = mid - 1;
                }
            }
            return 0;
        }
    }
}

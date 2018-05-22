package com.bookElementsOfProgramming.arrays;

public class AdvancingThruArray {

    //A[i] shows har far you can reach from that index. Find if we can reach to end or not.
    public static void main(String[] args) {
        //int[]  input = {2,4,1,1,0,2,3};
        //int[] input = {3,3,1,0,2,0,1};
        int[] input = {3,2,0,0,2,0,1};

        int farthestSoFar = 0;
        int lastIndex = input.length-1;
        for (int i = 0; i <= farthestSoFar && farthestSoFar < lastIndex ; i++) {
            farthestSoFar = Math.max(farthestSoFar, i + input[i]);
        }
        System.out.println("farthestSoFar = " + (farthestSoFar >= lastIndex));
    }
}

package com.interviewbit.solutions.OthersPractice;

import java.util.ArrayList;

public class ArraysMasterClass {

    public static void main(String[] args) {
        int[] input = {};

        //Subarray with given sum
        input = new int[]{11,23, 56, 18 , 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 15;
        int sum = 0;
        int startIndex = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (sum > target) {
                sum = sum - input[startIndex];
                startIndex ++;
            }
            if(sum == target) {
                System.out.println(startIndex + "," + i);
                break;
            }
        }
 // ======================================================================================================

        //Sort an array of 0s, 1s and 2s
        //— Dutch National Flag Algorithm, or 3-way Partitioning —
        /*Lo := 1; Mid := 1; Hi := N;
        while Mid <= Hi do
            Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
        case a[Mid] in
        0: swap a[Lo] and a[Mid]; Lo++; Mid++
        1: Mid++
        2: swap a[Mid] and a[Hi]; Hi–*/
        input = new int[]{0, 2, 1, 2, 0};
        int start = 0;
        int mid = 0;
        int end = input.length-1;
        while (mid <= end) {
            int value = input[mid];
            switch (value) {
                case 0:
                    swap(input, start, mid);
                    start++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(input, mid, end);
                    end--;
                    break;
            }
        }
        for (int i = 0; i < input.length; i++) {
            System.out.print(" " + input[i]);
        }
        System.out.println();

        // ======================================================================================================

        //Equilibrium point
        input = new int[]{-7, 1, 5, 2, -4, 3, 0};
        /*start = 0;
        end = input.length-1;
        int sumPre = input[start];
        int sumPost = input[end];
        while (start < end) {
            if(sumPre > sumPost) {
                end--;
                sumPost += input[end];
            } else if (sumPre < sumPost){
                start++;
                sumPre += input[start];
            } else {
                end--;
                sumPost += input[end];
                start++;
                sumPre += input[start];
            }
        }*/
        sum = 0;	 // initialize sum of whole array
        int leftsum = 0; // initialize leftsum

		/* Find sum of the whole array */
        for (int i = 0; i < input.length; ++i)
            sum += input[i];

        for (int i = 0; i < input.length; ++i)
        {
            sum -= input[i]; // sum is now right sum for index i

            if (leftsum == sum)
                System.out.println("Equilibrium point : " + i);

            leftsum += input[i];
        }
        //System.out.println("Equilibrium point not found if it reaches here");

        // ===================================================================================================

        //Maximum sum increasing subsequence
        input = new int[]{1, 101, 2, 3, 100, 4, 5};
        sum = 0;
        int maxSoFar = input[0];
        for (int i = 1; i < input.length; i++) {
            if(input[i] > input[i-1]) {
                sum += input[i];
            } else {
                sum = input[i];
            }
            if(sum > maxSoFar) {
                maxSoFar = sum;
            }
        }
        System.out.println("maxSoFar = " + maxSoFar);
    }

    private static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

    private ArrayList<Integer> getAllIncreasingSub(int[] input, ArrayList<Integer> result) {
        //if (input.length == 0) {
            return result;
        //}
    }
}

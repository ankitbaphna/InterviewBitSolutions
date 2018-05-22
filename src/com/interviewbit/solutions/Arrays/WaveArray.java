package com.interviewbit.solutions.Arrays;

import java.util.Arrays;

public class WaveArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};

        Solution solution = new Solution();
        int[] result = solution.wave(input);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }
        System.out.println(solution.wave(input));
    }

    public static class Solution {
        public int[] wave(int[] A) {
            /*for (int i = 1; i < A.length-1 ; i+=2) {
                if(A[i] > A[i-1] || A[i] > A[i+1]) {
                    if(A[i-1] > A[i+1]) {
                        int temp = A[i];
                        A[i] = A[i+1];
                        A[i+1] = temp;
                    } else {
                        int temp = A[i];
                        A[i] = A[i-1];
                        A[i-1] = temp;
                    }
                }
            }
        return A;*/
            Arrays.sort(A);
            for (int i = 0; i < A.length - 1; i += 2) {
                swap(A, i, i + 1);
            }
            return A;
        }

        void swap(int arr[], int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
    }
}

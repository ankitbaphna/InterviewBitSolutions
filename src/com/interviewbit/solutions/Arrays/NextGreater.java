package com.interviewbit.solutions.Arrays;

import java.util.Stack;

public class NextGreater {

    public static void main(String[] args) {
        int[] input = {4, 5, 2, 10};

        Solution solution = new Solution();
        int[] result = solution.nextGreater(input);
        for(int i : result){
            System.out.println(i);
        }
    }

    public static class Solution {
        public int[] nextGreater(int[] A) {
            int[] result = new int[A.length];
            Stack<Integer> stack = new Stack<>();
            result[A.length - 1] = -1;
            stack.add(A[A.length - 1]);

            for (int i = A.length - 2; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= A[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
                stack.add(A[i]);
            }
            return result;
        }
    }
}

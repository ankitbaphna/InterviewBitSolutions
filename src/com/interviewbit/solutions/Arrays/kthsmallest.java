package com.interviewbit.solutions.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthsmallest {

    public static void main(String[] args) {
        int[] input = {2, 1, 4, 3, 2};

        Solution solution = new Solution();
        System.out.println(solution.kthsmallest(input, 3));
    }

    public static class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int kthsmallest(final int[] A, int B) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(B, Comparator.<Integer>reverseOrder());
            for (int i : A) {
                if (minHeap.size() < B) {
                    minHeap.offer(i);
                } else {
                    if (i < minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(i);
                    }
                }
            }
            return minHeap.poll();
        }
    }
}

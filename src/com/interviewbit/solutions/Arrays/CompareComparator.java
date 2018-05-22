package com.interviewbit.solutions.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CompareComparator {

    public static void main(String[] args) {

        //Default is min heap -> Store k largest elements from array
        PriorityQueue<CompareThis> heap = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < 10; i++) {
            heap.add(new CompareThis(i));

            if (heap.size() > 5) {
                heap.poll();
            }
        }
        while (!heap.isEmpty()) {
            CompareThis popped = heap.poll();
            System.out.println("popped = " + popped.data);
        }

    }

    private static class CompareThis implements Comparable<CompareThis> {
        int data;

        public CompareThis(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "CompareThis{" +
                    "data=" + data +
                    '}';
        }

        @Override
        public int compareTo(CompareThis o) {
            return Integer.compare(this.data, o.data);
        }
    }
}

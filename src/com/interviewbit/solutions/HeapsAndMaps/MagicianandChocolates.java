package com.interviewbit.solutions.HeapsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicianandChocolates {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2147483647);
        input.add(2000000014);
        input.add(2147483647);

        System.out.println("nchoc(10, input) = " + nchoc(10, input));
    }

    public static int nchoc(int A, ArrayList<Integer> B) {
        if(B.size() == 0 || A == 0) {
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int result = 0;
        int modulo = (int)Math.pow(10, 9) + 7;

        maxHeap.addAll(B);

        for (int i = 0; i < A; i++) {
            int tookOut = maxHeap.poll();
            result = (result + tookOut%modulo)%modulo;
            maxHeap.add(tookOut/2);
        }

        return result;
    }
}

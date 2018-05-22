package com.interviewbit.solutions.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;

public class ThreeSumZero {

    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4};

        ArrayList<Integer> a = new ArrayList<>();
        for (int i :
                input) {
            a.add(i);
        }

        Collections.sort(a);
        LinkedHashSet<ArrayList<Integer>> resultHash = new LinkedHashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < a.size(); i++) {
            // initialize left and right
            int start = i + 1;
            int end = a.size() - 1;
            int x = a.get(i);
            while (start < end) {
                if (x + a.get(start) + a.get(end) == 0) {
                    ArrayList<Integer> tempResult = new ArrayList<>();
                    tempResult.add(x);
                    tempResult.add(a.get(start));
                    tempResult.add(a.get(end));
                    Collections.sort(tempResult);
                    resultHash.add(tempResult);
                    start++;
                    end--;
                } else if (x + a.get(start) + a.get(end) < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        for (ArrayList<Integer> q
                :
                resultHash) {
            result.add(q);
        }
        System.out.println();
    }

}

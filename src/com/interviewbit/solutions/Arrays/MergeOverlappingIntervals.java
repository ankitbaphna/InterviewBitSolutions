package com.interviewbit.solutions.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(2, 6));
        input.add(new Interval(8, 10));
        input.add(new Interval(15, 18));

        //A : [ (5, 28), (7, 70), (54, 93), (5, 98), (46, 70), (42, 63), (5, 91), (30, 49), (36, 57), (31, 95), (86, 88), (9, 90), (5, 53), (42, 62), (14, 100), (59, 75), (32, 100), (5, 79), (31, 31), (7, 42), (13, 47), (44, 87), (61, 83), (100, 100), (96, 98), (47, 51), (34, 44), (6, 53), (30, 92), (50, 64), (37, 57), (49, 67), (2, 67), (36, 50), (55, 100), (54, 78), (58, 70), (2, 37), (13, 54), (7, 60), (16, 79), (35, 78), (17, 57), (16, 84), (60, 80), (10, 54), (54, 59), (62, 85), (7, 37), (31, 99), (40, 41), (4, 99), (28, 45), (27, 71), (14, 64) ]
        //Expected: (2, 100)

        Solution solution = new Solution();
        ArrayList<Interval> result = solution.merge(input);
        for (Interval interval : result) {
            System.out.println(interval.start + "," + interval.end);
        }
    }

    public static class Solution {
        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
            ArrayList<Interval> result = new ArrayList<Interval>();

            if (intervals == null || intervals.size() == 0) {
                return result;
            }

            Collections.sort(intervals, new MyIntervalComparator());

            Interval prev = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                if (intervals.get(i).start <= prev.end) { //equality needed
                    //do merge
                    Interval merged = new Interval(prev.start, Math.max(intervals.get(i).end, prev.end));
                    prev = merged;
                } else {
                    result.add(prev);
                    prev = intervals.get(i);
                }
            }
            result.add(prev);
            return result;
        }
    }

    public static class MyIntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start != o2.start) {
                return o1.start - o2.start;
            } else {
                return o1.start - o2.start;
            }
        }
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

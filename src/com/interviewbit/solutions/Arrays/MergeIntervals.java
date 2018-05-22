package com.interviewbit.solutions.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 2));
        input.add(new Interval(3, 5));
        input.add(new Interval(6, 7));
        input.add(new Interval(8, 10));
        input.add(new Interval(12, 16));

        Solution solution = new Solution();
        ArrayList<Interval> result = solution.insert(input, new Interval(4, 9));
        for (Interval interval : result) {
            System.out.println(interval.start + "," + interval.end);
        }
    }

    public static class Solution {
        public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
            ArrayList<Interval> result = new ArrayList<>();

            if (intervals == null || intervals.size() == 0) {
                if (newInterval != null) {
                    result.add(newInterval);
                }
                return result;
            }
            if (newInterval == null) {
                return intervals;
            }

            if (intervals == null || intervals.size() == 0) {
                return result;
            }
            if (newInterval == null) {
                return intervals;
            }

            intervals.add(newInterval); //inserted

            Collections.sort(intervals, new MyComparator()); //sorted

            //merging
            Interval prev = intervals.get(0);
            for (Interval interval : intervals) {
                if (prev.end > interval.start) {
                    //do merge
                    Interval merged = new Interval(prev.start, Math.max(prev.end, interval.end));
                    prev = merged;
                } else {
                    result.add(prev);
                    prev = interval;
                }
            }
            result.add(prev);
            return result;
        }
    }

    public static class MyComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start != o2.start) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
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

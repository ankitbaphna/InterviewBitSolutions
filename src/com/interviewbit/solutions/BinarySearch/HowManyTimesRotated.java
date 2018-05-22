package com.interviewbit.solutions.BinarySearch;

import java.util.List;

public class HowManyTimesRotated {

    public int findMin(final List<Integer> a) {
        int start = 0;
        int end = a.size() - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if(a.get(start) <= a.get(end)){
                return a.get(start);
            }
            int n = a.size()-1;
            int next = (mid+1)%n , prev = (mid+n-1)%n;
            if(a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev)) {
                return a.get(mid);
            } else if(a.get(mid) <= a.get(end)) {
                end = mid - 1;
            } else if (a.get(mid) >= a.get(start)) {
                start = mid +1;
            }
        }
        return -1;
    }
}

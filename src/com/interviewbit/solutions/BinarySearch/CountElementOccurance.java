package com.interviewbit.solutions.BinarySearch;

public class CountElementOccurance {

    public int findCount(final int[] A, int B) {
        int start = startHelper(A, B);
        int end = endHelper(A,B);
        if (start != -1 && end != -1) {
            return end - start + 1;
        } else {
            return 0;
        }
    }

    private int startHelper (final int[] A, int B) {
        int start = 0;
        int end = A.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if(A[mid] == B) {
                result = mid;
                end = mid - 1;
            } else if(A[mid] < B) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private int endHelper (final int[] A, int B) {
        int start = 0;
        int end = A.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if(A[mid] == B) {
                result = mid;
                start = mid + 1;
            } else if(A[mid] < B) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

}

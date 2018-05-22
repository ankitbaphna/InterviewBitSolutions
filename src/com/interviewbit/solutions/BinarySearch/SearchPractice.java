package com.interviewbit.solutions.BinarySearch;

public class SearchPractice {

    public static void main(String[] args) {
        int[] input = {1,1,1,1,1,1,1,1,2,2,2,2,2,13,14, 14, 14, 25, 25, 25, 25, 25,25,66,77,88};
        int[] rotatedArray = {4,14, 25,66,1,2,3};

        printElementIndex(input, 25);
        printFirstOccurrence(input, 1);
        printInRotatedArray(rotatedArray, 1);
    }

    private static void printInRotatedArray(int[] rotatedArray, int searchMe) {
        int start = 0;
        int end = rotatedArray.length-1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if(rotatedArray[mid] == searchMe) {
                System.out.println("printInRotatedArray = " + mid);
                return;
            } else if(rotatedArray[start] <= rotatedArray[mid]) {
                //left part sorted
                //check if element in this left sorted range
                if(rotatedArray[start] <= searchMe && searchMe < rotatedArray[mid]){
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            } else {
                //check if it's in range of right elements
                if(rotatedArray[mid] < searchMe && searchMe <= rotatedArray[end]){
                    start = mid+1;
                }else{
                    end = mid-1;
                }
            }
        }
    }

    private static void printFirstOccurrence(int[] input, int searchMe) {
        int start = 0;
        int end = input.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (input[mid] >=  searchMe) {
                if (input[mid] ==  searchMe) {
                    result = mid;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println("printFirstOccurrence = " + result);
    }

    private static void printElementIndex(int[] input, int searchMe) {
        int start = 0;
        int end = input.length - 1;

        while (start <= end) {
            int mid = start  + (end - start)/2;
            if(input[mid] == searchMe) {
                System.out.println("printElementIndex = " + mid);
                return;
            } else if(input[mid] > searchMe) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
    }
}

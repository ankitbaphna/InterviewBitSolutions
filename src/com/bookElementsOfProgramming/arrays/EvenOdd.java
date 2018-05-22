package com.bookElementsOfProgramming.arrays;

public class EvenOdd {

    public static void main(String[] args) {
        int[] evenOdd = {1,2,3,4,5,6,7,8,9,10};

        int nextEven = 0;
        int nextOdd = evenOdd.length-1;

        while (nextEven < nextOdd) {
            if (evenOdd[nextEven] %2 == 0) {
                nextEven++;
            } else {
                int temp = evenOdd[nextEven];
                evenOdd[nextEven] = evenOdd[nextOdd];
                evenOdd[nextOdd] = temp;
                nextOdd--;
            }
        }

        for (int i = 0; i < evenOdd.length; i++) {
            System.out.println("evenOdd = " + evenOdd[i]);
        }
    }
}

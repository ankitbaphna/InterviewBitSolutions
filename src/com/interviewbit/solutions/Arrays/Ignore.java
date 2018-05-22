package com.interviewbit.solutions.Arrays;

import java.util.Arrays;

public class Ignore {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2, 2,2,2,3,3};
        int noDupsTill = 0;
        int current = 0;
        boolean seenOnce = false;
        while (current < a.length) {
            if(a[noDupsTill] != a[current] && seenOnce) {
                noDupsTill++;
                a[noDupsTill] = a[current];
                seenOnce = false;
            } else {
                seenOnce = true;
            }
            current++;
        }
        System.out.println("noDupsTill = " + noDupsTill + ",,,"+ Arrays.toString(a));
    }
}

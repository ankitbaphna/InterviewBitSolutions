package com.bookElementsOfProgramming.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApplyPermutation {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(6,7,8,9));
        List<Integer> perm = new ArrayList<>(Arrays.asList(3,1,2,0));

        for (int i = 0; i < A.size(); i++) {
            //Check if element at index i has not been moved by checking if
            //perm.get(i) is non-negative
            int next = i;
            while (perm.get(next) >= 0) {
                Collections.swap(A, i, perm.get(next));

                int temp = perm.get(next);
                //Substracts perm.size() from entry in perm to make it negative
                //which indicates the corresponding move has been performed
                perm.set(next, perm.get(next) - perm.size());
                next = temp;
            }
        }

        //Restore perm
        for (int i = 0; i < perm.size(); i++) {
            perm.set(i, perm.get(i) + perm.size());
        }
        for (int i = 0; i < A.size(); i++) {
            System.out.println("A = " + A.get(i));
        }
    }
}

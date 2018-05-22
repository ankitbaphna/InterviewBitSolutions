package com.bookElementsOfProgramming.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(6,2,1,5,4,3,0));

        //Find 1st entry from right that is smaller than entry immediately after it
        int inversion_point = input.size()-2;
        while (inversion_point >= 0
                && input.get(inversion_point) >= input.get(inversion_point+1)) {
            inversion_point--;
        }
        if (inversion_point == -1) {
            System.out.println("This is already last permutation = ");
        }

        //Swap the smallest entry after index inversion_point that is greater than
        //input[inversion_point]. Since entries are decreasing after inversion_point,
        //if we seach in reverse order, the first entry  that is greater than
        //input[inversion_point] is the entry to swap with
        for (int i = input.size()-1; i > inversion_point ; i--) {
            if (input.get(i) > input.get(inversion_point)) {
                Collections.swap(input, inversion_point, i);
                break;
            }
        }

        //Entries in input must appear in decreasing order after inversion_point, so
        //we simply reverse these entries to get the smallest dictionary order
        Collections.reverse(input.subList(inversion_point+1, input.size()));

        System.out.println("Next Permutation = " + input.toString());
    }
}

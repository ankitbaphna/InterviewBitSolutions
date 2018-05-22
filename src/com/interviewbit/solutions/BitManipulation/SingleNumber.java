package com.interviewbit.solutions.BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(0);
        int result = singleNumber(list);
        System.out.println("result = " + result);
    }

    public static int singleNumber(final List<Integer> a) {
        int result = 0;
        for (int i : a) {
         result ^= i;
        }
        return result;
    }
}

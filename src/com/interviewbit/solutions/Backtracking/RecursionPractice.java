package com.interviewbit.solutions.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//Space complexity of recursive algos is the depth of the tree for recursion. Usually like O(n-1) eg for fibonnaci
//Time complexity: https://www.youtube.com/watch?v=pqivnzmSbq4
//
public class RecursionPractice {

    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println("factorial = " + result);

        result = fibonacci(7, new HashMap<>());
        System.out.println("fibonncci = " + result);

        result = xpown(2,5);
        System.out.println("xpown = " + result);

        ArrayList<ArrayList<Integer>> allPermutationsOfArray =  new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(1);
        input.add(3);
        getAllPermutationsOfArray(0, input, allPermutationsOfArray);
        for (ArrayList<Integer> list : allPermutationsOfArray) {
            System.out.println("list = " + list);
        }
    }

    private static void getAllPermutationsOfArray(int index, ArrayList<Integer> input,
                                                                 ArrayList<ArrayList<Integer>> result) {
        if(index == input.size() - 1 /*Reached to the end and all swipes are done*/) {
            result.add(new ArrayList<>(input));
            return;
        }

        //same as for doing it for String..left is index and right is length..no difference.. CHeck permute in Permutatins.java
        for (int i = index; i < input.size(); i++) {
            Collections.swap(input, i, index);
            getAllPermutationsOfArray(index+1, input, result);
            Collections.swap(input, i, index);
        }
    }

    private static int xpownmod (int x, int n, int d) {
        if(n == 0) {
            return 1;
        }
        if(n%2 == 0) {
            int temp = xpownmod(x , n/2, d);
            return (temp*temp)%d;
        } else {
            return ((x%d) * xpownmod(x, n-1, d))%d;
        }
    }

    private static int xpown (int x, int n) {
        if(n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        int internResult = xpown (x, n/2);
        if(n%2 == 0) {
            return internResult * internResult;
        } else {
            return internResult * internResult * x;
        }
    }

    private static int factorial(int n) {
        if (n==0 || n==1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        return n*factorial(n-1);
    }

    private static int fibonacci (int n, HashMap<Integer, Integer> map) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int fN = fibonacci(n-1, map) + fibonacci(n-2, map);
            map.put(n, fN);
            return fN;
        }
    }
}

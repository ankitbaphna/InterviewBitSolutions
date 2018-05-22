package com.interviewbit.solutions.Backtracking;

public class GCD {

    public static void main(String[] args) {
        int result = computeGCD(45,20);
        System.out.println("result = " + result);
    }

    public static int computeGCD(int a, int b){

        if(a == 0){
            return b;
        } else {
            return computeGCD(b%a, a);
        }

    }
}

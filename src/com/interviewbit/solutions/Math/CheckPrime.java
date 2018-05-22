package com.interviewbit.solutions.Math;

public class CheckPrime {

    public static void main(String[] args) {
        System.out.println("isPrime(45) = " + isPrime(45));
    }
    public static int isPrime(int a) {
        if(a == 0 || a == 1 || (a%2 == 0 && a != 2)) {
            return 0;
        }
        int sq = (int) Math.sqrt(a);
        for (int i = 2; i <= sq ; i++) {
            if(a%i == 0) {
                return 0;
            }
        }
        return 1;
    }
}

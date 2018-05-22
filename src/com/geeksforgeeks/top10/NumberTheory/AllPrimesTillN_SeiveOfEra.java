package com.geeksforgeeks.top10.NumberTheory;

import java.util.Arrays;

public class AllPrimesTillN_SeiveOfEra {

    public static void main(String[] args) {
        int N = 13;
        boolean[] primes = new boolean[N+1]; //TODO: N+1 because we need last number as well
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i*i <= N ; i++) {  //TODO: i*i is important and equality
            if (primes[i] == true) {
                for (int j = i*2; j <= N; j=j+i) { //TODO: Equality with N
                    primes[j] = false;
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }
}

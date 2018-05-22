package com.interviewbit.solutions.OthersPractice;

//http://www.geeksforgeeks.org/find-whether-given-integer-power-3-not/
public class IntPowerOf3 {

    public static void main(String[] args) {
        System.out.println("intPowerOf3(9) = " + intPowerOf3(9));
    }

    private static boolean intPowerOf3(int input) {

        /* The maximum power of 3 value that
           integer can hold is 1162261467 ( 3^19 ) .*/
        return 1162261467 % input == 0;
    }
}

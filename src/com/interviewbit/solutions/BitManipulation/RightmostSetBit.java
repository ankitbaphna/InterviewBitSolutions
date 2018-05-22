package com.interviewbit.solutions.BitManipulation;
//https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
//https://www.geeksforgeeks.org/position-rightmost-different-bit/

/**
 * Algorithm:
 * Let I/P be 12 (1100)
 * <p>
 * 1. Take two's complement of the given no as all bits are reverted
 * except the first '1' from right to left (10111)
 * <p>
 * 2  Do an bit-wise & with original no, this will return no with the
 * required one only (00010)
 * <p>
 * 3  Take the log2 of the no, you will get position -1 (1)
 * <p>
 * 4  Add 1 (2)
 */
public class RightmostSetBit {

    //-n is actually 2s compliment
    private static int getFirstSetBitPos(int n) {
        return (int) ((Math.log10(n & -n)) / Math.log10(2)) + 1;
    }

    private static boolean isPowerOfTwo(int x) {
        return ((x != 0) && ((x & (~x + 1)) == x));
    }

    // Function to find the position of
    // rightmost different bit in the
    // binary representations of 'm' and 'n'
    static int posOfRightMostDiffBit(int m, int n) {
        // position of rightmost different bit
        return getFirstSetBitPos(m ^ n);
    }

    // Drive code
    public static void main(String[] args) {
        int n = 12;
        int y = ~n + 1; //2's complement..Result is -12
        System.out.println(getFirstSetBitPos(n));
        System.out.println("is = " + isPowerOfTwo(n));

    }
}

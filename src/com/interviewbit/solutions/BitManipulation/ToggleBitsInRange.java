package com.interviewbit.solutions.BitManipulation;

//https://www.geeksforgeeks.org/toggle-bits-given-range/

/**
 * Calculate num = ((1 << r) – 1) ^ ((1 << (l-1)) – 1).
 * This will produce a number num having r number of bits and bits in the range l to r are the only set bits.
 * Now, perform n = n ^ num. This will toggle the bits in the range l to r in n.
 */
public class ToggleBitsInRange {

    // Function to toggle bits in the given range
    static int toggleBitsFromLToR(int n, int l, int r)
    {
        // calculating a number 'num' having 'r'
        // number of bits and bits in the range l
        // to r are the only set bits
        int rr = (1<<r)-1; //This gives 11111 for r=5..
        int ll = (1<<(l-1)) - 1; //Just live above..Gives 1 for l=2
        int num = ((1 << r) - 1) ^ ((1 << (l - 1)) - 1);

        // toggle bits in the range l to r in 'n'
        // and return the number
        return (n ^ num);
    }

    // driver program
    public static void main (String[] args)
    {
        int n = 50;
        int l = 2, r = 5;
        System.out.println(toggleBitsFromLToR(n, l, r));
    }
}

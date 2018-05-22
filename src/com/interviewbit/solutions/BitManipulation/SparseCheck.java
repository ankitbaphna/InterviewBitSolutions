package com.interviewbit.solutions.BitManipulation;
//https://www.geeksforgeeks.org/check-if-a-given-number-is-sparse-or-not/

/**
 * A number is said to be a sparse number if in binary
 * representation of the number no two or more consecutive bits are set
 * <p>
 * If we observer carefully, then we can notice that if we can use bitwise
 * AND of binary representation of the “given number its
 * “right shifted number”(i.e., half the given number)
 * to figure out whether the number is sparse or not.
 * Result of AND operator would be 0 if number is sparse and non-zero if not sparse
 *
 * Instead of right shift, we could have used left shift also, but left shift might lead to overflow in some cases.
 */
public class SparseCheck {

    // Return true if n is
    // sparse,else false
    static int checkSparse(int n) {
        // n is not sparse if there
        // is set in AND of n and n/2
        if ((n & (n >> 1)) >= 1) {
            return 0;
        }
        return 1;
    }

    // Driver code
    public static void main(String[] args) {
        System.out.println(checkSparse(72));
        System.out.println(checkSparse(12));
        System.out.println(checkSparse(2));
        System.out.println(checkSparse(3));
    }

}

package com.interviewbit.solutions.OthersPractice;

import java.util.HashSet;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String input = "MAN";
        //permutation("", input);
        /*List<String> result = permutationWithReturn("", input, new ArrayList<>());
        for (String s :
                result) {
            System.out.println("s = " + s);
        }*/

        /*HashSet<String> result = uniquePermutationWithReturn("", input, new HashSet<>());
        for (String s :
                result) {
            System.out.println("s = " + s);
        }*/

        //RECOMMENDED
        //http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
        //https://youtu.be/AfxHGNRtFac?t=352
        //O(N * N!)
        permute(input, 0, input.length()-1);
    }

    //Returning all of same length
    private static List<String> permutationWithReturn(String prefix, String s, List<String> result) {
        int n = s.length();
        if(n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutationWithReturn(prefix + s.charAt(i),
                        s.substring(0, i) + s.substring(i+1, n), result);
            }
        }
        return result;
    }


    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param left starting index
     * @param right end index
     */
    private static void permute(String str, int left, int right)
    {
        if (left == right)
            System.out.println(str);
        else
        {
            for (int i = left; i <= right; i++) //not from 0
            {
                str = swap(str,left,i);
                permute(str, left+1, right); // this means keeping left constant
                str = swap(str,left,i); //backtrack
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    //Printing all of same length
    private static void permutation(String prefix, String s) {
        int n = s.length();
        if(n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
            }
        }
    }

    private static HashSet<String> uniquePermutationWithReturn(String prefix, String s, HashSet<String> result) {
        int n = s.length();
        if(n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                uniquePermutationWithReturn(prefix + s.charAt(i),
                        s.substring(0, i) + s.substring(i+1, n), result);
            }
        }
        return result;
    }

}

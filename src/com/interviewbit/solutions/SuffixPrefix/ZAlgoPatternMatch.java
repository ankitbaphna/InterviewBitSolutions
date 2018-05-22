package com.interviewbit.solutions.SuffixPrefix;


import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=CpZh4eF8QBw&list=PLrmLmBdmIlpvxhscYQdvfFNWU_pdkG5de&index=1
/*Z algorithm to pattern matching
        *
        * Time complexity - O(n + m)
        * Space complexity - O(n + m)
        *
        * http://www.geeksforgeeks.org/z-algorithm-linear-time-pattern-searching-algorithm/
        * http://www.utdallas.edu/~besp/demo/John2010/z-algorithm.htm*/


public class ZAlgoPatternMatch {

    public static void main(String[] args) {
        String text = "xabcabza";
        String pattern = "abc";
        List<Integer> patternExistAtPositions = makeZArray(text.toCharArray(), pattern.toCharArray());
        System.out.println("patternExistAtPositions = " + patternExistAtPositions);
    }

    private static List<Integer> makeZArray(char[] text, char[] pattern) {
        //Create new String like --- pattern + $ + text
        char[] newString = new char[text.length + pattern.length + 1];
        int i=0;
        for (char pat : pattern) {
            newString[i++] = pat;
        }
        newString[i++] = '$';
        for (char te : text) {
            newString[i++] = te;
        }

        //
        List<Integer> result = new ArrayList<>();
        int[] Z = calculateZ(newString);
        for (int j = 0; j < Z.length; j++) {
            if(Z[j] == pattern.length /*pattern length equals index we calculated*/) {
                result.add(j - pattern.length - 1); //move pattern length positions left
            }
        }
        return result;
    }

    private static int[] calculateZ(char[] input) {
        int[] Z = new int[input.length];
        int left = 0;
        int right = 0;
        for (int k = 1; k < input.length; k++) { //start from 1 since Z[0] is 0 because there is no left array matching 0th element
            if(k > right) {
                left = right = k;
                while (right < input.length /*bound check*/
                        && input[right] == input[right-left] /*prefix matching the ongoing string*/) {
                    right++;
                }
                Z[k] = right-left; //since these many chars are matching..will be zero if nothing matched
            } else {
                //we are operating inside box
                int k1 = k - left;
                //if value does not stretches till right bound then just copy it.
                if(Z[k1] < right - k + 1) {
                    Z[k] = Z[k1];
                } else { //otherwise try to see if there are more matches.
                    left = k;
                    while(right < input.length && input[right] == input[right - left]) {
                        right++;
                    }
                    Z[k] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }
}

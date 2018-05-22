package com.interviewbit.solutions.Hashing;

import java.util.HashMap;

public class Fraction {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("solution.fractionToDecimal(1,2) = " + solution.fractionToDecimal(-1, 2));
    }

    public static class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if(numerator == 0) {
                return "0";
            }
            if(denominator == 0) {
                return "";
            }
            StringBuilder result = new StringBuilder();
            long numeratorLong = numerator;
            long denominatorLong = denominator;

            if((numeratorLong > 0 && denominatorLong < 0) || (numeratorLong < 0 && denominatorLong > 0)) {
                result.append("-");
            }

            numeratorLong = Math.abs(numeratorLong);
            denominatorLong = Math.abs(denominatorLong);



            long res = numeratorLong/denominatorLong;
            result.append(String.valueOf(res));

            long remainder = (numeratorLong % denominatorLong) * 10;
            if (remainder == 0) {
                return result.toString();
            }

            result.append(".");

            HashMap<Long, Integer> map = new HashMap<Long, Integer>();
            while (remainder != 0) {
                if(map.containsKey(remainder)) {
                    int beginning = map.get(remainder);
                    String nonRepeatingPart = result.substring(0, beginning);
                    String repeatingPart = result.substring(beginning);
                    return nonRepeatingPart + "(" + repeatingPart + ")";
                }
                map.put(remainder, result.length());
                res = remainder/denominatorLong;
                result.append(String.valueOf(res));
                remainder = (remainder % denominatorLong) * 10;
            }

            return result.toString();
        }
    }
}

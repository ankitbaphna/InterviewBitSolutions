package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

    private static final String TEMPLATE_PATH = "/data/system/users/%s/fpdata";

    public static void main(String[] args) {
        //Primitive Types
        countOnes(123);
        swapBits(73, 1 , 6);
        computeDivide(15, 3);
        computeXPowY( 2, 3);
        isNumPalindrome(12321);
        reverseDigits(123);

        //Arrays
        int[] x = {1,2,5,6,7,7,5,2,3,4,5};
        separateEvenOdds(x);
        int[] x1 = {0,1,2,2,1,0,1,2,0,0,0,1,2};
        dutchNationalFlag(x1);
        int[] x2 = {5,2,9 , 9, 9, 5 , 9};
        incrementInteger(x2);
        //int[] x3 = {3,2,0,0,2,0,1};
        int[] x3 = {3,3,1,0,2,0,1};
        advancingArray(x3);
        int[] x4 = {1,2,2,2,3,4,4,5,8,9};
        deleteDupsFromSortedArr(x4);
        int[] x5 = {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
        buySellStockOnce(x5);
        int[] x6 = {12,11,13,9,12,8,14,13,15};
        buySellStockTwice(x6);
        allPrimesTillN(61);
        int[] x7 = {1,2,3,4,5};
        arrayRotation(x7, 2);

        String s = "1";
        int yyy = Integer.valueOf(s);
        System.out.println("Integer.valueOf(s) = " + yyy);
        System.out.println("TEMPLATE_PATH = " + String.format(TEMPLATE_PATH, "9"));

        int[] fingers = new int[10];
        System.out.println("fingers = " + Arrays.toString(fingers));

        GenericClass<Integer> genericClass = new GenericClass<Integer>(12);
        System.out.println("genericClass = " + genericClass.getData());

        String[] inn = new String[3];
        inn[0] = "0:/path1:0,0,0,0,0";
        inn[1] = "6:/path1:1,0,0,0,0";
        inn[2] = "3:/path1:0,2,0,0,0";


        List<String> users = new ArrayList<>();
        for (int i = 0; i < inn.length; i++) {
            String[] pieces = inn[i].split(":");
            String[] existingFingers = pieces[2].split(",");
            boolean hasEnrolledFingers = false;
            for (String finger: existingFingers) {
                if (!finger.equals("0")) {
                    hasEnrolledFingers = true;
                    break;
                }
            }
            if (hasEnrolledFingers) {
                users.add(pieces[0]);
            }
        }
        String[] resulttt = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            resulttt[i] = users.get(i);
        }
        System.out.println("Found users: " + users.toString());

        byte[] dataBytes = new byte[32];
        for (int j = 0; j < 32; j++) {
            dataBytes[j] = Integer.valueOf(-1*j).byteValue();
        }
        System.out.println("retStatus: " + Arrays.toString(dataBytes));
        short retStatus = -3;

    }

    private static void arrayRotation(int[] x, int k) {
        k %= x.length;
        int[] result = new int[x.length];
        for (int i = 0; i+k < x.length; i++) {
            result[i] = x[i+k];
        }
        for (int i = 0; i < k; i++) {
            result[x.length-k+i] = x[i];
        }
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));

    }

    private static void allPrimesTillN(int n) {
        int[] result = new int[n+1];
        result[0] = -1;
        result[1] = -1;
        for (int i = 2; i <= n; i++) {
            if (result[i] == 0) {
                for (int j = 2; i*j <= n; j++) {
                    result[i*j] = -1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (result[i] == 0) {
                list.add(i);
            }
        }
        System.out.println("list = " + list.toString());
    }

    //TODO: Pending
    private static void buySellStockTwice(int[] x) {

    }

    private static void buySellStockOnce(int[] x) {
        int minSoFar = x[0], maxProfitSoFar = 0;
        for (int i = 0; i < x.length; i++) {
            minSoFar = Math.min(minSoFar, x[i]);
            maxProfitSoFar = Math.max(maxProfitSoFar, x[i] - minSoFar);
        }
        System.out.println("maxProfitSoFar = " + maxProfitSoFar);
    }

    //TODO: Think about that we need only 1 variable to write to that index and plan accordingly
    //Go through the array and keep index of where we wanna write
    private static void deleteDupsFromSortedArr(int[] x) {
        int writeIndex = 1;
        for (int i = 0; i < x.length; i++) {
            if (x[writeIndex-1] != x[i]) {
                x[writeIndex] = x[i];
                writeIndex++;
            }
        }
        System.out.println("deleteDupsFromSortedArr = " + Arrays
                .toString(x) + " write index " + writeIndex);
    }

    private static void advancingArray(int[] x) {
        int maxSoFar = 0;
        //TODO: checking in for loop itself is good idea
        for (int i = 0; i <= maxSoFar && maxSoFar < x.length-1; i++) {
            maxSoFar = Math.max(maxSoFar, i + x[i]);
        }
        System.out.println("reached to end? = " + ((maxSoFar >= x.length-1) ? "yes": "no"));
    }

    private static void incrementInteger(int[] x) {
        int end = x.length-1;
        while (end >= 0) {
            x[end] = x[end] + 1;
            if (x[end] > 9) {
                x[end] %= 10;
                end--;
            } else {
                break;
            }
        }
        //assuming there are no zeros in original
        if (x[0] == 0) {
            x[0] = 10;
        }
        System.out.println("incrementInteger = " + Arrays.toString(x));
    }

    private static void dutchNationalFlag(int[] x) {
        int start = 0;
        int end = x.length-1;
        int partition = 0;

        while (partition <= end) {
            if (x[partition] == 0) {
                swap(x, start, partition);
                start++;
                partition++;
            } else if(x[partition] == 2) {
                swap(x, partition, end);
                end--;
            } else {
                partition++;
            }
        }
        System.out.println("dutchNationalFlag = " + Arrays.toString(x));
    }

    private static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }

    private static void separateEvenOdds(int[] x) {
        int start = 0;
        int end = x.length-1;
        while (start <= end) {
            if (x[start] % 2 == 0) {
                int temp = x[end];
                x[end] = x[start];
                x[start] = temp;
                end--;
            } else {
                start++;
            }
        }
        System.out.println("separateEvenOdds = " + Arrays.toString(x));
    }

    private static void reverseDigits(int x) {
        long result = 0;
        long xRemaining = Math.abs(x);
        while (xRemaining != 0) {
            result = result*10 + xRemaining%10;
            xRemaining /= 10;
        }
        System.out.println("Reverse " + ((x < 0) ? -result : result));
    }

    //TODO: Remember: No shift operators here
    private static void isNumPalindrome(int x) {
        int numberOfDigits = (int) Math.log10(x) + 1;
        for (int i = 0; i < numberOfDigits; i++) {
            numberOfDigits = (int) Math.log10(x) + 1;
            int firstDigit = (int) (x / Math.pow(10, numberOfDigits-1));
            int lastDigit = x%10;
            if(firstDigit != lastDigit) {
                System.out.println("Not Palindrome");
                return;
            }
            x = (int) (x % Math.pow(10, numberOfDigits-1));
            x = x/10;
        }
        System.out.println("Palindrome");

    }

    //Prefer the recursion way instead of this
    private static void computeXPowY(double x, int y) {
        double result = 1.0;
        long power = y;
        if(y<0) {
            power = -power;
            x = 1.0/x;
        }
        while (power != 0) {
            if ((power &1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        System.out.println("computeXPowY = " + result);
    }

    //TODO: learn this
    private static void computeDivide(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }
            result += 1L << power;
            x -= yPower;
        }
        System.out.println("computeDivide = " + result);
    }


    private static void countOnes(int i) {
        int countOnes = 0;
        while (i != 0) {
            i = i & (i-1);
            countOnes++;
        }
        System.out.println("countOnes = " + countOnes);
    }

    private static void swapBits(int x, int i, int j) {
        //TODO: 3 times >>> means that it's not a cyclic rotation
        //Rotation extra values becomes zero
        System.out.println("(x>>>j = " + (x >>> j));
        if (((x >>> i)&1) != ((x>>>j)&1)) {
            //ith and jth bits differ
            //we will swap them by flipping their values.
            //Select the bits to flip with bitmask
            //since x^1 = 0 when x=1 and 1 when x = 0
            //we can perform the flip XOR

            //TODO: This is used to flip a particular bit
            int bitMask = (1 << i) | (1 << j);
            x^=bitMask;
            System.out.println("swapBits = " + x);
        }
    }


}

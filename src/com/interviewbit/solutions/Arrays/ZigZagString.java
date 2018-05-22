package com.interviewbit.solutions.Arrays;

public class ZigZagString {

    public static void main(String[] args) {
        String s = "paypalishiring";
        String result = zigzag(s, 3);
        System.out.println("result = " + result);
    }

    private static String zigzag(String a, int b) {
        if(b == 1) {
            return a;
        }
        StringBuilder result = new StringBuilder();
        int n = b + b - 2;
        for(int i = 0; i < b; i++){
            int cur = i;
            while(cur < a.length()){
                result.append(a.charAt(cur));
                cur += n;
                if(i > 0 && i < b - 1 && (cur-i-i) < a.length()){
                    result.append(a.charAt(cur - i - i));
                }
            }
        }
        return result.toString();
    }
}

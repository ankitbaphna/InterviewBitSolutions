package com.interviewbit.solutions.DynamicProgramming;

/*
http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
        Input:  digits[] = "121"
        Output: 3
// The possible decodings are "ABA", "AU", "LA"

        Input: digits[] = "1234"
        Output: 3
// The possible decodings are "ABCD", "LCD", "AWD"
*/

public class PossibleDecodings {

    public static void main(String[] args) {
        int result = solutionByGeeksOfGeeks("1234");
        System.out.println("result = " + result);
    }



    //http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
    // It is similar to the problem of counting ways of climbing stairs. The relation is dp[n]=dp[n-1]+dp[n-2].
    private static int solutionByGeeksOfGeeks (String s) {
        int n = s.length()-1;
        int[] count = new int[n+1];// A table to store results of subproblems
        count[0] = 1;
        count[1] = 1;
        char[] digits = s.toCharArray();

        for (int i = 2; i <= n; i++)
        {
            count[i] = 0;

            // If the last digit is not 0, then last digit must add to
            // the number of words
            if (digits[i-1] > '0')
                count[i] = count[i-1];

            // If second last digit is smaller than 2 and last digit is
            // smaller than 7, then last two digits form a valid character
            if (digits[i-2] == '1' || (digits[i-2] == '2' && digits[i-1] <= '6') )
                count[i] += count[i-2];
        }
        return count[n];
    }

    //https://www.youtube.com/watch?v=6OTeggyT1QE
    private static int decodeStringSimplified(String s) {
        if(s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for (int i = s.length()-1; i >= 0 ; i--) {
            if(i < s.length()-1 && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))) {
                dp[i] = dp[i+1] + dp[i+2];
            } else if (s.charAt(i) > '0') {
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    //https://www.youtube.com/watch?v=aCKyFYF9_Bg
    private static int decodeDp(String message)
    {
        int msgLen = message.length();
        int[] decodeCount = new int[msgLen + 1];

        decodeCount[0] = 1;
        decodeCount[1] = 1;

        for(int i=2; i < msgLen + 1; i++)
        {
            if(message.charAt(i - 1) > '0')
                decodeCount[i] = decodeCount[i-1];

            if((message.charAt(i - 2) < '2') || ( message.charAt(i - 2) == '2' &&  message.charAt(i - 1) < '7' ) )
                decodeCount[i] = decodeCount[i] + decodeCount[i-2];
        }

        return decodeCount[msgLen];
    }

    // It is similar to the problem of counting ways of climbing stairs. The relation is dp[n]=dp[n-1]+dp[n-2].
    public static int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        if(s.length()==1)
            return 1;

        int[] dp = new int[s.length()];
        dp[0]=1;
        if(Integer.parseInt(s.substring(0,2))>26){
            if(s.charAt(1)!='0'){
                dp[1]=1;
            }else{
                dp[1]=0;
            }
        }else{
            if(s.charAt(1)!='0'){
                dp[1]=2;
            }else{
                dp[1]=1;
            }
        }

        for(int i=2; i<s.length(); i++){
            if(s.charAt(i)!='0'){
                dp[i]+=dp[i-1];
            }

            int val = Integer.parseInt(s.substring(i-1, i+1));
            if(val<=26 && val >=10){
                dp[i]+=dp[i-2];
            }
        }

        return dp[s.length()-1];
    }
}

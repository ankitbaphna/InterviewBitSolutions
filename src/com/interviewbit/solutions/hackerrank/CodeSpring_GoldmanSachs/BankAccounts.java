package com.interviewbit.solutions.hackerrank.CodeSpring_GoldmanSachs;

import java.util.Scanner;

/**
 * You are going to receive  payments in the upcoming month. The payments are numbered from  to  and denotes the amount of money in dollars that will be paid in connection with the -th payment. Before receiving the payments, you have two banking options to consider:

 You can receive all the payments on your current bank account remembering that the bank charges you for each payment  , where  and  are given.
 You can pay the bank  dollars upfront to open a new special account for which the bank doesn't charge you for any of the upcoming transactions.
 Your task is to decide which of the above two options is more profitable to you. If both ways are equally profitable, then you prefer to be charged for each transaction.

 For example, in the image below,  transactions are given namely . For  and , the two banking option are shown as follows. You can see that for this case, paying a fee is more profitable.

 image

 Input Format

 In the first line, there is a single integer  denoting the number of scenarios to handle. After that, descriptions of all these scenarios follow. In the first line of a single scenario, there are  space-separated integers . In the second line, there are  space separated integers .

 Constraints

 Output Format

 Print exactly  lines. In the -th of them, print the answer to the -th scenario. More specifically, print feeif it's more profitable to use the current account and let the bank charge for each transaction, or print upfront if it's better to pay the bank up front for opening the new special account.
 */
public class BankAccounts {

    static String feeOrUpfront(int n, int k, int x, int d, int[] p) {
        String result = "fee"; //Prefer to charge if values are equal
        double feeSum = 0;
        for (int i = 0; i < n; i++) {
            feeSum += Math.max(k, (double)x*(double)p[i]/100);
        }
        if(feeSum > (double)d) {
            result = "upfront";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int x = in.nextInt();
            int d = in.nextInt();
            int[] p = new int[n];
            for(int p_i = 0; p_i < n; p_i++){
                p[p_i] = in.nextInt();
            }
            String result = feeOrUpfront(n, k, x, d, p);
            System.out.println(result);
        }
        in.close();
    }
}

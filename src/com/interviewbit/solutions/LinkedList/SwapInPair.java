package com.interviewbit.solutions.LinkedList;

public class SwapInPair {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);

        Solution solution = new Solution();
        ListNode result = solution.reverseInPair(A);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static class Solution {
        public ListNode reverseInPair(ListNode a) {
            if (a == null || a.next == null) {
                return a;
            }

            ListNode prev = a;
            ListNode curr = a.next;
            a = curr;

            while (true) {
                ListNode temp = curr.next;
                curr.next = prev;
                if (temp == null || temp.next == null) {
                    prev.next = temp;
                    break;
                }
                prev.next = temp.next;
                prev = temp;
                curr = prev.next;
            }
            return a;
        }
    }
}

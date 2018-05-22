package com.interviewbit.solutions.LinkedList;

public class ReverseLLKTimes {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.addNode(2);
        head.addNode(3);
        head.addNode(4);
        head.addNode(5);
        head.addNode(6);
        head.addNode(7);
        head.addNode(8);
        head.addNode(9);

        Solution solution = new Solution();
        ListNode result = solution.reverseList(head, 3);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static class Solution {
        public ListNode reverseList(ListNode A, int B) {
            if (B == 0) {
                return A;
            }
            if (A == null) {
                return A;
            }
            ListNode current = A;
            ListNode next = null;
            ListNode prev = null;

            int count = 0;

            while (count < B && current != null)
            {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            if (next != null) {
                A.next = reverseList(next, B);
            }

            return prev;
        }
    }
}

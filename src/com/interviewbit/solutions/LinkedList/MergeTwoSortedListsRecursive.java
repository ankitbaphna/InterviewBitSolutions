package com.interviewbit.solutions.LinkedList;

public class MergeTwoSortedListsRecursive {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.addNode(2);
        A.addNode(2);
        A.addNode(2);
        A.addNode(3);
        A.addNode(6);

        ListNode B = new ListNode(4);
        B.addNode(4);
        B.addNode(5);
        B.addNode(8);
        B.addNode(9);
        B.addNode(10);
        B.addNode(11);

        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(B, A);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static class Solution {

        public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            if(a.val < b.val) {
                a.next = mergeTwoLists(a.next, b);
                return a;
            } else {
                b.next = mergeTwoLists(b.next, a);
                return b;
            }
        }
    }
}

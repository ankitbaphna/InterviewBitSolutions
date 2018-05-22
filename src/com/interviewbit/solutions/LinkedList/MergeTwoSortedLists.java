package com.interviewbit.solutions.LinkedList;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode A = new ListNode(1);
        A.addNode(2);
        A.addNode(2);
        A.addNode(2);
        A.addNode(3);
        A.addNode(4);
        A.addNode(5);
        A.addNode(6);

        ListNode B = new ListNode(7);
        B.addNode(8);
        B.addNode(9);
        B.addNode(10);
        B.addNode(11);

        Solution solution = new Solution();
        ListNode result = solution.mergeTwoLists(A, B);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static class Solution {

        public static ListNode mergeTwoLists(ListNode a, ListNode b) {
            ListNode head = new ListNode(Integer.MIN_VALUE);
            ListNode temp = head;
            while(a != null && b != null){
                if(a.val < b.val){
                    head.next = a;
                    head = head.next;
                    a = a.next;
                }
                else{
                    head.next = b;
                    head = head.next;
                    b = b.next;
                }
            }

            if(a != null)
                head.next = a;
            if(b != null)
                head.next = b;

            return temp.next;
        }

        /*public ListNode mergeTwoLists(ListNode a, ListNode b) {
            if (a == null) {
                return b;
            }
            if (b == null) {
                return a;
            }
            ListNode result;
            if (a.val < b.val) {
                result = a;
            } else {
                result = b;
                b = a;
                a = result;
            }
            while(a.next != null) {
                if (a.next.val > b.val) {
                    ListNode temp = a.next;
                    a.next = b;
                    b = temp;
                }
                a = a.next;
            }
            if (a.next == null) {
                a.next = b;
            }
            return result;
        }*/
    }
}

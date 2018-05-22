package com.interviewbit.solutions.LinkedList;

public class IntersectionOfLL {

    public static void main(String[] args) {

        ListNode A = new ListNode(1);
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
        B.addNode(4);
        B.addNode(5);
        B.addNode(6);

        Solution solution = new Solution();
        ListNode result = solution.getIntersectionNode(A, B);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }
    public static class Solution {
        public ListNode getIntersectionNode(ListNode a, ListNode b) {
            if(a == null || b == null) {
                return null;
            }
            ListNode result = null;
            int Asize = a.size();
            int Bsize = b.size();
            int diff = Math.abs(Asize-Bsize);
            for (int i = 0; i < diff; i++) {
                if (Asize > Bsize){
                    a = a.next;
                } else {
                    b = b.next;
                }
            }
            while (a != null && b != null){
                if(a == b){
                    return a;
                } else {
                    a = a.next;
                    b = b.next;
                }
            }
            return result;
        }
    }
}

package com.interviewbit.solutions.LinkedList;

public class Subtract {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.addNode(43);
        /*head.addNode(3);
        head.addNode(4);
        head.addNode(5);
        head.addNode(6);*/

        Solution solution = new Solution();
        ListNode result = solution.subtract(head);

        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    public static class Solution {
        public ListNode subtract(ListNode A) {
            ListNode head = A;
            ListNode result = A;

            //reverse second half
            ListNode slowPointer = head;
            ListNode fastPointer = head;

            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }

            //now reverse in-place
            ListNode prev = slowPointer;
            ListNode rHead = slowPointer.next;
            while (rHead != null) {
                ListNode temp = rHead.next;
                rHead.next = prev;
                prev = rHead;
                rHead = temp;
            }
            rHead = prev;

            ListNode savedRHead = rHead;
            //do subtract
            while (head != rHead
                    && rHead != null
                    && head != null) {
                head.val = rHead.val - head.val;
                head = head.next;
                rHead = rHead.next;
                if (head.next == rHead
                        && rHead != null
                        && head != null){
                    head.val = rHead.val - head.val;
                    break;
                }
            }

            //reverse back 2nd half
            prev = null;
            while (savedRHead != slowPointer) {
                ListNode temp = savedRHead.next;
                savedRHead.next = prev;
                prev = savedRHead;
                savedRHead = temp;
            }

            return result;
        }
    }
}

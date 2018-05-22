package com.geeksforgeeks.top10.LinkedList;

/**
 * https://www.youtube.com/watch?v=KYH83T4q6Vs&t
 */
public class ReverseRecursive {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.add(6);
        head.add(7);

        ListNode result = reverseRecursive(head);
        while (result != null) {
            System.out.println("result.value = " + result.value);
            result = result.next;
        }
    }

    private static ListNode reverseRecursive(ListNode head) {
        if(head.next == null)
            return head;

        ListNode rest = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return rest;
    }
}

package com.geeksforgeeks.top10.LinkedList;

public class ReverseInGivenSize {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.add(6);
        head.add(7);
        head.add(8);

        ListNode result = reverse(head, 3);

        while (result != null) {
            System.out.println("result.value = " + result.value);
            result = result.next;
        }
    }

    private static ListNode reverse(ListNode head, int k) {
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next != null) {
            head.next = reverse(next, k); /* Recursively call for rest of the list and link the two sub-lists */
        }
        return prev;  /* prev becomes the new head of the list */
    }
}

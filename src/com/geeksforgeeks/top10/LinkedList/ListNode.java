package com.geeksforgeeks.top10.LinkedList;

public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public void add (int newNode) {
        ListNode newOne = new ListNode(newNode);
        ListNode head = this;
        while (head.next != null) {
            head = head.next;
        }
        head.next = newOne;
    }
}

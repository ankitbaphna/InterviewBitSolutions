package com.interviewbit.solutions.LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void addNode(int x) {
        ListNode newNode = new ListNode(x);
        ListNode head = this;
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
    }

    public int size(){
        int result = 0;
        ListNode head = this;
        while ((head != null)){
            head = head.next;
            result++;
        }
        return result;
    }

    public ListNode reverseList(){
        ListNode prev = null;
        ListNode head = this;
        while (head.next != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next = prev;
        return head;
    }
}

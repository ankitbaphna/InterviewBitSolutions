package com.geeksforgeeks.top10.LinkedList;

public class InsertInSortedWay {

    //TODO: Ask if this is doubly linked list and if values are repeating and within range or not
    public static void main(String[] args) {
        ListNode list = new ListNode(2);
        list.add(5);
        list.add(7);
        list.add(10);
        list.add(15);

        ListNode head = addInSortedOrder(list, 1);
         head = addInSortedOrder(head, 9);
         head = addInSortedOrder(head, 16);
        while (head != null) {
            System.out.println("head.value = " + head.value);
            head = head.next;
        }
    }

    private static ListNode addInSortedOrder(ListNode head, int newValue) {
        ListNode newOne = new ListNode(newValue);
        if (head == null) {
            head = newOne;
            return head;
        }
        if (head.value > newValue) {
            newOne.next = head;
            return newOne;
        }
        ListNode savedHead = head;
        ListNode prev = null;
        while (head != null && head.value < newValue) {
            prev = head;
            head = head.next;
        }
        prev.next = newOne;
        newOne.next = head;
        return savedHead;
    }
}

package com.interviewbit.solutions.hackerrank;

import com.interviewbit.solutions.LinkedList.ListNode;

public class DeleteNodesGreaterThanX {

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        head.addNode(5);
        head.addNode(6);
        head.addNode(7);
        head.addNode(12);
        head.addNode(4);
        head.addNode(13);

        ListNode result = removeNodes(head, 3);
        while (result != null) {
            System.out.println("result.val = " + result.val);
            result = result.next;
        }
    }

    static ListNode removeNodes(ListNode list, int x) {

        if(list == null) {
            return list;
        }
        ListNode prev = null;
        ListNode curr = list;
        while (curr != null) {
            if (curr.val <= x) {
                prev = curr;
                curr = curr.next;
            } else {
                curr = curr.next;
                if(prev != null) {
                    prev.next = curr;
                } else {
                   list = list.next;
                }
            }
        }
        return list;
    }
}

package com.interviewbit.solutions.HeapsAndMaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {

    private static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(a.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        //add  first nodes of all lists
        for (ListNode node : a) {
            if(node != null) {
                minHeap.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode movingHead = head;
        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            movingHead.next = temp;
            if(temp.next != null) {
                minHeap.add(temp.next);
            }
            movingHead = movingHead.next;
        }
        return head.next; //skipping 0
    }

    class ArrayContainer implements Comparable<ArrayContainer> {
        int[] arr;
        int index;

        public ArrayContainer(int[] arr, int index) {
            this.arr = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.arr[this.index] - o.arr[o.index];
        }
    }
}

package com.geeksforgeeks.top10.LinkedList;

public class MergeAtAlternatePositions {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        list1.add(4);
        list1.add(6);
        list1.add(8);

        ListNode list2 = new ListNode(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        list2.add(9);
        list2.add(11);

        mergeLists(list1, list2);

        while (list1 != null) {
            System.out.println("list1 = " + list1.value);
            list1 = list1.next;
        }

        while (list2 != null) {
            System.out.println("list2.value = " + list2.value);
            list2 = list2.next;
        }
    }

    /**
     * Merge second into first
     * @param list1
     * @param list2
     */
    private static void mergeLists(ListNode list1, ListNode list2) {
        if(list2 == null) {
            return;
        }
        if(list1 == null) {
            list1 = list2;
            return;
        }

        while (list1 != null && list2 != null) {
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;
            list1.next = list2;
            list2.next = temp1;
            list2 = temp2;
            list1 = temp1;
        }
    }
}

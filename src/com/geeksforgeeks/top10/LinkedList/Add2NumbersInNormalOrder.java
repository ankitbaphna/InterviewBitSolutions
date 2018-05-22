package com.geeksforgeeks.top10.LinkedList;

/**
 * http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 *
 * 1) Calculate sizes of given two linked lists.
 2) If sizes are same, then calculate sum using recursion.
 Hold all nodes in recursion call stack till the rightmost node,
 calculate sum of rightmost nodes and forward carry to left side.
 3) If size is not same, then follow below steps:
 ….a) Calculate difference of sizes of two linked lists. Let the difference be diff
 ….b) Move diff nodes ahead in the bigger linked list.
 Now use step 2 to calculate sum of smaller list and right
 sub-list (of same size) of larger list. Also, store the carry of this sum.
 ….c) Calculate sum of the carry (calculated in previous step) with the remaining
 left sub-list of larger list. Nodes of this sum are added
 at the beginning of sum list obtained previous step.
 */
public class Add2NumbersInNormalOrder {

    //TODO: ask if this is single linked list or double..simple if doubly
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        head1.add(9);
        head1.add(9);

        ListNode head2 = new ListNode(1);
        head2.add(8);
        head2.add(8);

        addSameSize(head1, head2);
        if (carry != 0) {
            System.out.println("carry = " + carry);
        }
    }

    /*private static int getSize (ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }*/

    /*private static ListNode add(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        int size1 = getSize(head1);
        int size2 = getSize(head2);

        if (size1 == size2) {
            addSameSize(head1, head2);
        } else {
            //Always keep list1 larger than list2
            if (size1 < size2) {
                ListNode temp = head1;
                head1 = head2;
                head2 = temp;
            }
            int diff = Math.abs(size1-size2);
            // move diff. number of nodes in first list
            ListNode temp = head1;
            ListNode cur = null;
            while (diff-- >= 0)
            {
                cur = temp;
                temp = temp.next;
            }
            addSameSize(cur, head2);

            // get addition of remaining first list and carry
            propogatecarry(head1);
        }

        // if some carry is still there, add a new node to
        // the front of the result list. e.g. 999 and 87
        if (carry > 0)
            push(carry, 3);
        return null;
    }*/

    private static int carry  = 0;
    private static void addSameSize(ListNode head1, ListNode head2) {
        // Since the function assumes linked lists are of
        // same size, check any of the two head pointers
        if (head1 == null)
            return;

        // Recursively add remaining nodes and get the carry
        addSameSize(head1.next, head2.next);

        int sum = head1.value + head2.value + carry;
        carry = sum / 10; //TODO: Here carry can not be one of the params..since that is passed even before it's calculated
        sum = sum % 10;
        System.out.println("sum = " + sum);
    }

}

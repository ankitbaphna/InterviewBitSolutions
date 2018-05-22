package com.interviewbit.solutions.LinkedList;


/**
 *
 * http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 *
 * Distance traveled by fast pointer = 2 * (Distance traveled
 by slow pointer)

 (m + n*x + k) = 2*(m + n*y + k)

 Note that before meeting the point shown above, fast
 was moving at twice speed.

 x -->  Number of complete cyclic rounds made by
 fast pointer before they meet first time

 y -->  Number of complete cyclic rounds made by
 slow pointer before they meet first time

 m + k = (x-2y)*n

 Which means m+k is a multiple of n.

 So if we start moving both pointers again at same speed such that one
 pointer (say slow) begins from head node of linked list and other
 pointer (say fast) begins from meeting point. When slow pointer
 reaches beginning of linked list (has made m steps).
 Fast pointer would have made also moved m steps as they are now moving
 same pace. Since m+k is a multiple of n and fast starts from k, they
 would meet at the beginning. Can they meet before also?
 No because slow pointer enters the cycle first time after m steps.
 */
public class ListCycle {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = head.next;

        Solution solution = new Solution();
        ListNode result = solution.detectCycle(head);
        if(result != null) {
            System.out.println(result.val + "");
        } else {
            System.out.println("NULL");
        }

    }

    public static class Solution {
        public ListNode detectCycle(ListNode a) {
            if(a == null) {
                return null;
            }
            ListNode slow = a;
            ListNode fast = a;

            ListNode meetingNode = null;

            while(fast !=null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast) {
                    meetingNode  = slow;
                    break;
                }
            }

            //Get loop size
            /*int loopSize = 0;
            if(meetingNode != null) {
                while (slow != null) {
                    slow = slow.next;
                    loopSize++;
                    if(slow == meetingNode){
                        break;
                    }
                }
            }*/

            ListNode loopPoint = null;
            ListNode startPoint = a;
            //break the cycle
            //ListNode saveLast = meetingNode;
            while (meetingNode != null) {
                if(meetingNode == startPoint) {
                    loopPoint = meetingNode;
                    //Break the cycle
                    //saveLast.next = null;
                    break;
                }
                meetingNode = meetingNode.next;
                startPoint = startPoint.next;
                //break the cycle
                //saveLast = meetingNode;
            }
            return loopPoint;
        }
    }
}

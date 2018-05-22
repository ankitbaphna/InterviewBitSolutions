package com.interviewbit.solutions.OthersPractice;

import java.util.LinkedList;

public class LLQueueStack {

    public static void main(String[] args) {
        LinkedList<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println("q.removeFirst() = " + q.remove());
        }

        /*q.addFirst(1);
        q.addFirst(2);
        q.addFirst(3);
        q.addFirst(4);

        while (!q.isEmpty()) {
            System.out.println("q.removeFirst() = " + q.removeLast());
        }*/
    }
}

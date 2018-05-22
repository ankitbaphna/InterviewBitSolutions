package com.interviewbit.solutions.Trees;

import java.util.ArrayList;
import java.util.List;

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        TreeNode result = sortedArrayToBST(list);
        System.out.println("result = " + result);
    }

    public static TreeNode sortedArrayToBST(final List<Integer> a) {
        int mid = (a.size() - 1) / 2;
        return helper(a, 0, a.size() - 1);
    }

    private static TreeNode helper(final List<Integer> a, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(a.get(mid));
        node.left = helper(a, start, mid - 1);
        node.right = helper(a, mid + 1, end);
        return node;
    }
}

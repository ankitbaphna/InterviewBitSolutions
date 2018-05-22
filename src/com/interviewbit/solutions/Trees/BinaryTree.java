package com.interviewbit.solutions.Trees;

public class BinaryTree {

    public TreeNode addNode(int x, TreeNode root) {
        TreeNode newNode = new TreeNode(x);
        TreeNode savedHead = root;
        if(root == null) {
            root = newNode;
            return root;
        }

        TreeNode prev = null;
        while(root != null) {
            prev = root;
            if(root.val < x) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        if(prev.val < x) {
            prev.right = newNode;
        } else {
            prev.left = newNode;
        }
        return savedHead;
    }
}

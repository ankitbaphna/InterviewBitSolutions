package com.interviewbit.solutions.Trees;

public class CountLeafs {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(-10, root);
        root = bt.addNode(17, root);
        root = bt.addNode(20, root);
        root = bt.addNode(0, root);
        root = bt.addNode(-20, root);
        root = bt.addNode(11, root);
        System.out.println("result = " + countLeaves(root));
    }

    public static int countLeaves(TreeNode head) {
        if(head == null) {
            return 0;
        }
        if(head.left == null && head.right == null) {
            return 1;
        }
        return countLeaves(head.left) + countLeaves(head.right);
    }
}

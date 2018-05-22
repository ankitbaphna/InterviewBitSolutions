package com.interviewbit.solutions.Trees;

public class LCABT {

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

        System.out.println("lca = " + lca(root, 11, 20));
    }

    public static int lca(TreeNode a, int val1, int val2) {
        if (a == null) {
            return -1;
        }
        if(a.val == val1 || a.val == val2) {
            return a.val;
        }
        int left = lca(a.left, val1, val2);
        int right = lca(a.right, val1, val2);
        if(left != -1 && right != -1) {
            return a.val;
        }
        if(left == -1 && right == -1) {
            return -1;
        }
        if (left != -1) {
            return left;
        }
        if (right != -1) {
            return right;
        }
        return -1;
    }
}

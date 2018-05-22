package com.interviewbit.solutions.Trees;

public class ValidBST {

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

        System.out.println("isValidBST(root) = " + isValidBST(root));
    }

    private static boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if(root.val >= minValue && root.val < maxValue) {
            return helper(root.left, minValue, root.val) & helper(root.right, root.val, maxValue);
        } else {
            return false;
        }
    }
}

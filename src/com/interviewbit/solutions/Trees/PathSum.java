package com.interviewbit.solutions.Trees;

public class PathSum {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = null;
        root = bt.addNode(5, root);
        root = bt.addNode(1000, root);
        root = bt.addNode(200, root);

        System.out.println("hasPathSum(root, 36) = " + hasPathSum(root, 1000));
    }

    public static int hasPathSum(TreeNode a, int b) {
        return helper(a, b) ? 1 : 0;
    }

    public static boolean helper(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && (root.left == null && root.right == null))
            return true;

        return helper(root.left, sum - root.val)
                || helper(root.right, sum - root.val);
    }

}

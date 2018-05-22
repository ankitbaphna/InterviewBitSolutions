package com.interviewbit.solutions.Trees;

public class SymmetricBinaryTree {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = null;
        root = bt.addNode(10, root);
        root = bt.addNode(15, root);
        root = bt.addNode(15, root);
        root = bt.addNode(17, root);
        root = bt.addNode(20, root);
        root = bt.addNode(0, root);
        root = bt.addNode(-20, root);
        root = bt.addNode(11, root);

        System.out.println("isSymmetric(root) = " + isSymmetric(root));
    }

    public static int isSymmetric(TreeNode a) {
        return  helper(a, a);
    }

    private static int helper(TreeNode node1, TreeNode node2)
    {
        if (node1 == null && node2 == null) {
            return 1;
        }

        if (node1 != null && node2 != null && node1.val == node2.val)
            return (helper(node1.left, node2.right) == 1
                    && helper(node1.right, node2.left) == 1) ? 1 : 0;

        return 0;
    }
}

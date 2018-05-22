package com.interviewbit.solutions.Trees;

public class BalancedBinaryTree {

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

        System.out.println("isBal = " + isBalanced(root));
    }

    /*public static int isBalanced(TreeNode a) {
        return (helper(a) != Integer.MIN_VALUE) ? 1 : 0;
    }

    public static int helper(TreeNode root) {
        if(root == null) {
            return 1;
        }
        int lHeight = helper(root.left);
        if (lHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rHeight = helper(root.right);
        if(rHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if(Math.abs(lHeight - rHeight) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(lHeight, rHeight) + 1;
        }
    }*/


    //Editorial solution
    static int balanced = 1;

    public static int isBalanced(TreeNode A) {

        balanced(A);
        return balanced;

    }

    public static int balanced(TreeNode A) {

        if (A == null)
            return 0;

        int heightLeft = 1 + balanced(A.left);
        int heightRight = 1 + balanced(A.right);

        if (Math.abs(heightLeft - heightRight) > 1)
            balanced = 0;

        return Math.max(heightLeft, heightRight);

    }
}

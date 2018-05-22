package com.interviewbit.solutions.Trees;

public class LCABST {
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

        System.out.println("lcabst(root, 15, 20) = " + lcabst(root, 15, 20));
    }

    private static TreeNode lcabst(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        if ((root.val >= val1 && root.val <= val2) ||
                (root.val <= val1 && root.val >= val2) ){
            return root;
        }
        if(root.val > val1 && root.val > val2) {
            return lcabst(root.left, val1, val2);
        }
        if (root.val < val1 && root.val < val2) {
            return lcabst(root.right, val1, val2);
        }
        return null;
    }
}

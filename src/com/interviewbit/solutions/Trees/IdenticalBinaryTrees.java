package com.interviewbit.solutions.Trees;

public class IdenticalBinaryTrees {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode head = treeNode;
        treeNode.right = new TreeNode(2);
        treeNode = treeNode.right;
        treeNode.left = new TreeNode(3);
        treeNode = treeNode.left;

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode head1 = treeNode1;
        treeNode1.right = new TreeNode(2);
        treeNode1 = treeNode1.right;
        treeNode1.left = new TreeNode(3);
        treeNode1 = treeNode1.left;

        Solution solution = new Solution();
        System.out.println("solution.isSameTree(treeNode, treeNode1) = " + solution.isSameTree(treeNode, treeNode1));
    }

    public static class Solution {
        public int isSameTree(TreeNode a, TreeNode b) {
            if(a == null && b == null) {
                return 1;
            } else if(a == null || b == null) {
                return 0;
            }
            if(a.val == b.val
                    && isSameTree(a.left, b.left) == 1
                    && isSameTree(a.right, b.right) == 1) {
                return 1;
            }
            return 0;
        }
    }
}

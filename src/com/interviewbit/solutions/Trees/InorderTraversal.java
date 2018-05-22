package com.interviewbit.solutions.Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode head = treeNode;
        treeNode.right = new TreeNode(2);
        treeNode = treeNode.right;
        treeNode.left = new TreeNode(3);
        treeNode = treeNode.left;

        Solution solution = new Solution();
        /*ArrayList<Integer> result =*/ solution.printInIterative(head);
        /*for (int r : result) {
            System.out.println("r = " + r);
        }*/
    }

    public static class Solution {
        public ArrayList<Integer> inorderTraversalWithRecursion(TreeNode a) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            if (a == null) {
                return result;
            }
            result.addAll(inorderTraversalWithRecursion(a.left));
            result.add(a.val);
            result.addAll(inorderTraversalWithRecursion(a.right));
            return result;
        }

        public ArrayList<Integer> inorderTraversal(TreeNode a) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            if (a == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode node = a;

            //push all lefts
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            while (stack.size() > 0) {
                node = stack.pop();
                result.add(node.val);
                if (node.right != null) {
                    node = node.right;
                    while (node != null) {
                        stack.push(node);
                        node = node.left;
                    }
                }
            }
            return result;
        }

        public void printInIterative (TreeNode a) {
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode node = a;
            while(true){
                if(node != null){
                    stack.addFirst(node);
                    node = node.left;
                }
                else{
                    if(stack.isEmpty()){
                        break;
                    }
                    node = stack.pollFirst();
                    System.out.println(node.val);
                    node = node.right;
                }
            }
        }
    }
}

package com.interviewbit.solutions.Trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreePractice {
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

        doInOrder(root);
        doPreOrder(root);
        doPostOrder(root);

        boolean isFound = doBFS(20, root);
        System.out.println("isFound = " + isFound);

        printInLevel(root);

        printInSpiral(root);

        System.out.println("heightOfTree(root) = " + heightOfTree(root));

        System.out.println("countNodes(root) = " + countNodes(root));
    }

    private static int countNodes (TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.right) + countNodes(root.left) + 1;
    }

    private static int heightOfTree (TreeNode root) {
        if(root == null) {
            return -1; //Height is -1 for empty tree
        }
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    private static void printInSpiral(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                System.out.println("Spiral = " + node.val);
                if(node.left != null) {
                    stack2.push(node.left);
                }
                if(node.right != null) {
                    stack2.push(node.right);
                }
            }
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                System.out.println("Spiral = " + node.val);
                if(node.right != null) {
                    stack1.push(node.right);
                }
                if(node.left != null) {
                    stack1.push(node.left);
                }
            }
        }
    }

    //https://www.youtube.com/watch?v=7uG0gLDbhsI&feature=youtu.be
    private static void printInLevel(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
            q.offer(null); //Null as delimiter
        }
        int level = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                //same level
                System.out.println("In level node = " + node.val + " level " + level);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            } else {
                if (!q.isEmpty()) {
                    level++;
                    q.offer(null); //new level
                }
            }
        }
    }

    private static boolean doBFS(int searchMe, TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visitedNodes = new HashSet<>(); //Optional for trees..Needed for Graphs
        q.offer(root);
        while (!q.isEmpty()) {
            System.out.println("q = " + q);
            TreeNode node = q.poll();
            if (searchMe == node.val) {
                return true;
            }
            if (!visitedNodes.contains(node)) { //Optional for trees..Needed for Graphs
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                visitedNodes.add(node); //Optional for trees..Needed for Graphs
            }
        }
        return false;
    }

    private static void doPostOrder(TreeNode root) {
        if (root != null) {
            doPostOrder(root.left);
            doPostOrder(root.right);
            System.out.println("PostOrder = " + root.val);
        }
    }

    private static void doPreOrder(TreeNode root) {
        if (root != null) {
            System.out.println("Preorder = " + root.val);
            doPreOrder(root.left);
            doPreOrder(root.right);
        }
    }

    private static void doInOrder(TreeNode root) {
        if (root != null) {
            doInOrder(root.left);
            System.out.println("Inorder = " + root.val);
            doInOrder(root.right);
        }
    }

}

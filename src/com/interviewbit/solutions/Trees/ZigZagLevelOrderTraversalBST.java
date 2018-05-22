package com.interviewbit.solutions.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBST {
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

        ArrayList<ArrayList<Integer>> result = zigzagLevelOrder(root);
        for (ArrayList<Integer> list:
            result){
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(a);

        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(a.val);

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            tempList = new ArrayList<>();
            while(!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                tempList.add(node.val);
                if(node.left != null) {
                    stack2.push(node.left);
                }
                if(node.right != null) {
                    stack2.push(node.right);
                }
            }
            if(tempList.size() != 0) {
                result.add(tempList);
            }

            tempList = new ArrayList<>();
            while(!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                tempList.add(node.val);
                if(node.right != null) {
                    stack1.push(node.right);
                }
                if(node.left != null) {
                    stack1.push(node.left);
                }
            }
            if(tempList.size() != 0) {
                result.add(tempList);
            }
        }

        return result;
    }
}

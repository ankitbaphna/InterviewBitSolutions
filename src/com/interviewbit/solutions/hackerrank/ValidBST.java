package com.interviewbit.solutions.hackerrank;

import java.util.*;

public class ValidBST {

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static class BST {
        Node root;
        ArrayList<Integer> preOrderList = new ArrayList<>();

        public void insert (int val) {
            Node savedRoot = root;
            if (root == null) {
                root = new Node(val);
                return;
            }

            Node prev = null;
            while (root != null) {
                prev = root;
                if (root.val >= val) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }

            Node newNode = new Node(val);
            if(prev.val < val) {
                prev.right = newNode;
            } else {
                prev.left = newNode;
            }

            root = savedRoot;
        }

        public String preOrderString() {
            getPreOrderList(root);
            return preOrderList.toString();
        }

        private void getPreOrderList(Node currentNode) {
            if(currentNode != null) {
                preOrderList.add(currentNode.val);
                getPreOrderList(currentNode.left);
                getPreOrderList(currentNode.right);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int totalTests = scan.nextInt();

        for (int i=0; i<totalTests ; i++) {
            int totalNode = scan.nextInt();
            scan.nextLine();
            String sValue = scan.nextLine();
            String[] sValues = sValue.split(" ");
            BST bst = new BST();
            for(String s : sValues) {
                bst.insert(Integer.parseInt(s));
            }

            if(bst.preOrderString().equals(sValue)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}

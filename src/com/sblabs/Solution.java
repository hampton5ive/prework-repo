package com.sblabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Solution {
    public static class Node {
        int val;
        Node left, right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        String q = scanner.nextLine();
        int numQueries = Integer.parseInt(q);

        for (int i=0; i < numQueries; i++) {
            // take num nodes
            String nn = scanner.nextLine();
            int numNodes = Integer.parseInt(nn);
            String path = scanner.nextLine();
            boolean currentPathValid = isValidPreorder(path);
            System.out.println(currentPathValid);
        }
    }

    private static boolean isValidPreorder(String inputPath) {
        // 2, 1, 3
        String[] tokens = inputPath.split("\\s");
        List<Integer> path = new ArrayList<Integer>();
        for (String token: tokens) {
            int num = Integer.parseInt(token);
            path.add(num);
        }

        Node root = new Node(path.get(0), null, null);
        // create a BST froom the path
        for (int i=1; i < path.size(); i++) {
            Node newNode = new Node(path.get(i), null, null);
            root = insert(root, newNode);
        }
        // run a preorder traversal of that BST and see if it correlates to path
        List<Integer> preorderPath = preOrder(root, new ArrayList<Integer>());

        for (int i=0; i < path.size(); i++) {
            if (path.get(i) != preorderPath.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> preOrder(Node node, List<Integer> prePath) {
        if (node == null) return null;
        prePath.add(node.val);
        preOrder(node.left, prePath);
        preOrder(node.right, prePath);
        return prePath;
    }

    private static Node insert(Node current, Node newNode) {
        if (current == null) {
            return newNode;
        }
        if (newNode.val < current.val) {
            current.left = insert(current.left, newNode);
        }
        else {
            current.right = insert(current.right, newNode);
        }
        return current;
    }


}

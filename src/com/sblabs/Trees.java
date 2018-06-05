package com.sblabs;

import java.util.ArrayList;

public class Trees {

    public static void main(String[] args) {

    }

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public int isSameTree(TreeNode A, TreeNode B) {
        boolean same = sameHelper(A, B);
        if (same) {
            return 1;
        }
        return 0;
    }

    public boolean sameHelper(TreeNode A, TreeNode B) {
        if (A == null && B != null) {
            return false;
        }
        if (A != null && B == null) {
            return false;
        }
        if (A != null && B != null && A.val != B.val) {
            return false;
        }
        if (A == null && B == null) {
            return true;
        }
        boolean left = sameHelper(A.left, B.left);
        boolean right = sameHelper(A.right, B.right);
        return left && right;
    }

    public int isSymmetric(TreeNode A) {
        boolean result = helper(A.left, A.right);
        if (result) {
            return 1;
        }
        return 0;
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null) {
            return true;
        }
        if (right == null) {
            return true;
        }

        if (left.val != right.val) {
            return false;
        }
        boolean leftResult = helper(left.left, right.right);
        boolean rightResult = helper(left.right, right.left);
        return leftResult && rightResult;
    }

    public int sumNumbers(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int temp = 0;
        helper(A, temp, result);
        int sum = 0;
        if (result == null || result.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < result.size(); i++) {
            sum = sum + result.get(i);
        }
        return sum % 1003;
    }

    public static void helper(TreeNode root, int sum, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        int temp = (sum + root.val) * 10;
        if (root.left == null && root.right == null) {
            int total = sum + root.val;
            //System.out.println(total);
            result.add(total % 1003);
            return;
        }
        if (root.left == null) {
            helper(root.right, temp % 1003, result);
        } else if (root.right == null) {
            helper(root.left, temp % 1003, result);
        } else {
            helper(root.left, temp % 1003, result);
            helper(root.right, temp % 1003, result);
        }
        return;
    }

}

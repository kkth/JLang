package com.kun;

import java.util.Stack;

public class Range_sum_938 {

    public static void main(String[] args) {
        Range_sum_938 rangeSum938 = new Range_sum_938();

        TreeNode root = BTrees.getTree();
        System.out.println(rangeSum938.rangeSumBST(root, 7, 15));

        TreeNode root2 = BTrees.getTree2();
        System.out.println(rangeSum938.rangeSumBST(root2, 6, 10));
    }

    /*
        Traverse the tree by in-order
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null)
            return sum;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                if (node.val >= low && node.val <= high) {
                    sum += node.val;
                    System.out.println(node.val);
                }
                cur = node.right;
            }
        }
        return sum;
    }
}

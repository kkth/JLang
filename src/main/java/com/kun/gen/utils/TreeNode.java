package com.kun.gen.utils;

public class TreeNode {
    public int val;
    public TreeNode left = null;
    public TreeNode right = null;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

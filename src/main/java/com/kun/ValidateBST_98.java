package com.kun;

public class ValidateBST_98 {


    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return false;
        if((root.left == null ) && (root.right == null)){
            return true;
        }
        if((root.left == null) && (root.right != null)){
            return (root.val <= root.right.val) && (isValidBST(root.right));
        }
        if((root.left != null) && (root.right == null)){
            return (root.val >= root.left.val) && (isValidBST(root.left));
        }
        return (root.val >= root.left.val) && (isValidBST(root.left)) &&
                (root.val <= root.right.val) && (isValidBST(root.right));
    }
}

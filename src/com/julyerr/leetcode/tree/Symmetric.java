package com.julyerr.leetcode.tree;

public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return issymmetric(root.left, root.right);
    }

    private boolean issymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return issymmetric(p.left, q.right) && issymmetric(p.right, q.left);
    }
}

package com.julyerr.leetcode.tree;

/*
 * 针对左右孩子进行递归判断即可
 * */
public class Rob {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int t1 = 0;
        int t2 = 0;
        if (root.left != null) {
            t1 = rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            t2 = rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(root.val + t1 + t2, rob(root.left) + rob(root.right));
    }
}

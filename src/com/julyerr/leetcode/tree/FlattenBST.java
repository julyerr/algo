package com.julyerr.leetcode.tree;

public class FlattenBST {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
//        调整前驱指针
        if (prev != null) {
            prev.right = root;
            prev.left = null;
        }

//        保存left,right节点
        TreeNode left = root.left;
        TreeNode right = root.right;

        prev = root;
        flatten(left);
        flatten(right);
    }
}

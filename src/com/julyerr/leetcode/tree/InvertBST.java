package com.julyerr.leetcode.tree;

public class InvertBST {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
//        先交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
//        递归调用左右节点处理
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

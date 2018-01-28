package com.julyerr.targetOffer.tree;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

/**
 * 简单递归即可
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        mirror(root);
    }

    private void mirror(TreeNode node) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        mirror(node.left);
        mirror(node.right);
    }
}

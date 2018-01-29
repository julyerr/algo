package com.julyerr.targetOffer.tree;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Depth {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return treeDepth(root);
    }

    private int treeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(treeDepth(node.left), treeDepth(node.right));
    }
}

package com.julyerr.leetcode.array;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */

/**
 * the p in preOrder is equals to the middle of q in inOrder
 * using recursely
 */
public class ConstructBSTPI {
    int p;
    int[] preOrder;
    int[] inOrder;

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        this.preOrder = preOrder;
        this.inOrder = inOrder;
        this.p = 0;
        return buildTree(0, preOrder.length);
    }

    public TreeNode buildTree(int start, int end) {
        if (start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[p]);
        int i;
        for (i = start; i < end && preOrder[p] != inOrder[i]; i++) ;
        p++;
        root.lChild = buildTree(start, i);
        root.rChild = buildTree(i + 1, end);
        return root;
    }
}

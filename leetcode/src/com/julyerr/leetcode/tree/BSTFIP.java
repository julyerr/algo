package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class BSTFIP {
    int p;
    int[] inOrder;
    int[] postOrder;

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        this.p = postOrder.length - 1;
        this.inOrder = inOrder;
        this.postOrder = postOrder;
        return buildTree(0, postOrder.length);
    }

    TreeNode buildTree(int start, int end) {
        if (start >= end) {
            return null;
        }

        TreeNode node = new TreeNode(postOrder[p]);
        int i;
        for (i = start; i < end && postOrder[p] != inOrder[i]; i++) ;
        p--;
        //build the right node first and then left child.
        node.rChild = buildTree(i + 1, end);
        node.lChild = buildTree(start, i);
        return node;
    }
}

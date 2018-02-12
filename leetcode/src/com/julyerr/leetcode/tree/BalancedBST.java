package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */

/**
 * simple recurse the BST
 */
public class BalancedBST {
    public boolean isBalancedBST(TreeNode node) {
        if (node == null) {
            return true;
        }

        return Math.abs(height(node.lChild) - height(node.rChild)) <= 1
                && isBalancedBST(node.lChild) && isBalancedBST(node.rChild);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.lChild), height(node.rChild)) + 1;
    }
}

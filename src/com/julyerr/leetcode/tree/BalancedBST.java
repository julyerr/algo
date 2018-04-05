package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every Task never differ by more than 1.
 */

/**
 * simple recurse the BST
 */
public class BalancedBST {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return balancedHelp(root,new int[1]);
    }

    //    判断该节点是否平衡，并且返回node的高度
    private boolean balancedHelp(TreeNode node, int[] height) {
        if (node == null) {
            height[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];
        if (!balancedHelp(node.left, left) || !balancedHelp(node.right, right) || Math.abs(left[0] - right[0]) > 1) {
            return false;
        }
        height[0] = Math.max(left[0], right[0]) + 1;
        return true;
    }
}

package com.julyerr.leetcode.DFS;

import com.julyerr.leetcode.array.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 */


/*
 * 通过简单的height比较，实现简单但是时间复杂度比较高
 * 剑指offer中的利用后续遍历的方式，效率提高很多
 * */
class Solution {
    public boolean isBalanced(TreeNode root) {
//        check validation
        if (root == null) {
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        return balanced(root, new int[1]);
    }

    private boolean balanced(TreeNode node, int[] height) {
        if (node == null) {
            height[0] = 0;
            return true;
        }

        int[] left = new int[1];
        int[] right = new int[1];
        if (!balanced(node.lChild, left) || !balanced(node.rChild, right) || Math.abs(left[0] - right[0]) > 1) {
            return false;
        }
        height[0] = 1 + (left[0] > right[0] ? left[0] : right[0]);
        return true;
    }
}
package com.julyerr.leetcode.tree;

public class MinmumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        对应各种情况处理
        if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        } else if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

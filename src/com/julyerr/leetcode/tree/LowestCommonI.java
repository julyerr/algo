package com.julyerr.leetcode.tree;

public class LowestCommonI {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        int min = p.val > q.val ? q.val : p.val;
        int max = p.val + q.val - min;

        while (root != null) {
//            在root的右边
            if (root.val < min) {
                root = root.right;
//            在root的左边
            } else if (root.val > max) {
                root = root.left;
//             处于两者之间
            } else {
                return root;
            }
        }
        return null;
    }
}

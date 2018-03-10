package com.julyerr.leetcode.tree;

public class LowestCommonII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        root等于p或者q可以直接返回
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

//        左右节点分别包含p,q
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}

package com.julyerr.leetcode.tree;

public class PathSumI {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
//        只有在当前节点没有左右孩子节点的时候才可能进行返回判断
        if (root.left == null && root.right == null) {
            return sum == 0 ? true : false;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}

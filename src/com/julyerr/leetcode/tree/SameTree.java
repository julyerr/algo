package com.julyerr.leetcode.tree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
//        直接如此判断，判断的是同一个对象，显然不行
//        if (p != q) {
//            return false;
//        }
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

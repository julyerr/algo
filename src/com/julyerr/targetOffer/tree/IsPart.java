package com.julyerr.targetOffer.tree;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。
 */

/**
 * 注意递归过程中判断情况即可
 */
public class IsPart {
    public boolean isPart(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) {
            return false;
        }
        TreeNode node = findNode(r1, r2);
        if (node == null) {
            return false;
        }
        return equal(r1, r2);
    }

    private TreeNode findNode(TreeNode r, TreeNode node) {
        if (r == null) {
            return null;
        }
        if (r.data == node.data) {
            return r;
        }
        if (r.data > node.data) {
            return findNode(r.left, node);
        }
        return findNode(r.right, node);
    }

    private boolean equal(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 != null && r2 != null) {
            if (r1.data != r2.data) {
                return false;
            }
            return equal(r1.left, r2.left) && equal(r1.right, r2.right);
        }
        return false;
    }
}

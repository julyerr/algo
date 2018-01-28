package com.julyerr.targetOffer.tree;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

/**
 * 递归左右的child进行判断
 */
public class Symmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return symmetrical(pRoot.left, pRoot.right);
    }

    private boolean symmetrical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 != null) {
            if (node1.data == node2.data) {
                return symmetrical(node1.left, node2.right)
                        && symmetrical(node1.right, node2.left);
            }
        }
        return false;
    }
}

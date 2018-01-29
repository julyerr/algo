package com.julyerr.targetOffer.tree;

import java.util.Stack;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class KNode {
    TreeNode KthNode(TreeNode pRoot, int k) {
//        check validation
        if (pRoot == null || k <= 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRoot;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                k--;
                if (k == 0) {
                    return p;
                }
                p = p.right;
            }
        }
        return null;
    }
}

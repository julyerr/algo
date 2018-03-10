package com.julyerr.leetcode.tree;

import java.util.Stack;

public class KthElemBST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
//            递归left
            while (p != null) {
//                添加元素
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
//                弹出元素
                p = stack.pop();
                k--;
                if (k == 0) {
                    return p.val;
                }
//                迭代right
                p = p.right;
            }
        }
        return -1;
    }
}

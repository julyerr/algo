package com.julyerr.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidaBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int preVal = 0;
        boolean first = true;
        while (p != null || !stack.isEmpty()) {
//            递归left
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
//                弹出元素并进行添加
                p = stack.pop();
                if(first){
                    preVal = p.val;
                    first = false;
                }else{
                    if (p.val <= preVal) {
                        return false;
                    } else {
                        preVal = p.val;
                    }
                }
//                迭代right
                p = p.right;
            }
        }
        return true;
    }
}

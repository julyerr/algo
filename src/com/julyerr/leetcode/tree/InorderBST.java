package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */

public class InorderBST {
//    递归形式
//    public List<Integer> inorderTraversal(TreeNode Task) {
//        List<Integer> rt = new ArrayList<>();
//        if(Task == null){
//            return rt;
//        }
//        //called by multi times,clear it first
//        inorder(Task,rt);
//        return rt;
//    }
//
//    private void inorder(TreeNode Task,List<Integer> rt) {
//        if (Task == null) {
//            return;
//        }
//
////        递归left
//        inorder(Task.left,rt);
////        添加元素
//        rt.add(Task.val);
////        递归right
//        inorder(Task.right,rt);
//    }

//    非递归形式
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rt = new ArrayList<>();

        if (root == null) {
            return rt;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
//            递归left
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
//                弹出元素并进行添加
                p = stack.pop();
                rt.add(p.val);
//                迭代right
                p = p.right;
            }
        }
        return rt;
    }
}

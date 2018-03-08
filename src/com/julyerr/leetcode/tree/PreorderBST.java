package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */


/**
 * using stackQueue to store the right node
 */
public class PreorderBST {
//    递归形式
//    public List<Integer> preorderTraversal(TreeNode node) {
//        List<Integer> rt = new ArrayList<>();
//        if(node == null){
//            return rt;
//        }
//        //called by multi times,clear it first
//        preorder(node,rt);
//        return rt;
//    }
//
//    private void preorder(TreeNode node,List<Integer> rt) {
//        if (node == null) {
//            return;
//        }
//
////        添加元素
//        rt.add(node.val);
////        递归left
//        preorder(node.left,rt);
////        递归right
//        preorder(node.right,rt);
//    }

    //    非递归形式
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rt = new ArrayList<>();

        if (root == null) {
            return rt;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
//            递归left
            while (p != null) {
//                添加元素
                rt.add(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
//                弹出元素
                p = stack.pop();
//                迭代right
                p = p.right;
            }
        }
        return rt;
    }
}

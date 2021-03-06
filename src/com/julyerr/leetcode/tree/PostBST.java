package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */

/**
 * using the first flag to show the Task is first in the stackQueue or not
 */
public class PostBST {

    //    递归形式
//    public List<Integer> postorderTraversal(TreeNode Task) {
//        List<Integer> rt = new ArrayList<>();
//        if(Task == null){
//            return rt;
//        }
//        postorder(Task,rt);
//        return rt;
//    }
//
//    private void postorder(TreeNode Task,List<Integer> rt) {
//        if (Task == null) {
//            return;
//        }
//
////        递归left
//        postorder(Task.left,rt);
////        递归right
//        postorder(Task.right,rt);
////        添加元素
//        rt.add(Task.val);
//    }


    //    非递归形式
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rt = new ArrayList<>();
        if (root == null) {
            return rt;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root, visited = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                p = stack.peek().right;
//                访问当前节点，仅当right=null或者right已经访问过了
                if (p != null && p != visited) {
                    stack.add(p);
//                    进行下一次迭代
                    p = p.left;
                } else {
                    p = stack.pop();
//                    访问
                    visited = p;
                    rt.add(p.val);
                    p = null;
                }
            }
        }
        return rt;
    }
}


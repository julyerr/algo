package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */


/**
 * using stack to store the right node
 */
public class PreorderBST {
    public List<Integer> preOrderTraversal(TreeNode node) {
        List<Integer> rt = new ArrayList<Integer>();
        if (node == null) {
            return rt;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = node;
        while (p != null || stack.isEmpty()) {
            while (p != null) {
                rt.add(p.data);
                stack.add(p);
                p = p.lChild;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.rChild;
            }
        }
        return rt;
    }
}

package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */

/**
 * using the first flag to show the node is first in the stack or not
 */
public class PostBST {
    public List<Integer> postOrderTraversal(TreeNode node) {
        List<Integer> rt = new ArrayList<Integer>();
        if (node == null) {
            return rt;
        }
        Stack<PostTreeNode> stack = new Stack<PostTreeNode>();
        TreeNode p = node;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                PostTreeNode post = new PostTreeNode();
                post.node = p;
                post.first = true;
                stack.push(post);
                p = p.lChild;
            }
            if (!stack.isEmpty()) {
                PostTreeNode t = stack.pop();
                if (t.first) {
                    t.first = false;
                    stack.push(t);
                    p = t.node.rChild;
                } else {
                    rt.add(t.node.data);
                    //fetch the new node
                    p = null;
                }
            }
        }
        return rt;
    }
}

class PostTreeNode {
    TreeNode node;
    boolean first;
}


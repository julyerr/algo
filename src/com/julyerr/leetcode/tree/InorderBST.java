package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */

public class InorderBST {
    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode node) {
        //called by multi times,clear it first
        list.clear();
        inorder(node);
        return list;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.lChild);
        list.add(node.data);
        inorder(node.rChild);
    }
}

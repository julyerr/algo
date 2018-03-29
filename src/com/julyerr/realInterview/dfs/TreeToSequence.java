package com.julyerr.realInterview.dfs;

import com.julyerr.leetcode.tree.TreeNode;

/*
 * 这道题主要是理解题目的意思:https://www.nowcoder.com/practice/e3a3a1a956914d8ca5688ea47a5cf9c9
 * */
public class TreeToSequence {
    public String toSequence(TreeNode root) {
        if (root == null) {
            return "";
        }
        return "(" + toSequence(root.left) + toSequence(root.right) + ")";
    }
}

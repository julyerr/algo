package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */

//if from bottom to the top
//        Collections.reverse(rt);
public class Levelorder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rt = new ArrayList<>();
        if (root == null) {
            return rt;
        }

        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
//            下一层元素添加
            for (TreeNode node :
                    cur) {
                tmp.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
//            交换，下一次迭代
            rt.add(tmp);
            cur = next;
        }
//        Collections.reverse(rt);
        return rt;
    }
}

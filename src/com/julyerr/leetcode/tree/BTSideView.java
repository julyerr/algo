package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */


/**
 * similar to level traversal but just push the right elem into the array
 */

public class BTSideView {
    public List<Integer> rightSideView(TreeNode node) {
        List<Integer> rt = new ArrayList<Integer>();
        if (node == null) {
            return rt;
        }
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        final TreeNode END = new TreeNode(0);
        deque.add(node);
        deque.add(END);
        while (!deque.isEmpty()) {
            TreeNode p = deque.pop();
            if (p == END) {
                if (!deque.isEmpty()) {
                    deque.add(END);
                }
            } else {
                //if the next node is END , just push the data into the rt
                if (deque.peek() == END) {
                    rt.add(p.data);
                }
                if (p.left != null) {
                    deque.add(p.left);
                }
                if (p.right != null) {
                    deque.add(p.right);
                }
            }
        }
        return rt;
    }
}

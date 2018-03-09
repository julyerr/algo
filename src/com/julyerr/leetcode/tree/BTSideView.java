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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rt = new ArrayList<>();
        if (root == null) {
            return rt;
        }

        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            List<TreeNode> next = new ArrayList<>();
//            下一层元素添加
            for (TreeNode node :
                    cur) {
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            rt.add(cur.get(cur.size() - 1).val);
            //            交换，下一次迭代
            cur = next;
        }
        return rt;
    }
}

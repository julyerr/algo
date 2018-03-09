package com.julyerr.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rt = new ArrayList<>();
        if (root == null) {
            return rt;
        }

        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        boolean flag = true;
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
            if (!flag) {
                Collections.reverse(tmp);
            }
            flag = !flag;
            rt.add(tmp);
            cur = next;
        }
//        Collections.reverse(rt);
        return rt;
    }
}

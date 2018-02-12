package com.julyerr.targetOffer.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

public class ZigZagTraversal {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> rt = new ArrayList<>();
        if (pRoot == null) {
//            照说，如果pRoot == null, 返回的应该是[[]]而不是[].
//           rt.add(new ArrayList<>());
            return rt;
        }
        Queue<TreeNode> pre = new LinkedList<>();
        pre.add(pRoot);
        Queue<TreeNode> cur = new LinkedList<>();
        boolean flag = false;
        while (!pre.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            flag = !flag;
            while (!pre.isEmpty()) {
                TreeNode node = pre.poll();
                tmp.add(node.data);
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
            if (flag) {
                rt.add(tmp);
            } else {
                Collections.reverse(tmp);
                rt.add(tmp);
            }
            pre = cur;
            cur = new LinkedList<>();
        }
        return rt;
    }
}

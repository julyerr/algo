package com.julyerr.leetcode.tree;

import java.util.LinkedList;

public class PopulateNextPointer {
//    层次遍历调整
    //    public void connect(TreeLinkNode root) {
//        if (root == null) {
//            return;
//        }
//
//        LinkedList<TreeLinkNode> cur, next;
//        cur = new LinkedList<>();
//        cur.add(root);
//
//        while (!cur.isEmpty()) {
//            next = new LinkedList<>();
//            int size = cur.size();
//            for (int i = 0; i < size; i++) {
//                TreeLinkNode first = cur.get(i);
//                if (first.left != null) {
//                    next.add(first.left);
//                }
//                if (first.right != null) {
//                    next.add(first.right);
//                }
//                if (i == size - 1) {
//                    break;
//                }
//                first.next = cur.get(i + 1);
//            }
//            cur.get(size - 1).next = null;
//
//            cur = next;
//        }
//    }

    //    递归方式
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
//        调整当前节点
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null && root.next.left != null) {
            root.right.next = root.next.left;
        }
//        递归调整left,right
        connect(root.left);
        connect(root.right);
    }
}

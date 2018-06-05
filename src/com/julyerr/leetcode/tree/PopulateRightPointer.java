package com.julyerr.leetcode.tree;

/*
 * 参考资料：http://fisherlei.blogspot.com/2012/12/leetcode-populating-next-right-pointers_29.html
 * 注意其中几个坑
 * */
public class PopulateRightPointer {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
//        这里需要一个循环判断
        TreeLinkNode p = root.next;
        while (p != null) {
            if (p.left != null) {
                p = p.left;
                break;
            }
            if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }
        if (root.right != null) {
            root.right.next = p;
        }
        if (root.left != null) {
            root.left.next = root.right != null ? root.right : p;
        }
//        右端先设置完成之后，然后再进行left设置
        connect(root.right);
        connect(root.left);
    }

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}

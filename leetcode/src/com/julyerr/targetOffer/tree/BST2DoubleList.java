package com.julyerr.targetOffer.tree;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

/**
 * 按照中序遍历的方式跳针前后指针即可
 */
public class BST2DoubleList {
    public TreeNode Convert(TreeNode pRootOfTree) {
//        check validation
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = pRootOfTree;
        TreeNode newHead = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (pre == null) {
                    pre = cur;
                    newHead = cur;
                } else {
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                }
                cur = cur.right;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        BST2DoubleList bst2DoubleList = new BST2DoubleList();
        int[] nums = new int[]{8, 6, 10, 5, 7, 9, 11};
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = BSTTree.insertRecurse(root, nums[i]);
        }

        TreeNode node = bst2DoubleList.Convert(root);
        TreeNode p = node;
        while (p.right != null) {
            System.out.print(p.data + " ");
            p = p.right;
        }
        System.out.print(p.data);
        System.out.println("first traversal finished");

        while (p.left != null) {
            System.out.print(p.data + " ");
            p = p.left;
        }
        System.out.println(p.data);
        System.out.println("second traversal finished");
    }
}



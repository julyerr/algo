package com.julyerr.leetcode.tree;

import java.util.Stack;

/*
 * 开始没有理解题目意思，参考资料：
 *   https://blog.csdn.net/wzy_1988/article/details/43675445
 * */
public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.add(p);
            p = p.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.isEmpty();
    }

    /**
     * @return the next smallest number,通过内置策略进行处理
     */
    public int next() {
        TreeNode node = stack.pop();
        int ret = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
        }
        return ret;
    }
}

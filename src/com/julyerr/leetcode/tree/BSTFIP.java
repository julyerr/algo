package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
public class BSTFIP {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
//        check validation
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return constructBT(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode constructBT(int[] inorder, int inStart, int inEnd, int[] post, int pStart, int pEnd) {
        if (inStart > inEnd || pStart > pEnd) {
            return null;
        }
        int i = 0;
        for (i = inStart; i <= inEnd; i++) {
            if (inorder[i] == post[pEnd]) {
                break;
            }
        }
        TreeNode node = new TreeNode(post[pEnd]);
        node.left = constructBT(inorder, inStart, i - 1, post, pStart, pStart + i - inStart - 1);
        node.right = constructBT(inorder, i + 1, inEnd, post, pStart + i - inStart, pEnd - 1);
        return node;
    }
}

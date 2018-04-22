package com.julyerr.leetcode.tree;

public class BSTFIF {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        check validation
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return constructBT(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode constructBT(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
//        边界范围
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int i = 0;
        for (i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                break;
            }
        }
        TreeNode newNode = new TreeNode(pre[preStart]);
        newNode.left = constructBT(pre, preStart + 1, preStart+(i-inStart), in, inStart, i - 1);
        newNode.right = constructBT(pre, preStart+(i-inStart)+1, preEnd, in, i + 1, inEnd);
        return newNode;
    }

}

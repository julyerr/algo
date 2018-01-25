package com.julyerr.targetOffer.tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */


/**
 * 设置一个p的游标作为新的node，start,end只是针对in数组而言
 */
public class ConstructTree {
    private static int p = 0;

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        return reConstructBinaryTree(pre, in, 0, pre.length);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in, int start, int end) {
        if (start >= end || p == pre.length) {
            return null;
        }
        TreeNode node = new TreeNode(pre[p]);
        int i;
        for (i = start; i < end; i++) {
            if (in[i] == pre[p]) {
                break;
            }
        }
        p++;
        node.left = reConstructBinaryTree(pre, in, start, i);
        node.right = reConstructBinaryTree(pre, in, i + 1, end);
        return node;
    }

    public static void main(String[] args) {
//        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
//        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        int[] pre = new int[]{1, 2, 4, 5, 3};
        int[] in = new int[]{4, 2, 5, 1, 3};
        TreeNode root = reConstructBinaryTree(pre, in);
//        BSTTree.print(BSTTree.levelOrder(root));
        BSTTree.print(BSTTree.preOrder(root));
        BSTTree.print(BSTTree.inOrder(root));
        BSTTree.print(BSTTree.postOrder(root));
    }
}

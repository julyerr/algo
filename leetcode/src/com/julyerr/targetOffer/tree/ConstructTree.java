package com.julyerr.targetOffer.tree;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */


/**
 * 通过设置两个左右的边界进行条件判断
 */
public class ConstructTree {

    /*
     * 这种方式构建的有效的前提是二叉树必须是BST
     * */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0) {
            return null;
        }
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int i = 0;
        for (i = inStart; i <= inEnd; i++) {
            if (pre[preStart] == in[i]) {
                break;
            }
        }
        TreeNode node = new TreeNode(pre[preStart]);
//        针对二叉树而不是BST，需要设置preStart+(i-inStart)而不是i
        node.left = reConstructBinaryTree(pre, preStart + 1, preStart + (i - inStart), in, inStart, i - 1);
        node.right = reConstructBinaryTree(pre, preStart + (i - inStart) + 1, preEnd, in, i + 1, inEnd);
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

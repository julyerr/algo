package com.julyerr.targetOffer.tree;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

/**
 * 比较直观的想法是利用深度去比较，然而每个节点需要比较进行深度比较，性能比较低
 * 作者思路比较巧妙，先将左右的节点访问，并且获取到
 * 相应的深度，然后直接比较即可
 */
public class IsBalanced {
//    使用深度进行比较
//    public boolean IsBalanced_Solution(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        return isBalanced(root);
//    }
//
//    private boolean isBalanced(TreeNode Task) {
//        if (Task == null) {
//            return true;
//        }
//        if (Math.abs(treeDepth(Task.left) - treeDepth(Task.right)) > 1) {
//            return false;
//        }
//        return isBalanced(Task.left) && isBalanced(Task.right);
//    }
//
//    private int treeDepth(TreeNode Task) {
//        if (Task == null) {
//            return 0;
//        }
//        return 1 + Math.max(treeDepth(Task.left), treeDepth(Task.right));
//    }

    //    后序遍历的方式
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return tmp(root, new int[1]);
    }

    private boolean tmp(TreeNode node, int[] depth) {
        if (node == null) {
            depth[0] = 0;
            return true;
        }
        int[] left = new int[1];
        int[] right = new int[1];
        if (!(tmp(node.left, left) && tmp(node.right, right)) || Math.abs(left[0] - right[0]) > 1) {
            return false;
        }
        depth[0] = 1 + Math.max(left[0], right[0]);
        return true;
    }

    public static void main(String[] args) {
        IsBalanced isBalanced = new IsBalanced();
//        int[] nums = new int[]{6,3,7,2,4,5};
        int[] nums = new int[]{7, 4, 10, 3, 5, 6};
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = BSTTree.insertRecurse(root, nums[i]);
        }

        System.out.println(isBalanced.IsBalanced_Solution(root));
    }
}

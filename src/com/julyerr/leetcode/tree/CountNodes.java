package com.julyerr.leetcode.tree;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

//        分别获取left,right的高度
        int leftHeight = 1;
        int rightHeight = 1;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while(left!=null){
            left = left.left;
            leftHeight++;
        }
        while(right!=null){
            right = right.right;
            rightHeight++;
        }

//        完全满二叉树
        if(leftHeight == rightHeight){
            return (1<<leftHeight)-1;
        }

        return 1+countNodes(root.left)+countNodes(root.right);
    }
}

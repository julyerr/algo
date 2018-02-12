package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

public class BTTFIF {
    int p ;
    int[] preOrder;
    int[] inOrder;
    public TreeNode buildTree(int[] inOrder,int[] preOrder){
        this.inOrder = inOrder;
        this.preOrder = preOrder;
        this.p = 0;
        return buildTree(0,preOrder.length);
    }

    TreeNode buildTree(int start,int end){
        if(start >= end){
            return null;
        }

        TreeNode node = new TreeNode(preOrder[p]);
        int i ;
        for (i = start; i < end && inOrder[i] != preOrder[p]; i++) ;
        p++;
        node.lChild = buildTree(start,i);
        node.rChild = buildTree(i+1,end);
        return node;
    }
}

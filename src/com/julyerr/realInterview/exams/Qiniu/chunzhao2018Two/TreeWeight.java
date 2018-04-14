package com.julyerr.realInterview.exams.Qiniu.chunzhao2018Two;


public class TreeWeight {
    public static int largeW(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return node.w;
        }
        return Math.max(node.w, Math.max(largeW(node.left), largeW(node.right)));
    }
    
    private static class TreeNode{
        int w;
        TreeNode left,right;

        public TreeNode(int w) {
            this.w = w;
        }
    }
}

package com.julyerr.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class SumTopBottom {
//    路径基础上添加求和的功能
    //    private int sum =0;
//    public int sumNumbers(TreeNode root) {
//        dfs(root,new ArrayList<>());
//        return sum;
//    }
//
//    private void dfs(TreeNode Task,List<Integer> cur){
//        if(Task == null){
//            return;
//        }
//        cur.add(Task.val);
//        if(Task.left==null&&Task.right==null){
//            int tmp = 0;
//            for (int i = 0; i < cur.size(); i++) {
//                tmp = 10*tmp+cur.get(i);
//            }
//            sum += tmp;
//        }
//        dfs(Task.left,cur);
//        dfs(Task.right,cur);
//        cur.remove(cur.size()-1);
//    }

    //    将根节点一路的值传递到叶子节点
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int parantVal) {
//        部分子节点为空
        if (node == null) {
            return 0;
        }
        int val = parantVal * 10 + node.val;
//        已经是叶子节点，直接返回值
        if (node.left == null && node.right == null) {
            return val;
        }
        return dfs(node.left, val) + dfs(node.right, val);
    }
}

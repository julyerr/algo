package com.julyerr.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> rt = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return rt;
        }
        dfs(root, new ArrayList<Integer>(), sum);
        return rt;
    }

    private void dfs(TreeNode node, List<Integer> cur, int target) {
        if (node == null) {
            return;
        }

        target -= node.val;
//        添加进当前节点
        cur.add(node.val);
//        只有在叶子节点的时候再进行判断
        if (node.left == null && node.right == null) {
            if (target == 0) {
                rt.add(new ArrayList<>(cur));
            }
        }
        dfs(node.left, cur, target);
        dfs(node.right, cur, target);
//        删除当下节点，不影响后面操作
        cur.remove(cur.size() - 1);
    }
}

package com.julyerr.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class NumOfTreeII {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
//       共用一个数组
        return dfs(nums, 0, n);
    }

    public List<TreeNode> dfs(int[] nums, int start, int end) {
        List<TreeNode> rt = new ArrayList<>();
        if (start >= end) {
//            null也需要添加进来遍历
            rt.add(null);
            return rt;
        }

//        以不同元素为root，构建tree数组
        for (int i = start; i < end; i++) {
            for (TreeNode left :
                    dfs(nums, start, i)) {
                for (TreeNode right :
                        dfs(nums, i + 1, end)) {
                    TreeNode node = new TreeNode(nums[i]);
                    node.left = left;
                    node.right = right;
                    rt.add(node);
                }
            }
        }
        return rt;
    }
}

package com.julyerr.leetcode.dynamic;

import com.julyerr.targetOffer.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 */


/**
 * 没有必要可以追求方法，只需要将问题解决即可
 * 如果直接处理非常麻烦，转而使用递归
 * 递归封装私有方法，针对1..n分别设置root节点，可以传入数组，然后针对传入的数组同时进行迭代
 */

public class UniqueBSTII {
    class TreeNode {
        Integer data;
        TreeNode left, right;

        public TreeNode(Integer data) {
            this.data = data;
        }
    }


    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return generateTrees(nums);
    }

    private List<TreeNode> generateTrees(int[] nums) {
        List<TreeNode> list = new ArrayList<>();
        if (nums.length == 0) {
            list.add(null);
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            for (TreeNode left :
                    generateTrees(Arrays.copyOfRange(nums, 0, i))) {
                for (TreeNode right :
                        generateTrees(Arrays.copyOfRange(nums, i + 1, nums.length))) {
                    TreeNode root = new TreeNode(nums[i]);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}

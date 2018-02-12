package com.julyerr.leetcode.DFS;

import com.julyerr.targetOffer.tree.TreeNode;
import com.julyerr.targetOffer.tree.BSTTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 */

/*
 * 尽量减少额外空间的使用，复用迭代中使用的空间
 * */
public class BTPath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rt = new ArrayList<>();
        if (root == null) {
            return rt;
        }
        List<Integer> list = new ArrayList<>();
        bTPaths(root, rt, list);
        return rt;
    }

    private void bTPaths(TreeNode node, List<String> stringList, List<Integer> list) {
        list.add(node.data);
        if (node.left != null) {
            bTPaths(node.left, stringList, list);
        }
        if (node.right != null) {
            bTPaths(node.right, stringList, list);
        }
        if (node.left == null && node.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                stringBuilder.append("->").append(list.get(i));
            }
            stringList.add(stringBuilder.toString());
        }
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        BTPath btPath = new BTPath();
        int[] nums = new int[]{4, 3, 5, 2};
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = BSTTree.insertRecurse(root, nums[i]);
        }
        for (String string :
                btPath.binaryTreePaths(root)) {
            System.out.println(string);
        }
        System.out.println();
    }
}

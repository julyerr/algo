package com.julyerr.targetOffer.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

/**
 * 面试的时候，没有测试环境，最好能够测试之后再提交代码
 */
public class PathSum {
    private ArrayList<ArrayList<Integer>> rt = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return rt;
        }
        findPath(root, target, new ArrayList<>());
        return rt;
    }

    private void findPath(TreeNode node, int target, List<Integer> list) {
        target -= node.data;
        list.add(node.data);
//        ensure the node in the last layer
        if (target == 0 && node.left == null && node.right == null) {
            rt.add(new ArrayList<>(list));
            return;
        }
        if (node.left != null) {
            findPath(node.left, target, new ArrayList<>(list));
        }
        if (node.right != null) {
            findPath(node.right, target, new ArrayList<>(list));
        }
    }

    public static void main(String[] args) {
        TreeNode root = null;
        int[] nums = new int[]{10, 5, 12, 4, 7};
        for (int i = 0; i < nums.length; i++) {
            root = BSTTree.insertRecurse(root, nums[i]);
        }
        for (Integer integer :
                BSTTree.levelOrder(root)) {
            System.out.print(integer + " ");
        }
        System.out.println("finished level traversal");

        PathSum pathSum = new PathSum();
        ArrayList<ArrayList<Integer>> rt = pathSum.FindPath(root, 22);
        for (int i = 0; i < rt.size(); i++) {
            for (int j = 0; j < rt.get(i).size(); j++) {
                System.out.print(rt.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}

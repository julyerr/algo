package com.julyerr.targetOffer.tree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

/**
 * 做这道题目花了较长的时间，首先明确A、B二叉树并不是BST树，
 * 然后注意B可以只是A的一部分，并不是子树（坑）
 */
public class IsPart {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return hasSubtree(root1, root2);
    }

    private boolean hasSubtree(TreeNode node1, TreeNode node2) {
        if (equal(node1, node2)) {
            return true;
        }
        if (node1.left != null && hasSubtree(node1.left, node2)) {
            return true;
        }
        if (node1.right != null) {
            return hasSubtree(node1.right, node2);
        }
        return false;
    }

    private boolean equal(TreeNode node1, TreeNode node2) {
        if (node1 != null && node2 != null) {
            if (node1.data != node2.data) {
                return false;
            }
            return equal(node1.left, node2.left) && equal(node1.right, node2.right);
        }
        if (node2 == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 6, 9, 3, 7};
        TreeNode root1 = null;
        for (int i = 0; i < nums.length; i++) {
            root1 = BSTTree.insertRecurse(root1, nums[i]);
        }

        int[] nums2 = new int[]{6, 2, 7};
        TreeNode root2 = null;
        for (int i = 0; i < nums2.length; i++) {
            root2 = BSTTree.insertRecurse(root2, nums2[i]);
        }
        IsPart isPart = new IsPart();
        System.out.println(isPart.hasSubtree(root1, root2));
    }
}

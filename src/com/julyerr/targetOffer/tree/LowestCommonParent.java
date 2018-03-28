package com.julyerr.targetOffer.tree;

/**
 * 输入一棵树的根节点，输入两个被观察节点，求这两个节点的最低(最近)公共祖先。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 开始没有解题思路，参考了https://www.jianshu.com/p/edffe43abc14
 * 比较巧妙的方式是，从root找到分别到达两个被观察节点路径，然后找到两条路径的最后一个公共节点即可
 */
public class LowestCommonParent {
    public TreeNode lowestCommonParent(TreeNode root, TreeNode node1, TreeNode node2) {
//        check validation
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        getPath(list1, root, node1);
        getPath(list2, root, node2);
        int index = 0;
        while (index < list1.size() && index < list2.size()) {
            if (list1.get(index) != list2.get(index)) {
                return list1.get(index - 1);
            }
            index++;
        }
        return null;
    }

    /*
    这道题花了较长的时间去解决，关键是递归的过程需要处理好元素的添加和删除，
    如果没有找到元素需要remove已经添加进来的元素
    * */
    private boolean getPath(List<TreeNode> queue, TreeNode node, TreeNode node1) {
        queue.add(node);
        if (node == node1) {
            return true;
        }
        if (node.left != null && getPath(queue, node.left, node1)) {
            return true;
        }
        if (node.right != null && getPath(queue, node.right, node1)) {
            return true;
        }
        queue.remove(node);
        return false;
    }

    public static void main(String[] args) {
        LowestCommonParent lowestCommonParent = new LowestCommonParent();
        TreeNode node = null;
        int[] nums = new int[]{5, 3, 7, 2, 6, 8};
        TreeNode[] nodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new TreeNode(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            node = BSTTree.insertRecurse(node, nodes[i]);
        }
        System.out.println("level traversal tree finished");
//        TreeNode found = lowestCommonParent.lowestCommonParent(Node, nodes[4], nodes[5]);
        TreeNode found = lowestCommonParent.lowestCommonParent(node, nodes[3], nodes[2]);
        if (found != null)
            System.out.println("found:" + found.data);
        else {
            System.out.println("found:null");
        }
    }
}

package com.julyerr.targetOffer.tree;

import java.util.*;

public class BSTTree {

    public static TreeNode insertRecurse(TreeNode node, Integer data) {
        if (node == null) {
            return new TreeNode(data);
        }
        if (node.data.compareTo(data) > 0) {
            node.left = insertRecurse(node.left, data);
        } else if (node.data.compareTo(data) < 0) {
            node.right = insertRecurse(node.right, data);
        }
        return node;
    }

    public static TreeNode deleteRecurse(TreeNode node, Integer data) {
        if (node == null || node.data.compareTo(data) == 0) {
            return null;
        }
        if (node.data.compareTo(data) > 0) {
            node.left = deleteRecurse(node.left, data);
        } else {
            node.right = deleteRecurse(node.right, data);
        }
        return node;
    }

    public static List preOrderRecurse(TreeNode node) {
        List list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        preOrderRecurse(node, list);
        return list;
    }

    private static void preOrderRecurse(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        preOrderRecurse(node.left, list);
        preOrderRecurse(node.right, list);
    }

    public static List postOrderRecurse(TreeNode node) {
        List list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        postOrderRecurse(node, list);
        return list;
    }

    private static void postOrderRecurse(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        postOrderRecurse(node.left, list);
        postOrderRecurse(node.right, list);
        list.add(node.data);
    }

    public static List inOrderRecurse(TreeNode node) {
        List list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        inOrderRecurse(node, list);
        return list;
    }

    private static void inOrderRecurse(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        inOrderRecurse(node.left, list);
        list.add(node.data);
        inOrderRecurse(node.right, list);
    }

    public static List levelOrder(TreeNode node) {
        List list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        levelOrder(node, list);
        return list;
    }

    private static void levelOrder(TreeNode node, List list) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode n = queue.poll();
            list.add(n.data);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    public static void print(List<Integer> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer data = (Integer) iterator.next();
            System.out.print(data + " ");
        }
        System.out.println();
    }

    //    non recurse
    public static List preOrder(TreeNode node) {
        List list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        TreeNode p = node;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                list.add(p.data);
                stack.add(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
        return list;
    }

    public static List inOrder(TreeNode node) {
        List list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        TreeNode p = node;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                list.add(p.data);
                p = p.right;
            }
        }
        return list;
    }

    //    实现方式比较巧妙，设置visited指针，针对没有孩子的情况和已经访问过的情况才真正pop元素
    public static List postOrder(TreeNode node) {
        List list = new ArrayList<>();
        if (node == null) {
            return list;
        }
        TreeNode p = node;
        TreeNode visited = null;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.peek().right;
                if (p != null && p != visited) {
                    stack.add(p);
                    p = p.left;
                } else {
                    visited = stack.pop();
                    list.add(visited.data);
                    p = null;
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 2, 4};
        TreeNode bstTree = null;
        for (int i = 0; i < nums.length; i++) {
            bstTree = insertRecurse(bstTree, nums[i]);
        }

//        preorder
//        List<Integer> list = preOrderRecurse(bstTree);
        List<Integer> list = preOrder(bstTree);
        print(list);

//        inorder
//        list =inOrderRecurse(bstTree);
        list = inOrder(bstTree);
        print(list);

//        postOrder
//        list = postOrderRecurse(bstTree);
        list = postOrder(bstTree);
        print(list);

//        levelOrder
        list = levelOrder(bstTree);
        print(list);
    }


}

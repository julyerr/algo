package com.julyerr.targetOffer.tree;

import java.util.*;

public class BSTTree<T extends Comparable> {
    private TreeNode<T> root;

    public void insertRecurse(T data) {
        root = insertRecurse(root, data);
    }

    private TreeNode<T> insertRecurse(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }
        if (node.data.compareTo(data) > 0) {
            node.left = insertRecurse(node.left, data);
        } else if (node.data.compareTo(data) < 0) {
            node.right = insertRecurse(node.right, data);
        }
        return node;
    }

    public void deleteRecurse(T data) {
        root = deleteRecurse(root, data);
    }

    private TreeNode<T> deleteRecurse(TreeNode<T> node, T data) {
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

    public List<T> preOrderRecurse() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        preOrderRecurse(root, list);
        return list;
    }

    private void preOrderRecurse(TreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        preOrderRecurse(node.left, list);
        preOrderRecurse(node.right, list);
    }

    public List<T> postOrderRecurse() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postOrderRecurse(root, list);
        return list;
    }

    private void postOrderRecurse(TreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        postOrderRecurse(node.left, list);
        postOrderRecurse(node.right, list);
        list.add(node.data);
    }

    public List<T> inOrderRecurse() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inOrderRecurse(root, list);
        return list;
    }

    private void inOrderRecurse(TreeNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        inOrderRecurse(node.left, list);
        list.add(node.data);
        inOrderRecurse(node.right, list);
    }

    public List<T> levelOrder() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        levelOrder(root, list);
        return list;
    }

    private void levelOrder(TreeNode<T> node, List<T> list) {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode<T> n = queue.poll();
            list.add(n.data);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    public void print(List<T> list) {
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            T data = iterator.next();
            System.out.print(data + " ");
        }
        System.out.println();
    }

    //    non recurse
    public List<T> preOrder() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode<T> p = root;
        Stack<TreeNode<T>> stack = new Stack<>();
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

    public List<T> inOrder() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode<T> p = root;
        Stack<TreeNode<T>> stack = new Stack<>();
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
    public List<T> postOrder() {
        List<T> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode<T> p = root;
        TreeNode<T> visited = null;
        Stack<TreeNode<T>> stack = new Stack<>();
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
        BSTTree<Integer> bstTree = new BSTTree<>();
        for (int i = 0; i < nums.length; i++) {
            bstTree.insertRecurse(nums[i]);
        }

//        preorder
//        List<Integer> list = bstTree.preOrderRecurse();
        List<Integer> list = bstTree.preOrder();
        bstTree.print(list);

//        inorder
//        list = bstTree.inOrderRecurse();
        list = bstTree.inOrder();
        bstTree.print(list);

//        postOrder
//        list = bstTree.postOrderRecurse();
        list = bstTree.postOrder();
        bstTree.print(list);

//        levelOrder
        list = bstTree.levelOrder();
        bstTree.print(list);
    }
}

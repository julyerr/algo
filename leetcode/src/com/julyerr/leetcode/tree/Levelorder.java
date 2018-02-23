package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */

//if from bottom to the top
//        Collections.reverse(rt);
public class Levelorder {
    public List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        if (node == null) {
            return rt;
        }

        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        List<Integer> level = new ArrayList<>();
        final TreeNode END = new TreeNode(0);
        deque.add(node);
        deque.add(END);
        while (!deque.isEmpty()) {
            TreeNode p = deque.pop();
            if (p == END) {
                rt.add(new ArrayList<Integer>(level));
                //have added all the elements to the deque,clear it.
                level.clear();
                if (!deque.isEmpty()) {
                    deque.add(END);
                }
            } else {
                level.add(p.data);
                if (p.lChild != null) {
                    deque.add(p.lChild);
                }
                if (p.rChild != null) {
                    deque.add(p.rChild);
                }
            }
        }
//        Collections.reverse(rt);
        return rt;
    }
}


/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).

 */
//public class Levelorder {
//    public List<List<Integer>> levelOrder(TreeNode node) {
//        List<List<Integer>> rt = new ArrayList<List<Integer>>();
//        if (node == null) {
//            return rt;
//        }
//
//        Deque<TreeNode> deque = new LinkedList<TreeNode>();
//        List<Integer> level = new ArrayList<>();
//        final TreeNode END = new TreeNode(0);
//        deque.offer(node);
//        deque.offer(END);
//        int count = 0;
//        while (!deque.isEmpty()) {
//            TreeNode p = deque.pop();
//            if (p == END) {
//                if(count % 2 ==1){
//                    Collections.reverse(level);
//                }
//                rt.offer(new ArrayList<Integer>(level));
//                //have added all the elements to the deque,clear it.
//                level.clear();
//                if (!deque.isEmpty()) {
//                    deque.offer(END);
//                }
//                count++;
//            } else {
//                level.offer(p.data);
//                if (p.left != null) {
//                    deque.offer(p.left);
//                }
//                if (p.right != null) {
//                    deque.offer(p.right);
//                }
//            }
//        }
////        Collections.reverse(rt);
//        return rt;
//    }
//}

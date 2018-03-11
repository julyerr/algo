package com.julyerr.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp == null) {
                stringBuilder.append(",").append("null");
            } else {
                stringBuilder.append(",").append(tmp.val);
//                不论是否null，直接添加进来
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
        }
//        去除第一个,
        return stringBuilder.toString().substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
//        比较坑的一点是，"".split()之后返回的还是""
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] strings = data.split(",");

//        先建立node数组
        int length = strings.length;
        TreeNode[] nodes = new TreeNode[length];
        for (int i = 0; i < length; i++) {
            if (!strings[i].equals("#")) {
                nodes[i] = new TreeNode(Integer.parseInt(strings[i]));
            }
        }
//        记录有效的parent
        int parent = 0;
        for (int i = 0; parent * 2 + 2 < length; i++) {
//            调整左右关系
            if (nodes[i] != null) {
                nodes[i].left = nodes[2 * parent + 1];
                nodes[i].right = nodes[2 * parent + 2];
                parent++;
            }
        }
        return nodes[0];
    }
}

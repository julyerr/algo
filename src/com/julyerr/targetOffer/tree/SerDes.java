package com.julyerr.targetOffer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */

/**
 * 不妨换一个角度来思考这个问题，假设已经存在string，如何通过string来构建Tree
 * 显然利用前序遍历的方式进行，针对string逐个字符check
 * 为了方便构件左右节点，使用队列存储已经构建好的node
 * 自然想到了tree的serialize方式
 * Node,Node.left,Node.right
 */
public class SerDes {

    String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.data);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp.left != null) {
                stringBuilder.append("," + tmp.left.data);
                queue.add(tmp.left);
            } else {
                stringBuilder.append(",#");
            }

            if (tmp.right != null) {
                stringBuilder.append("," + tmp.right.data);
                queue.add(tmp.right);
            } else {
                stringBuilder.append(",#");
            }
        }

        return stringBuilder.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0 || str.equals("#")) {
            return null;
        }
        int index = 0;
        String[] strings = str.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strings[index++]));
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!strings[index].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(strings[index++]));
                queue.add(node.left);
            } else {
                index++;
            }
            if (!strings[index].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(strings[index++]));
                queue.add(node.right);
            } else {
                index++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        SerDes serDes = new SerDes();

//        int[] nums = new int[]{8, 7, 5, 6, 10};
        int[] nums = new int[]{8, 6, 10, 5, 7, 9, 11};
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            root = BSTTree.insertRecurse(root, nums[i]);
        }
        System.out.println("finished construct tree");
        String tmp = serDes.Serialize(root);
        System.out.println(tmp);

        System.out.println("Start deserialize");
        TreeNode node = serDes.Deserialize(tmp);
        for (Integer integer :
                BSTTree.levelOrder(node)) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}

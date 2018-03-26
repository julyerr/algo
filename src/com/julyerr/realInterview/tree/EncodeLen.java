package com.julyerr.realInterview.tree;

import java.util.*;

/*
 * 典型的霍夫曼树编码解题
 * */
public class EncodeLen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
//            构造优先级队列，根据出现的次数排序
            PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.count - o2.count;
                }
            });
//            统计不同字母出现的次数
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < line.length(); i++) {
                Integer tmp = 0;
                char c = line.charAt(i);
                if ((tmp = map.get(c)) == null) {
                    tmp = 0;
                }
                map.put(c, tmp + 1);
            }
//            添加元素
            for (Map.Entry<Character, Integer> en :
                    map.entrySet()) {
                priorityQueue.add(new Node(en.getValue()));
            }

//            两次poll，构成新节点插入优先级队列
            while (priorityQueue.size() > 1) {
                Node node1 = priorityQueue.poll();
                Node node2 = priorityQueue.poll();

                Node node = new Node(node1.count + node2.count);
                node.left = node1;
                node.right = node2;

                priorityQueue.add(node);
            }

            Node root = priorityQueue.poll();
//            递归求解叶子节点值
            System.out.println(dfs(root, 0));
        }
    }

    private static int dfs(Node node, int level) {
        if (node == null) {
            return 0;
        }
//        可能存在多个字母
        if (node.left == null && node.right == null) {
            return node.count * level;
        }
        level++;
        return dfs(node.left, level) + dfs(node.right, level);
    }

    //    自定义节点
    private static class Node {
        int count;
        Node left, right;

        public Node(int count) {
            this.count = count;
        }
    }
}

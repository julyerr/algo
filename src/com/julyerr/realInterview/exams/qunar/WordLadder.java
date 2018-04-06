package com.julyerr.realInterview.exams.qunar;

import java.util.*;

/*
hot
doh got dot god tod dog lot log
4

初始单词hot，其逆序为toh，单词列表[doh, got, dot, god, tod, dog, lot, log]，最短变换路径为[hot,tod,doh,toh]，最短变换路径长度为4。

从题目意思来看，没有注重单词的顺序，但是ac的题解注重了顺序，只能呵呵；
如果注重题目顺序的话，比较直观的想法是使用队列直接bfs
* */
public class WordLadder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            int len = word.length();
            String[] words = scanner.nextLine().split(" ");
            List<String> strings = new ArrayList<>(Arrays.asList(words));
            String target = new StringBuilder(word).reverse().toString();
//            添加结果，不论单词列表中存在结果，添加进去没有影响
            strings.add(target);
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(word, 1));
            boolean founded = false;
            Node cur = null;
            while (!queue.isEmpty()) {
                cur = queue.poll();
//                初始化队列
                if (cur.string.equals(target)) {
                    founded = true;
                    break;
                }
                if (cur.times > 99) {
                    continue;
                }
//                遍历单词列表，相差一的单词添加进来
                for (int i = 0; i < strings.size(); i++) {
                    int tmp = 0;
                    for (int j = 0; j < len; j++) {
                        if (cur.string.charAt(j) != strings.get(i).charAt(j)) {
                            tmp++;
                        }
                    }
                    if (tmp == 1) {
                        queue.add(new Node(strings.get(i), cur.times + 1));
                    }
                }
            }
            if (founded) {
                System.out.println(cur.times);
            } else {
                System.out.println(0);
            }
        }
    }

    private static class Node {
        String string;
        int times;

        public Node(String string, int times) {
            this.string = string;
            this.times = times;
        }
    }
}

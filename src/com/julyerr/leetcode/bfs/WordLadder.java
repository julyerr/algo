package com.julyerr.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 使用广搜的方式，参考实现方式：https://segmentfault.com/a/1190000003698569
 * */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length() || wordList == null || wordList.size() == 0) {
            return 0;
        }
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
//            bfs针对当前层的修改，遍历到了就说明是最少步数的转换
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();
                for (int j = 0; j < tmp.length(); j++) {
                    StringBuilder stringBuilder = new StringBuilder(tmp);
                    for (int k = 'a'; k <= 'z'; k++) {
                        stringBuilder.setCharAt(j, (char) k);
                        String s = stringBuilder.toString();
                        if (endWord.equals(s)) {
                            return step;
                        } else if (words.contains(s)) {
                            queue.add(s);
                            words.remove(s);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}

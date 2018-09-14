package com.julyerr.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/*
 * 参考思路：http://www.cnblogs.com/grandyang/p/5806493.html
 *
 * 比较巧妙使用map保存level和长度的关系
 * */
public class LengthLongestPath {
    public int lengthLongestPath(String input) {
        int rt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (String string :
                input.split("\n")) {
            int level = string.lastIndexOf('\t') + 1;
            int len = string.substring(level).length();
            if (!string.contains(".")) {
                map.put(level + 1, map.get(level) + len + 1);
            } else {
                rt = Math.max(rt, map.get(level)+len);
            }
        }
        return rt;
    }
}

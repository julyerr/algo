package com.julyerr.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
//        第一次遍历的时候统计次数
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int times = 0;
            if (map.get(c) != null) {
                times = map.get(c);
            }
            map.put(c, ++times);
        }

//        第二次遍历的时候次数--，并判断
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.get(c) == null) {
                return false;
            }
            int times = map.get(c);
            if (times == 0) {
                return false;
            }
            map.put(c, --times);
        }

//        最后一遍判断0
        for (Integer integer :
                map.values()) {
            if (integer != 0) {
                return false;
            }
        }
        return true;
    }
}

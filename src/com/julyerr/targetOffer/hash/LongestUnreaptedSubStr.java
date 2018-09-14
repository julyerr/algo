package com.julyerr.targetOffer.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
 */
public class LongestUnreaptedSubStr {
    public int longestUnreaptedSubStr(String str) {
//        check validation
        if (str == null || str.length() == 0) {
            return 0;
        }
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
//            更新left，保证每次截止当前字符为非重复字符串
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestUnreaptedSubStr longestUnreaptedSubStr = new LongestUnreaptedSubStr();
        System.out.println(longestUnreaptedSubStr.longestUnreaptedSubStr("arabcacfr"));
    }
}

package com.julyerr.leetcode.bitmap;

import java.util.*;

public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rt = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return rt;
        }
//        字符编码转换
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('G', 1);
        map.put('C', 2);
        map.put('T', 3);

        int hash = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
//            10字符长子串转换成hash编码
            hash = (hash << 2) | map.get(s.charAt(i));
            hash = ((1 << 20) - 1) & hash;
            if (i >= 9) {
                String string = s.substring(i - 9, i + 1);
//                不能出现重复添加的情况
                if (set.contains(hash)&&!rt.contains(string)) {
                    rt.add(string);
                } else {
                    set.add(hash);
                }
            }
        }
        return rt;
    }
}

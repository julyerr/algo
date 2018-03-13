package com.julyerr.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

/**
 * for every three digits just dfs
 */
public class RestoreIp {
    List<String> rt;
    String[] strs = new String[4];

    public List<String> restoreIpAddresses(String s) {
        rt = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return rt;
        }
        dfs(s, 0, 0);
        return rt;
    }

    private void dfs(String s, int cur, int segs) {
        if (segs == 4) {
            if (cur >= s.length()) {
                rt.add(String.join(".", strs));
            }
            return;
        }
//        考虑接下来的1-3个字符划分为新的一段
        for (int i = 1; i <= 3; i++) {
            if (cur + i > s.length()) {
                return;
            }
//            如果当前字符是0,除了当前0为一段之外，其他直接返回
            if (i > 1 && s.charAt(cur) == '0') {
                return;
            }
            String number = s.substring(cur, cur + i);
            if (Integer.parseInt(number) <= 255) {
                strs[segs] = number;
                dfs(s, cur + i, segs + 1);
            }
        }
    }
}

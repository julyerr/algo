package com.julyerr.leetcode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> rt = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return rt;
        }
        for (int i = 0; i < s.length(); i++) {
//            截取前半部分
            String prePart = s.substring(0, i+1);
            if (isPalindrome(prePart)) {
//                对后半部分进行递归
                List<List<String>> subList = partition(s.substring(i + 1));
                if (subList.isEmpty()) {
                    rt.add(Arrays.asList(prePart));
                } else {
//                    扩展两部分
                    for (List<String> list :
                            subList) {
                        List<String> tmp = new ArrayList<>();
                        tmp.add(prePart);
                        tmp.addAll(list);
                        rt.add(tmp);
                    }
                }
            }
        }
        return rt;
    }

//    判断是否为回文字符串
    private boolean isPalindrome(String s) {
//        防止出现死循环
        if (s.length() == 0) {
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

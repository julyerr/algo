package com.julyerr.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
//        左右空格去除，然后中建多个空格使用正则进行分隔
        List<String> strings = Arrays.asList(s.trim().split(" +"));
        Collections.reverse(strings);
        return String.join(" ", strings);
    }
}

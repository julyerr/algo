package com.julyerr.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rt = new ArrayList<>();
        //        check validation
        if (numRows < 1) {
            return rt;
        }

//        pre
        Integer[] pre = null;
        for (int i = 1; i <= numRows; i++) {
            Integer[] cur = new Integer[i];
//            计算cur数组的值
            cur[0] = 1;
            cur[i - 1] = 1;
            for (int j = 1; j < i - 1; j++) {
                cur[j] = pre[j - 1] + pre[j];
            }
            rt.add(new ArrayList<>(Arrays.asList(cur)));
//            更新pre
            pre = cur;
        }
        return rt;
    }
}

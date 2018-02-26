package com.julyerr.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
//        check validation
        Integer[] rt = new Integer[rowIndex + 1];
        if (rowIndex < 0) {
            return new ArrayList<Integer>(Arrays.asList(rt));
        }

//        fill values
        Arrays.fill(rt, 1);
        for (int i = 0; i < rowIndex - 1; i++) {
            for (int j = i + 1; j >= 1; j--) {
                rt[j] = rt[j - 1] + rt[j];
            }
        }
        return new ArrayList<>(Arrays.asList(rt));
    }
}

package com.julyerr.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MajorElemII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> rt = new ArrayList<>();
//        check validation
        if (nums == null || nums.length == 0) {
            return rt;
        }
        int length = nums.length;

        int count1 = 1;
        int count2 = 0;
        int m1 = nums[0];
        int m2 = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] == m1) {
                count1++;
            } else if (nums[i] == m2) {
                count2++;
//                更新元素值
            } else if (count1 == 0) {
                count1 = 1;
                m1 = nums[i];
            } else if (count2 == 0) {
                count2 = 1;
                m2 = nums[i];
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
//        统计出现次数
        for (int i = 0; i < length; i++) {
            if (nums[i] == m1) {
                count1++;
            } else if (nums[i] == m2) {
                count2++;
            }
        }

        if (count1 > length / 3) {
            rt.add(m1);
        }
        if (count2 > length / 3) {
            rt.add(m2);
        }
        return rt;
    }
}

package com.julyerr.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> rt = new ArrayList<>();
        //        check validation
        if (nums == null || nums.length == 0) {
            return rt;
        }

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int start = i;
            int end = start;

            while (i + 1 < length && nums[i + 1] - 1 == nums[i]) {
                i++;
                end++;
            }

            if (start == end) {
                rt.add(nums[start] + "");
            } else {
                rt.add(nums[start] + "->" + nums[end]);
            }
        }
        return rt;
    }
}

package com.julyerr.leetcode.array;

import java.util.SortedSet;
import java.util.TreeSet;

public class ConstainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        check validation
        if (nums == null || nums.length < 2 || k < 1 || t < 0) {
            return false;
        }
        SortedSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
//            截取一定范围内的subSet,左闭右开
            SortedSet<Long> subSet = set.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!subSet.isEmpty()) {
                return true;
            }
//            下一次迭代的时候需要移除的元素
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        ConstainsDuplicateIII constainsDuplicateIII = new ConstainsDuplicateIII();
        int[] nums = new int[]{1, 3, 1};
        System.out.println(constainsDuplicateIII.containsNearbyAlmostDuplicate(nums, 1, 1));
    }
}

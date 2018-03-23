package com.julyerr.leetcode.bitmap;

import java.util.*;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Set<List<Integer>> rt = new HashSet<>();

        int length = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < Math.pow(2, length); i++) {
            int tmp = i;
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < length; j++) {
                int bit = tmp & 0x01;
                tmp = tmp >> 1;
                if (bit == 1) {
                    list.add(nums[j]);
                }
            }
            rt.add(list);
        }
        return new ArrayList<>(rt);
    }


    public static void main(String[] args){
        SubsetsII subsetsII = new SubsetsII();
        int[] nums = new int[]{1,2,3};
        for (List list :
                subsetsII.subsetsWithDup(nums)) {
            System.out.println(list);
        }
    }
}

package com.julyerr.leetcode.bitmap;

public class SingleNumII {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ret = 0;
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            int count = 0;

//            统计每一位1的num的个数
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & bit) != 0) {
                    count++;
                }
            }
            bit <<= 1;
//            重新构造单个数
            ret |= (count % 3) << i;
        }
        return ret;
    }


    public static void main(String[] args) {
        SingleNumII singleNumII = new SingleNumII();
        int[] nums = new int[]{3, 3, 3, 1};
        System.out.println(singleNumII.singleNumber(nums));
        ;
    }
}

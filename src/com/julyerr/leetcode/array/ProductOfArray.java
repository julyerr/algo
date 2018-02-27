package com.julyerr.leetcode.array;

public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int length = nums.length;
        int[] right = new int[length];
//        保存从右到左的乘积结果
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

//        从左到右扫描
        int left = nums[0];
        for (int i = 1; i < length; i++) {
            right[i] *= left;
//            保存从左到右的乘积迭代结果
            left *= nums[i];
        }
        return right;
    }
    public static void main(String[] args){
//        int[] nums = new int[]{0,0};
        int[] nums = new int[]{1,0};
        ProductOfArray productOfArray = new ProductOfArray();
        int[] ret = productOfArray.productExceptSelf(nums);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]+" ");
        }
        System.out.println();
    }
}

package com.julyerr.targetOffer.tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class IsPostArray {
    public boolean VerifySquenceOfBST(int[] sequence) {
//        照说null的时候应该返回true的，总存在null的tree
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean verifySquenceOfBST(int[] nums, int start, int end) {
        if (start >= end) {
            return true;
        }
        int last = nums[end];
        int i = start;

        //      ignore the last element
        for (i = start; i < end; i++) {
            if (nums[i] >= last) {
                break;
            }
        }
        for (int j = i + 1; j < end; j++) {
            if (nums[j] < last) {
                return false;
            }
        }
        return verifySquenceOfBST(nums, start, i - 1)
                && verifySquenceOfBST(nums, i, end - 1);
    }

    public static void main(String[] args) {
        IsPostArray postArray = new IsPostArray();
//        int[] nums = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] nums = new int[]{5, 7, 6, 9, 4, 10, 8};
        System.out.println(postArray.VerifySquenceOfBST(nums));
    }
}

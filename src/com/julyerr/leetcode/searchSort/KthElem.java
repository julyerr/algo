package com.julyerr.leetcode.searchSort;

//这道题目没有明确，是否中间的元素可以出现重复（看结果应该是不允许出现重复的）
public class KthElem {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return findK(nums, nums.length - k, 0, nums.length - 1);
    }

    private int findK(int[] nums, int k, int left, int right) {
//        寻找中间分节点的位置
        int p = partition(nums, left, right);
        while (p != k) {
//            不断进行调整
            if (p > k) {
                p = partition(nums, left, p - 1);
            } else {
                p = partition(nums, p + 1, right);
            }
        }
        return nums[p];
    }

    //    一次快排操作
    private int partition(int[] nums, int left, int right) {
        if (left > right) {
            return left;
        }
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= nums[left]) {
                right--;
            }
            swap(nums, left, right);
            while (left < right && nums[left] <= nums[right]) {
                left++;
            }
            swap(nums, left, right);
        }
        nums[left] = tmp;
        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        KthElem kthElem = new KthElem();
        int[] nums = new int[]{3, 2, 1, 5, 6,6,4};
        System.out.println(kthElem.findKthLargest(nums, 1));
        System.out.println(kthElem.findKthLargest(nums, 2));
        System.out.println(kthElem.findKthLargest(nums, 3));
        System.out.println(kthElem.findKthLargest(nums, 4));
        System.out.println(kthElem.findKthLargest(nums, 5));
        System.out.println(kthElem.findKthLargest(nums, 6));
    }
}

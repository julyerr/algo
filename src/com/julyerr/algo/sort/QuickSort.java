package com.julyerr.algo.sort;

/**
 * 这篇文章总结比较好：http://wangkuiwu.github.io/2013/05/02/quick-sort/
 * <p>
 * 1.是非稳定的排序，最好的时间复杂度O(Nlog(N)),最坏的时间复杂度O(N^2)
 * 2.比较适合对数组进行排序，对于链表通常使用归并排序（对下标的操作要求不是很高）
 * <p>
 * 算法实现关键是：
 * 通过第一个元素作为整个待排序的中间数（比左边数都大，比右边数都小），然后递归调用（直接看代码）
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,5,4,1};
//        int[] nums = new int[]{1};
        int[] nums = new int[]{1, 2, 2, 5, 5, 5, 3, 3};
        QuickSort.quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        qS(nums, 0, nums.length - 1);
    }

    private static void qS(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
//        保留起始和结束位置
        int begin = left;
        int end = right;
        //        基准
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= tmp) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] <= tmp) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }
        }
        nums[left] = tmp;
        qS(nums, begin, left - 1);
        qS(nums, left + 1, end);
    }
}

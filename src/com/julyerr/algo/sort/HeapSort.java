package com.julyerr.algo.sort;

import com.julyerr.algo.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/*
关于算法稳定性：
堆排序、快速排序、希尔排序、直接选择排序不是稳定的排序算法，
而基数排序、冒泡排序、直接插入排序、折半插入排序、归并排序是稳定的排序算法。

*
 *
  *
  * 堆排序这篇文章总结比较好：http://wangkuiwu.github.io/2013/03/01/binary-heap-java/
* 最大堆：适合为升序排序，最小堆：适合降序排序，实现方式基本一致，以最大堆为例编写代码
*
* 最大堆：保证父节点的值都比子节点值大
* 生序排序算法：使用数组实现的话，每次交换最大元素（起始节点，设置为0）和末尾元素（n-1），然后对数组(0..n-1)递归进行堆的调整
* */

public class HeapSort {

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 5, 4, 1};
//        int[] nums = new int[]{1};
        int[] nums = new int[]{1, 2, 2, 5, 5, 5, 3, 3};
        HeapSort.heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
//        构建最大堆
        for (int i = length / 2; i >= 0; i--) {
            heaprify(nums, i, length - 1);
        }
//        调整最后一个元素和root的值
        for (int i = length - 1; i > 0; i--) {
            Utils.swap(nums, 0, i);
            heaprify(nums, 0, i - 1);
        }
    }

    private static void heaprify(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start * 2 + 1;
        int max = left;
        if (left + 1 <= end && nums[left + 1] > nums[left]) {
            max = left + 1;
        }
//        end the recurse
        if (max > end || nums[start] >= nums[max]) {
            return;
        }
        Utils.swap(nums, start, max);
        heaprify(nums, max, end);
    }
}

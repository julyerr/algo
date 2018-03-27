package com.julyerr.algo.sort;

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
    //  使用ArrayList作为数组操作对象
    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heaprify(nums, i, length - 1);
        }
        for (int i = length - 1; i > 0; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heaprify(nums, 0, i - 1);
        }
    }

    private static void heaprify(int[] nums, int start, int end) {
        if (start >= end || start * 2 + 1 > end) {
            return;
        }
        int max = 2 * start + 1;
        if (max + 1 <= end && nums[max] < nums[max + 1]) {
            max = max + 1;
        }
        if (nums[max] <= nums[start]) {
            return;
        }
        int tmp = nums[max];
        nums[max] = nums[start];
        nums[start] = tmp;
        heaprify(nums, max, end);
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 233, 23, 3, 3, 3, 5, 5, 5, 3, 0, -19, -20};
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

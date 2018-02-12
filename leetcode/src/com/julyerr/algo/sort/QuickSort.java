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
    public static void quickSort(int[] array, int left, int right) {
//            递归结束
        if (left >= right) {
            return;
        }
//        设置左右的游标
        int start = left, end = right;
//        保存第一个元素的值
        int temp = array[start];
        while (start < end) {
//            找到右边第一个值小的元素
            while (start < end && temp < array[end]) {
                end--;
            }
//            交换
            if (start < end)
                array[start++] = array[end];
//            找到左边第一个值大的元素
            while (start < end && array[start] < temp) {
                start++;
            }
//            交换
            if (start < end) {
                array[end--] = array[start];
            }
        }
//        中间量还原
        array[start] = temp;
//        递归调用
        quickSort(array, left, start - 1);
        quickSort(array, end + 1, right);
    }
}

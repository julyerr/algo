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
    List<Integer> maxHeap;

    public HeapSort(List<Integer> maxHeap) {
        this.maxHeap = new ArrayList<Integer>(maxHeap);
    }

    //    堆调整
    public void heapify(int start, int end) {
        int left;
//        不断进行调整
        while (start * 2 + 1 <= end) {
            left = start * 2 + 1;
//            寻找子节点较大的那个元素
            if (left + 1 <= end && maxHeap.get(left) < maxHeap.get(left + 1)) {
                left++;
            }
//           均比左右节点值都大
            if (maxHeap.get(left) <= maxHeap.get(start)) {
                break;
            } else {
//                交换元素
                Integer temp = maxHeap.get(start);
                maxHeap.set(start, maxHeap.get(left));
                maxHeap.set(left, temp);
            }
        }
    }

    //    升序排序算法
    public List<Integer> sort() {
//        构建最大堆
        for (int i = 0; i < maxHeap.size(); i++) {
            heapify(i, maxHeap.size() - 1);
        }
//        交换最后元素和第一个元素的位置
        for (int i = maxHeap.size() - 1; i > 0; i--) {
            Integer temp = maxHeap.get(i);
            maxHeap.set(i, maxHeap.get(0));
            maxHeap.set(0, temp);
            heapify(0, i - 1);
        }
        return this.maxHeap;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 233, 23, 3, 0, -19, -20};
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            temp.add(array[i]);
        }
        HeapSort heapSort = new HeapSort(temp);
        System.out.println(heapSort.sort());
    }
}

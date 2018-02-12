package com.julyerr.targetOffer.sort;

/**
 * 平均时间复杂度O(log(n)),空间复杂度O(logn),非稳定排序
 * 比较适合对元素操作灵活的场所，不适合链表等
 */
public class QuickSort {
    public static void quickSort(int[] arrays) {
//        check validation
        if (arrays == null || arrays.length == 0 || arrays.length == 1) {
            return;
        }
//        note1:传入的边界条件是，left,right均能取到
        quickSort(arrays, 0, arrays.length - 1);
    }

    private static void quickSort(int[] arrays, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int left = begin;
        int right = end;
        int first = arrays[left];
        while (left < right) {
            while (left < right && arrays[right] >= first) {
                right--;
            }
//            note2：如果进行了交换，需要改变元素的位置
            if (left < right) {
                arrays[left] = arrays[right];
                left++;
            }
            while (left < right && arrays[left] <= first) {
                left++;
            }
            if (left < right) {
                arrays[right] = arrays[left];
                right--;
            }
        }
        arrays[left] = first;
        quickSort(arrays, begin, left - 1);
        quickSort(arrays, right + 1, end);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3,7,8,1,23,-123,2352,2351325,1323,-1239,32,1023,0};
        int[] nums = new int[]{3, 3, 3, 33, 35, 5, 5, 5, 5, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

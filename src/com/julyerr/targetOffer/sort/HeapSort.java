package com.julyerr.targetOffer.sort;

/**
 * 时间复杂度log(n),空间复杂度O(1)，非稳定性排序
 * 注意点：
 * 首先需要构建大顶堆，这个过程需要迭代for()
 */
public class HeapSort {
    public static void heapSort(int[] nums) {
//        check validation
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }
        int length = nums.length;
        for (int i = length / 2; i >= 0; i--) {
            heapSort(nums, i, length - 1);
        }
        for (int i = length - 1; i >= 1; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapSort(nums, 0, i - 1);
        }
    }

    private static void heapSort(int[] nums, int start, int end) {
        int left = start * 2 + 1;
        int max = left;
        if ((left + 1) <= end && nums[left + 1] > nums[left]) {
            max = left + 1;
        }
//        large than any other child nodes,just return
        if (left > end || nums[start] > nums[max]) {
            return;
        }
//        swap
        int tmp = nums[max];
        nums[max] = nums[start];
        nums[start] = tmp;
//        recurse heaprify
        heapSort(nums, max, end);
//        if(max !=end){
//            heapSort(nums,max,end);
//        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3,1,7,8};
//                int[] nums = new int[]{3,7,8,1,23,-123,2352,2351325,1323,-1239,32,1023,0};
        int[] nums = new int[]{3, 3, 3, 33, 35, 5, 5, 5, 5, 5};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

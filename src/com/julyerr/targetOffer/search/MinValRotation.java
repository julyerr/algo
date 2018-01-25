package com.julyerr.targetOffer.search;

/**
 * 把一个数组最开始的若干个元素搬到末尾成为数组的旋转，
 * 如1,2,3,4,5=>3,4,5,1,2；0,1,1,1,1=>1,1,1,0,1；0,1,1,1,1=>1,0,1,1,1。
 * 求一个原本递增的数组旋转后的最小数字。
 */

/**
 * 参看：https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba
 * 如果单纯的求最小值，没有什么新意
 * 使用二分法，然后针对特殊的的情况进行处理
 */
public class MinValRotation {
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (array[mid] < array[high]) {
//                防止mid == 0 的情况发生越界访问
                high = mid;
            } else if (array[mid] > array[high]) {
                low = mid + 1;
            } else {
//                逐个比较
                high = high - 1;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        MinValRotation minValRotation = new MinValRotation();
        System.out.println(minValRotation.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minValRotation.minNumberInRotateArray(new int[]{1, 1, 1, 0, 1}));
    }
}

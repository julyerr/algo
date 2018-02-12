package com.julyerr.targetOffer.search;

/**
 * 统计一个数字在排序数组中出现的次数。例如，输入{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */
public class Times {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        int ret = 0;
        int left = 0;
        int right = length - 1;
        int mid;
//        防止k不存在array中造成的死循环
        int flag = -1;
        do {
            mid = (left + right) / 2;
            if (array[mid] > k) {
                right = mid;
            } else {
                left = mid + 1;
            }
            if (flag != mid) {
                flag = mid;
            } else {
                break;
            }
        } while (array[mid] != k);
        int tmp = mid;
        while (tmp < length && array[tmp] == k) {
            tmp++;
            ret++;
        }
//        上面已经计算过一次mid
        mid = mid - 1;
        while (mid >= 0 && array[mid] == k) {
            mid--;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        Times times = new Times();
//        int[] nums = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
//        int[] nums = new int[]{3,3};
        int[] nums = new int[]{1, 1};
        int k = 3;
        System.out.println(times.GetNumberOfK(nums, k));
    }
}

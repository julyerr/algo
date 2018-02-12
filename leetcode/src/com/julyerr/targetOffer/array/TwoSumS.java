package com.julyerr.targetOffer.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

/**
 * 注意乘积变小需要更新
 */
public class TwoSumS {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> rt = new ArrayList<>();
        if (array == null || array.length < 2) {
            return rt;
        } else if (array.length == 2) {
            if (array[0] + array[1] == sum) {
                rt.add(array[0]);
                rt.add(array[1]);
            }
            return rt;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int cur = array[left] + array[right];
            if (cur < sum) {
                left++;
            } else if (cur == sum) {
                if (rt.isEmpty()) {
                    rt.add(array[left]);
                    rt.add(array[right]);
                } else {
                    if (rt.get(0) * rt.get(1) > array[left] * array[right]) {
                        rt.remove(0);
                        rt.remove(0);
                        rt.add(array[left]);
                        rt.add(array[right]);
                    }
                }

                left++;
                right--;
            } else {
                right--;
            }
        }
        return rt;
    }

    public static void main(String[] args) {
        TwoSumS twoSumS = new TwoSumS();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        List<Integer> rt = twoSumS.FindNumbersWithSum(nums, 21);
        System.out.println(rt);

    }
}


package com.julyerr.targetOffer.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中出现次数超过数组长度一半的数字。如输入{1,2,3,2,2,2,5,4,2}，则输出2。
 */
public class MoreThanHalf {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int length = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 0);
            }
            int count = map.get(array[i]) + 1;
            map.put(array[i], count);
            if (count > length / 2) {
                return array[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MoreThanHalf moreThanHalf = new MoreThanHalf();
        int[] nums = new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(moreThanHalf.MoreThanHalfNum_Solution(nums));

    }
}

package com.julyerr.targetOffer.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 得到一个数据流中的中位数
 */


/**
 * 考察就是插入排序
 */
public class FetchMedian {
    private int length = 0;
    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            int i = 0;
            for (i = list.size() - 1; i >= 0; i--) {
                if (num >= list.get(i)) {
                    list.add(i + 1, num);
                    length++;
                    return;
                }
            }
            list.add(0, num);
        }

        length++;
    }

    public Double GetMedian() {
        double tmp = 0;
        int mid = length >> 1;
        if (length % 2 == 1) {
            tmp = list.get(mid);
        } else {
            tmp = (list.get(mid) + list.get(mid - 1)) / 2.00;
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
//        int[] nums = new int[]{1,2,3,4,5};
        FetchMedian fetchMedian = new FetchMedian();
        for (int i = 0; i < nums.length; i++) {
            fetchMedian.Insert(nums[i]);
            System.out.println(fetchMedian.GetMedian());
            System.out.println("-----");
        }
    }
}

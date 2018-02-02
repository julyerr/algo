package com.julyerr.targetOffer.dp;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划
 */
public class UglyNumer {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int t1, t2, t3;
        t1 = t2 = t3 = 0;
        int min = 1;
        while (--index > 0) {
            int k1 = list.get(t1);
            int k2 = list.get(t2);
            int k3 = list.get(t3);
            min = Math.min(k1 * 2, Math.min(k2 * 3, k3 * 5));
            list.add(min);
//            为防止出现重复结果
            if (min == k1 * 2) {
                t1++;
            }
            if (min == k2 * 3) {
                t2++;
            }
            if (min == k3 * 5) {
                t3++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        UglyNumer uglyNumer = new UglyNumer();
        System.out.println(uglyNumer.GetUglyNumber_Solution(2));
        System.out.println(uglyNumer.GetUglyNumber_Solution(5));
        System.out.println(uglyNumer.GetUglyNumber_Solution(6));
        System.out.println(uglyNumer.GetUglyNumber_Solution(7));
    }
}

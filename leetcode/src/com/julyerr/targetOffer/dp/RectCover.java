package com.julyerr.targetOffer.dp;


/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    public int RectCover(int target) {
//        check validation
        if (target <= 0) {
            return 0;
        }
        int step1, step2;
        step1 = step2 = 1;
        for (int i = 2; i <= target; i++) {
            step2 += step1;
            step1 = step2;
        }
        return step2;
    }
}

package com.julyerr.targetOffer.dp;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class JumpFloor {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        int sum = 1;
        for (int i = 1; i < target; i++) {
            sum += sum;
        }
        return sum;
    }
}

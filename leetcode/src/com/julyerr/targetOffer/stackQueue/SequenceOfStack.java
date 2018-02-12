package com.julyerr.targetOffer.stackQueue;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出序序列。
 * 假设压入栈的所有数字均不相等。例如，压入序列为(1,2,3,4,5)，序列(4,5,3,2,1)是它的弹出序列，而(4,3,5,1,2)不是。
 */

/**
 * 作者思路比较好的：https://www.jianshu.com/p/e39ff6a1b3ee
 * 自己实现的较上者有较大的区别
 */
public class SequenceOfStack {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || pushA.length == 0) {
            return true;
        }
        int length = pushA.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(pushA[i], i);
        }
//      check popA array
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(popA[i])) {
                return false;
            }
        }
        int boundary = 0;
        for (int i = 0; i < length; i++) {
            if (pushA[length - 1] == popA[i]) {
                boundary = i;
                break;
            }
        }
        for (int i = 1; i <= boundary; i++) {
//            all the nums are different from each other
            if (map.get(popA[i]) <= map.get(popA[i - 1])) {
                return false;
            }
        }
        for (int i = boundary; i < length - 1; i++) {
            if (map.get(popA[i]) <= map.get(popA[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SequenceOfStack sequenceOfStack = new SequenceOfStack();
//        int[] pushA = new int[]{1,2,3,4,5};
//        int[] popA = new int[]{1,2,3,4,5};
//        int[] popA = new int[]{5,4,3,2,1};
//        int[] popA = new int[]{1,4,5,3,2};
//        int[] popA = new int[]{1,4,5,2,3};
        int[] pushA = new int[]{1};
        int[] popA = new int[]{2};
        System.out.println(sequenceOfStack.IsPopOrder(pushA, popA));
    }
}

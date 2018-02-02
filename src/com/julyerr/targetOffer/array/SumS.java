package com.julyerr.targetOffer.array;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 */

/**
 * 看了讨论题解，部分使用二元一次方程组性质去求解，个人比较偏重双指针进行移动的解法
 */
public class SumS {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rt = new ArrayList<>();
        if (sum <= 0) {
            return rt;
        }
        int left = 1;
        int right = 2;
        while (left < right) {
//            left = 1,最接近k^2 == sum
            int cur = (left + right) * (right - left + 1) / 2;
            if (cur < sum) {
                right++;
            } else if (cur == sum) {
                ArrayList<Integer> tmp = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    tmp.add(i);
                }
                left++;
                rt.add(tmp);
            } else {
//                end the loop
                left++;
            }
        }
        return rt;
    }

    public static void main(String[] args) {
        SumS sumS = new SumS();
        ArrayList<ArrayList<Integer>> rt = sumS.FindContinuousSequence(100);
        System.out.println();
    }
}

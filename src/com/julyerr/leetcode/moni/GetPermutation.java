package com.julyerr.leetcode.moni;

import java.util.ArrayList;
import java.util.List;

/*
* 参考资料：https://www.jianshu.com/p/db90675cb82b
* */
public class GetPermutation {
    public String getPermutation(int n, int k) {
        if (k < 1) {
            return "";
        }
        int[] steps = new int[n];
        steps[0] = 1;
        int tmp = 1;
        for (int i = 1; i < n; i++) {
            tmp *= i;
            steps[i] = tmp;
        }
        StringBuilder stringBuilder = new StringBuilder();
//        最小的情况数肯定包括进来的
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            data.add(i);
        }
        k--;
        for (int i = 1; i < n; i++) {
            int index = k / steps[n - i];
            stringBuilder.append(data.get(index));
            data.remove(index);
            k %= steps[n - i];
        }
        stringBuilder.append(data.get(0));
        return stringBuilder.toString();
    }
}

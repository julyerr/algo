package com.julyerr.niuke;

/*
* 题目描述
小易总是感觉饥饿，所以作为章鱼的小易经常出去寻找贝壳吃。最开始小易在一个初始位置x_0。
对于小易所处的当前位置x，他只能通过神秘的力量移动到 4 * x + 3或者8 * x + 7。
因为使用神秘力量要耗费太多体力，所以它只能使用神秘力量最多100,000次。
贝壳总生长在能被1,000,000,007整除的位置(比如：位置0，位置1,000,000,007，位置2,000,000,014等)。
小易需要你帮忙计算最少需要使用多少次神秘力量就能吃到贝壳。
输入描述:
输入一个初始位置x_0,范围在1到1,000,000,006
输出描述:
输出小易最少需要使用神秘力量的次数，如果使用次数使用完还没找到贝壳，则输出-1
示例1
输入

125000000
输出

1
* */

import java.util.Scanner;

/**
 * 没有明确的解题思路，参考了别人的思路
 * http://blog.csdn.net/fcxxzux/article/details/52138964#t0
 * <p>
 * 通过对开始一部分到达位置的枚举发现，所能达到的情况是 times*x0+times-1,其中times = 2^k
 */
public class HungryXiaoyi {
    public static final int STEP = 1000000007;

    public static void main(String[] args) {
        HungryXiaoyi hungryXiaoyi = new HungryXiaoyi();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long x0 = scanner.nextInt();
            long res = 100001;
            long times = 4;
            for (int i = 1; i <= 300000; i++) {
                long x = (x0 * times + times - 1) % STEP;
                if (x == 0) {
                    res = (i + 1) / 3 + ((i + 1) % 3 == 0 ? 0 : 1);
                    break;
                }
                times = times * 2 % STEP;
            }
            System.out.println(res > 100000 ? -1 : res);
        }
    }
}

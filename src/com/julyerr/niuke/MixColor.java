package com.julyerr.niuke;

import java.util.*;

/**
 * 你就是一个画家！你现在想绘制一幅画，但是你现在没有足够颜色的颜料。
 * 为了让问题简单，我们用正整数表示不同颜色的颜料。你知道这幅画需要的n种颜色的颜料，你现在可以去商店购买一些颜料
 * ，但是商店不能保证能供应所有颜色的颜料，所以你需要自己混合一些颜料。
 * 混合两种不一样的颜色A和颜色B颜料可以产生(A XOR B)这种颜色的颜料(新产生的颜料也可以用作继续混合产生新的颜色,XOR表示异或操作)。
 * 本着勤俭节约的精神，你想购买更少的颜料就满足要求，所以兼职程序员的你需要编程来计算出最少需要购买几种颜色的颜料？
 * 输入描述:
 * 第一行为绘制这幅画需要的颜色种数n (1 ≤ n ≤ 50)
 * 第二行为n个数xi(1 ≤ xi ≤ 1,000,000,000)，表示需要的各种颜料.
 * 输出描述:
 * 输出最少需要在商店购买的颜料颜色种数，注意可能购买的颜色不一定会使用在画中，只是为了产生新的颜色。
 * 示例1
 * 输入
 * <p>
 * 3
 * 1 7 3
 * 输出
 * <p>
 * 3
 */

/**
 * 参考别人的代码书写的，利用线性方程组求解的思路解题
 */
public class MixColor {
    public static void main(String[] args) {
        MixColor mixColor = new MixColor();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }
            System.out.println(mixColor.mixColor(list, n));
        }
    }

    public int mixColor(List<Integer> list, int n) {
        int ret = 0;
        Collections.sort(list);
        while (list.size() > 2) {
            int bigger = list.size() - 1;
            int smaller = bigger - 1;
//            高位有相同的部分
            if (getHigh(list.get(bigger)) == getHigh(list.get(smaller))) {
                int tmp = list.get(bigger) ^ list.get(smaller);
//                是否^之后的元素可以找到
                if (!list.contains(tmp)) {
                    list.add(tmp);
                    bigger++;
                    smaller++;
                    Collections.sort(list);
                }
            } else {
                ret++;
            }
            list.remove(bigger);
            bigger--;
            smaller--;
        }

        return ret + list.size();
    }

    private int getHigh(int n) {
        int ret = 0;
        while (n > 0) {
            ret++;
            n >>= 1;
        }
        return ret;
    }
}

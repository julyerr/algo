package com.julyerr.niuke;

/**
 * 题目描述
 * 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 * 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 * 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
 * 输入描述:
 * 第一行输入一个正整数n(n ≤ 1000)
 * 第二行为n个数正整数xi(xi ≤ 1000)
 * 输出描述:
 * 输出可以产生的幸运的袋子数
 * 示例1
 * 输入
 * <p>
 * 3
 * 1 1 1
 * 输出
 * <p>
 * 2
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛客网上公司的笔试编程题目，还是有难度的，看了别人的讨论借鉴而来
 * 使用dfs的方式进行，但是为了提高效率进行剪枝处理;
 * 如果a+b > a * b,则a,b中必然存在一个为1，同时除掉重复的数
 */
public class LuckyPacket {
    public static void main(String[] args) {
        LuckyPacket luckyPacket = new LuckyPacket();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
//            searchSort the array
            Arrays.sort(nums);
            System.out.println(luckyPacket.luckyPacket(nums, 0, 0, 1));
        }
    }

    public int luckyPacket(int[] nums, int start, int sum, int multi) {
        int ret = 0;
        int length = nums.length;
        for (int i = start; i < length; i++) {
            sum += nums[i];
            multi *= nums[i];
            if (sum > multi) {
                ret += 1 + luckyPacket(nums, i + 1, sum, multi);
            } else if (nums[i] == 1) {
                ret += luckyPacket(nums, i + 1, sum, multi);
            } else {
                break;
            }
            sum -= nums[i];
            multi /= nums[i];
//            remove repeatable num
            while (i < length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return ret;
    }
}

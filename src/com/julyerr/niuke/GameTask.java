package com.julyerr.niuke;

/*
* 题目描述
游戏里面有很多各式各样的任务，其中有一种任务玩家只能做一次，这类任务一共有1024个，任务ID范围[1,1024]。
请用32个unsigned int类型来记录着1024个任务是否已经完成。初始状态都是未完成。
输入两个参数，都是任务ID，需要设置第一个ID的任务为已经完成；并检查第二个ID的任务是否已经完成。
输出一个参数，如果第二个ID的任务已经完成输出1，如果未完成输出0。如果第一或第二个ID不在[1,1024]范围，则输出-1。
输入描述:
输入包括一行,两个整数表示人物ID.
输出描述:
输出是否完成
示例1
输入

1024 1024
输出

1
* */

import java.util.Scanner;

/*
 * 开始还不是清除题目意思，其实就是通过32个unisighed int数组记录1024个任务的完成情况(java中无unsight int但是通过位运算得到的结果没有影响)；
 * 节省空间使用位运算，1024bit正好是32*32bit，然后根据输入检测即可
 * */
public class GameTask {

    public static void main(String[] args) {
//        标志数组
        int[] nums = new int[32];

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

//            判断是否符合输入条件
            if (m < 1 || m > 1024 || n < 1 || n > 1024) {
                System.out.println(-1);
            } else {
//            先设置标志位
                check(nums, m - 1, true);
//            后判断
                if (check(nums, n - 1, false)) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }

    private static boolean check(int[] nums, int n, boolean flag) {
        int index = n / 32;
        int pos = n % 32;

//        选择1，而不是0x8000000;因为后者向右移动的话，会补1，而不是零
        int tmp = 1 << pos;
        //        如果是set 标志位
        if (flag) {
            nums[index] = tmp;
        }
        return (nums[index] & tmp) != 0;
    }
}

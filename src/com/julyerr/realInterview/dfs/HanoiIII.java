package com.julyerr.realInterview.dfs;

/*
 * 开始想了没有思路，参考大神的解题思路（原来是《程序员面试指南》中的一道题目）：https://www.nowcoder.com/questionTerminal/b2d552cd60b7415fad2612a32e799812
 *
 * 数组下标代表盘子的大小，可以从最大的盘子（也就是数组中最后面一个元素）往前递归考虑；
 *
 * 1.如果当前盘子在中间，不是最优解（直观观察）；
 * 2.如果当前盘子在最右边，说明数组已经完成了Hanoi的前两步，第一步将前n-1移动到中间步数为2^(n-1)-1,然后最后一个n移动到右边步数为1，总共为2^(n-1);
 *   此时只需要递归判断前n-1个数组的移动次数，并且添加进来；
 * 3.如果当前盘子最左边，说明对第n盘子没有进行任何操作（如果是最优解），只需要递归求解前n-1个盘子的操作次数
 * 具体参见实现代码
 *
 * */

public class HanoiIII {
    public int chkStep(int[] arr, int n) {
        if (arr == null || arr.length < 1 || arr.length != n) {
            return -1;
        }
        return checkstep(arr, n - 1, 1, 2, 3);
    }

    private int checkstep(int[] arr, int cur, int left, int mid, int right) {
//       所有盘子递归完毕
        if (cur == -1) {
            return 0;
        }
//        在中间
        if (arr[cur] == mid) {
//            在左边
            return -1;
        } else if (arr[cur] == left) {
            return checkstep(arr, cur - 1, left,right,mid);
//            在右边
        } else {
            int tmp = checkstep(arr, cur - 1, mid,left,right);
//            如果cur-1个盘子不是最优解
            if (tmp == -1) {
                return -1;
            }
            return (1 << cur) + tmp;
        }
    }
}

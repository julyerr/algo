package com.julyerr.niuke;

import java.util.Scanner;

/*
* 题目：

洗牌在生活中十分常见，现在需要写一个程序模拟洗牌的过程。 现在需要洗2n张牌，从上到下依次是第1张，第2张，第3张一直到第2n张。
首先，我们把这2n张牌分成两堆，左手拿着第1张到第n张（上半堆），右手拿着第n+1张到第2n张（下半堆）。
接着就开始洗牌的过程，先放下右手的最后一张牌，再放下左手的最后一张牌，接着放下右手的倒数第二张牌，再放下左手的倒数第二张牌，
直到最后放下左手的第一张牌。接着把牌合并起来就可以了。
例如有6张牌，最开始牌的序列是1,2,3,4,5,6。首先分成两组，左手拿着1,2,3；右手拿着4,5,6。
在洗牌过程中按顺序放下了6,3,5,2,4,1。把这六张牌再次合成一组牌之后，我们按照从上往下的顺序看这组牌，就变成了序列1,4,2,5,3,6。
现在给出一个原始牌组，请输出这副牌洗牌k次之后从上往下的序列。

输入描述:

第一行一个数T(T ≤ 100)，表示数据组数。对于每组数据，第一行两个数n,k(1 ≤ n,k ≤ 100)，接下来一行有2n个数a1,a2,...,a2n(1 ≤ ai ≤ 1000000000)。
表示原始牌组从上到下的序列。



输出描述:

对于每组数据，输出一行，最终的序列。数字之间用空格隔开，不要在行末输出多余的空格。


输入例子:

3
3 1
1 2 3 4 5 6
3 2
1 2 3 4 5 6
2 2
1 1 1 1


输出例子:

1 4 2 5 3 6
1 5 4 3 2 6
1 1 1 1
* */

/*
 * 开始没有想到更好的方法，直接使用暴力求解的方式，通过但是时间和空间占用比较大；
 * 参考了大神的思路就是清晰
 *      通过对特定的位置进行优先确定，输入的时候只需要对号入座即可
 *       https://www.nowcoder.net/questionTerminal/5a0a2c7e431e4fbbbb1ff32ac6e8dfa0
 *  以后面试的时候，在5分之内没有找到更好的方法就进行暴力求解；无论怎样都需要提前争取一下比较好的方法
 * */
public class Shuffle {
//    暴力求解
//    public static void main(String[] args) {
//        Shuffle shuffle = new Shuffle();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            while (n-- >= 0) {
//                int m = scanner.nextInt() << 1;
//                int k = scanner.nextInt();
//                int[] nums = new int[m];
//                for (int i = 0; i < m; i++) {
//                    nums[i] = scanner.nextInt();
//                }
//                shuffle.shuffle(nums, k);
//                for (int i = 0; i < nums.length - 1; i++) {
//                    System.out.print(nums[i] + " ");
//                }
//                System.out.println(nums[nums.length - 1]);
//            }
//        }
//    }
//
//    public void shuffle(int[] nums, int k) {
//        int length = nums.length;
//        while (k-- > 0) {
//            int[] tmp = new int[length];
//            int half = length >> 1;
//            for (int i = 0; i < half; i++) {
//                tmp[i << 1] = nums[i];
//            }
//            for (int i = 0; i < half; i++) {
//                tmp[(i << 1) + 1] = nums[i + half];
//            }
//            for (int i = 0; i < length; i++) {
//                nums[i] = tmp[i];
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            while (n-- >= 0) {
                int m = scanner.nextInt();
                int length = m << 1;
                int k = scanner.nextInt();
                int[] nums = new int[length];
                for (int i = 0; i < length; i++) {
                    int tmp = i;
                    for (int j = 0; j < k; j++) {
                        if (tmp < m) {
                            tmp = tmp << 1;
                        } else {
//                            tmp = length - 1 - (length - 1 - i) * 2;
                            tmp = tmp * 2 - length + 1;
                        }
                    }
                    nums[tmp] = scanner.nextInt();
                }
                for (int i = 0; i < length - 1; i++) {
                    System.out.print(nums[i] + " ");
                }
                System.out.println(nums[length - 1]);
                System.out.println();
            }
        }
    }
}

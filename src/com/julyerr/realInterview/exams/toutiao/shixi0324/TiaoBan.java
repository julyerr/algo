package com.julyerr.realInterview.exams.toutiao.shixi0324;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 参考大神的解题思路：https://blog.csdn.net/flushhip/article/details/79685488
 *
 * 使用bfs解题思路：
 * 先将所有的跳板排序好；将可能达到的位置添加进队列；迭代过程中获取最大值
 * */
public class TiaoBan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int H = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
//            跳板排序好
            Arrays.sort(nums);
            Queue<Node> queue = new LinkedList<>();
//            初始化
            queue.add(new Node(0, 0, 0));
            long rt = 0;
            while (!queue.isEmpty()) {
                Node node = queue.poll();
//                更新最大值
                rt = Math.max(rt, node.height);
                for (int i = node.next; i < N; i++) {
//                    可能根据跳板达到新位置
                    if (node.height < nums[i] && node.height + H >= nums[i] && node.cnt < K) {
                        queue.add(new Node((nums[i] << 1) - node.height, node.cnt + 1, i + 1));
                    } else {
                        break;
                    }
                }
            }
            System.out.println(rt);
        }
    }

    private static class Node {
        //        达到的高度，跳的次数，下一次开始跳的位置（提高效率）
        int height, cnt, next;

        public Node(int height, int cnt, int next) {
            this.height = height;
            this.cnt = cnt;
            this.next = next;
        }
    }
}
/*
in1:
3 3 2
1
3
6
out1:
8

in2:
3 3 4
1
4
6
out2:
10

* */

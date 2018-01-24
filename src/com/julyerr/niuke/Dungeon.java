package com.julyerr.niuke;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 题目描述
 * 给定一个 n 行 m 列的地牢，其中 '.' 表示可以通行的位置，'X' 表示不可通行的障碍，牛牛从 (x0 , y0 ) 位置出发，
 * 遍历这个地牢，和一般的游戏所不同的是，他每一步只能按照一些指定的步长遍历地牢，要求每一步都不可以超过地牢的边界，也不能到达障碍上。
 * 地牢的出口可能在任意某个可以通行的位置上。牛牛想知道最坏情况下，他需要多少步才可以离开这个地牢。
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试用例的第一行包含两个整数 n 和 m（1 <= n, m <= 50），
 * 表示地牢的长和宽。接下来的 n 行，每行 m 个字符，描述地牢，地牢将至少包含两个 '.'。
 * 接下来的一行，包含两个整数 x0, y0，表示牛牛的出发位置（0 <= x0 < n, 0 <= y0 < m，左上角的坐标为 （0, 0），出发位置一定是 '.'）。
 * 之后的一行包含一个整数 k（0 < k <= 50）表示牛牛合法的步长数，接下来的 k 行，每行两个整数 dx, dy 表示每次可选择移动的行和列步长（-50 <= dx, dy <= 50）
 * 输出描述:
 * 输出一行一个数字表示最坏情况下需要多少次移动可以离开地牢，如果永远无法离开，输出 -1。
 * 以下测试用例中，牛牛可以上下左右移动，在所有可通行的位置.上，地牢出口如果被设置在右下角，牛牛想离开需要移动的次数最多，为3次。
 * 示例1
 * 输入
 * <p>
 * 3 3
 * ...
 * ...
 * ...
 * 0 1
 * 4
 * 1 0
 * 0 1
 * -1 0
 * 0 -1
 * 输出
 * <p>
 * 3
 * <p>
 * 简化后的题目意思：
 * 链接：https://www.nowcoder.com/questionTerminal/0385945b7d834a99bc0010e67f892e38
 * 来源：牛客网
 * <p>
 * 从给定起点（一定为'.'），按照给定的若干跳跃（可以跨过障碍，但不可以落在'x'上），到达任意一个'.'的最小步骤次数集合中，选择一个最大的！
 * 如果存在一个点'.'从起点始终无法抵达，则认为起点到该点的最小距离为无穷∞，则返回-1.
 * 因此，从起点开始广度优先遍历到所有可达点，记录每个可达点的最小距离，将其存入集合中。然后遍历集合寻找最大的距离。如果存在一个点'.'
 * 无法抵达，直接返回-1.
 */


public class Dungeon {
    public void dungeon() {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            char[][] matrix = new char[m][n];
            int[][] paths = new int[m][n];
            for (int i = 0; i < m; i++) {
//                input a line
                matrix[i] = scanner.next().toCharArray();
            }
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            paths[startX][startY] = 1;
            queue.add(startX);
            queue.add(startY);
            int k = scanner.nextInt();
            int[] deltX = new int[k];
            int[] deltY = new int[k];
            for (int i = 0; i < k; i++) {
                deltX[i] = scanner.nextInt();
                deltY[i] = scanner.nextInt();
            }

            while (!queue.isEmpty()) {
                startX = queue.poll();
                startY = queue.poll();
                for (int i = 0; i < k; i++) {
                    int newX = startX + deltX[i];
                    int newY = startY + deltY[i];
//                    没有超过边界
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
//                        设置访问条件，不然出现死循环
                        if (paths[newX][newY] == 0) {
                            if (matrix[newX][newY] != 'X') {
                                paths[newX][newY] = paths[startX][startY] + 1;
                                queue.add(newX);
                                queue.add(newY);
                            } else {
                                paths[newX][newY] = -1;
                            }
                        }
                    }
                }
            }
            boolean flag = false;
            int max = 0;
//            重新遍历整个paths，获取最大的数值
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '.' && paths[i][j] == 0) {
                        flag = true;
                        break;
                    }
                    max = Math.max(max, paths[i][j]);
                }
            }

            if (flag) {
                System.out.println(-1);
            } else {
//               其实节点设置为1，因此需要减去1
                System.out.println(max);
            }
        }
    }

    public static void main(String[] args) {
        Dungeon dungon = new Dungeon();
        dungon.dungeon();
    }
}

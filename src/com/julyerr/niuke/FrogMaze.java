package com.julyerr.niuke;

import java.util.*;

/*
 * 还是有难度的，参考大神的解题思路
 * https://www.nowcoder.com/questionTerminal/571cfbe764824f03b5c0bfd2eb0a8ddf
 * 给定起点，对四面分别递归处理，如果发现体能消耗更加小的便进行更新
 * */

public class FrogMaze {
    static boolean reachable = false;
    static String path = "";
    static int n, m;
    static int[][] maze;
    static int maxRemainStrength = 0;
    //    插入和删除比较多
    static LinkedList<String> list = new LinkedList<>();

    public static void main(String[] args) {
        FrogMaze frogMaze = new FrogMaze();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int strength = scanner.nextInt();
            maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            frogMaze.isReachable(maze, strength, 0, 0);
            if (reachable) {
                System.out.println(path);
            } else {
                System.out.println("Can not escape!");
            }
        }
    }

    private void isReachable(int[][] maze, int strength, int x, int y) {
//        check validation
        if (strength < 0 || x < 0 || y < 0 || x >= n || y >= m || maze[x][y] != 1) {
            return;
        }
//        不能被重复访问
        maze[x][y] = 0;
        list.add("[" + x + "," + y + "]");
//        到达目的地
        if (x == 0 && y == m - 1) {
            reachable = true;
//         如果发现更加不耗体能则进行更新
            if (strength >= maxRemainStrength) {
                maxRemainStrength = strength;
                updatePath();
            }
//          继续寻找更短路径
            maze[x][y] = 1;
            list.removeLast();
            return;
        }
        isReachable(maze, strength - 3, x - 1, y);
        isReachable(maze, strength - 1, x, y + 1);
        isReachable(maze, strength, x + 1, y);
        isReachable(maze, strength - 1, x, y - 1);
        maze[x][y] = 1;
        list.removeLast();
    }

    private void updatePath() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string :
                list) {
            stringBuilder.append(string).append(",");
        }
//        删除最后一个','
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        path = stringBuilder.toString();
    }


}

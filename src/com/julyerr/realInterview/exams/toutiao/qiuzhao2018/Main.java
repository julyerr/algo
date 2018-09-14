package com.julyerr.realInterview.exams.toutiao.qiuzhao2018;

import java.util.Scanner;

/*
10,10
0,0,0,0,0,0,0,0,0,0
0,0,0,1,1,0,1,0,0,0
0,1,0,0,0,0,0,1,0,1
1,0,0,0,0,0,0,0,1,1
0,0,0,1,1,1,0,0,0,1
0,0,0,0,0,0,1,0,1,1
0,1,1,0,0,0,0,0,0,0
0,0,0,1,0,1,0,0,0,0
0,0,1,0,0,1,0,0,0,0
0,1,0,0,0,0,0,0,0,0
* */
public class Main {

    private static int count = 0;
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] inputs = line.split(",");
        int M = Integer.parseInt(inputs[0]);
        int N = Integer.parseInt(inputs[1]);
        int[][] nums = new int[M][N];
        for (int i = 0; i < M; i++) {
            line = scanner.nextLine();
            inputs = line.split(",");
            for (int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = dfs(nums,i,j);
                if(tmp!=0){
                    count++;
                }
                max = Math.max(tmp,max);
            }
        }
        System.out.println(count+","+max);
    }

    private static int dfs(int[][] nums, int x, int y) {
        if (x < 0 || x >= nums.length || y < 0 || y >= nums[0].length || nums[x][y] == 0) {
            return 0;
        }
        nums[x][y] = 0;
        int tmp = 1;
        tmp+=dfs(nums, x - 1, y);
        tmp+=dfs(nums, x + 1, y);
        tmp+=dfs(nums, x, y - 1);
        tmp+=dfs(nums, x, y + 1);

        tmp+=dfs(nums, x - 1, y - 1);
        tmp+=dfs(nums, x + 1, y + 1);
        tmp+=dfs(nums, x - 1, y + 1);
        tmp+=dfs(nums, x + 1, y - 1);
        return tmp;
    }
}

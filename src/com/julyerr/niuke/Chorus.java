package com.julyerr.niuke;

import java.util.Scanner;

/**
 * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 * 要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
 * 接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
 * 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 * 输出描述:
 * 输出一行表示最大的乘积。
 * <p>
 * <p>
 * 输入
 * <p>
 * 3
 * 7 4 7
 * 2 50
 * <p>
 * <p>
 * 输出
 * <p>
 * 49
 */

/**
 * 如果正面考虑非常复杂的话，使用递归或者是动态规划
 *  动态规划，每一的结果依赖于上次的结果，随着每一步的进行均能取到对应的最优解
 *  fm[k][i] 表示选择k个人，最后一个人标号为i，最大取值
 *  fn[k][i] 表示选择k个人，最后一个人标号为i，最小取值
 *
 */
public class Chorus {
    public long chorus() {
//        get the input value
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] stu = new int[n + 1];
//        对应的输入
        for (int i = 1; i <= n; i++) {
            stu[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        long[][] fm = new long[k + 1][n + 1];
        long[][] fn = new long[k + 1][n + 1];
        long ret = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            fm[1][i] = stu[i];
            fn[1][i] = stu[i];
//            already handled the j = 1
            for (int j = 2; j <= k; j++) {
                for (int l = i - 1; l > 0 && (i - l) <= d; l--) {
                    fm[j][i] = Math.max(fm[j][i], Math.max(fm[j - 1][l] * stu[i], fn[j - 1][l] * stu[i]));
                    fn[j][i] = Math.min(fn[j][i], Math.min(fm[j - 1][l] * stu[i], fn[j - 1][l] * stu[i]));
                }
            }
            ret = Math.max(ret, fm[k][i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Chorus chorus = new Chorus();
        System.out.println(chorus.chorus());
    }
}

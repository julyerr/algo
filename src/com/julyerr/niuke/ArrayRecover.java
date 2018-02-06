package com.julyerr.niuke;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，
 * 其中有一些位置（不超过 10 个）看不清了，但是牛牛记得这个数列顺序对的数量是 k，
 * 顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。
 * 输入描述:
 * 每个输入包含一个测试用例。每个测试用例的第一行包含两个整数 n 和 k（1 <= n <= 100, 0 <= k <= 1000000000），
 * 接下来的 1 行，包含 n 个数字表示排列 A，其中等于0的项表示看不清的位置（不超过 10 个）。
 * 输出描述:
 * 输出一行表示合法的排列数目。
 * 示例1
 * 输入
 * <p>
 * 5 5
 * 4 0 0 2 0
 * 输出
 * <p>
 * 2
 */

/**
 * 开始没有解题思路，想着如果枚举全排然后各种情况统计，时间复杂度会很高；
 * 看了很多讨论区其他的答案发现基本上都是全排的情况，也是醉了
 * 面试的时候，实在想不出其他的方案的话，暴力求解可能也是一种不错的方案（逃
 */
public class ArrayRecover {
    List<List<Integer>> permutations = new ArrayList<>();

    public int arrayRecover(int n, int k, int[] nums) {
//        用于标识是否flag = true
        boolean[] flag = new boolean[n + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                flag[nums[i]] = true;
            }
        }
//        获取所有的zeros代表的数
        List<Integer> zeros = new ArrayList<>();
        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) {
                zeros.add(i);
            }
        }

//        获取所有zeros的全排序列
        permutation(zeros, 0);

        int ret = 0;
        //        获取增加permutations之后的序列情况
        for (List<Integer> list :
                permutations) {
            int tmp = perm(list, nums);
            if (tmp == k) {
                ret++;
            }
        }

        return ret;
    }

    private int perm(List<Integer> list, int[] nums) {
        int ret = 0;
        int index = 0;
        int len = nums.length;
        int[] tmpArray = Arrays.copyOf(nums, len);
        for (int i = 0; i < len; i++) {
            if (tmpArray[i] == 0) {
                tmpArray[i] = list.get(index++);
            }
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (tmpArray[i] < tmpArray[j]) {
                    ret++;
                }
            }
        }
        return ret;
    }


    private void permutation(List<Integer> list, int start) {
        if (start == list.size() - 1) {
            permutations.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < list.size(); i++) {
                swap(list, start, i);
                permutation(list, start + 1);
                swap(list, i, start);
            }
        }
    }

    private void swap(List<Integer> list, int a, int b) {
        int tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }

    public static void main(String[] args) {
        ArrayRecover arrayRecover = new ArrayRecover();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(arrayRecover.arrayRecover(n, k, nums));
        }
    }
}

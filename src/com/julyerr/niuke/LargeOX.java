package com.julyerr.niuke;

import java.util.Scanner;


/*
 * 直接暴力求解的话，会超时；
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/fc05f68c5f47438db54c6923ef23cf4a
 * 使用字典树，先通过输入数组构建字典树，之后针对每个元素在字典树中判断是否^之后值会大于m;
 * 而且计算的结果使用int会发生溢出
 * */

public class LargeOX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(largeOX(nums, m));
        }
    }

    private static long largeOX(int[] nums, int m) {
        TrieTree trieTree = buildTree(nums);

        long ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret += queryTree(trieTree, nums[i], m, 31);
        }
//        元素出现重复的计算
        return ret / 2;
    }

    private static class TrieTree {
        TrieTree[] next = new TrieTree[2];
        int count = 1;
    }

    //    建字典树
    private static TrieTree buildTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        TrieTree ret = new TrieTree();
        for (int i = 0; i < nums.length; i++) {
            TrieTree cur = ret;
            for (int j = 31; j >= 0; j--) {
                int tmp = (nums[i] >> j) & 1;
                if (cur.next[tmp] == null) {
                    cur.next[tmp] = new TrieTree();
                } else {
                    cur.next[tmp].count++;
                }
                cur = cur.next[tmp];
            }
        }

        return ret;
    }

    private static int queryTree(TrieTree tree, int n, int m, int start) {
        if (tree == null) {
            return 0;
        }

        TrieTree cur = tree;
        for (int i = start; i >= 0; i--) {
            int nDigit = (n >> i) & 1;
            int mDigit = (m >> i) & 1;

            if (mDigit == 1 && nDigit == 1) {
//                小于
                if (cur.next[0] == null) {
                    return 0;
                }
//                相等
                cur = cur.next[0];
            } else if (mDigit == 1 && nDigit == 0) {
                if (cur.next[1] == null) {
                    return 0;
                }
                cur = cur.next[1];
            } else if (mDigit == 0 && nDigit == 1) {
//                出现1，则统计都大于的情况
                int p = (cur.next[0] == null) ? 0 : cur.next[0].count;
//                递归比较
                int q = queryTree(cur.next[1], n, m, i - 1);
                return p + q;
            } else {
                int p = (cur.next[1] == null) ? 0 : cur.next[1].count;
                int q = queryTree(cur.next[0], n, m, i - 1);
                return p + q;
            }
        }

        return 0;
    }
}

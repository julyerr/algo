package com.julyerr.leetcode.dynamic;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 */

/**
 * 找到了前者和后者之间的关系，但是没有考虑到:树的种数 = 左孩子次数 × 右孩子次数
 */
public class UniqueBST {
    public int uniqueBST(int n) {
//        wrong way
//        if (n <= 0) {
//            return 0;
//        }
//        if (n == 1 || n == 2) {
//            return n;
//        }
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            for (int j = i - 1; j > i / 2; j--) {
//                dp[i] += 2 * dp[j];
//            }
//            if(i%2==1){
//                dp[i] += dp[i/2]*dp[i/2];
//            }else{
//                dp[i] += 2*dp[i/2]*dp[i/2-1];
//            }
//        }
//        return dp[n];

        if(n ==1 || n ==2){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0]=dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                tmp += dp[j] * dp[i-1-j];
            }
            dp[i] = tmp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBST uniqueBST = new UniqueBST();
        System.out.println(uniqueBST.uniqueBST(3));
        System.out.println(uniqueBST.uniqueBST(4));
        System.out.println(uniqueBST.uniqueBST(5));
        System.out.println(uniqueBST.uniqueBST(6));
        System.out.println(uniqueBST.uniqueBST(7));
    }
}

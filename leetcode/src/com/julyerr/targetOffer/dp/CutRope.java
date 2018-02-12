package com.julyerr.targetOffer.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一根长度为n的绳子，请把绳子剪成m段，记每段绳子长度为k[0],k[1]...k[m-1],求k[0]k[1]...k[m-1]的最大值。
 * 已知绳子长度n为整数，m>1(至少要剪一刀，不能不剪)，k[0],k[1]...k[m-1]均要求为整数。
 * 例如，绳子长度为8时，把它剪成3-3-2，得到最大乘积18；绳子长度为3时，把它剪成2-1，得到最大乘积2。
 */

public class CutRope {
    /**
     * 自己动态规划的时候选择的标准出现错误，后面进行切割的时候不一定需要在前面的某一段进行切割，可以在整个线段上任意切割
     *
     * @param args 原作者的思路，设置线段长度的动态数组dp[n] ，表示长n的线段通过切割得到的最大长度之积
     *             <p>
     *             <p>
     *             因此，动态规划通常有两种思路，dp[n]表示返回的结果，另一种就是dp[n]进行比较的过程中设置max的flag中间不断进行比较得到结果
     *             前者，保证dp[n] 为当前的最优解； 后者，并不能保证，需要中间迭代取到
     */
    //    public long cutRope(int n){
//        if(n < 2){
//            return 0;
//        }
//        long newN = (long)n;
//        long m  = newN / 2 ;
//        long[] s = new long[(int)m+1];
//        List<List<Long>> list = new ArrayList<List<Long>>();
//        list.add(new ArrayList<>());
////        initial the values
//        List tmp = new ArrayList<Long>();
//        if(newN % 2 ==0){
//            s[1] = newN / 2 * newN / 2;
//            tmp.add(newN / 2);
//            tmp.add(newN / 2);
//        }else{
//            s[1] = newN / 2 *(newN / 2 +1);
//            tmp.add(newN / 2);
//            tmp.add(newN / 2 +1);
//        }
//        list.add(tmp);
//        long max = s[1];
//        for (int i = 2; i <= m ; i++) {
//            tmp = new ArrayList<Long>();
//            tmp.addAll(list.get(i-1));
//            s[i] = s[i-1];
//            List<Long> pre = list.get(i-1);
//            for (int j = 0; j < pre.size(); j++) {
//                for (int k = 2; k <= Math.sqrt(pre.get(j)); k++) {
//                    long t = pre.get(j);
//                    long tmpSum = s[i-1] / t *k * (t-k);
//                    if(tmpSum > s[i]){
//                        s[i] = tmpSum;
//                        tmp.remove(j);
//                        tmp.add(t);
//                        tmp.add(t-k);
//                    }
//                }
//            }
//            if(max < s[i]){
//                max = s[i];
//            }
//
//            list.add(tmp);
//            for (int j = 0; j < tmp.size(); j++) {
//                System.out.print(tmp.get(j)+" ");
//            }
//            System.out.println();
//        }
//        return max;
//    }
    public int cutRope(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
//        保证可以分割，之后的线段可以不进行分割
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if (dp[i] < dp[i - j] * dp[j]) {
                    dp[i] = dp[i - j] * dp[j];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        for (int i = 3; i <= 9; i++) {
            System.out.println(i + "-> " + cutRope.cutRope(i));
        }
//        System.out.println(cutRope.cutRope(7));
    }
}

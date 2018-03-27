package com.julyerr.realInterview.exams.netease;

import java.util.Scanner;

/*
参考大神的解题思路，https://www.nowcoder.com/test/question/done?tid=14539495&qid=126951#summary
游历城市，分为两种情况：
1.如果步行的次数小于树的最大深度的话，只需要沿着最大深度步行即可
2.如果步行次数大于树的最大深度的话，可以朝着最大深度的方向步行，但是中间经过的分岔路口可以选择游历一些城市然后返回，
分叉来回需要重复两次路线，因此游历的城市数为 = (L-maxdepath)/2;
当然游历的城市数不能超过总数之和
* */
public class VisiteCity {
    //    非常巧妙的构造了深度数组保存深度，当然可以构建好树然后求最大深度
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int L = scanner.nextInt();
            int[] parent = new int[n];
            int[] depth = new int[n];
            int maxDepth = 0;
            for (int i = 1; i < n; i++) {
                parent[i] = scanner.nextInt();
                depth[i] = depth[parent[i]] + 1;
                maxDepth = Math.max(maxDepth, depth[i]);
            }
            int count = 0;
//            分两种情况讨论
            if (L <= maxDepth) {
                count = L + 1;
            } else {
                count = (L - maxDepth) / 2 + maxDepth + 1;
            }
            if (count > n) {
                count = n;
            }
            System.out.println(count);
        }
    }
}
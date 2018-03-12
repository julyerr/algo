package com.julyerr.niuke;

import java.util.*;


public class MergeDays {
    /*
     * 参考大神ac的代码：https://www.nowcoder.com/questionTerminal/01cb04dc53f54625834f2a86c519dce9
     * 先开辟一块数组，然后针对每个输入的start,end之间的所有元素的值都赋值成相同的；
     * 然后寻找起点和终点输出即可。
     * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] costs = new int[10001];
//        整个输入的起始和结束位置
        int minStart = Integer.MAX_VALUE, maxEnd = Integer.MIN_VALUE;
        while (scanner.hasNext()) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int cost = scanner.nextInt();
            for (int i = start; i <= end; i++) {
                costs[i] = cost;
            }
            if (minStart > start) {
                minStart = start;
            }
            if (maxEnd < end) {
                maxEnd = end;
            }
        }

        System.out.print("[" + minStart);
        int pre = minStart;
        for (int i = minStart + 1; i <= maxEnd; i++) {
            int cur = i;
//            找到新的分界点
            if (costs[cur] != costs[pre]) {
//                过滤0的情况
                if (costs[pre] != 0) {
                    System.out.print(", " + (i - 1) + ", " + costs[pre] + "]");
                }
//                过滤0的情况
                if (costs[cur] != 0) {
                    System.out.print(",[" + i);
                }
            }
            pre = cur;
        }
//        最后一种情况没有包含
        System.out.print(", " + maxEnd + ", " + costs[maxEnd] + "]");
    }
    /*
     * 牛客的测试平台还不是很稳定，使用自定义排序规则老是出错
     *
     * 下面的逻辑是：不断进行合并，感觉没有什么大的错误。。。10%卡死
     *
     * */
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int index = 0;
//        List<intervals> tmp = new ArrayList<>();
//        while (scanner.hasNext()) {
//            int start = scanner.nextInt();
//            int end = scanner.nextInt();
//            int cost = scanner.nextInt();
//
//            tmp.add(new intervals(start, end, cost));
//            index++;
//        }
//
//        Collections.sort(tmp, new Comparator<intervals>() {
//            @Override
//            public int compare(intervals o1, intervals o2) {
//                if (o1.start <= o2.start) {
//                    return -1;
//                }
//                return o1.cost - o2.cost;
//            }
//        });
//        List<intervals> rt = new ArrayList<>();
//        for (int i = 0; i < index; i++) {
//            int start = i;
//            while (i + 1 < index && (tmp.get(i).cost == tmp.get(i+1).cost) && (tmp.get(i).end + 1 == tmp.get(i + 1).start)) {
//                tmp.get(start).end = tmp.get(i + 1).end;
//                i++;
//            }
//            rt.add(tmp.get(start));
//        }
//        System.out.print(rt.get(0));
//        for (int i = 1; i < rt.size(); i++) {
//            System.out.print("," + rt.get(i));
//        }
//        System.out.println();
//    }
//
//    public static class intervals {
//        int start, end;
//        int cost;
//
//        public intervals(int start, int end, int cost) {
//            this.start = start;
//            this.end = end;
//            this.cost = cost;
//        }
//
//        @Override
//        public String toString() {
//            return "[" + start +
//                    ", " + end +
//                    ", " + cost +
//                    ']';
//        }
//    }
}

package com.julyerr.realInterview.exams.netease;

import java.util.*;

public class KindsSubSeq {
//    下面这种方式超时，后面参考大神的解题思路
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String line = scanner.nextLine();
//            int half = line.length() / 2;
//            validBracket("",half,half);
//            rt.remove(line);
//            for (String str :
//                    rt) {
//                findLCS(line,str);
//            }
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < num.size() ;i++) {
//                max = Math.max(max,num.get(i));
//            }
//            int out = 0;
//            for (int i = 0; i < num.size() ;i++) {
//                if(num.get(i) == max){
//                    out++;
//                }
//            }
//            System.out.println(out);
//        }
//    }
//
//    private static void findLCS(String A, String B) {
//        int n = A.length();
//        int m = B.length();
//        int[][] dp = new int[n+1][m+1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m ; j++) {
//                if(A.charAt(i-1) == B.charAt(j-1)){
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                }else{
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//                }
//            }
//        }
//        num.add(dp[n][m]);
//    }
//
//    private static void validBracket(String cur,int left,int right){
//        if(left > right){
//            return ;
//        }
//        if(left == 0 && right == 0){
//            rt.add(cur);
//            return;
//        }
//        if(left>0){
//            validBracket(cur+"(",left-1,right);
//        }
//        if(right>0){
//            validBracket(cur+")",left,right-1);
//        }
//    }
//
//    private static List<String> rt = new ArrayList<>();
//    private static List<Integer> num = new ArrayList<>();

    /*
     * 参考解题思路：https://www.nowcoder.com/test/question/done?tid=14539495&qid=126953#summary
     * 最长的子序列和原字符串只相差一，暴力替换原字符串任意个字符，然后判断新生成的字符是否是满足括号特性，满足则添加到set集合中（自动去重）
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            set.clear();
            String line = scanner.nextLine();
            getSequence(line);
//            包含原字符串
            System.out.println(set.size() - 1);
        }
    }

    private static void getSequence(String line) {
        for (int i = 0; i < line.length(); i++) {
//            每次删除一个字符
            StringBuilder stringBuilder = new StringBuilder(line);
            char c = line.charAt(i);
            stringBuilder.deleteCharAt(i);
            for (int j = 0; j < line.length(); j++) {
//                对应位置插入一个字符
                stringBuilder.insert(j, c);
                if (isValidBracket(stringBuilder.toString())) {
                    set.add(stringBuilder.toString());
                }
//                下次循环判断，删除该字符
                stringBuilder.deleteCharAt(j);
            }
        }
    }

    //    判断某字符串是否满足括号特性
    private static boolean isValidBracket(String str) {
        int left = str.length() / 2;
        int right = left;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left--;
            } else {
                right--;
            }
            if (left > right) {
                return false;
            }
        }
        return true;
    }

    private static Set<String> set = new HashSet<>();
}

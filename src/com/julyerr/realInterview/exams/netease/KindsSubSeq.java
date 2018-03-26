package com.julyerr.realInterview.exams.netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KindsSubSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int half = line.length() / 2;
            validBracket("",half,half);
            rt.remove(line);
            for (String str :
                    rt) {
                findLCS(line,str);
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < num.size() ;i++) {
                max = Math.max(max,num.get(i));
            }
            int out = 0;
            for (int i = 0; i < num.size() ;i++) {
                if(num.get(i) == max){
                    out++;
                }
            }
            System.out.println(out);
        }
    }

    private static void findLCS(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        num.add(dp[n][m]);
    }

    private static void validBracket(String cur,int left,int right){
        if(left > right){
            return ;
        }
        if(left == 0 && right == 0){
            rt.add(cur);
            return;
        }
        if(left>0){
            validBracket(cur+"(",left-1,right);
        }
        if(right>0){
            validBracket(cur+")",left,right-1);
        }
    }

    private static List<String> rt = new ArrayList<>();
    private static List<Integer> num = new ArrayList<>();
}

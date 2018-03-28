package com.julyerr.realInterview.exams.netease.one0327;

import java.util.Scanner;

public class TurnDir {
//    相对当前位置的往左往右可能值
    private static char[] dirs = new char[]{'E','S','W','N','E','S','W'};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n =scanner.nextInt();
            String line = scanner.next();
            int left=0;
            int right=0;
//            统计左右转的总次数
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i)=='L'){
                    left++;
                }else{
                    right++;
                }
            }
//            当前状态
            int cur = 3;
            if(left == right){
                System.out.println("N");
            }else if(left>right){
//                往左转
                cur -=(left-right)%4;
            }else{
//                往右转
                cur += (right-left)%4;
            }
            System.out.println(dirs[cur]);
        }
    }
}

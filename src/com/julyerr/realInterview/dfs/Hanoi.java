package com.julyerr.realInterview.dfs;

/*
 * 参考：https://www.zhihu.com/question/24385418
 * */
public class Hanoi {
    public void hanoi(int n, int from, int buffer, int to) {
        if (n == 1) {
            System.out.println("from " + from + " to " + to);
            return;
        }
        hanoi(n - 1, from, to, buffer);
        hanoi(1, from, buffer, to);
        hanoi(n - 1, buffer, from, to);
    }

    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(3, 1, 2, 3);
    }

}

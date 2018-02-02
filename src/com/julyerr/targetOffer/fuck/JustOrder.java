package com.julyerr.targetOffer.fuck;

/*
 *求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * */
public class JustOrder {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean tmp = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}

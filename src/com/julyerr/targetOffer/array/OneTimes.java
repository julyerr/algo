package com.julyerr.targetOffer.array;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */

/*
 * 迭代递归的过程
 * */
public class OneTimes {
    public int NumberOf1Between1AndN_Solution(int n) {
//        check validation
        if (n <= 0) {
            return 0;
        }
        int delta = 1;
        int base = 10;
        int count = 1;
        while (n > base) {
            int tmp = n / base % 10;
            if (tmp == 1) {
                count += delta + n % base + 1;
            } else if (tmp > 0) {
                count += tmp * delta + base;
            }
            delta = 10 * delta + base;
            base = 10 * base;
        }
        if (n == base) {
            count = delta + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        OneTimes oneTimes = new OneTimes();
        System.out.println(oneTimes.NumberOf1Between1AndN_Solution(5));
        System.out.println("-----------");
        System.out.println(oneTimes.NumberOf1Between1AndN_Solution(10));
        System.out.println("-----------");
        System.out.println(oneTimes.NumberOf1Between1AndN_Solution(19));
        System.out.println("-----------");
        System.out.println(oneTimes.NumberOf1Between1AndN_Solution(100));
        System.out.println("-----------");
        System.out.println(oneTimes.NumberOf1Between1AndN_Solution(111));
        System.out.println("-----------");
        System.out.println(oneTimes.NumberOf1Between1AndN_Solution(199));
        System.out.println("-----------");
        System.out.println(oneTimes.NumberOf1Between1AndN_Solution(1021));
        System.out.println("-----------");
    }
}

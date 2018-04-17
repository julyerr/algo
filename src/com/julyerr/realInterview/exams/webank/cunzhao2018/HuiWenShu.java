package com.julyerr.realInterview.exams.webank.cunzhao2018;

import java.util.Scanner;

public class HuiWenShu {
    public static void main(String[] args) {
        long[] tmp = new long[65];
        tmp[1] = 2;
        tmp[2] = 2;
        for (int i = 3; i < 65; i++) {
            tmp[i] = tmp[i - 2] << 1;
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            int len = 0;
            for (len = 63; len >= 0; len--) {
                long a = (long) 1 << len;
                if ((n & a) != 0) {
                    break;
                }
            }
            len++;
            int mid = (len + 1) / 2;
            long last = ((long)1<<(len-1))<=n?1:0;
            if(last==1){
                for (int i = len - 1; i > mid; i--) {
                    if ((n & (1 << (i - 1))) != 0) {
                        long cur = n;
                        cur |= (1 << (len - i));
                        for (int j = len - i + 1; j < i-1; j++) {
                            cur &= ~((long) 1 << j);
                        }
                        if (cur <= n) {
                            last <<= 1;
                        }
                    }
                }
                if (mid % 2 != 0) {
                    if ((n & ((long)1 << mid - 1)) != 0) {
                        last <<= 1;
                    }
                }
            }
            long[] test = new long[65];
            test[1] = 2;
            test[2] = 1;
            last += 3;
            for (int i = 3; i < len; i++) {
                test[i] += tmp[i - 2];
                last += test[i];
            }
            System.out.println(last);
        }
    }
}

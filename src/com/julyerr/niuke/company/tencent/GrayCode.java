package com.julyerr.niuke.company.tencent;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        if (n == 1) {
            return new String[]{"0", "1"};
        }
        String[] pre = getGray(n - 1);
        String[] rt = new String[pre.length * 2];
        int index = 0;
        boolean flag = true;
        for (String string :
                pre) {
            if (flag) {
                rt[index++] = string + "0";
                rt[index++] = string + "1";
            } else {
                rt[index++] = string + "1";
                rt[index++] = string + "0";
            }
            flag=!flag;
        }
        return rt;
    }

    public static void main(String[] args){
        GrayCode grayCode = new GrayCode();
        for (String st :
                grayCode.getGray(3)) {
            System.out.println(st);
        }
    }

}

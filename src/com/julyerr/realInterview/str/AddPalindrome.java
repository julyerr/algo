package com.julyerr.realInterview.str;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/cfa3338372964151b19e7716e19987ac
 * 将原字符串从开始慢慢移除字符，如果剩下的字符串是回文的话，直接返回被移除字符串reversed之后的字符串即可
 * */

import java.util.HashMap;
import java.util.Map;

public class AddPalindrome {
    public String addToPalindrome(String A, int n) {
        if (n < 2) {
            return A;
        }
        int i;
        for (i = 1; i < A.length() - 1; i++) {
            if (isPalindrome(A.substring(i))) {
                break;
            }
        }
        return new StringBuilder(A.substring(0, i)).reverse().toString();
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

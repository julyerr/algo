package com.julyerr.leetcode.array;

/*
* 参考实现思路：https://blog.csdn.net/qq508618087/article/details/51359965
* */
public class AddtiveNumber {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {
            return false;
        }
        for (int i = 1; i <= num.length() - 2; i++) {
            String num1 = num.substring(0, i);
            for (int j = i + 1; j <= num.length() - 1; j++) {
                String num2 = num.substring(i, j);
                if (dfs(num1, num2, num.substring(j))) {
                    return true;
                }
                if (num2.charAt(0) == '0') {
                    break;
                }
            }
            if (num1.charAt(0) == '0') {
                break;
            }
        }
        return false;
    }

    private boolean dfs(String num1, String num2, String num3) {
        if (num3.length() == 0) {
            return true;
        }
        String sum = getSum(num1, num2);
        for (int i = 1; i <= num3.length(); i++) {
            String tmp = num3.substring(0, i);
            if (tmp.equals(sum) && dfs(num2, tmp, num3.substring(i))) {
                return true;
            }
            if (tmp.charAt(0) == '0') {
                return false;
            }
        }
        return false;
    }

    String getSum(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int step = 0;
        int cur = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (lenA >= 0 && lenB >= 0) {
            int tmp = a.charAt(lenA) - '0' + b.charAt(lenB) - '0' + step;
            stringBuilder.append(tmp % 10);
            step = tmp / 10;
            lenA--;
            lenB--;
        }
        while (lenA >= 0) {
            int tmp = a.charAt(lenA) - '0' + step;
            stringBuilder.append(tmp % 10);
            step = tmp / 10;
            lenA--;
        }
        while (lenB >= 0) {
            int tmp = b.charAt(lenB) - '0' + step;
            stringBuilder.append(tmp % 10);
            step = tmp / 10;
            lenB--;
        }
        if (step != 0) {
            stringBuilder.append(step);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args){
        AddtiveNumber addtiveNumber = new AddtiveNumber();
        System.out.println(addtiveNumber.isAdditiveNumber("112358"));
    }
}

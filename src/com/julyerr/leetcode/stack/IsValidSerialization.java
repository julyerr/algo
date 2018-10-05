package com.julyerr.leetcode.stack;

import java.util.Stack;

/*
 * 参考解题思路:https://blog.csdn.net/aishangyutian12/article/details/52003811
 * 可以使用正则表达式或者是栈解题，想法是一致的：
 *    不能连续出现三个# # #
 *    数字 # # 可以替换成 #，然后递归判断
 * */
public class IsValidSerialization {
    //    这种方式比较巧妙
    //    public boolean isValidSerialization(String preorder) {
//        String s = preorder.replaceAll("\\d+,#,#", "#");
//        return s.equals("#") || !s.equals(preorder) && isValidSerialization(s);
//    }
    public boolean isValidSerialization(String preorder) {
        String[] strings = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < strings.length; i++) {
            if ("#".equals(strings[i])) {
//                递推判断
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
//                    只有两个## 或者三个 ### 返回错误
                    if (stack.isEmpty() || stack.peek().equals("#")) {
                        return false;
                    }
                    stack.pop();
                }
                stack.add("#");
            } else {
//                替换数字
                stack.add("n");
            }
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }
}

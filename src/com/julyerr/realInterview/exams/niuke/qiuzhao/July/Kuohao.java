package com.julyerr.realInterview.exams.niuke.qiuzhao.July;

import java.util.Scanner;
import java.util.Stack;

public class Kuohao {
    private static int[] left, right;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        left = new int[n];
        right = new int[n];

        int n1 = 0;
        int n2 = 0;
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
//            自身已经匹配不需要增加到处理过程中
            if (isMatch(i, strings[i])) {
                n1++;
            }
        }
        for (int i = 0; i < n - 1; i++) {
//            只有不相等才可能匹配
            if (left[i] != right[i] && (left[i] == 0 || right[i] == 0)) {
                for (int j = i + 1; j < n; j++) {
                    if (left[i] == right[j] && right[i] == left[j]) {
                        n2++;
                    }
                }
            }
        }
        System.out.println(n1 * n1 + n2);
    }


    private static boolean isMatch(int index, String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.add('(');
                left[index]++;
            } else {
                right[index]++;
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    left[index]--;
                    right[index]--;
                } else {
                    stack.add(')');
                }
            }
        }
        return stack.isEmpty();
    }
}
/*
5
(()
)))))
()()()
(((
))

7
()(
)
)(
())
(((
()()()
()

9
(()
((())
(
)
(()()(()())))
)
)(()(
)())(
)()(

* */
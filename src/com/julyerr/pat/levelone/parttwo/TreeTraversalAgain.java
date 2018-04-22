package com.julyerr.pat.levelone.parttwo;

import java.util.Scanner;
import java.util.Stack;

/*
 * 这道题没有必要构建成树,可以直接进行先递归left，然后right，输出即可；
 *
 * 此题需要注意的地方就是，push的是具体的值，但是通过pre，in构建树的过程根据的是下标
 * */
public class TreeTraversalAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] pre = new int[n];
            int[] mid = new int[n];
            int index = 0;
            int[] values = new int[n];
            int valueIndex = 0;
            int preIndex = 0, midIndex = 0;
            Stack<Integer> stack = new Stack<>();
//            前序和中序
            for (int i = 0; i < n << 1; i++) {
                String line = scanner.nextLine();
                String[] strings = line.split(" ");
                if (strings[0].equals("Push")) {
                    values[valueIndex++] = Integer.parseInt(strings[1]);
                    pre[preIndex++] = index;
                    stack.push(index);
                    index++;
                } else {
                    mid[midIndex++] = stack.pop();
                }
            }

            post = new int[n];
            cons1(pre, 0, n - 1, mid, 0, n - 1);
            System.out.print(values[post[0]]);
            for (int i = 1; i < n; i++) {
                System.out.print(" " + values[post[i]]);
            }
            System.out.println();
        }

    }

    private static void cons1(int[] pre, int preStart, int preEnd, int[] mid, int midStart, int midEnd) {
        if (preStart > preEnd || midStart > midEnd) {
            return;
        }
        int i = 0;
        for (i = midStart; i <= midEnd; i++) {
            if (mid[i] == pre[preStart]) {
                break;
            }
        }
        cons1(pre, preStart + 1, preStart + i - midStart, mid, midStart, i - 1);
        cons1(pre, preStart + i - midStart + 1, preEnd, mid, i + 1, midEnd);
        post[postIndex++] = pre[preStart];
    }


    private static int postIndex = 0;
    private static int[] post;

}

/*
19
Push 4
Push 11
Push 7
Push 12
Pop
Pop
Pop
Push 14
Push 17
Pop
Pop
Push 6
Push 18
Pop
Push 8
Pop
Pop
Push 4
Pop
Pop
Push 11
Push 16
Push 11
Push 12
Pop
Push 2
Pop
Pop
Pop
Push 7
Push 4
Pop
Pop
Push 12
Pop
Pop
Push 11
Pop
* */
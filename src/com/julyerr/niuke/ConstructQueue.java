package com.julyerr.niuke;

import java.util.*;

/*
*
* 题目描述
小明同学把1到n这n个数字按照一定的顺序放入了一个队列Q中。现在他对队列Q执行了如下程序：
while(!Q.empty())              //队列不空，执行循环

{

    int x=Q.front();            //取出当前队头的值x

    Q.pop();                 //弹出当前队头

    Q.push(x);               //把x放入队尾

    x = Q.front();              //取出这时候队头的值

    printf("%d\n",x);          //输出x

    Q.pop();                 //弹出这时候的队头

}

做取出队头的值操作的时候，并不弹出当前队头。
小明同学发现，这段程序恰好按顺序输出了1,2,3,...,n。现在小明想让你构造出原始的队列，你能做到吗？[注：原题样例第三行5有错，应该为3，以下已修正]
输入描述:
第一行一个整数T（T ≤ 100）表示数据组数，每组数据输入一个数n（1 ≤ n ≤ 100000），输入的所有n之和不超过200000。
输出描述:
对于每组数据，输出一行，表示原始的队列。数字之间用一个空格隔开，不要在行末输出多余的空格.
示例1
输入

4
1
2
3
10
输出

1
2 1
2 1 3
8 1 6 2 10 3 7 4 9 5
* */

/*
 * 自愧不如，自己借鉴joseph的解题思路，只不过设置对应的visited标志表示是否已经访问过
 *   空间和时间都超了
 * 借鉴大神的解题思路，简单高效，就是对应操作的反行为
 *   https://www.nowcoder.net/questionTerminal/657d09e2b3704574814089ba8566d98d
 * */
public class ConstructQueue {
//    自己实现思路
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ConstructQueue constructQueue = new ConstructQueue();
//        ListNode head, p;
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            while (n-- >= 0) {
//                int len = scanner.nextInt();
//                head = constructQueue.new ListNode();
//                p = head;
//                p.next = head;
//                for (int i = 1; i < len; i++) {
//                    p.next = constructQueue.new ListNode();
//                    p.next.next = head;
//                    p = p.next;
//                }
//                int index = 1;
//                while (index <= len) {
//                    p = p.next;
//                    while (p.visited) {
//                        p = p.next;
//                    }
//                    p = p.next;
//                    while (p.visited) {
//                        p = p.next;
//                    }
//                    p.val = index;
//                    p.visited = true;
//                    index++;
//                }
////                sout
//                p = head;
//                while (p.next != head) {
//                    System.out.print(p.val + " ");
//                    p = p.next;
//                }
//                System.out.println(p.val);
//            }
//        }
//    }
//
//    class ListNode {
//        Integer val;
//        ListNode next;
//        boolean visited;
//    }


    //    借鉴大神的解题思路
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
//            先比较，后减少1操作
            while (n-- > 0) {
                int m = scanner.nextInt();
                LinkedList<Integer> list = new LinkedList<>();
                for (int i = m; i >= 1; i--) {
                    list.addFirst(i);
                    int t = list.pollLast();
                    list.addFirst(t);
                }
                for (int i = 0; i < list.size() - 1; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println(list.get(list.size() - 1));
            }
        }
    }
}

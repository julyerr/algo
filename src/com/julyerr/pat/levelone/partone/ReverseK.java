package com.julyerr.pat.levelone.partone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 花了老大的一把力气，使用list反转的方式弄出来，思路没有问题，主要是超时和栈溢出，应该是使用的方式出错了；
 *
 * 改用数组下标的方式试一试,如果直接使用link的方式还是比较繁琐，参考实现：https://blog.csdn.net/JingLisen/article/details/79093451
 * 使用数组进行交换，相对于link简洁很多,部分数据还是超时（java算法效率还是硬伤）
 * */
public class ReverseK {
    //    改用数组下标的方式
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int start = scanner.nextInt();
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            Node[] nodes = new Node[100001];
            for (int i = 0; i < n; i++) {
                Node node = new Node(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                nodes[node.addr] = node;
            }
            List<Node> list = link(nodes, start);
            reverse(list, k);
            for (int i = 0; i < list.size() - 1; i++) {
                System.out.printf("%05d %d %05d\n", list.get(i).addr, list.get(i).val, list.get(i + 1).addr);
            }
            System.out.printf("%05d %d -1\n", list.get(list.size() - 1).addr, list.get(list.size() - 1).val);
        }
    }

    private static void reverse(List<Node> nodes, int k) {
        int size = nodes.size();
        if (k < 2 || k > size) {
            return;
        }
        for (int i = 0; i + k <= size; i += k) {
            int left = i;
            int right = i + k - 1;
            while (left < right) {
                Node tmp = nodes.get(right);
                nodes.set(right, nodes.get(left));
                nodes.set(left, tmp);
                left++;
                right--;
            }
        }
    }

    private static List<Node> link(Node[] nodes, int start) {
        List<Node> rt = new ArrayList<>();
        while (start != -1) {
            rt.add(nodes[start]);
            start = nodes[start].nextAddr;
        }
        return rt;
    }

    private static class Node {
        int addr, val, nextAddr;

        public Node(int addr, int val, int nextAddr) {
            this.addr = addr;
            this.val = val;
            this.nextAddr = nextAddr;
        }
    }

    //    使用list反转的方式，超时、栈移除（部分正确通过）
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String start = scanner.next();
//            int n = scanner.nextInt();
//            int k = scanner.nextInt();
//            Map<String, Node> map = new HashMap<>();
////            输入处理
//            for (int i = 0; i < n; i++) {
//                String addr = scanner.next();
//                int val = scanner.nextInt();
//                String next = scanner.next();
//                map.put(addr, new Node(addr, val, next));
//            }
////            构建链表
//            for (String addr :
//                    map.keySet()) {
//                Node node = map.get(addr);
//                if (!node.nextAddr.equals("-1")) {
//                    node.next = map.get(node.nextAddr);
//                }
//            }
//            Node head = map.get(start);
//            head = reverseK(head, n, k);
//            while (head.next != null) {
//                System.out.println(head.address + " " + head.val + " " + head.next.address);
//                head = head.next;
//            }
//            System.out.println(head.address + " " + head.val + " -1");
//        }
//    }
//
//    private static Node reverseK(Node head, int n, int k) {
//        if (k <= 1 || k > n) {
//            return head;
//        }
//        Node newHead = new Node();
//        newHead.next = head;
//        Node preHead = newHead;
//        while (true) {
//            int tmp = k;
//            Node pre = preHead;
//            while (tmp-- > 0 && pre.next != null) {
//                pre = pre.next;
//            }
//            if (tmp == -1) {
//                Node last = preHead.next;
//                Node a = pre.next;
//                pre.next = null;
////                拼接起来
//                preHead.next = reverse(preHead.next);
//                preHead = last;
//                preHead.next = a;
//            } else {
//                break;
//            }
//        }
//        return newHead.next;
//    }
//
//    private static Node reverse(Node node) {
//        if (node == null || node.next == null) {
//            return node;
//        }
//        Node tmp = node.next;
//        Node newHead = reverse(node.next);
//        tmp.next = node;
//        node.next = null;
//        return newHead;
//    }
//
//    private static class Node {
//        String address, nextAddr;
//        Node next;
//        int val;
//
//        public Node(String address, int val, String nextAddr) {
//            this.address = address;
//            this.val = val;
//            this.nextAddr = nextAddr;
//        }
//
//        public Node() {
//        }
//    }
}

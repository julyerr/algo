package com.julyerr.realInterview.dfs;

import java.util.ArrayList;
import java.util.List;

/*
 * 参考大神的解题思路：https://www.nowcoder.com/questionTerminal/430180b66a7547e1963b69b1d0efbd3c
 * 联想到使用二叉树的结构，然后中序遍历得到结果。可以不需要构件树，直接使用递归添加元素
 * */
public class PaperFolding {
    public String[] foldPaper(int n) {
        String[] tmp = foldpager(n, true).toArray(new String[0]);
        return tmp;
    }

    private List<String> foldpager(int n, boolean flag) {
        List<String> rt = new ArrayList<>();
        if (n == 1) {
            if (flag) {
                rt.add("down");
            } else {
                rt.add("up");
            }
            return rt;
        }
//        左孩子
        rt.addAll(foldpager(n - 1, true));
        if (flag) {
            rt.add("down");
        } else {
            rt.add("up");
        }
//        右孩子
        rt.addAll(foldpager(n - 1, false));
        return rt;
    }

    public static void main(String[] args) {
        PaperFolding paperFolding = new PaperFolding();
        int n = 5;
        for (String str :
                paperFolding.foldPaper(n)) {
            System.out.print(str + " ");
        }
    }
}


package com.julyerr.realInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 这道题就是求多叉树中两个节点的最低公共祖先
 *
 * 可以保留两个栈，分别记录从根节点到indexA和indexB的路径，然后判断即可
 * */
public class XiaomiGit {
    private List<List<Integer>> rt = new ArrayList<>();

    public int getSplitNode(String[] matrix, int indexA, int indexB) {
//        可以直接判断结果
        if (indexA == 0 || indexB == 0) {
            return 0;
        }
        if (indexA == indexB) {
            return indexA;
        }

        List<Integer> tmp = new ArrayList<>();
        boolean[] flags = new boolean[matrix.length];
        dfs(tmp, 0, matrix, indexA, flags);

//        重新计算路径
        tmp.clear();
        Arrays.fill(flags, false);

        dfs(tmp, 0, matrix, indexB, flags);
        int min = rt.get(0).size() > rt.get(1).size() ? rt.get(1).size() : rt.get(0).size();
//        从后往前比较
        for (int i = min - 1; i >= 0; i--) {
            if (rt.get(0).get(i) == rt.get(1).get(i)) {
                return rt.get(0).get(i);
            }
        }
        return 0;
    }

    private void dfs(List<Integer> cur, int pos, String[] matrix, int index, boolean[] visited) {
        int len = matrix.length;
        if (pos >= len) {
            return;
        }
//        添加该节点
        visited[pos] = true;
        cur.add(pos);
        if (pos == index) {
            rt.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < len; i++) {
//            递归
            if (!visited[i] && matrix[pos].charAt(i) == '1') {
                dfs(cur, i, matrix, index, visited);
            }
        }
//        删除该节点
        visited[pos] = false;
        cur.remove(cur.size() - 1);
        return;
    }

    public static void main(String[] args) {
        XiaomiGit xiaomiGit = new XiaomiGit();
        String[] matrix = new String[]{
                "0000100001", "0001000011", "0000000001", "0100000000", "1000000000",
                "0000000010", "0000000010", "0000000001", "0100011000", "1110000100"
        };
        int indexA = 5;
        int indexB = 1;
        System.out.println(xiaomiGit.getSplitNode(matrix, indexA, indexB));
    }
}

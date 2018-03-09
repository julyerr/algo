package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */

//整个代码还是规范一点，尽量避免自动配置等的问题
public class BTPath {

    private List<String> rt = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,new ArrayList<>());
        return rt;
    }

    private void dfs(TreeNode node, List<TreeNode> cur) {
        if (node == null) {
            return;
        }

        cur.add(node);
        if (node.left == null && node.right == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(cur.get(0).val);
            for (int i = 1; i < cur.size(); i++) {
                stringBuilder.append("->").append(cur.get(i).val);
            }
            rt.add(stringBuilder.toString());
        }
//        迭代left,right
        dfs(node.left, cur);
        dfs(node.right, cur);
//        移除当前元素，便于下次迭代
        cur.remove(cur.size() - 1);
    }
}

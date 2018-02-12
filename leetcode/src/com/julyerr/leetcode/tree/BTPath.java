package com.julyerr.leetcode.tree;

import com.julyerr.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */

//整个代码还是规范一点，尽量避免自动配置等的问题
public class BTPath {
    private List<String> rt = new ArrayList<String>();
    private List<Integer> path = new ArrayList<Integer>();

    public List<String> binatyTreePaths(TreeNode node) {
        findPath(node);
        return rt;
    }

    private void findPath(TreeNode node) {
        if (node == null) {
            return;
        }
        path.add(node.data);
        //ensure the node is in the last level
        if (node.lChild == null && node.rChild == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(path.get(0));
            for (int i = 1; i < path.size(); i++) {
                stringBuilder.append("->").append(path.get(i));
            }
            rt.add(stringBuilder.toString());
        }
        findPath(node.lChild);
        findPath(node.rChild);
        path.remove(path.size() - 1);
    }
}

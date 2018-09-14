package com.julyerr.leetcode.tree;

/*
 * 深度和广度结合来实现，参考思路：
 * https://blog.csdn.net/qq508618087/article/details/50995525
 * */
public class WordDictionary {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.children[c - 'a'] == null) {
                p.children[c - 'a'] = new TrieNode();
            }
            p = p.children[c - 'a'];
        }
        p.isWord = true;
    }


    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int start) {
        if (node == null) {
            return false;
        }
        if (start >= word.length()) {
            return node.isWord;
        }
        if (word.charAt(start) != '.') {
            return dfs(node.children[word.charAt(start) - 'a'], word, start + 1);
        }
        for (int i = 0; i < 26; i++) {
            if (dfs(node.children[i], word, start + 1)) {
                return true;
            }
        }
        return false;
    }

    class TrieNode {
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

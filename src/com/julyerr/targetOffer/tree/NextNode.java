package com.julyerr.targetOffer.tree;

/**
 * 给定二叉树和其中一个节点，找到中序遍历序列的下一个节点。树中的节点除了有左右孩子指针，还有一个指向父节点的指针。
 */

/**
 * 这道题目首先需要理解next表示parent(汗），针对不同的情况进行处理，然后发现很多不同的情况可以
 * 放在同一个function中处理
 * <p>
 * 提交怀疑平台有问题，怎么会出现nullPoint异常，其实root.next.left就是异常（醉了）
 */
public class NextNode {
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
//        validation
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            return help(pNode.right);
        }
        while (pNode.next != null && pNode.next.left != pNode) {
            pNode = pNode.next;
        }
        return pNode.next;
    }

    private TreeLinkNode help(TreeLinkNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}

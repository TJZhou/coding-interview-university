package com.tianju.tree;

import com.tianju.ds.DSDeque;
import com.tianju.ds.DSLinkedList;

/**
 * Tianju Zhou
 * Jun 4, 2020
 */
public class BinaryTree<T> {
    TreeNode<T> root;

    public void bfs() {
        bfs(root);
    }

    public void bfs(TreeNode<T> node) {
        if(node == null) return;
        DSDeque<TreeNode<T>> dq = new DSLinkedList<>();
        dq.offer(node);
        while(!dq.isEmpty()) {
            int size = dq.size();
            for(int i = 0; i < size; i++) {
                TreeNode<T> n = dq.poll();
                /*
                 * do something for BFS
                 */
                if(n.left != null) dq.offer(n.left);
                if(n.right != null) dq.offer(n.right);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode<T> node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        /*
         * do something for in-order traversal
         */
        inOrder(node.right);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(TreeNode<T> node) {
        if(node == null) {
            return;
        }
        /*
          do something for pre-order traversal
         */
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(TreeNode<T> node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        /*
          do something for post-order traversal
         */
    }
}

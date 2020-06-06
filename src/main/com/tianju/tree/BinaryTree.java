package com.tianju.tree;

import com.tianju.ds.DSDeque;
import com.tianju.ds.DSLinkedList;

/**
 * Tianju Zhou
 * Jun 4, 2020
 */
public abstract class BinaryTree<T extends Comparable<T>> {

    static class TreeNode<T extends Comparable<T>> {
        T val;
        TreeNode<T> parent;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T val, TreeNode<T> parent) {
            this.val = val;
            this.parent = parent;
        }

        void addLeft(T val) {
            this.left = new TreeNode<>(val, this);
        }

        void addRight(T val) {
            this.right = new TreeNode<>(val, this);
        }
    }

    TreeNode<T> root;
    int size;

   public  BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public BinaryTree(T val) {
        this.size = 1;
        this.root = new TreeNode<>(val, null);
    }

    abstract boolean search(T t);

    abstract boolean insert(T t);

    abstract  boolean delete(T t);

    public int height() {
        if(root == null) throw new NullPointerException("Tree is empty");
        TreeNode<T> node = root;
        return heightHelper(node);
    }

    private int heightHelper(TreeNode<T> n) {
        if(n == null) return -1;
        int leftHeight = heightHelper(n.left);
        int rightHeight = heightHelper(n.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void bfs() {
        TreeNode<T> node = root;
        bfs(node);
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
        TreeNode<T> node = root;
        inOrder(node);
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
        TreeNode<T> node = root;
        preOrder(node);
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
        TreeNode<T> node = root;
        postOrder(node);
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

    public TreeNode<T> getRoot() {
        if(root == null) throw new NullPointerException("Tree is empty!");
        return root;
    }

    public int size() {
        return size;
    }
}

package com.tianju.tree;

/**
 * Tianju Zhou
 * Jun 4, 2020
 */
public interface BinaryTree<T extends Comparable<T>> {

    class TreeNode<T extends Comparable<T>> {
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

    boolean search(T t);

    boolean insert(T t);

    boolean delete(T t);

    void bfs();

    void bfs(TreeNode<T> node);

    void inOrder();

    void inOrder(TreeNode<T> node);

    void preOrder();

    void preOrder(TreeNode<T> node);

    void postOrder();

    void postOrder(TreeNode<T> node);

    TreeNode<T> getRoot();

    int size();

}

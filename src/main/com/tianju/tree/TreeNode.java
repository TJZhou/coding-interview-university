package com.tianju.tree;

/**
 * Tianju Zhou
 * Jun 4, 2020
 */
public class TreeNode<T> {
    T val;
    TreeNode<T> parent;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode() {}

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}

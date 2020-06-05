package com.tianju.tree;

/**
 * Tianju Zhou
 * Jun 4, 2020
 */
public class TreeNode<T> {
    private T val;
    private TreeNode<T> parent;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode() {}

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> parent) {
        this.val = val;
        this.parent = parent;
    }

    public TreeNode(T val, TreeNode<T> parent, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public TreeNode<T> addLeft(T val) {
        this.left = new TreeNode<>(val, this);
        return this.left;
    }

    public TreeNode<T> addRight(T val) {
        this.right = new TreeNode<>(val, this);
        return this.right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}

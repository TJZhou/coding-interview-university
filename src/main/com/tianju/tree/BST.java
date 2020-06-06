package com.tianju.tree;

/**
 * Tianju Zhou
 * Jun 5, 2020
 */
public class BST<T extends Comparable<T>> extends BinaryTree<T> {

    public BST() {
        super();
    }

    public BST(T val) {
        super(val);
    }

    public boolean search(T t) {
        TreeNode<T> node = root;
        return searchHelper(node, t);
    }

    private boolean searchHelper(TreeNode<T> n, T t) {
        if(n == null) {
            return false;
        }
        if(t.compareTo(n.val) == 0) {
            return true;
        } else if(t.compareTo(n.val) < 0) {
            return searchHelper(n.left, t);
        } else {
            return searchHelper(n.right, t);
        }
    }

    // Only return true if element doesn't exist in the original BST
    public boolean insert(T t) {
        size++;
        if(root == null) {
            root = new TreeNode<T>(t, null);
            return true;
        }
        TreeNode<T> node = root;
        return insertHelper(node, t);
    }

    private boolean insertHelper(TreeNode<T> n, T t) {
        if(t.compareTo(n.val) < 0) {
            if(n.left == null) {
                n.addLeft(t);
                return true;
            } else {
                return insertHelper(n.left, t);
            }
        } else if(t.compareTo(n.val) > 0){
            if(n.right == null) {
                n.addRight(t);
                return true;
            } else {
                return insertHelper(n.right, t);
            }
        } else {
            // elements already exists. Do not update size
            size--;
            return false;
        }
    }

    // only return true if element t exists in BST
    public boolean delete(T t) {
        TreeNode<T> node = root;
        int prevSize = size;
        root = deleteHelper(node, t);
        return prevSize != size;
    }

    private TreeNode<T> deleteHelper(TreeNode<T> n, T t) {
        if(n == null) {
            return null;
        }
        if(t.compareTo(n.val) < 0) {
            n.left = deleteHelper(n.left, t);
        } else if(t.compareTo(n.val) > 0) {
            n.right = deleteHelper(n.right, t);
        } else {
            if(n.left != null || n.right != null || n == root) size--;
            if(n.left == null && n.right == null) {
                return null;
            } else if(n.left == null) {
                // change parent node
                n.right.parent = n.parent;
                return n.right;
            } else if(n.right == null) {
                n.left.parent = n.parent;
                return n.left;
            } else {
                n.val = min(n.right);
                n.right = deleteHelper(n.right, n.val);
            }
        }
        return n;
    }

    public T min() {
        TreeNode<T> node = root;
        return min(node);
    }

    private T min(TreeNode<T> n) {
        if(n == null) throw new NullPointerException("Node is empty");
        while(n.left != null) {
            n = n.left;
        }
        return n.val;
    }

    public T max() {
        TreeNode<T> node = root;
        return max(node);
    }

    private T max(TreeNode<T> n) {
        if(n == null) throw new NullPointerException("Node is empty");
        while(n.right != null) {
            n = n.right;
        }
        return n.val;
    }
}

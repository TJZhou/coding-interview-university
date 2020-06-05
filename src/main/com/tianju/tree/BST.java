package com.tianju.tree;

import com.tianju.ds.DSDeque;
import com.tianju.ds.DSLinkedList;

/**
 * Tianju Zhou
 * Jun 5, 2020
 */
public class BST<T extends Comparable<T>> implements BinaryTree<T> {


    private TreeNode<T> root;
    private int size;

    public BST() {
        this.size = 0;
        this.root = null;
    }

    public BST(TreeNode<T> root) {
        this.size = 1;
        this.root = root;
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
            root = new TreeNode<>(t, null);
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
        boolean tExits = deleteHelper(node, t);
        if(tExits) size--;
        return tExits;
    }

    private boolean deleteHelper(TreeNode<T> n, T t) {
        if(n == null) {
            return false;
        }
        if(t.compareTo(n.val) < 0) {
            return deleteHelper(n.left, t);
        } else if(t.compareTo(n.val) > 0) {
            return deleteHelper(n.right, t);
        } else {
            deleteNode(n, t);
            return true;
        }
    }

    private void deleteNode(TreeNode<T> n, T t) {
        // n is leaf node
        if(n.left == null && n.right == null) {
            if(n == root) root = null;
            else {
                if(t.compareTo(n.parent.val) < 0) n.parent.left = null;
                else n.parent.right = null;
            }
        // both left and right child of n is not null
        } else if(n.left != null && n.right != null) {
            n.val = smallestValueInRightSubtree(n.right);
        // left child of n is not null, right child is null
        } else if(n.left != null){
            if(n == root) {
                root = root.left;
                root.parent = null;
            }
            else {
                if(t.compareTo(n.parent.val) < 0) n.parent.left = n.left;
                else n.parent.right = n.left;
                n.left.parent = n.parent;
            }
        // right child of n is not null, left chils is null
        } else {
            if(n == root) {
                root = root.right;
                root.parent = null;
            }
            else {
                if(t.compareTo(n.parent.val) < 0) n.parent.left = n.right;
                else n.parent.right = n.right;
                n.right.parent = n.parent;
            }
        }
    }

    private T smallestValueInRightSubtree(TreeNode<T> n) {
        TreeNode<T> node = n;
        while(n.left != null) {
            n = n.left;
        }
        T val = n.val;
        if(n == node) {
            n.parent.right = n.right;
            n.right.parent = n.parent;
        } else {
            n.parent.left = null;
        }
        return val;
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
        return root;
    }

    public int size() {
        return size;
    }
}

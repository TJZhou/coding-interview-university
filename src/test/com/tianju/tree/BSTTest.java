package com.tianju.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tianju Zhou
 * Jun 5, 2020
 */
public class BSTTest {
    @Test
    public void binarySearchTreeTest() {
        BST<Integer> bst = new BST<>();
        bst.insert(10);
        bst.insert(6);
        bst.insert(12);
        bst.insert(8);
        bst.insert(11);
        Assertions.assertEquals(bst.getRoot().val, 10);
        Assertions.assertEquals(bst.size(), 5);
        Assertions.assertTrue(bst.search(8));
        Assertions.assertFalse(bst.search(100));
        Assertions.assertTrue(bst.insert(100));
        Assertions.assertFalse(bst.insert(12));
        Assertions.assertEquals(6, bst.size());
        Assertions.assertTrue(bst.search(100));
        bst.delete(10);
        Assertions.assertEquals(bst.size(), 5);
        Assertions.assertFalse(bst.search(10));
        Assertions.assertEquals(bst.getRoot().val, 11);
        bst.delete(11);
        Assertions.assertEquals(bst.size(), 4);
        Assertions.assertFalse(bst.search(11));
        Assertions.assertEquals(bst.getRoot().val, 12);
        Assertions.assertFalse(bst.delete(20));
        Assertions.assertTrue(bst.delete(6));
        Assertions.assertTrue(bst.delete(8));
        Assertions.assertTrue(bst.delete(12));
        Assertions.assertTrue(bst.delete(100));
        Assertions.assertEquals(bst.size(), 0);
        Assertions.assertEquals(bst.getRoot(), null);
    }
}

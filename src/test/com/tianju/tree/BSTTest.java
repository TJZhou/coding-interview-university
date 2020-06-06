package com.tianju.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tianju Zhou
 * Jun 5, 2020
 */
public class BSTTest {

    @Test
    public void binarySearchTreeInsertTest() {
        BST<Integer> bst = new BST<>();
        Assertions.assertThrows(NullPointerException.class, bst::getRoot);
        Assertions.assertThrows(NullPointerException.class, bst::height);
        Assertions.assertThrows(NullPointerException.class, bst::max);
        Assertions.assertThrows(NullPointerException.class, bst::min);

        bst.insert(10);
        Assertions.assertEquals(bst.size(), 1);
        Assertions.assertEquals(bst.getRoot().val, 10);
        Assertions.assertEquals(0, bst.height());
        Assertions.assertEquals(10, bst.max());
        Assertions.assertEquals(10, bst.min());

        bst.insert(6);
        Assertions.assertEquals(bst.size(), 2);
        Assertions.assertEquals(1, bst.height());
        Assertions.assertEquals(10, bst.max());
        Assertions.assertEquals(6, bst.min());

        bst.insert(12);
        Assertions.assertEquals(bst.size(), 3);
        Assertions.assertEquals(1, bst.height());
        Assertions.assertEquals(12, bst.max());
        Assertions.assertEquals(6, bst.min());

        bst.insert(8);
        Assertions.assertEquals(bst.size(), 4);
        Assertions.assertEquals(2, bst.height());
        bst.insert(11);
        Assertions.assertEquals(bst.size(), 5);
        Assertions.assertEquals(2, bst.height());

        Assertions.assertTrue(bst.search(8));
        Assertions.assertFalse(bst.search(100));

        Assertions.assertTrue(bst.insert(9));
        Assertions.assertFalse(bst.insert(12));
        Assertions.assertEquals(6, bst.size());
        Assertions.assertEquals(3, bst.height());
        Assertions.assertTrue(bst.search(9));
    }


    @Test
    public void binarySearchTreeDeleteTest() {
        BST<Integer> bst = new BST<>();
        bst.insert(10);
        bst.insert(6);
        bst.insert(12);
        bst.insert(8);
        bst.insert(11);
        bst.insert(5);

        bst.delete(10);
        Assertions.assertEquals(bst.size(), 5);
        Assertions.assertFalse(bst.search(10));
        Assertions.assertEquals(bst.getRoot().val, 11);
        Assertions.assertEquals(bst.height(), 2);

        bst.delete(11);
        Assertions.assertEquals(bst.size(), 4);
        Assertions.assertFalse(bst.search(11));
        Assertions.assertEquals(bst.getRoot().val, 12);
        Assertions.assertEquals(bst.height(), 2);


        Assertions.assertFalse(bst.delete(20));

        Assertions.assertTrue(bst.delete(6));
        Assertions.assertEquals(bst.size(), 3);

        Assertions.assertTrue(bst.delete(8));
        Assertions.assertEquals(bst.height(), 1);
        Assertions.assertEquals(bst.size(), 2);

        Assertions.assertTrue(bst.delete(12));
        Assertions.assertEquals(bst.height(), 0);
        Assertions.assertEquals(bst.size(), 1);

        Assertions.assertTrue(bst.delete(5));
        Assertions.assertEquals(bst.size(), 0);
        Assertions.assertThrows(NullPointerException.class, bst::height);
        Assertions.assertThrows(NullPointerException.class, bst::getRoot);
    }
}

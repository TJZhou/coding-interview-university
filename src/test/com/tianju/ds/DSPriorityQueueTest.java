package com.tianju.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * Tianju Zhou
 * Jun 6, 2020
 */
public class DSPriorityQueueTest {

    /**
     * Min Heap Test
     */
    @Test
    public void dsPriorityQueueTest() {
        DSPriorityQueue<Integer> dsPriorityQueue = new DSPriorityQueue<>();
        dsPriorityQueue.offer(new Integer[] {12,3,5,11,8,9,0,2,22,4,6,6,6});
        Assertions.assertEquals(dsPriorityQueue.size(), 13);
        Assertions.assertEquals(dsPriorityQueue.peek(), 0);

        Assertions.assertEquals(dsPriorityQueue.get(0), 0);
        Assertions.assertEquals(dsPriorityQueue.get(1), 2);
        Assertions.assertEquals(dsPriorityQueue.get(2), 3);
        Assertions.assertEquals(dsPriorityQueue.get(3), 8);
        Assertions.assertEquals(dsPriorityQueue.get(4), 4);
        Assertions.assertEquals(dsPriorityQueue.get(5), 6);
        Assertions.assertEquals(dsPriorityQueue.get(6), 5);
        Assertions.assertEquals(dsPriorityQueue.get(7), 12);
        Assertions.assertEquals(dsPriorityQueue.get(8), 22);
        Assertions.assertEquals(dsPriorityQueue.get(9), 11);
        Assertions.assertEquals(dsPriorityQueue.get(10), 6);
        Assertions.assertEquals(dsPriorityQueue.get(11), 9);
        Assertions.assertEquals(dsPriorityQueue.get(12), 6);


        Assertions.assertEquals(dsPriorityQueue.poll(), 0);
        Assertions.assertEquals(dsPriorityQueue.poll(), 2);
        Assertions.assertEquals(dsPriorityQueue.size(), 11);
        Assertions.assertEquals(dsPriorityQueue.peek(), 3);

        Assertions.assertEquals(dsPriorityQueue.removeAt(dsPriorityQueue.size() - 1), 6);
        Assertions.assertTrue(dsPriorityQueue.remove(6));
        Assertions.assertEquals(dsPriorityQueue.size(), 9);

        dsPriorityQueue.offer(100);
        Assertions.assertEquals(dsPriorityQueue.size(), 10);
        Assertions.assertEquals(dsPriorityQueue.get(dsPriorityQueue.size() - 1), 100);

        dsPriorityQueue.offer(0);
        Assertions.assertEquals(dsPriorityQueue.size(), 11);
        Assertions.assertEquals(dsPriorityQueue.get(0), 0);
    }

    /**
     * Max Heap Test
     */
    @Test
    public void dsPriorityQueueReverseOrderTest() {
        DSPriorityQueue<Integer> dsPriorityQueue = new DSPriorityQueue<>(Collections.reverseOrder());
        dsPriorityQueue.offer(new Integer[] {12,3,5,11,8,9,0,2,22,4,6,6,6});
        Assertions.assertEquals(dsPriorityQueue.size(), 13);
        Assertions.assertEquals(dsPriorityQueue.peek(), 22);

        Assertions.assertEquals(dsPriorityQueue.get(0), 22);
        Assertions.assertEquals(dsPriorityQueue.get(1), 12);
        Assertions.assertEquals(dsPriorityQueue.get(2), 9);
        Assertions.assertEquals(dsPriorityQueue.get(3), 11);
        Assertions.assertEquals(dsPriorityQueue.get(4), 8);
        Assertions.assertEquals(dsPriorityQueue.get(5), 6);
        Assertions.assertEquals(dsPriorityQueue.get(6), 0);
        Assertions.assertEquals(dsPriorityQueue.get(7), 2);
        Assertions.assertEquals(dsPriorityQueue.get(8), 3);
        Assertions.assertEquals(dsPriorityQueue.get(9), 4);
        Assertions.assertEquals(dsPriorityQueue.get(10), 6);
        Assertions.assertEquals(dsPriorityQueue.get(11), 5);
        Assertions.assertEquals(dsPriorityQueue.get(12), 6);

        Assertions.assertEquals(dsPriorityQueue.poll(), 22);
        Assertions.assertEquals(dsPriorityQueue.poll(), 12);
        Assertions.assertEquals(dsPriorityQueue.size(), 11);
        Assertions.assertEquals(dsPriorityQueue.peek(), 11);

        Assertions.assertEquals(dsPriorityQueue.removeAt(dsPriorityQueue.size() - 1), 5);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dsPriorityQueue.removeAt(-1));
        Assertions.assertEquals(dsPriorityQueue.size(), 10);

        dsPriorityQueue.offer(100);
        Assertions.assertEquals(dsPriorityQueue.size(), 11);
        Assertions.assertEquals(dsPriorityQueue.get(0), 100);

        dsPriorityQueue.offer(0);
        Assertions.assertEquals(dsPriorityQueue.size(), 12);
        Assertions.assertEquals(dsPriorityQueue.get(dsPriorityQueue.size() - 1), 0);
    }
}

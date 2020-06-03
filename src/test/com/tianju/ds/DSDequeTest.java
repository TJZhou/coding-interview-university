package com.tianju.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class DSDequeTest {

    @Test
    public void offerTest() {
        DSDeque<Integer> dsDeque = new DSDeque<>();
        dsDeque.offerFirst(0);
        dsDeque.offerFirst(1);
        Assertions.assertEquals(dsDeque.peekFirst(), 1);
        Assertions.assertEquals(dsDeque.peekLast(), 0);

        dsDeque.offerLast(2);
        dsDeque.offerLast(3);
        Assertions.assertEquals(dsDeque.peekLast(), 3);
    }

    @Test
    public void pollTest() {
        DSDeque<Integer> dsDeque = new DSDeque<>();
        dsDeque.offer(0);
        dsDeque.offer(1);
        dsDeque.offer(2);
        dsDeque.offer(3);
        Assertions.assertEquals(dsDeque.poll(), 0);
        Assertions.assertEquals(dsDeque.peekFirst(), 1);
        Assertions.assertEquals(dsDeque.pollLast(), 3);
        Assertions.assertEquals(dsDeque.peekLast(), 2);
    }
}

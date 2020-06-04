package com.tianju.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Tianju Zhou
 * Jun 3, 2020
 */
public class DSHashSetTest {

    @Test
    public void dsHashSetTest () {
        DSHashSet<Integer> dsHashSet = new DSHashSet<>();
        dsHashSet.add(1);
        dsHashSet.add(2);
        dsHashSet.add(3);
        Assertions.assertEquals(dsHashSet.size(), 3);
        Assertions.assertTrue(dsHashSet.contains(1));
        Assertions.assertFalse(dsHashSet.contains(4));
        Assertions.assertTrue(dsHashSet.remove(3));
        Assertions.assertFalse(dsHashSet.contains(3));
        Assertions.assertFalse(dsHashSet.remove(4));

        dsHashSet.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17));
        Assertions.assertEquals(dsHashSet.size(), 17);
        Assertions.assertTrue(dsHashSet.contains(10));
    }
}

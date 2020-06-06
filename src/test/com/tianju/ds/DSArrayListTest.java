package com.tianju.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Tianju Zhou
 * Jun 2, 2020
 */
public class DSArrayListTest {

    @Test
    public void dsArrayListTest() {
        DSArrayList<Integer> dsArrayList = new DSArrayList<>();

        dsArrayList.add(1);
        dsArrayList.add(2);
        Assertions.assertEquals(dsArrayList.size(), 2);
        Assertions.assertEquals(dsArrayList.get(0), 1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dsArrayList.get(5));

        dsArrayList.add(0,0);
        Assertions.assertEquals(dsArrayList.size(), 3);
        Assertions.assertEquals(dsArrayList.get(0), 0);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dsArrayList.add(5,5));


        dsArrayList.addAll(Arrays.asList(3,4,5,6,7,8,9,10,11,12,13,14,15));
        Assertions.assertEquals(dsArrayList.size(), 16);
        Assertions.assertEquals(dsArrayList.get(5), 5);

        dsArrayList.remove(0);
        Assertions.assertEquals(dsArrayList.size(), 15);
        Assertions.assertEquals(dsArrayList.get(0), 1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dsArrayList.remove(20));

        Integer ele = 15;
        Assertions.assertTrue(dsArrayList.remove(ele));
        Assertions.assertEquals(dsArrayList.size(), 14);
        Assertions.assertEquals(dsArrayList.get(13), 14);

        ele = 20;
        Assertions.assertFalse(dsArrayList.remove(ele));
        Assertions.assertEquals(dsArrayList.size(), 14);
    }
}

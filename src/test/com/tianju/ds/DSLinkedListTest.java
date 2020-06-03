package com.tianju.ds;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DSLinkedListTest {

    @Test
    public void insertTest() {
        DSLinkedList<Integer> dsLinkedList = new DSLinkedList<>();
        dsLinkedList.insert(0,1);
        dsLinkedList.insert(0,2);
        dsLinkedList.insert(2,3);
        Assertions.assertEquals(3, dsLinkedList.get(2));
        Assertions.assertEquals(2, dsLinkedList.get(0));
        Assertions.assertEquals(1, dsLinkedList.get(1));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dsLinkedList.insert(4, 4));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dsLinkedList.get(-1));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> dsLinkedList.get(4));

        dsLinkedList.addFirst(0);
        Assertions.assertEquals(dsLinkedList.getFirst(), dsLinkedList.get(0));
        Assertions.assertEquals(0,dsLinkedList.getFirst());
        dsLinkedList.addLast(100);
        Assertions.assertEquals(5, dsLinkedList.size());
        Assertions.assertEquals(dsLinkedList.getLast(), dsLinkedList.get(dsLinkedList.size() - 1));
        Assertions.assertEquals(100, dsLinkedList.get(dsLinkedList.size() - 1));
    }

    @Test
    public void deleteTest() {
        DSLinkedList<Integer> dsLinkedList = new DSLinkedList<>();
        dsLinkedList.insert(0,5);
        dsLinkedList.insert(0,4);
        dsLinkedList.insert(0,3);
        dsLinkedList.insert(0,2);
        dsLinkedList.insert(0,1);

        dsLinkedList.remove(2);
        Assertions.assertEquals(4, dsLinkedList.size());
        Assertions.assertEquals(4, dsLinkedList.get(2));

        dsLinkedList.removeFirst();
        Assertions.assertEquals(3, dsLinkedList.size());
        Assertions.assertEquals(2, dsLinkedList.getFirst());

        dsLinkedList.removeLast();
        Assertions.assertEquals(2, dsLinkedList.size());
        Assertions.assertEquals(4, dsLinkedList.getLast());

        Integer integer = 4;
        dsLinkedList.remove(integer);
        Assertions.assertEquals(1, dsLinkedList.size());
        Assertions.assertEquals(2, dsLinkedList.getFirst());
        Assertions.assertEquals(2, dsLinkedList.getLast());
    }
}

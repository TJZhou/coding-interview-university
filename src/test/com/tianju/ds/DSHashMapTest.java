package com.tianju.ds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tianju Zhou
 * Jun 3, 2020
 */
public class DSHashMapTest {

    @Test
    public void dsHashMapTest() {
        DSHashMap<String, String> dsHashMap = new DSHashMap<>();
        dsHashMap.put("key1", "val1");
        dsHashMap.put("key2", "val2");
        dsHashMap.put("key3", "val3");
        dsHashMap.put("key4", "val4");
        dsHashMap.put("key5", "val5");
        dsHashMap.put("key6", "val6");
        dsHashMap.put("key7", "val7");
        dsHashMap.put("key8", "val8");
        dsHashMap.put("key9", "val9");
        dsHashMap.put("key10", "val10");
        dsHashMap.put("key11", "val11");
        dsHashMap.put("key12", "val12");
        dsHashMap.put("key13", "val13");
        dsHashMap.put("key14", "val14");
        dsHashMap.put("key15", "val15");
        dsHashMap.put("key16", "val16");
        dsHashMap.put("key17", "val17");
        dsHashMap.put("key18", "val18");
        Assertions.assertEquals(dsHashMap.size(), 18);
        Assertions.assertEquals(dsHashMap.get("key1"), "val1");
        Assertions.assertTrue(dsHashMap.containsKey("key9"));
        Assertions.assertEquals(dsHashMap.put("key3", "newVal3"), "val3");
        Assertions.assertEquals(dsHashMap.remove("key18"), "val18");
        Assertions.assertNull(dsHashMap.remove("key19"));
        dsHashMap.remove("key17");
        dsHashMap.remove("key16");
        dsHashMap.remove("key15");
        Assertions.assertEquals(dsHashMap.size(), 14);
        Assertions.assertFalse(dsHashMap.containsKey("key16"));
        Assertions.assertNull(dsHashMap.get("key15"));
    }

    @Test
    public void sameHashCodeTest() {
        System.out.println("FB".hashCode() + " " + "Ea".hashCode());
        DSHashMap<String, String> dsHashMap = new DSHashMap<>();
        dsHashMap.put("FB", "FB");
        dsHashMap.put("Ea", "Ea");
        Assertions.assertEquals(dsHashMap.size(), 2);
        dsHashMap.remove("FB");
        Assertions.assertFalse(dsHashMap.containsKey("FB"));
        Assertions.assertEquals(dsHashMap.get("Ea"), "Ea");
    }
}

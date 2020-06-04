package com.tianju.ds;

import java.util.Collection;

/**
 * Tianju Zhou
 * Jun 3, 2020
 * @param <K>
 */
public class DSHashSet<K> {
    DSHashMap<K, Object> dsHashMap = new DSHashMap<>();

    private Object PRESENT = new Object();

    public DSHashSet() {}

    public void add(K key) {
        dsHashMap.put(key, PRESENT);
    }

    public void addAll(Collection<K> ks) {
        for(K k : ks) {
            add(k);
        }
    }

    public boolean contains(K key) {
        return dsHashMap.containsKey(key);
    }

    public int size() {
        return dsHashMap.size();
    }

    public boolean isEmpty() {
        return dsHashMap.isEmpty();
    }

    public boolean remove(K key) {
        return dsHashMap.remove(key) != null;
    }


}

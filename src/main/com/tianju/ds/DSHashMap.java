package com.tianju.ds;

/**
 * Tianju Zhou
 * Jun 3, 2020
 * @param <K>
 * @param <V>
 */
public class DSHashMap<K, V> {

    private int size = 0;

    private int BUCKET_SIZE = 1 << 4;

    private final int MIN_SIZE = 1 << 4;

    private final int MAX_SIZE = 1 << 30;

    @SuppressWarnings("unchecked")
    private Node<K, V>[] bucket = new Node[BUCKET_SIZE];

    static class Node<K,V>{
        K key;
        V value;
        Node<K,V> next;

        Node(K key, V value,  Node<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V val) {
        int hashCode = hash(key.hashCode());
        Node<K, V> node = bucket[hashCode], dummy = node;
        while(node != null && !node.key.equals(key)) {
            node = node.next;
        }
        if(node == null) {
            Node<K, V> newNode = new Node<>(key, val, dummy);
            bucket[hashCode] = newNode;
            size++;
            if(size == BUCKET_SIZE) {
                grow();
            }
            return null;
        } else {
            V oldVal = node.value;
            node.value = val;
            return oldVal;
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V get(K key) {
        int hashCode = hash(key.hashCode());
        Node<K, V> node = bucket[hashCode];
        while(node != null && !node.key.equals(key)) {
            node = node.next;
        }
        if(node == null) {
            return null;
        } else {
            return node.value;
        }
    }

    public V remove(K key) {
        int hashCode = hash(key.hashCode());
        Node<K, V> node = bucket[hashCode], prev = null;
        while(node != null && !node.key.equals(key)) {
            prev = node;
            node = node.next;
        }
        if(node == null) {
            return null;
        } else {
            if(prev == null) {
                bucket[hashCode] = null;
            } else {
                prev.next = node.next;
            }
            size--;
            if(size == (BUCKET_SIZE >> 2)) {
                shrink();
            }
            return node.value;
        }
    }

    private int hash(int hashCode) {
        return hashCode % BUCKET_SIZE;
    }

    private void grow() {
        if(BUCKET_SIZE >= MAX_SIZE) {
            return;
        }
        // double the size
        BUCKET_SIZE <<= 1;
        resize();
    }

    private void shrink() {
        if(BUCKET_SIZE <= MIN_SIZE) {
            return;
        }
        // shrink the map size to 1/2
        BUCKET_SIZE >>= 1;
        resize();
    }

    private void resize() {
        Node<K,V>[] oldBucket = bucket;
        bucket = (Node<K,V>[]) new Node[BUCKET_SIZE];
        for(Node<K,V> node : oldBucket) {
            Node<K,V> n = node;
            while(n != null) {
                size--;
                // in put there will be a statement to increase size. But actual size doesn't change
                put(n.key, n.value);
                n = n.next;
            }
        }
    }
}

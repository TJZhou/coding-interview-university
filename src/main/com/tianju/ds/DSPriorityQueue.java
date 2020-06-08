package com.tianju.ds;

import java.util.Collection;
import java.util.Comparator;

/**
 * Tianju Zhou
 * Jun 6, 2020
 *
 * @param <T>
 */
public class DSPriorityQueue<T extends Comparable<? super T>> implements DSQueue<T> {

    private final Comparator<? super T> comparator;

    private static final int DEFAULT_CAPACITY = 10;

    private int capacity;

    private int size;

    private Object[] elements;

    public DSPriorityQueue() {
        this(DEFAULT_CAPACITY, Comparator.naturalOrder());
    }

    public DSPriorityQueue(int capacity) {
        this(capacity, Comparator.naturalOrder());
    }

    public DSPriorityQueue(Comparator<? super T> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    public DSPriorityQueue(int capacity, Comparator<? super T> comparator) {
        if(capacity < 0)
            throw new IllegalArgumentException("Capacity cannot less than 0");
        this.comparator = comparator;
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public DSPriorityQueue(Collection<T> cs) {
        this(cs, Comparator.naturalOrder());
    }

    public DSPriorityQueue(Collection<T> cs, Comparator<? super T> comparator) {
        this.comparator = comparator;
        this.capacity = (int) (cs.size() * 1.5);
        this.elements = cs.toArray();
        this.size = cs.size();
        heapify();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int idx) {
        if(idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        return (T) elements[idx];
    }

    public void offer(T t) {
        if(size == capacity)
            resize();
        elements[size++] = t;
        if(size >= 2)
            siftUp(size-1, t);
    }

    public void offer(T[] ts) {
        for(T t : ts)
            offer(t);
    }

    public void offer(Collection<T> ts) {
        for(T t : ts)
            offer(t);
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if(size == 0)
            return null;
        T t = (T) elements[0];
        swap(0, size-1);
        elements[--size] = null;
        if(size != 0)
            siftDown(0, (T) elements[0]);
        return t;
    }

    private void swap(int idx1, int idx2) {
        Object temp = elements[idx1];
        elements[idx1] = elements[idx2];
        elements[idx2] = temp;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if(size == 0)
            return null;
        return (T) elements[0];
    }

    public boolean remove(T t) {
        int i = 0;
        for(; i < size; i++) {
            if(t.equals(elements[i])) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T removeAt(int idx) {
        if(idx == 0)
            return poll();
        if(idx < 0 || idx >= size)
            throw new ArrayIndexOutOfBoundsException(idx);
        T t = (T) elements[idx];
        System.arraycopy(elements, idx + 1, elements, idx, size - idx);
        elements[size--] = null;
        return t;
    }

    private void resize() {
        capacity *= 1.5;
        Object[] newElements = new Object[capacity];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    @SuppressWarnings("unchecked")
    private void heapify() {
        for(int i = size / 2 - 1; i >= 0; i--)
            siftDown(i, (T) elements[i]);
    }

    @SuppressWarnings("unchecked")
    private void siftUp(int idx, T t) {
        while(idx > 0) {
            int parent = (idx - 1) / 2;
            if(comparator.compare(t, (T) elements[parent]) >= 0)
                break;
            swap(idx, parent);
            idx = parent;
        }
    }

    @SuppressWarnings("unchecked")
    private void siftDown(int idx, T t) {
        int half = size / 2;
        while(idx < half) {
            int left = 2 * idx + 1;
            int right= 2 * idx + 2;
            int child = left;
            if(right < size && (comparator.compare((T) elements[right], (T) elements[left]) <= 0))
                child = right;
            if(comparator.compare(t, (T) elements[child]) <= 0)
                break;
            swap(idx, child);
            idx = child;
        }
    }
}

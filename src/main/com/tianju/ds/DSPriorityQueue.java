package com.tianju.ds;

import java.util.Comparator;

/**
 * Tianju Zhou
 * Jun 6, 2020
 *
 * @param <T>
 */
public class DSPriorityQueue<T> implements DSQueue<T> {

    private final Comparator<? super T> comparator;

    private static final int DEFAULT_CAPACITY = 11;

    private int capacity;

    private int size;

    private Object[] elements;

    public DSPriorityQueue() {
        this(DEFAULT_CAPACITY, null);
    }

    public DSPriorityQueue(int capacity) {
        this(capacity, null);
    }

    public DSPriorityQueue(Comparator<? super T> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    public DSPriorityQueue(int capacity, Comparator<? super T> comparator) {
        if(capacity < 0)
            throw new IllegalArgumentException("Capacity cannot less than 0");
        this.capacity = capacity;
        this.comparator = comparator;
        this.elements = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int idx) {
        if(idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        @SuppressWarnings("unchecked")
        T ele = (T) elements[idx];
        return ele;
    }

    public void offer(T t) {
        size++;
    }

    public T poll() {
        return null;
    }

    public T peek() {
        return null;
    }

    public boolean remove(T t) {
        size--;
        return true;
    }

    public T removeAt(int idx) {
        if(idx < 0 || idx >= size)
            throw new ArrayIndexOutOfBoundsException(idx);
        @SuppressWarnings("unchecked")
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

    private void heapify() {

    }

    private void siftUp(int idx, T t) {

    }

    private void sifDown(int idx, T t) {

    }
}

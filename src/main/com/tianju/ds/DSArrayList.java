package com.tianju.ds;

import java.util.Collection;

/**
 * Tianju Zhou
 * Jun 2, 2020
 * @param <T>
 */
public class DSArrayList<T> {
    private int ARRAY_SIZE = 10;

    private Object[] elements;

    private int size = 0;

    public DSArrayList() {
        elements = new Object[ARRAY_SIZE];
    }

    public DSArrayList(int size) {
        ARRAY_SIZE = size;
        elements = new Object[ARRAY_SIZE];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T get(int idx) {
        if(idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        @SuppressWarnings("unchecked")
        T ele = (T) elements[idx];
        return ele;
    }

    public void add(T t) {
        elements[size++] = t;
        if(size == ARRAY_SIZE) {
           resize();
        }
    }

    public void add(int idx, T t) {
        if(idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        System.arraycopy(elements, idx, elements, idx + 1, size + 1 - idx);
        size++;
        elements[idx] = t;
        if(size == ARRAY_SIZE) {
            resize();
        }
    }

    public void addAll(Collection<T> ts) {
        for(T t : ts) {
            add(t);
        }
    }

    private void resize() {
        ARRAY_SIZE *= 1.5;
        Object[] newElements = new Object[ARRAY_SIZE];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    public T remove(int idx) {
        if(idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        @SuppressWarnings("unchecked")
        T t = (T) elements[idx];
        System.arraycopy(elements, idx + 1, elements, idx, size - idx);
        elements[size--] = null;
        return t;
    }

    public boolean remove(T t) {
        int i = 0;
        boolean find = false;
        for(; i < size; i++) {
            if(elements[i].equals(t)) {
                find = true;
                break;
            }
        }
        if(find) remove(i);
        return find;
    }
}

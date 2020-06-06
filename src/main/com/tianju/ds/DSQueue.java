package com.tianju.ds;


/**
 * Tianju Zhou
 * Jun 6, 2020
 * @param <T>
 */
public interface DSQueue<T> {
    int size();

    boolean isEmpty();

    void offer(T t);

    T poll();

    T peek();

    boolean remove(T t);
}

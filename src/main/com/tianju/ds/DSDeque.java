package com.tianju.ds;

/**
 * Tianju Zhou
 * Jun 2, 2020
 * @param <T>
 */
public interface DSDeque<T> {

    int size();

    boolean isEmpty();

    void offer(T t);

    T poll();

    void offerFirst(T t);

    void push(T t);

    void offerLast(T t);

    T pop();

    T pollFirst();

    T pollLast();

    T peekFirst();

    T peekLast();
}

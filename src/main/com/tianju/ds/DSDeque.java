package com.tianju.ds;

/**
 * Tianju Zhou
 * Jun 2, 2020
 * @param <T>
 */
public interface DSDeque<T> extends DSQueue<T>{

    int size();

    boolean isEmpty();

    void offer(T t);

    void offerFirst(T t);

    void offerLast(T t);

    T poll();

    T pollFirst();

    T pollLast();

    T peek();

    T peekFirst();

    T peekLast();

    void push(T t);

    T pop();

    boolean remove(T t);
}

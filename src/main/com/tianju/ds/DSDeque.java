package com.tianju.ds;

/**
 * Tianju Zhou
 * Jun 2, 2020
 * @param <T>
 */
public class DSDeque<T> {
    DSLinkedList<T> dsLinkedList = new DSLinkedList<>();

    public DSDeque() {}

    public void offer(T t) {
        this.offerLast(t);
    }

    public T poll() {
        return this.pollFirst();
    }

    public void offerFirst(T t) {
        dsLinkedList.addFirst(t);
    }

    public void offerLast(T t) {
        dsLinkedList.addLast(t);
    }

    public T pollFirst() {
        return dsLinkedList.removeFirst();
    }

    public T pollLast() {
        return dsLinkedList.removeLast();
    }

    public T peekFirst() {
        return dsLinkedList.getFirst();
    }

    public T peekLast() {
        return dsLinkedList.getLast();
    }
}

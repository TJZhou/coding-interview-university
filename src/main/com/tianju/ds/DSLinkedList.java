package com.tianju.ds;

import java.util.NoSuchElementException;

/**
 * Tianju Zhou
 * Jun 2, 2020
 * @param <T>
 */
public class DSLinkedList<T> implements DSDeque<T>{

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T val;
        Node() {}
        Node (T val, Node<T> next, Node<T> prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<T> first = new Node<T>();
    Node<T> last = new Node<T>();
    private int size = 0;

    public DSLinkedList() {
        first.next = last;
        last.prev = first;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public T get(int idx) {
        if(idx < 0 || idx > size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        Node<T> node = first.next;
        for(int i = 0; i < idx; i++) {
            node = node.next;
        }
        return node.val;
    }

    public void insert(int idx, T val) {
        if(idx < 0 || idx > size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        size++;
        Node<T> insertNode = new Node<>();
        insertNode.val = val;
        Node<T> prev = first;
        for(int i = 0; i < idx; i++) {
            prev = prev.next;
        }
        Node<T> next = prev.next;
        insertNode.prev = prev;
        insertNode.next = next;
        prev.next = insertNode;
        next.prev = insertNode;
    }

    public void addFirst(T val) {
        Node<T> node = new Node<>(val, first.next, first);
        first.next.prev = node;
        first.next = node;
        size++;
    }

    public T getFirst() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        return first.next.val;
    }

    public void addLast(T val) {
        Node<T> node = new Node<>(val, last, last.prev);
        last.prev.next = node;
        last.prev = node;
        size++;
    }

    public T getLast() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        return last.prev.val;
    }

    public void remove(T t) {
        Node<T> node = first.next;
        while(node != last) {
            if(node.val.equals(t)) {
                link(node);
                size--;
                return;
            }
            node = node.next;
        }
        throw new NoSuchElementException();
    }

    public void remove(int idx) {
        if(idx < 0 || idx > size) {
            throw new ArrayIndexOutOfBoundsException(idx);
        }
        Node<T> node = first.next;
        while(idx-- > 0) {
            node = node.next;
        }
        link(node);
        size--;
    }

    public T removeFirst() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        T res = first.next.val;
        link(first.next);
        size--;
        return res;
    }

    public T removeLast() {
        if(size == 0) {
            throw new NoSuchElementException();
        }
        T res = last.prev.val;
        link(last.prev);
        size--;
        return res;
    }

    private void link(Node<T> node) {
        Node<T> prev = node.prev;
        Node<T> next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = first.next;
        while(node != last) {
            sb.append(node.val);
            sb.append(" ");
            node = node.next;
        }
        return sb.toString();
    }

    @Override
    public void offer(T t) {
        this.addLast(t);
    }

    @Override
    public T poll() {
        return this.removeFirst();
    }

    @Override
    public void offerFirst(T t) {
        this.addFirst(t);
    }

    @Override
    public void push(T t) {
        this.addFirst(t);
    }

    @Override
    public void offerLast(T t) {
        this.addLast(t);
    }

    @Override
    public T pop() {
        return this.removeFirst();
    }

    @Override
    public T pollFirst() {
        return this.removeFirst();
    }

    @Override
    public T pollLast() {
        return this.removeLast();
    }

    @Override
    public T peekFirst() {
        return this.getFirst();
    }

    @Override
    public T peekLast() {
        return this.getLast();
    }
}

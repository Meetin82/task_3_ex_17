package ru.vsu.cs.semenov_d_s;

public class LinkedList<T> {

    public static class LinkedListException extends Exception {
        public LinkedListException(String message) {
            super(message);
        }
    }

    private class Node {
        public T data;
        public Node next;

        public Node(T value, Node next) {
            this.data = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void addLast(T value) {
        if (size == 0) {
            head = tail = new Node(value);
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws LinkedListException {
        if (size == 0) {
            throw new LinkedListException("Empty list");
        }
    }

    public void removeFirst() throws LinkedListException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public T getFirst() throws LinkedListException {
        checkEmptyError();
        return head.data;
    }
}

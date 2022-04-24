package ru.vsu.cs.semenov_d_s;

public class MyQueue<T> extends LinkedList<T> {

    public void add(T value) {
        addLast(value);
    }

    public T remove() throws Exception {
        T result = this.element();
        removeFirst();
        return result;
    }

    public T element() throws Exception {
        if (this.empty()) {
            throw new Exception("Queue is empty");
        }
        return getFirst();
    }

    public boolean empty() {
        return size() == 0;
    }
}

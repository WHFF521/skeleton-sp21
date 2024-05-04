package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node sentinal;
    private int size;

    /**
     * create an empty deque
     */
    public LinkedListDeque() {
        sentinal = new Node(null);
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
        this.size = 0;
    }

    /**
     * add item into first place
     *
     * @param item
     */
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item);
        newNode.next = sentinal.next;
        sentinal.next.prev = newNode;
        sentinal.next = newNode;
        newNode.prev = sentinal;
        this.size += 1;
    }

    /**
     * add item into last place
     *
     * @param item
     */
    @Override
    public void addLast(T item) {
        Node newNode = new Node(item);
        newNode.prev = sentinal.prev;
        sentinal.prev.next = newNode;
        sentinal.prev = newNode;
        newNode.next = sentinal;
        this.size += 1;
    }

    /**
     * return the size of it
     *
     * @return type int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * print the whole deque
     */
    @Override
    public void printDeque() {
        Node current = sentinal.next;
        while (current != sentinal) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    /**
     * @return the first item of deque, if it is empty, return null
     */
    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T firstItem = sentinal.next.data;
        sentinal.next.next.prev = sentinal;
        sentinal.next = sentinal.next.next;
        this.size -= 1;
        return firstItem;
    }

    /**
     * @return the last item of deque, if it is empty, return null
     */
    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        T lastItem = sentinal.prev.data;
        sentinal.prev.prev.next = sentinal;
        sentinal.prev = sentinal.prev.prev;
        this.size -= 1;
        return lastItem;
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node current = sentinal.next;

        public boolean hasNext() {
            return current != sentinal;
        }

        public T next() {
            if (current == sentinal) {
                return null;
            }
            T item = current.data;
            current = current.next;
            return item;
        }
    }

    /**
     * @param index
     * @return the item at the given index, if no such item exists, return null
     */
    @Override
    public T get(int index) {
        if (index >= this.size) {
            return null;
        }
        Node current = sentinal.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public T getRecursive(int index) {
        if (index >= this.size) {
            return null;
        }
        return getRecursiveHelper(sentinal.next, index);
    }

    private T getRecursiveHelper(Node current, int index) {
        if (index == 0) {
            return current.data;
        }
        return getRecursiveHelper(current.next, index - 1);
    }

    /**
     * check if two deques are equal
     *
     * @param o
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Deque)) {
            return false;
        } else {
            Deque<?> other = (Deque<?>) o;
            if (this.size() != other.size()) {
                return false;
            }
            for (int i = 0; i < this.size(); i++) {
                Object a = this.get(i);
                Object b = other.get(i);
                if (!a.equals(b)) {
                    return false;
                }
            }
            return true;
        }
    }
}

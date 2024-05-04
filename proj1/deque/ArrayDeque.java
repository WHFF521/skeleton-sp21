package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int size;
    private int firstPrev;
    private int lastNext;

    /**
     * create an empty deque
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        firstPrev = 3;
        lastNext = 4;
    }

    @Override
    public void addFirst(T item) {
        items[firstPrev] = item;
        firstPrev -= 1;
        size += 1;
        if (firstPrev == -1) {
            resize(size * 2);
        }
    }

    @Override
    public void addLast(T item) {
        items[lastNext] = item;
        lastNext += 1;
        size += 1;
        if (lastNext == items.length) {
            resize(size * 2);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int newFirstPrev = (capacity - size) / 2 - 1;
        System.arraycopy(items, firstPrev + 1, a, newFirstPrev + 1, size);
        items = a;
        firstPrev = newFirstPrev;
        lastNext = firstPrev + size + 1;
    }

    private void checkSize() {
        if (this.isEmpty()) {
            resize(8);
        }
        if (size > 4 && size * 4 < items.length) {
            resize(items.length / 2);
        }
    }

    @Override
    public void printDeque() {
        for (int i = firstPrev + 1; i < lastNext; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        firstPrev += 1;
        T firstItem = items[firstPrev];
        items[firstPrev] = null;
        size -= 1;
        checkSize();
        return firstItem;
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        lastNext -= 1;
        T lastItem = items[lastNext];
        items[lastNext] = null;
        size -= 1;
        checkSize();
        return lastItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return this.items[firstPrev + 1 + index];
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int current = firstPrev + 1;

        public boolean hasNext() {
            return current < lastNext;
        }

        public T next() {
            if (current == lastNext) {
                return null;
            }
            T item = items[current];
            current += 1;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<?> other = (Deque<?>) o;
        if (other.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) != other.get(i)) {
                return false;
            }
        }
        return true;
    }
}

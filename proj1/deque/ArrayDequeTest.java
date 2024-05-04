package deque;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Iterator;

public class ArrayDequeTest {
    @Test
    public void testEqualsMoreNumbers() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        assertTrue(ad1.equals(ad2));
        ad1.addFirst(1);
        assertFalse(ad1.equals(ad2));
        ad2.addFirst(1);
        assertTrue(ad1.equals(ad2));
        for (int i = 1; i <= 1000; i++) {
            ad1.addFirst(i);
            ad2.addFirst(i);
        }
        assertTrue(ad1.equals(ad2));
    }

    @Test
    public void testLinkedEqualsArray() {
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        lld1.addFirst(1);
        assertFalse(lld1.equals(ad1));
        ad1.addFirst(1);
        assertTrue(lld1.equals(ad1));
    }

    @Test
    public void testIteratornext() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        Iterator<Integer> dequeIterator = deque.iterator();
        int i = 0;
        while (dequeIterator.hasNext()) {
            int x = deque.get(i);
            assertEquals(x, (int) dequeIterator.next());
            i++;
        }
    }

    @Test
    public void testIteratorHasNext() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        Iterator<Integer> dequeIterator = deque.iterator();
        for (int i = 1; i <= 10; i++) dequeIterator.next();
        assertFalse(dequeIterator.hasNext());

    }

    @Test
    public void testAddFirstAndRemoveFirst() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        assertEquals(3, deque.size());
        assertEquals(Integer.valueOf(1), deque.removeFirst());
        assertEquals(Integer.valueOf(2), deque.removeFirst());
        assertEquals(Integer.valueOf(3), deque.removeFirst());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testAddLastAndRemoveLast() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());
        assertEquals(Integer.valueOf(3), deque.removeLast());
        assertEquals(Integer.valueOf(2), deque.removeLast());
        assertEquals(Integer.valueOf(1), deque.removeLast());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testGet() {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addLast("apple");
        deque.addLast("banana");
        deque.addLast("orange");
        assertEquals("apple", deque.get(0));
        assertEquals("banana", deque.get(1));
        assertEquals("orange", deque.get(2));
        assertNull(deque.get(3)); // Out of bounds
        assertNull(deque.get(-1)); // Out of bounds
    }

    @Test
    public void testIterator() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        StringBuilder result = new StringBuilder();
        for (Integer item : deque) {
            result.append(item);
        }

        assertEquals("123", result.toString());
    }

    @Test
    public void testEquals() {
        ArrayDeque<Integer> deque1 = new ArrayDeque<>();
        deque1.addLast(1);
        deque1.addLast(2);
        deque1.addLast(3);

        ArrayDeque<Integer> deque2 = new ArrayDeque<>();
        deque2.addLast(1);
        deque2.addLast(2);
        deque2.addLast(3);


        ArrayDeque<Integer> deque3 = new ArrayDeque<>();
        deque3.addLast(3);
        deque3.addLast(2);
        deque3.addLast(1);

        assertEquals(deque1, deque2);
        assertNotEquals(deque1, deque3);
    }
}

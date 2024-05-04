package deque;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;

public class MaxArrayDequeTest {

    // Define a simple comparator for testing
    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return a.compareTo(b);
        }
    }

    @Test
    public void testMaxWithIntegers() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntegerComparator());
        deque.addLast(3);
        deque.addLast(7);
        deque.addLast(1);
        assertEquals(Integer.valueOf(7), deque.max());
    }

    @Test
    public void testMaxWithStrings() {
        Comparator<String> stringComparator = Comparator.naturalOrder();
        MaxArrayDeque<String> deque = new MaxArrayDeque<>(stringComparator);
        deque.addLast("apple");
        deque.addLast("banana");
        deque.addLast("orange");
        assertEquals("orange", deque.max());
    }

    @Test
    public void testMaxWithCustomComparator() {
        // Define a custom comparator for Strings
        Comparator<String> stringLengthComparator = Comparator.comparing(String::length);

        MaxArrayDeque<String> deque = new MaxArrayDeque<>(stringLengthComparator);
        deque.addLast("apple");
        deque.addLast("banana");
        deque.addLast("orange");
        assertEquals("banana", deque.max());
    }

    @Test
    public void testMaxWithEmptyDeque() {
        MaxArrayDeque<Integer> deque = new MaxArrayDeque<>(new IntegerComparator());
        assertNull(deque.max());
    }
}

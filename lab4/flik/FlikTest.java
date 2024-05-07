package flik;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FlikTest {
    @Test
    public void testIsSameNumber() {
        for (int i = 0; i < 500; i++) {
            assertTrue(Flik.isSameNumber(i, i));
        }
    }
}

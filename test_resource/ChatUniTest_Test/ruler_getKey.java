package software.amazon.event.ruler;

// package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Assume Entry is supposed to be in its own file with correct visibility modifiers
public class EntryTest {

    static class Entry {
        private final int key;
        private final int value;

        public Entry(final int key, final int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }
        
        public int getValue() {
            return value;
        }
    }

    @Test
    public void testGetKey() {
        // Create an Entry object with a known key and value
        Entry entry = new Entry(10, 20);

        // Assert that the getKey method returns the correct key value
        assertEquals(10, entry.getKey());
    }

    @Test
    public void testGetKeyWithNegativeValue() {
        // Create an Entry object with a negative key and a value
        Entry entry = new Entry(-5, 15);

        // Assert that the getKey method returns the correct negative key value
        assertEquals(-5, entry.getKey());
    }

    @Test
    public void testGetKeyWithZeroValue() {
        // Create an Entry object with a key of zero and a value
        Entry entry = new Entry(0, 30);

        // Assert that the getKey method returns the correct zero key
        assertEquals(0, entry.getKey());
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.event.ruler.IntIntMap;
import software.amazon.event.ruler.IntIntMap.Entry;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the IntIntMap's entries() method.
 * Covers scenarios including normal behavior, empty collections, single entry collections,
 * and modification during iteration.
 */
public class OutlierTest {

    private IntIntMap intIntMap;

    @BeforeEach
    void setUp() {
        intIntMap = new IntIntMap();
    }

    @Test
    @DisplayName("Verify normal behavior of entries() with a non-empty collection")
    void entriesWithNonEmptyCollection() {
        // Arrange
        intIntMap.put(1, 100);
        intIntMap.put(2, 200);
        intIntMap.put(3, 300);

        // Act
        Iterable<Entry> entries = intIntMap.entries();
        Iterator<Entry> iterator = entries.iterator();

        // Assert
        assertNotNull(entries, "Entries should not be null");
        assertNotNull(iterator, "Iterator should not be null");

        Set<Integer> keysSeen = new HashSet<>();
        Set<Integer> valuesSeen = new HashSet<>();

        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            keysSeen.add(entry.getKey());
            valuesSeen.add(entry.getValue());
        }

        assertEquals(3, keysSeen.size(), "Unexpected number of keys");
        assertTrue(keysSeen.contains(1), "Missing key 1");
        assertTrue(keysSeen.contains(2), "Missing key 2");
        assertTrue(keysSeen.contains(3), "Missing key 3");

        assertEquals(3, valuesSeen.size(), "Unexpected number of values");
        assertTrue(valuesSeen.contains(100), "Missing value 100");
        assertTrue(valuesSeen.contains(200), "Missing value 200");
        assertTrue(valuesSeen.contains(300), "Missing value 300");
    }

    @Test
    @DisplayName("Check the behavior of entries() when the collection is empty")
    void entriesWhenEmpty() {
        // Act
        Iterable<Entry> entries = intIntMap.entries();
        Iterator<Entry> iterator = entries.iterator();

        // Assert
        assertFalse(iterator.hasNext(), "The iterator should not have any entries to iterate over when the map is empty.");
    }

    @Test
    @DisplayName("Test the boundary condition with a collection that contains a single Entry object")
    void entriesWithSingleEntry() {
        // Arrange
        intIntMap.put(1, 10);

        // Act
        Iterable<Entry> entries = intIntMap.entries();
        Iterator<Entry> iterator = entries.iterator();

        // Assert
        assertTrue(iterator.hasNext(), "Iterator should have next entry");

        Entry entry = iterator.next();
        assertEquals(1, entry.getKey(), "Entry key should be 1");
        assertEquals(10, entry.getValue(), "Entry value should be 10");

        assertFalse(iterator.hasNext(), "Iterator should no longer have any entries");
    }

    @Test
    @DisplayName("Handle iteration after a modification attempt on the collection during iteration")
    void modificationDuringIteration() {
        // Arrange
        intIntMap.put(1, 100);
        intIntMap.put(2, 200);

        // Act
        Iterable<Entry> entries = intIntMap.entries();
        Iterator<Entry> iterator = entries.iterator();

        // Assert
        if (iterator.hasNext()) {
            Entry entry = iterator.next();

            // Modify the underlying collection
            intIntMap.put(3, 300);

            // Attempt to continue iteration should throw an exception
            assertThrows(ConcurrentModificationException.class, iterator::next, 
                "Modifying the collection during iteration should throw ConcurrentModificationException");
        }
    }
}
package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class slice0_IntIntMap_entries_5_0_Test {

    @Test
    public void testEntriesReturnsNonNullIterable() {
        IntIntMap map = new IntIntMap();
        Iterable<IntIntMap.Entry> entries = map.entries();
        assertNotNull("entries() should not return null", entries);
    }

    @Test
    public void testEntriesIteratorIsNotNull() {
        IntIntMap map = new IntIntMap();
        Iterator<IntIntMap.Entry> iterator = map.entries().iterator();
        assertNotNull("iterator() should not return null", iterator);
    }

    @Test
    public void testEntriesIteratorHasNoElementsInitially() {
        IntIntMap map = new IntIntMap();
        Iterator<IntIntMap.Entry> iterator = map.entries().iterator();
        assertFalse("Iterator should have no elements initially", iterator.hasNext());
    }

    // Assuming IntIntMap.Entry and EntryIterator implementations exist and are accessible
    @Test
    public void testEntriesIteratorWithElements() {
        IntIntMap map = new IntIntMap();
        // Assume map.put(int key, int value) is a method to add entries to the map
        map.put(1, 100);
        map.put(2, 200);
        Iterator<IntIntMap.Entry> iterator = map.entries().iterator();
        assertTrue("Iterator should have elements after adding entries", iterator.hasNext());
        IntIntMap.Entry entry1 = iterator.next();
        assertEquals("First entry key should be 1", 1, entry1.getKey());
        assertEquals("First entry value should be 100", 100, entry1.getValue());
        IntIntMap.Entry entry2 = iterator.next();
        assertEquals("Second entry key should be 2", 2, entry2.getKey());
        assertEquals("Second entry value should be 200", 200, entry2.getValue());
        assertFalse("Iterator should have no more elements", iterator.hasNext());
    }
}




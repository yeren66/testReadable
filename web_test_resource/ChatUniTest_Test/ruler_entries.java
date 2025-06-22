package software.amazon.event.ruler;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntIntMapTest {

    private IntIntMap map;

    @Before
    public void setUp() {
        map = new IntIntMap();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEntriesEmptyMap() {
        // When the map is empty, entries should not have next elements
        Iterator<IntIntMap.Entry> iterator = map.entries().iterator();
        assertFalse(iterator.hasNext());
        
        // Should throw NoSuchElementException if trying to get next element
        iterator.next();
    }

    @Test
    public void testEntriesSingleElement() {
        map.put(1, 10);
        
        Iterator<IntIntMap.Entry> iterator = map.entries().iterator();
        assertTrue(iterator.hasNext());
        
        IntIntMap.Entry entry = iterator.next();
        assertEquals(1, entry.getKey());
        assertEquals(10, entry.getValue());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEntriesMultipleElements() {
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        
        Iterator<IntIntMap.Entry> iterator = map.entries().iterator();
        assertTrue(iterator.hasNext());

        IntIntMap.Entry entry1 = iterator.next();
        assertTrue(entry1.getKey() >= 1 && entry1.getKey() <= 3);
        assertTrue(entry1.getValue() >= 10 && entry1.getValue() <= 30);

        assertTrue(iterator.hasNext());
        IntIntMap.Entry entry2 = iterator.next();
        assertTrue(entry2.getKey() >= 1 && entry2.getKey() <= 3);
        assertTrue(entry2.getValue() >= 10 && entry2.getValue() <= 30);

        assertTrue(iterator.hasNext());
        IntIntMap.Entry entry3 = iterator.next();
        assertTrue(entry3.getKey() >= 1 && entry3.getKey() <= 3);
        assertTrue(entry3.getValue() >= 10 && entry3.getValue() <= 30);

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testEntriesAfterRemoval() {
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, 30);
        
        map.remove(2);

        Iterator<IntIntMap.Entry> iterator = map.entries().iterator();
        assertTrue(iterator.hasNext());

        IntIntMap.Entry entry1 = iterator.next();
        assertTrue(entry1.getKey() == 1 || entry1.getKey() == 3);
        assertTrue(entry1.getValue() == 10 || entry1.getValue() == 30);
        
        assertTrue(iterator.hasNext());
        
        IntIntMap.Entry entry2 = iterator.next();
        assertTrue(entry2.getKey() == 1 || entry2.getKey() == 3);
        assertTrue(entry2.getValue() == 10 || entry2.getValue() == 30);

        assertFalse(iterator.hasNext());
    }
}
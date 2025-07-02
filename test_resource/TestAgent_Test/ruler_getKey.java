package software.amazon.event.ruler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the behavior of the IntIntMap.Entry class.
 * Covers scenarios for normal conditions, upper boundary, and lower boundary of the 'key' field.
 */
public class OutlierTest {

    private software.amazon.event.ruler.IntIntMap.Entry entry;
    private software.amazon.event.ruler.IntIntMap map;

    /**
     * Sets up common fixtures for tests.
     * Uses reflection or IntIntMap methods to initialize Entry instances.
     */
    @BeforeEach
    void setUp() {
        map = new IntIntMap();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify that the method returns the correct value of 'key' under normal conditions.",
     * 'Input_Type': "The 'key' field is initialized to a specific valid integer value.",
     * 'Output_Type': "The method should return the same integer value as the 'key' field."}
     */
    @Test
    @DisplayName("Verify getKey() returns the correct value under normal conditions")
    void testGetKey_NormalConditions() throws Exception {
        // Arrange: Create an Entry instance with key=42 and value=100 using reflection
        Constructor<IntIntMap.Entry> constructor = IntIntMap.Entry.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        entry = constructor.newInstance(42, 100);

        // Act: Call the getKey() method
        int actualKey = entry.getKey();

        // Assert: Verify the key matches the expected value
        assertEquals(42, actualKey, "The getKey() method should return the initialized key value (42).");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Check the behavior of the method when 'key' is at the boundary of valid integer values.",
     * 'Input_Type': "The 'key' field is initialized to Integer.MAX_VALUE.",
     * 'Output_Type': 'The method should return Integer.MAX_VALUE.'}
     */
    @Test
    @DisplayName("Verify getKey() returns Integer.MAX_VALUE when key is set to the upper boundary")
    void testGetKey_MaxValue() {
        // Arrange: Add an entry with key=Integer.MAX_VALUE to the map
        map.put(Integer.MAX_VALUE, 0); // 0 is a placeholder value
        entry = map.entries().iterator().next();

        // Act: Call the getKey() method
        int actualKey = entry.getKey();

        // Assert: Verify the key matches Integer.MAX_VALUE
        assertEquals(Integer.MAX_VALUE, actualKey, "The getKey() method should return Integer.MAX_VALUE when key is set to the upper boundary.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Check the behavior of the method when 'key' is at the lower boundary of valid integer values.",
     * 'Input_Type': "The 'key' field is initialized to Integer.MIN_VALUE.",
     * 'Output_Type': 'The method should return Integer.MIN_VALUE.'}
     */
    @Test
    @DisplayName("Verify getKey() returns Integer.MIN_VALUE when key is set to the lower boundary")
    void testGetKey_MinValue() {
        // Arrange: Add an entry with key=Integer.MIN_VALUE to the map
        map.put(Integer.MIN_VALUE, 0); // 0 is a placeholder value
        Iterator<IntIntMap.Entry> iterator = map.entries().iterator();
        if (iterator.hasNext()) {
            entry = iterator.next();
        }

        // Act: Call the getKey() method
        int actualKey = entry.getKey();

        // Assert: Verify the key matches Integer.MIN_VALUE
        assertEquals(Integer.MIN_VALUE, actualKey, "The getKey() method should return Integer.MIN_VALUE when key is set to the lower boundary.");
    }
}
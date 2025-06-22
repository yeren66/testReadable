package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.*;

public class RangeTest {

    @Test
    public void testLessThanOrEqualToWithPositiveNumber() {
        // Arrange
        String value = "100.0";

        // Act
        Range range = Range.lessThanOrEqualTo(value);

        // Assert
        assertNotNull("Range should not be null", range);
        assertEquals("Range should have correct openBottom", false, range.openBottom);
        assertEquals("Range should have correct openTop", false, range.openTop);
        assertFalse("Range should not be CIDR", range.isCIDR);

        byte[] expectedTop = stringToComparableBytes(value);
        assertArrayEquals("Top of range should match expected byte representation of value",
                expectedTop, range.top);
    }

    @Test
    public void testLessThanOrEqualToWithNegativeNumber() {
        // Arrange
        String value = "-50.5";

        // Act
        Range range = Range.lessThanOrEqualTo(value);

        // Assert
        assertNotNull("Range should not be null", range);
        assertEquals("Range should have correct openBottom", false, range.openBottom);
        assertEquals("Range should have correct openTop", false, range.openTop);
        assertFalse("Range should not be CIDR", range.isCIDR);

        byte[] expectedTop = stringToComparableBytes(value);
        assertArrayEquals("Top of range should match expected byte representation of value",
                expectedTop, range.top);
    }

    @Test
    public void testLessThanOrEqualToWithZero() {
        // Arrange
        String value = "0";

        // Act
        Range range = Range.lessThanOrEqualTo(value);

        // Assert
        assertNotNull("Range should not be null", range);
        assertEquals("Range should have correct openBottom", false, range.openBottom);
        assertEquals("Range should have correct openTop", false, range.openTop);
        assertFalse("Range should not be CIDR", range.isCIDR);

        byte[] expectedTop = stringToComparableBytes(value);
        assertArrayEquals("Top of range should match expected byte representation of value",
                expectedTop, range.top);
    }

    @Test
    public void testLessThanOrEqualToWithLargeNumber() {
        // Arrange
        String value = "9999999999.999";

        // Act
        Range range = Range.lessThanOrEqualTo(value);

        // Assert
        assertNotNull("Range should not be null", range);
        assertEquals("Range should have correct openBottom", false, range.openBottom);
        assertEquals("Range should have correct openTop", false, range.openTop);
        assertFalse("Range should not be CIDR", range.isCIDR);

        byte[] expectedTop = stringToComparableBytes(value);
        assertArrayEquals("Top of range should match expected byte representation of value",
                expectedTop, range.top);
    }

    private byte[] stringToComparableBytes(String string) {
        // Utility method to call the private method from the Range class for testing purposes
        try {
            java.lang.reflect.Method method = Range.class.getDeclaredMethod("stringToComparableBytes", String.class);
            method.setAccessible(true);
            return (byte[]) method.invoke(null, string);
        } catch (Exception e) {
            fail("Failed to convert string to comparable bytes: " + e.getMessage());
            return null;
        }
    }
}
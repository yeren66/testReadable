import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MultiByte functionality.
 * Covers:
 * - Normal behavior for valid single-byte arrays.
 * - Exceptional cases for empty byte arrays.
 * - Exceptional cases for byte arrays with more than one element.
 */
public class OutlierTest {

    private MultiByte multiByte;

    @BeforeEach
    void setUp() {
        // No shared setup required for these tests, but method is here for future extensibility.
    }

    @Test
    @DisplayName("Test normal behavior for a valid single-byte array")
    void testSingularWithSingleByteArray() {
        // Arrange
        byte expectedByte = 5;
        multiByte = new MultiByte(new byte[]{expectedByte});

        // Act
        byte actualByte = multiByte.singular();

        // Assert
        assertEquals(expectedByte, actualByte, "The singular method should return the byte value from a single-byte array.");
    }

    @Test
    @DisplayName("Test exceptional case for an empty byte array")
    void testConstructorExceptionalCaseForEmptyArray() {
        // Arrange
        byte[] emptyArray = new byte[]{};

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new MultiByte(emptyArray),
                "Expected IllegalArgumentException when constructing MultiByte with an empty array.");
        assertEquals("Must provide at least one byte", exception.getMessage(), "Exception message should match the expected output.");
    }

    @Test
    @DisplayName("Test exceptional case for a byte array with more than one element")
    void testSingularWithMultipleBytes() {
        // Arrange
        multiByte = new MultiByte(new byte[]{1, 2, 3});

        // Act & Assert
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> multiByte.singular(),
                "Expected IllegalStateException when calling singular() on a MultiByte instance with multiple bytes.");
        assertEquals("Must be a singular byte", exception.getMessage(), "Exception message should match the expected output.");
    }
}
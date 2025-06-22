import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MultiByte functionality.
 * Covers scenarios for byte array comparison including identical arrays, different arrays,
 * subset arrays, empty arrays, and arrays with mixed content.
 */
public class OutlierTest {

    private MultiByte multiByte;

    /**
     * Sets up the MultiByte instance with a default byte array before each test.
     */
    @BeforeEach
    void setUp() {
        // Default setup for tests; overridden in specific tests if needed.
        multiByte = new MultiByte(new byte[]{1, 2, 3});
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify function correctness with identical byte arrays',
     * 'Input_Type': 'Valid input with identical byte arrays for both this.bytes and the parameter bytes',
     * 'Output_Type': 'The function should return true indicating both arrays are identical'}
     */
    @Test
    @DisplayName("Should return true for identical byte arrays")
    void testIsWithIdenticalByteArrays() {
        // Arrange
        byte[] identicalBytes = {1, 2, 3};

        // Act
        boolean result = multiByte.is(identicalBytes);

        // Assert
        assertTrue(result, "Expected true for identical byte arrays");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify function behavior with different byte arrays',
     * 'Input_Type': 'Valid input with different byte arrays for this.bytes and the parameter bytes',
     * 'Output_Type': 'The function should return false indicating the arrays are not identical'}
     */
    @Test
    @DisplayName("Should return false for different byte arrays")
    void testIsWithDifferentByteArrays() {
        // Arrange
        byte[] differentBytes = {4, 5, 6};

        // Act
        boolean result = multiByte.is(differentBytes);

        // Assert
        assertFalse(result, "Expected false for different byte arrays");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior with one byte array being a subset of the other',
     * 'Input_Type': 'Valid input where one array is a prefix or suffix of the other',
     * 'Output_Type': 'The function should return false because their lengths differ'}
     */
    @Test
    @DisplayName("Should return false for prefix byte arrays")
    void testIsWithPrefixByteArray() {
        // Arrange
        byte[] prefixArray = {1, 2}; // Prefix of the initialized array

        // Act
        boolean result = multiByte.is(prefixArray);

        // Assert
        assertFalse(result, "Expected false because the arrays have different lengths");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate behavior with empty byte arrays',
     * 'Input_Type': 'Both this.bytes and the parameter bytes are empty arrays',
     * 'Output_Type': 'The function should return true as both arrays are equal in terms of length and content'}
     */
    @Test
    @DisplayName("Should return true for empty byte arrays")
    void testIsWithEmptyByteArrays() {
        // Arrange
        multiByte = new MultiByte(new byte[]{}); // Initialize with an empty array
        byte[] emptyArray = {};

        // Act
        boolean result = multiByte.is(emptyArray);

        // Assert
        assertTrue(result, "Expected true for empty byte arrays");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test with mixed content in byte arrays',
     * 'Input_Type': 'Valid input with this.bytes being [0, 1, 2] and the parameter bytes being [2, 1, 0]',
     * 'Output_Type': 'The function should return false, as array contents differ in order'}
     */
    @Test
    @DisplayName("Should return false for byte arrays with mixed content")
    void testIsWithMixedContentInByteArrays() {
        // Arrange
        multiByte = new MultiByte(new byte[]{0, 1, 2}); // Initialize with specific array
        byte[] mixedContentArray = {2, 1, 0};

        // Act
        boolean result = multiByte.is(mixedContentArray);

        // Assert
        assertFalse(result, "Expected false for arrays with mixed content");
    }
}
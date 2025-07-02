import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the `getHeaderComments` method in the `CSVFormat` class.
 * Covers scenarios for normal behavior, boundary conditions, and null handling.
 */
public class OutlierTest {

    private CSVFormat csvFormat;

    /**
     * Helper method to initialize a CSVFormat instance with header comments.
     *
     * @param headerComments The header comments to set, can be null or an array of strings.
     * @return A configured CSVFormat instance.
     */
    private CSVFormat createCSVFormatWithHeaderComments(String[] headerComments) {
        return CSVFormat.DEFAULT.builder().setHeaderComments(headerComments).build();
    }

    @BeforeEach
    void setUp() {
        // Common setup logic can be added here if needed for all tests.
    }

    @Test
    @DisplayName("Verify normal behavior when headerComments is not null")
    void testGetHeaderComments_NotNull() {
        // Arrange
        String[] headerComments = {"Comment1", "Comment2", "Comment3"};
        csvFormat = createCSVFormatWithHeaderComments(headerComments);

        // Act
        String[] result = csvFormat.getHeaderComments();

        // Assert
        String[] expectedComments = {"Comment1", "Comment2", "Comment3"};
        assertArrayEquals(expectedComments, result, "Returned header comments should match the original comments");
        assertNotSame(expectedComments, result, "The returned array should be a different instance than the internal array");
    }

    @Test
    @DisplayName("Test boundary condition when headerComments is an empty array")
    void testGetHeaderComments_EmptyArray() {
        // Arrange
        String[] headerComments = new String[0];
        csvFormat = createCSVFormatWithHeaderComments(headerComments);

        // Act
        String[] result = csvFormat.getHeaderComments();

        // Assert
        String[] expected = new String[0];
        assertArrayEquals(expected, result, "Returned header comments should be a new, empty array");
    }

    @Test
    @DisplayName("Ensure correct behavior when headerComments is null")
    void testGetHeaderComments_Null() {
        // Arrange
        csvFormat = createCSVFormatWithHeaderComments(null);

        // Act
        String[] result = csvFormat.getHeaderComments();

        // Assert
        assertNull(result, "The headerComments should be null when set as null");
    }
}
import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the `getCommentMarker` method in the CSVFormat class.
 * Covers scenarios where the comment marker is set to valid, null, or uncommon characters.
 */
public class OutlierTest {

    private CSVFormat csvFormat;

    /**
     * Sets up the default CSVFormat instance before each test.
     * Common setup logic is extracted to ensure DRY principles.
     */
    @BeforeEach
    void setUp() {
        // Default setup; specific configurations are applied in individual tests.
        csvFormat = CSVFormat.DEFAULT;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method returns the correct character when the commentMarker is set to a valid character.', 
     * 'Input_Type': "commentMarker is set to a valid character (e.g., '/').", 
     * 'Output_Type': "Expected output is the character that was set (e.g., '/')."}
     */
    @Test
    @DisplayName("Should return the correct character when commentMarker is set to a valid character")
    void testGetCommentMarker_whenMarkerIsSet() {
        // Arrange
        csvFormat = csvFormat.builder().setCommentMarker('/').build();

        // Act
        Character actual = csvFormat.getCommentMarker();

        // Assert
        assertEquals(Character.valueOf('/'), actual, "Expected the comment marker to be '/' when explicitly set.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method handles the case when the commentMarker is not set.', 
     * 'Input_Type': 'commentMarker is set to null.', 
     * 'Output_Type': 'Expected output is null, indicating no comment marker is set.'}
     */
    @Test
    @DisplayName("Should return null when commentMarker is not set")
    void testGetCommentMarkerWhenNotSet() {
        // Act
        Character actual = csvFormat.getCommentMarker();

        // Assert
        assertNull(actual, "Expected the comment marker to be null when not set.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior when commentMarker is set to an invalid character type (e.g., numeric or special character other than common comment markers).', 
     * 'Input_Type': "commentMarker is set to an uncommon character such as numeric ('1') or special character ('*').", 
     * 'Output_Type': 'Expected output is the uncommon character that was explicitly set, reflecting no restriction or filtering on character type.'}
     */
    @Test
    @DisplayName("Should return the uncommon character when commentMarker is set to an invalid character type")
    void testGetCommentMarkerWithUncommonCharacter() {
        // Arrange
        csvFormat = csvFormat.builder().setCommentMarker('*').build();

        // Act
        Character actual = csvFormat.getCommentMarker();

        // Assert
        assertEquals(Character.valueOf('*'), actual, "Expected the comment marker to be '*' when explicitly set.");
    }
}
import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for verifying the hashCode behavior of the {@link Option} class.
 * Covers various scenarios including valid values, null values, empty strings, and boundary cases.
 */
public class OutlierTest {

    private Option option;

    @BeforeEach
    void setUp() {
        // Reset the Option object before each test to ensure isolation
        option = null;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior with valid non-null values for longOption and option.', 
     * 'Input_Type': 'Valid non-null values for both longOption and option (e.g., strings or integers).', 
     * 'Output_Type': 'An integer hash code generated based on the hash of longOption and option.'}
     */
    @Test
    @DisplayName("HashCode with valid non-null values for longOption and option")
    void testHashCode_withValidNonNullValues() {
        // Arrange
        option = new Option("o", "option");
        option.setLongOpt("longOption");

        // Act
        int hashCode = option.hashCode();

        // Assert
        int expectedHashCode = Objects.hash("longOption", "o");
        assertEquals(expectedHashCode, hashCode, "Hash code should match the expected hash of longOption and option.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior with one null value (longOption is null, option is non-null).', 
     * 'Input_Type': 'longOption is null, option is a valid non-null value (e.g., a string).', 
     * 'Output_Type': 'An integer hash code generated based on the hash of a null longOption and a valid option.'}
     */
    @Test
    @DisplayName("HashCode with null longOption and valid option")
    void testHashCode_withNullLongOption() {
        // Arrange
        String validOption = "validOption";
        option = new Option(validOption, validOption);
        option.setLongOpt(null);

        // Act
        int hashCode = option.hashCode();

        // Assert
        int expectedHashCode = Objects.hash(null, validOption);
        assertEquals(expectedHashCode, hashCode, "Hash code should match the expected hash of null longOption and valid option.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior with both longOption and option being null.', 
     * 'Input_Type': 'Both longOption and option are null.', 
     * 'Output_Type': 'An integer hash code generated based on the hash of two null values.'}
     */
    @Test
    @DisplayName("HashCode with both longOption and option as null")
    void testHashCode_withBothLongOptionAndOptionNull() {
        // Arrange
        option = new Option(null, null);

        // Act
        int hashCode = option.hashCode();

        // Assert
        int expectedHashCode = Objects.hash(null, null);
        assertEquals(expectedHashCode, hashCode, "Hash code with both longOption and option as null should match the expected hash of two null values.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior with both longOption and option being empty strings.', 
     * 'Input_Type': 'Both longOption and option are empty strings.', 
     * 'Output_Type': 'An integer hash code generated based on the hash of two empty strings.'}
     */
    @Test
    @DisplayName("HashCode with both longOption and option as empty strings")
    void testHashCode_withEmptyStrings() {
        // Arrange
        option = new Option("", ""); // Both longOption and option are empty strings

        // Act
        int hashCode = option.hashCode();

        // Assert
        int expectedHashCode = Objects.hash("", "");
        assertEquals(expectedHashCode, hashCode, "Hash code with both longOption and option as empty strings should match the expected hash of two empty strings.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior with boundary case where longOption and option have extremely large strings or long numbers.', 
     * 'Input_Type': 'longOption and option are very large strings or numbers (e.g., hundreds or thousands of characters long).', 
     * 'Output_Type': 'An integer hash code generated based on the hash of large strings or numbers.'}
     */
    @Test
    @DisplayName("HashCode with longOption and option as large strings")
    void testHashCode_withLargeStrings() {
        // Arrange
        String largeLongOption = "longOption" + new String(new char[1000]).replace('\0', 'A'); // String with 1000 'A' characters
        String largeOption = "option" + new String(new char[1000]).replace('\0', 'B'); // String with 1000 'B' characters
        option = new Option(largeLongOption, largeOption);

        // Act
        int hashCode = option.hashCode();

        // Assert
        int expectedHashCode = Objects.hash(largeLongOption, largeOption);
        assertEquals(expectedHashCode, hashCode, "Hash code with large strings should match the expected hash of largeLongOption and largeOption.");
    }
}
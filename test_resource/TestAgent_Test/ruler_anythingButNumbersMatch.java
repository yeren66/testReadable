import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.event.ruler.Patterns;
import software.amazon.event.ruler.AnythingBut;
import software.amazon.event.ruler.ComparableNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the Patterns.anythingButNumbersMatch method.
 * Covers various input scenarios including normal cases, edge cases, and invalid inputs.
 */
public class OutlierTest {

    private Set<String> numberStrings;
    private Set<String> emptySet;
    private Set<String> nonNumericSet;
    private Set<String> singleNumberSet;
    private Set<String> duplicateNumbersSet;

    @BeforeEach
    void setUp() {
        // Common test fixtures
        numberStrings = new HashSet<>(Set.of("1", "2", "3"));
        emptySet = new HashSet<>();
        nonNumericSet = new HashSet<>(Set.of("a", "b", "c"));
        singleNumberSet = Collections.singleton("42");
        duplicateNumbersSet = new HashSet<>(Set.of("1", "1", "2"));
    }

    @Test
    @DisplayName("Verify normal behavior with a typical set of number strings")
    void testAnythingButNumbersMatch_normalCase() {
        // Arrange
        Set<String> expectedNormalizedNumbers = new HashSet<>();
        for (String number : numberStrings) {
            expectedNormalizedNumbers.add(ComparableNumber.generate(number));
        }

        // Act
        AnythingBut result = Patterns.anythingButNumbersMatch(numberStrings);

        // Assert
        assertNotNull(result, "Resulting AnythingBut object should not be null");
        assertEquals(expectedNormalizedNumbers, result.getValues(), "Normalized numbers set should match expected values");
        assertTrue(result.isNumeric(), "Numeric flag should be set to true");
    }

    @Test
    @DisplayName("Test behavior with an empty set to check boundary conditions")
    void testAnythingButNumbersMatch_emptySet() {
        // Act
        AnythingBut result = Patterns.anythingButNumbersMatch(emptySet);

        // Assert
        assertNotNull(result, "Resulting AnythingBut object should not be null");
        assertTrue(result.getValues().isEmpty(), "Resulting set should be empty");
        assertTrue(result.isNumeric(), "Numeric flag should be set to true");
    }

    @Test
    @DisplayName("Test behavior with invalid input containing non-numeric strings")
    void testAnythingButNumbersMatch_nonNumericValues() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Patterns.anythingButNumbersMatch(nonNumericSet);
        }, "Expected IllegalArgumentException for non-numeric input");
        assertNotNull(exception.getMessage(), "Exception message should not be null");
    }

    @Test
    @DisplayName("Check behavior with a single numeric string to ensure correct normalization")
    void testAnythingButNumbersMatch_singleNumber() {
        // Arrange
        String normalizedNumber = ComparableNumber.generate("42");

        // Act
        AnythingBut result = Patterns.anythingButNumbersMatch(singleNumberSet);

        // Assert
        assertNotNull(result, "Resulting AnythingBut object should not be null");
        assertEquals(1, result.getValues().size(), "Resulting set should contain one normalized number");
        assertTrue(result.getValues().contains(normalizedNumber), "Resulting set should contain the normalized number '42'");
        assertTrue(result.isNumeric(), "Numeric flag should be set to true");
    }

    @Test
    @DisplayName("Verify behavior with duplicate numbers in input")
    void testAnythingButNumbersMatch_duplicates() {
        // Arrange
        Set<String> expectedNormalizedSet = new HashSet<>();
        expectedNormalizedSet.add(ComparableNumber.generate("1"));
        expectedNormalizedSet.add(ComparableNumber.generate("2"));

        // Act
        AnythingBut result = Patterns.anythingButNumbersMatch(duplicateNumbersSet);

        // Assert
        assertNotNull(result, "Resulting AnythingBut object should not be null");
        assertEquals(expectedNormalizedSet, result.getValues(), "Normalized numbers set should match expected values");
        assertTrue(result.isNumeric(), "Numeric flag should be set to true");
    }
}
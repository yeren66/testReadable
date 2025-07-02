package software.amazon.event.ruler;

// package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

public class PatternsTest {

    /**
     * Test for the anythingButNumbersMatch method to ensure that it correctly
     * normalizes numbers and creates an AnythingBut instance.
     */
    @Test
    public void testAnythingButNumbersMatch() {
        // Test input set
        Set<String> inputSet = new HashSet<>();
        inputSet.add("123.45");
        inputSet.add("0.99");

        // Invoke the focal method
        AnythingBut anythingBut = Patterns.anythingButNumbersMatch(inputSet);

        // Validate that the result is not null
        assertNotNull("The AnythingBut object should not be null", anythingBut);

        // Check if the AnythingBut object contains normalized numbers
        Set<String> expectedNormalizedNumbers = new HashSet<>();
        expectedNormalizedNumbers.add(ComparableNumber.generate("123.45"));
        expectedNormalizedNumbers.add(ComparableNumber.generate("0.99"));

        // Validate the internal state of the AnythingBut object
        assertEquals("The AnythingBut object should contain normalized numbers",
            expectedNormalizedNumbers, anythingBut.getValues());
    }

    /**
     * Test for an empty input set should create an AnythingBut object with an empty set.
     */
    @Test
    public void testAnythingButNumbersMatch_emptySet() {
        // Test with an empty set
        Set<String> inputSet = new HashSet<>();

        // Invoke the focal method
        AnythingBut anythingBut = Patterns.anythingButNumbersMatch(inputSet);

        // Validate that the result is not null
        assertNotNull("The AnythingBut object should not be null", anythingBut);

        // Validate it contains an empty set
        assertTrue("The AnythingBut object should contain an empty set",
            anythingBut.getValues().isEmpty());
    }

    /**
     * Test handling of a null input, expecting it to handle gracefully.
     * This may vary depending on implementation (throw exception or return empty object).
     */
    @Test(expected = NullPointerException.class)
    public void testAnythingButNumbersMatch_nullInput() {
        // Invoke the focal method with null
        Patterns.anythingButNumbersMatch(null);

        // Note: If handling null internally without exception is desired, the test should verify that behavior.
    }
}
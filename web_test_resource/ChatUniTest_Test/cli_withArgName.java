package org.apache.commons.cli;

// // package org.apache.commons.cli;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for OptionBuilder.
 */
public class OptionBuilderTest {

    @Before
    public void setUp() {
        // Reset the state before each test.
        // Use a test helper method to access the private reset method.
        resetOptionBuilderState();
    }

    @After
    public void tearDown() {
        // Reset the state after each test to ensure no side effects
        resetOptionBuilderState();
    }

    /**
     * Resets the OptionBuilder state via reflection (for testing purposes only).
     */
    private void resetOptionBuilderState() {
        try {
            // Use reflection to access the private reset method
            java.lang.reflect.Method resetMethod = OptionBuilder.class.getDeclaredMethod("reset");
            resetMethod.setAccessible(true);
            resetMethod.invoke(null);
        } catch (Exception e) {
            throw new RuntimeException("Failed to reset OptionBuilder state", e);
        }
    }

    /**
     * Test the withArgName method with a valid argument name.
     */
    @Test
    public void testWithArgName_ValidName() {
        String testName = "argNameTest";
        
        // Call the focal method
        OptionBuilder builder = OptionBuilder.withArgName(testName);
        
        assertNotNull("The returned OptionBuilder instance should not be null", builder);
        assertEquals("The argument name should match the expected value", testName, OptionBuilder.create('a').getArgName());
    }

    /**
     * Test the withArgName method with an empty argument name.
     * It should accept an empty string and set it as argument name.
     */
    @Test
    public void testWithArgName_EmptyName() {
        String testName = "";
        
        // Call the focal method
        OptionBuilder builder = OptionBuilder.withArgName(testName);
        
        assertNotNull("The returned OptionBuilder instance should not be null", builder);
        assertEquals("The argument name should be an empty string", testName, OptionBuilder.create('b').getArgName());
    }

    /**
     * Test the withArgName method with null as argument name.
     */
    @Test
    public void testWithArgName_NullName() {
        String testName = null;
        
        // Call the focal method
        OptionBuilder builder = OptionBuilder.withArgName(testName);
        
        assertNotNull("The returned OptionBuilder instance should not be null", builder);
        assertNull("The argument name should be null", OptionBuilder.create('c').getArgName());
    }
}
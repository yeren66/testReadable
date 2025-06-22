package org.apache.commons.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test class for verifying the behavior of the CommandLine iterator method.
 * Covers scenarios for non-empty, empty, and null options collections.
 */
public class OutlierTest {

    private CommandLine commandLine;

    /**
     * Sets up a mocked CommandLine object for tests that require specific configurations.
     */
    @BeforeEach
    public void setUp() {
        commandLine = mock(CommandLine.class);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the iterator returns a valid iterator over a non-empty options collection.', 
     * 'Input_Type': 'A CommandLine object with a non-empty options collection.', 
     * 'Output_Type': 'An Iterator object that correctly iterates over the Option objects in the options collection.'}
     */
    @Test
    @DisplayName("Iterator over non-empty options collection should return valid elements")
    public void iteratorReturnsValidIteratorForNonEmptyOptions() {
        // Arrange: Mock a non-empty options collection
        Option option1 = new Option("a", "option1", false, "Option 1 description");
        Option option2 = new Option("b", "option2", false, "Option 2 description");
        Iterator<Option> iterator = java.util.Arrays.asList(option1, option2).iterator();
        when(commandLine.iterator()).thenReturn(iterator);

        // Act: Retrieve the iterator
        Iterator<Option> resultIterator = commandLine.iterator();

        // Assert: Validate the iterator's behavior
        assertNotNull(resultIterator, "Iterator should not be null");
        assertTrue(resultIterator.hasNext(), "Iterator should have at least one element");

        Option firstOption = resultIterator.next();
        assertEquals("option1", firstOption.getLongOpt(), "First option should match expected value");

        Option secondOption = resultIterator.next();
        assertEquals("option2", secondOption.getLongOpt(), "Second option should match expected value");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the iterator handles an empty options collection correctly.', 
     * 'Input_Type': 'A CommandLine object with an empty options collection.', 
     * 'Output_Type': 'An Iterator object that immediately returns false when calling hasNext(), indicating no elements to iterate.'}
     */
    @Test
    @DisplayName("Iterator over empty options collection should have no elements")
    public void iteratorHandlesEmptyOptionsCollection() {
        // Arrange: Mock an empty options collection
        when(commandLine.iterator()).thenReturn(java.util.Collections.emptyIterator());

        // Act: Retrieve the iterator
        Iterator<Option> resultIterator = commandLine.iterator();

        // Assert: Validate the iterator's behavior
        assertNotNull(resultIterator, "Iterator should not be null");
        assertFalse(resultIterator.hasNext(), "Iterator should not have any elements");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify behavior when the options collection is null (exceptional case).', 
     * 'Input_Type': 'A CommandLine object with a null options collection.', 
     * 'Output_Type': 'A NullPointerException should be thrown when the iterator is accessed.'}
     */
    @Test
    @DisplayName("Accessing iterator on null options collection should throw NullPointerException")
    public void iteratorThrowsExceptionForNullOptionsCollection() {
        // Arrange: Mock a null options collection
        when(commandLine.iterator()).thenThrow(new NullPointerException());

        // Act & Assert: Validate that accessing the iterator throws NullPointerException
        NullPointerException exception = assertThrows(NullPointerException.class, () -> commandLine.iterator(),
                "Accessing iterator on null options collection should throw NullPointerException");
        assertNotNull(exception, "Exception should not be null");
    }
}
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.TypeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the TypeHandler class, specifically testing the createObject method.
 * Covers various scenarios including valid inputs, invalid inputs, edge cases, and error handling.
 */
public class OutlierTest {

    private TypeHandler typeHandler;

    /**
     * Sets up common fixtures for all tests.
     */
    @BeforeEach
    void setUp() {
        typeHandler = new TypeHandler();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify the method works as expected when a valid class name is provided, and the class has an accessible no-argument constructor.', 
     * 'Input_Type': "A valid, fully qualified class name for a class with a public no-argument constructor (e.g., 'java.util.ArrayList').", 
     * 'Output_Type': 'An instance of the class corresponding to the class name is returned, with no exceptions thrown.'}
     */
    @Test
    @DisplayName("Valid class name with accessible no-arg constructor should return an instance")
    void validClassName_ReturnsInstance() {
        // Arrange
        String className = "java.util.ArrayList";

        // Act
        Object result = assertDoesNotThrow(() -> typeHandler.createObject(className), 
                "ParseException should not be thrown for a valid class name");

        // Assert
        assertNotNull(result, "Object should not be null");
        assertTrue(result instanceof java.util.ArrayList, "Object should be an instance of ArrayList");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the method when an invalid class name is provided that cannot be found.', 
     * 'Input_Type': "A string representing a class name that does not exist or cannot be found (e.g., 'com.example.NonExistentClass').", 
     * 'Output_Type': "A ParseException is thrown with the message 'Unable to find the class: <class_name>'."}
     */
    @Test
    @DisplayName("Invalid class name should throw ParseException")
    void invalidClassName_ShouldThrowParseException() {
        // Arrange
        String invalidClassName = "com.example.NonExistentClass";

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, 
                () -> typeHandler.createObject(invalidClassName), 
                "Expected ParseException was not thrown");
        assertEquals("Unable to find the class: " + invalidClassName, exception.getMessage(), 
                "Exception message should match the expected format");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the method when the class does not have an accessible no-argument constructor.', 
     * 'Input_Type': "A valid, fully qualified class name for a class that exists but does not have a public no-argument constructor (e.g., 'java.awt.Point' with a constructor requiring arguments).", 
     * 'Output_Type': 'A ParseException is thrown, indicating that the instance could not be created, with the exception class name and message.'}
     */
    @Test
    @DisplayName("Class without accessible no-arg constructor should throw ParseException")
    void noAccessibleNoArgConstructor_ShouldThrowParseException() {
        // Arrange
        String className = "java.awt.Point"; // java.awt.Point requires arguments for its constructor

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, 
                () -> typeHandler.createObject(className), 
                "Expected ParseException was not thrown");
        assertTrue(exception.getMessage().contains("Unable to create instance"), 
                "Exception message should indicate inability to create instance");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the method when the class name is an empty string, representing an edge case for input validation.', 
     * 'Input_Type': "An empty string (e.g., '').", 
     * 'Output_Type': "A ClassNotFoundException is thrown internally, resulting in a ParseException with the message 'Unable to find the class: '."}
     */
    @Test
    @DisplayName("Empty class name should throw ParseException")
    void emptyClassName_ShouldThrowParseException() {
        // Arrange
        String emptyClassName = "";

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, 
                () -> typeHandler.createObject(emptyClassName), 
                "Expected ParseException was not thrown");
        assertEquals("Unable to find the class: " + emptyClassName, exception.getMessage(), 
                "Exception message should match the expected format");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test the method with a null class name to check how the method handles null inputs.', 
     * 'Input_Type': 'A null value for the class name (e.g., null).', 
     * 'Output_Type': "A ParseException is thrown, indicating the class could not be found, with the message 'Unable to find the class: null'."}
     */
    @Test
    @DisplayName("Null class name should throw ParseException")
    void nullClassName_ShouldThrowParseException() {
        // Arrange
        String nullClassName = null;

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, 
                () -> typeHandler.createObject(nullClassName), 
                "Expected ParseException was not thrown");
        assertEquals("Unable to find the class: null", exception.getMessage(), 
                "Exception message should match the expected format");
    }
}
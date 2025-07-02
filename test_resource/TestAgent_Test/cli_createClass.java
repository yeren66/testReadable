import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.TypeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for the TypeHandler class, focusing on the createClass method.
 * Covers normal behavior, exceptional behavior, and boundary cases.
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
     * @implNote {'Test_Purpose': 'Test normal behavior when a valid class name is provided.', 
     * 'Input_Type': "A valid fully qualified class name (e.g., 'java.lang.String')", 
     * 'Output_Type': 'The method should return the corresponding Class<?> object (e.g., String.class).'}
     */
    @Test
    @DisplayName("Given a valid class name, when createClass is called, then it should return the corresponding Class object")
    void testCreateClass_withValidClassName() throws ParseException {
        // Arrange
        String className = "java.lang.String";

        // Act
        Class<?> result = typeHandler.createClass(className);

        // Assert
        assertNotNull(result, "Resulting class object should not be null");
        assertEquals(String.class, result, "Expected class should be java.lang.String");
    }

    /**
     * @implNote {'Test_Purpose': 'Test exceptional behavior when an invalid class name is provided.', 
     * 'Input_Type': "An invalid class name (e.g., 'non.existing.Class')", 
     * 'Output_Type': "The method should throw a ParseException with the message 'Unable to find the class: non.existing.Class'."}
     */
    @Test
    @DisplayName("Given an invalid class name, when createClass is called, then it should throw a ParseException")
    void testCreateClass_withInvalidClassName_throwsParseException() {
        // Arrange
        String invalidClassName = "non.existing.Class";

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, () -> typeHandler.createClass(invalidClassName),
                "Expected ParseException to be thrown for invalid class name");
        assertEquals("Unable to find the class: non.existing.Class", exception.getMessage(),
                "Exception message should match the expected output");
    }

    /**
     * @implNote {'Test_Purpose': 'Test boundary behavior with an empty class name.', 
     * 'Input_Type': "An empty string ('') as the class name.", 
     * 'Output_Type': "The method should throw a ParseException with the message 'Unable to find the class: '."}
     */
    @Test
    @DisplayName("Given an empty class name, when createClass is called, then it should throw a ParseException")
    void testCreateClass_withEmptyClassName_throwsParseException() {
        // Arrange
        String emptyClassName = "";

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, () -> typeHandler.createClass(emptyClassName),
                "Expected ParseException to be thrown for empty class name");
        assertEquals("Unable to find the class: ", exception.getMessage(),
                "Exception message should match the expected output");
    }

    /**
     * @implNote {'Test_Purpose': 'Test boundary behavior with a class name containing only whitespace.', 
     * 'Input_Type': "A string with only whitespace (e.g., '   ') as the class name.", 
     * 'Output_Type': "The method should throw a ParseException with the message 'Unable to find the class:    '."}
     */
    @Test
    @DisplayName("Given a whitespace-only class name, when createClass is called, then it should throw a ParseException")
    void testCreateClass_withWhitespaceClassName_throwsParseException() {
        // Arrange
        String whitespaceClassName = "   ";

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, () -> typeHandler.createClass(whitespaceClassName),
                "Expected ParseException to be thrown for whitespace-only class name");
        assertEquals("Unable to find the class:    ", exception.getMessage(),
                "Exception message should match the expected output");
    }

    /**
     * @implNote {'Test_Purpose': 'Test normal behavior with a class name that is part of the default Java libraries.', 
     * 'Input_Type': "A valid class name from Java libraries (e.g., 'java.util.ArrayList')", 
     * 'Output_Type': 'The method should return the corresponding Class<?> object (e.g., ArrayList.class).'}
     */
    @Test
    @DisplayName("Given a valid Java library class name, when createClass is called, then it should return the corresponding Class object")
    void testCreateClass_withValidJavaLibraryClassName() throws ParseException {
        // Arrange
        String className = "java.util.ArrayList";

        // Act
        Class<?> result = typeHandler.createClass(className);

        // Assert
        assertNotNull(result, "Resulting class object should not be null");
        assertEquals(java.util.ArrayList.class, result, "Expected class should be java.util.ArrayList");
    }
}
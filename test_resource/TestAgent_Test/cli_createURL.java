import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.TypeHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

/**
 * OutlierTest class consolidates tests for the TypeHandler.createURL method.
 * It covers various scenarios including valid URLs, malformed URLs, edge cases, and protocol handling.
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
     * @implNote Test Purpose: {'Test_Purpose': 'Test valid URL input to ensure proper URL object creation.', 
     * 'Input_Type': "A valid URL string such as 'https://www.example.com'.", 
     * 'Output_Type': 'The method returns a valid URL object corresponding to the input string.'}
     */
    @Test
    @DisplayName("Given a valid URL string, when createURL is called, then a valid URL object is returned")
    void testCreateURL_ValidURL() throws Exception {
        // Arrange
        String validUrlString = "https://www.example.com";

        // Act
        URL result = typeHandler.createURL(validUrlString);

        // Assert
        assertNotNull(result, "The URL object should not be null");
        assertEquals(validUrlString, result.toString(), "The URL should match the input string");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test edge case with an empty string as input to check for potential handling of malformed input.', 
     * 'Input_Type': "An empty string, '' (no URL).", 
     * 'Output_Type': 'The method throws a ParseException with a message indicating that the URL cannot be parsed.'}
     */
    @Test
    @DisplayName("Given an empty string, when createURL is called, then a ParseException is thrown")
    void testCreateURL_EmptyString() {
        // Arrange
        String emptyString = "";

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, () -> typeHandler.createURL(emptyString),
                "Expected ParseException when URL string is empty");
        assertEquals("Unable to parse URL", exception.getMessage(), "Exception message should indicate parsing failure");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test invalid URL input to confirm that the method handles malformed URLs correctly.', 
     * 'Input_Type': "A malformed URL string such as 'htp://invalid-url'.", 
     * 'Output_Type': 'The method throws a ParseException indicating the inability to parse the URL.'}
     */
    @Test
    @DisplayName("Given a malformed URL string, when createURL is called, then a ParseException is thrown")
    void testCreateURL_InvalidURL() {
        // Arrange
        String invalidURL = "htp://invalid-url"; // Malformed URL

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, () -> typeHandler.createURL(invalidURL),
                "Expected ParseException when URL string is malformed");
        assertEquals("Unable to parse URL", exception.getMessage(), "Exception message should indicate parsing failure");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test URL with missing protocol to check if it is considered invalid.', 
     * 'Input_Type': "A URL string without a protocol, such as 'www.example.com'.", 
     * 'Output_Type': 'The method throws a ParseException indicating the inability to parse the URL.'}
     */
    @Test
    @DisplayName("Given a URL string without a protocol, when createURL is called, then a ParseException is thrown")
    void testCreateURL_MissingProtocol() {
        // Arrange
        String urlString = "www.example.com"; // Missing protocol

        // Act & Assert
        ParseException exception = assertThrows(ParseException.class, () -> typeHandler.createURL(urlString),
                "Expected ParseException when URL string is missing protocol");
        assertEquals("Unable to parse URL", exception.getMessage(), "Exception message should indicate parsing failure");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test valid URL with different protocols (http, ftp) to verify the method handles different schemes.', 
     * 'Input_Type': "A valid URL string with a different protocol, such as 'ftp://ftp.example.com'.", 
     * 'Output_Type': 'The method returns a valid URL object corresponding to the input string.'}
     */
    @Test
    @DisplayName("Given a valid URL with FTP protocol, when createURL is called, then a valid URL object is returned")
    void testCreateURL_WithFtpProtocol() throws Exception {
        // Arrange
        String ftpUrl = "ftp://ftp.example.com";

        // Act
        URL result = typeHandler.createURL(ftpUrl);

        // Assert
        assertNotNull(result, "The URL object should not be null");
        assertEquals("ftp", result.getProtocol(), "URL protocol should be ftp");
        assertEquals("ftp.example.com", result.getHost(), "URL host should be ftp.example.com");
    }
}
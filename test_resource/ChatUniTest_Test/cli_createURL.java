package org.apache.commons.cli;

import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.*;

public class TypeHandlerTest {

    @Test
    public void testCreateURLWithValidURL() throws Exception {
        // Valid URL
        String validUrlStr = "http://www.example.com";
        URL url = TypeHandler.createURL(validUrlStr);
        
        // Assertions to check the URL object properties
        assertNotNull(url);
        assertEquals("http", url.getProtocol());
        assertEquals("www.example.com", url.getHost());
        assertEquals("", url.getPath());
    }

    @Test
    public void testCreateURLWithValidURLAndPath() throws Exception {
        // Valid URL with Path
        String validUrlStr = "https://www.example.com/path/to/resource";
        URL url = TypeHandler.createURL(validUrlStr);

        // Assertions to check the URL object properties
        assertNotNull(url);
        assertEquals("https", url.getProtocol());
        assertEquals("www.example.com", url.getHost());
        assertEquals("/path/to/resource", url.getPath());
    }

    @Test
    public void testCreateURLWithInvalidURL() {
        // Invalid URL
        String invalidUrlStr = "htp://bad-url";

        try {
            TypeHandler.createURL(invalidUrlStr);
            fail("Expected ParseException to be thrown");
        } catch (ParseException e) {
            assertEquals("Unable to parse the URL: htp://bad-url", e.getMessage());
        }
    }
    
    @Test
    public void testCreateURLWithNull() {
        try {
            TypeHandler.createURL(null);
            fail("Expected ParseException to be thrown");
        } catch (ParseException e) {
            assertEquals("Unable to parse the URL: null", e.getMessage());
        }
    }
    
    @Test
    public void testCreateURLWithEmptyString() {
        try {
            TypeHandler.createURL("");
            fail("Expected ParseException to be thrown");
        } catch (ParseException e) {
            assertEquals("Unable to parse the URL: ", e.getMessage());
        }
    }
}
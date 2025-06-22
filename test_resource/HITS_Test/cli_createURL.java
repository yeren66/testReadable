package org.apache.commons.cli;

import org.junit.Test;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.net.MalformedURLException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

public class TypeHandler_createURL_6_0_Test {

    @Test
    public void testCreateURL_ValidURL() {
        try {
            String urlString = "http://www.example.com";
            URL expectedURL = new URL(urlString);
            URL actualURL = TypeHandler.createURL(urlString);
            assertEquals(expectedURL, actualURL);
        } catch (Exception e) {
            fail("Exception should not be thrown for a valid URL");
        }
    }

    @Test
    public void testCreateURL_InvalidURL() {
        String invalidUrlString = "invalid-url";
        try {
            TypeHandler.createURL(invalidUrlString);
            fail("ParseException should have been thrown for an invalid URL");
        } catch (ParseException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test
    public void testCreateURL_EmptyString() {
        String emptyUrlString = "";
        try {
            TypeHandler.createURL(emptyUrlString);
            fail("ParseException should have been thrown for an empty URL");
        } catch (ParseException e) {
            // Expected exception, test passes
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }
}

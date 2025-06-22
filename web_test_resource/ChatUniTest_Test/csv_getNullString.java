package org.apache.commons.csv;

// CSVFormatTest.java
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

// Test class for CSVFormat focusing on getNullString method
public class CSVFormatTest {

    @Test
    public void testGetNullString_DefaultFormat() {
        // Given a CSVFormat object with default settings
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        
        // When getNullString is called
        String nullString = csvFormat.getNullString();
        
        // Then it should return null since default setting does not replace null with any string
        assertNull("The nullString should be null for default format", nullString);
    }
    
    @Test
    public void testGetNullString_CustomNullString() {
        // Given a CSVFormat object with a custom null string
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setNullString("NULL").build();
        
        // When getNullString is called
        String nullString = csvFormat.getNullString();
        
        // Then it should return the custom null string set during configuration
        assertEquals("The nullString should be 'NULL'", "NULL", nullString);
    }

    @Test
    public void testGetNullString_EmptyNullString() {
        // Given a CSVFormat configured with an empty string as the null representation
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setNullString("").build();
        
        // When getNullString is called
        String nullString = csvFormat.getNullString();
        
        // Then it should return an empty string as defined
        assertEquals("The nullString should be an empty string", "", nullString);
    }

    @Test
    public void testGetNullString_NullStringUnset() {
        // Given a CSVFormat configured by setting a null string and then resetting to null
        CSVFormat.Builder builder = CSVFormat.DEFAULT.builder().setNullString("NULL");
        CSVFormat csvFormat = builder.setNullString(null).build();

        // When getNullString is called
        String nullString = csvFormat.getNullString();

        // Then it should return null as it was reset
        assertNull("The nullString should be null since it was unset", nullString);
    }

    @Test
    public void testGetNullString_ComplexCustomString() {
        // Given a CSVFormat object with a complex custom string for null
        String complexNullString = "<null/>";
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setNullString(complexNullString).build();

        // When getNullString is called
        String nullString = csvFormat.getNullString();

        // Then it should return the complex custom string set
        assertEquals("The nullString should match the complex custom string", complexNullString, nullString);
    }
}
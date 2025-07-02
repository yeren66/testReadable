package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormatTest {

    @Test
    public void testGetCommentMarker() {
        // Test case: No comment marker set
        CSVFormat csvFormatWithoutComment = CSVFormat.DEFAULT.builder().setCommentMarker(null).build();
        assertNull("Expected comment marker to be null when not set", csvFormatWithoutComment.getCommentMarker());

        // Test case: Comment marker set to '#'
        CSVFormat csvFormatWithHashComment = CSVFormat.DEFAULT.builder().setCommentMarker('#').build();
        assertNotNull("Expected comment marker not to be null", csvFormatWithHashComment.getCommentMarker());
        assertEquals("Expected comment marker to be '#'", Character.valueOf('#'), csvFormatWithHashComment.getCommentMarker());

        // Test case: Comment marker set to ';'
        CSVFormat csvFormatWithSemicolonComment = CSVFormat.DEFAULT.builder().setCommentMarker(';').build();
        assertNotNull("Expected comment marker not to be null", csvFormatWithSemicolonComment.getCommentMarker());
        assertEquals("Expected comment marker to be ';'", Character.valueOf(';'), csvFormatWithSemicolonComment.getCommentMarker());

        // Test case: Comment marker set to a line break character should throw an exception
        try {
            CSVFormat.DEFAULT.builder().setCommentMarker('\n').build();
            fail("Expected IllegalArgumentException when setting a line break character as comment marker");
        } catch (IllegalArgumentException e) {
            assertEquals("Unexpected exception message", "The comment start marker character cannot be a line break", e.getMessage());
        }
    }
}
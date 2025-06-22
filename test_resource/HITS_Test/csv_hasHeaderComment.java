package org.apache.commons.csv;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.csv.Token.Type.TOKEN;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class slice0_CSVParser_hasHeaderComment_20_0_Test {

    private CSVParser csvParserWithHeaderComment;

    private CSVParser csvParserWithoutHeaderComment;

    @Before
    public void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Create dummy CSVFormat for testing
        CSVFormat dummyFormat = CSVFormat.DEFAULT;
        // Initialize CSVParser instances
        csvParserWithHeaderComment = new CSVParser(new StringReader("dummy"), dummyFormat);
        csvParserWithoutHeaderComment = new CSVParser(new StringReader("dummy"), dummyFormat);
        // Use reflection to set the private headerComment field
        Field headerCommentField = CSVParser.class.getDeclaredField("headerComment");
        headerCommentField.setAccessible(true);
        // Set header comment for csvParserWithHeaderComment
        headerCommentField.set(csvParserWithHeaderComment, "This is a header comment");
        // Set header comment to null for csvParserWithoutHeaderComment
        headerCommentField.set(csvParserWithoutHeaderComment, null);
    }

    @Test
    public void testHasHeaderComment_ReturnsTrue_WhenHeaderCommentIsPresent() {
        assertTrue("Expected hasHeaderComment to return true when headerComment is present", csvParserWithHeaderComment.hasHeaderComment());
    }

    @Test
    public void testHasHeaderComment_ReturnsFalse_WhenHeaderCommentIsAbsent() {
        assertFalse("Expected hasHeaderComment to return false when headerComment is absent", csvParserWithoutHeaderComment.hasHeaderComment());
    }
}




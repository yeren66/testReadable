package org.apache.commons.csv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Field;
import org.junit.Before;
import org.junit.Test;
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

public class slice0_CSVParser_hasTrailerComment_21_0_Test {

    private CSVFormat format;

    private CSVParser parserWithTrailerComment;

    private CSVParser parserWithoutTrailerComment;

    @Before
    public void setUp() throws IOException, NoSuchFieldException, IllegalAccessException {
        format = CSVFormat.DEFAULT;
        // Instantiate CSVParser and set trailerComment using reflection
        parserWithTrailerComment = new CSVParser(new StringReader(""), format);
        setTrailerComment(parserWithTrailerComment, "This is a trailer comment");
        parserWithoutTrailerComment = new CSVParser(new StringReader(""), format);
        setTrailerComment(parserWithoutTrailerComment, null);
    }

    private void setTrailerComment(CSVParser parser, String comment) throws NoSuchFieldException, IllegalAccessException {
        Field trailerCommentField = CSVParser.class.getDeclaredField("trailerComment");
        trailerCommentField.setAccessible(true);
        trailerCommentField.set(parser, comment);
    }

    @Test
    public void testHasTrailerComment_WhenTrailerCommentIsPresent_ShouldReturnTrue() {
        assertTrue(parserWithTrailerComment.hasTrailerComment());
    }

    @Test
    public void testHasTrailerComment_WhenTrailerCommentIsAbsent_ShouldReturnFalse() {
        assertFalse(parserWithoutTrailerComment.hasTrailerComment());
    }
}




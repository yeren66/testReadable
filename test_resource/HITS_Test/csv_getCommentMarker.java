package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.apache.commons.csv.Constants.COMMA;
import static org.apache.commons.csv.Constants.CRLF;
import static org.apache.commons.csv.Constants.DOUBLE_QUOTE_CHAR;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.csv.Constants.BACKSLASH;
import static org.apache.commons.csv.Constants.COMMENT;
import static org.apache.commons.csv.Constants.CR;
import static org.apache.commons.csv.Constants.EMPTY;
import static org.apache.commons.csv.Constants.LF;
import static org.apache.commons.csv.Constants.PIPE;
import static org.apache.commons.csv.Constants.SP;
import static org.apache.commons.csv.Constants.TAB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class slice1_CSVFormat_getCommentMarker_21_0_Test {

    @Test
    public void testGetCommentMarker() {
        // Use the builder to set the comment marker
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setDelimiter(COMMA).setQuote(DOUBLE_QUOTE_CHAR).setCommentMarker('#').setRecordSeparator(CRLF).build();
        // Assert that the commentMarker is correctly set
        assertEquals(Character.valueOf('#'), csvFormat.getCommentMarker());
    }

    @Test
    public void testGetCommentMarkerWhenNull() {
        // Use the builder without setting a comment marker
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setDelimiter(COMMA).setQuote(DOUBLE_QUOTE_CHAR).setRecordSeparator(CRLF).build();
        // Assert that the commentMarker is null by default
        assertNull(csvFormat.getCommentMarker());
    }
}



package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.apache.commons.csv.Constants.COMMA;
import static org.apache.commons.csv.Constants.CRLF;
import static org.apache.commons.csv.Constants.DOUBLE_QUOTE_CHAR;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.csv.Constants.BACKSLASH;
import static org.apache.commons.csv.Constants.COMMENT;
import static org.apache.commons.csv.Constants.CR;
import static org.apache.commons.csv.Constants.EMPTY;
import static org.apache.commons.csv.Constants.LF;
import static org.apache.commons.csv.Constants.PIPE;
import static org.apache.commons.csv.Constants.SP;
import static org.apache.commons.csv.Constants.TAB;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class slice2_CSVFormat_getCommentMarker_21_0_Test {

    @Test
    public void testGetCommentMarker() {
        // Use the builder to set the comment marker
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setDelimiter(COMMA).setQuote(DOUBLE_QUOTE_CHAR).setCommentMarker('#').setRecordSeparator(CRLF).build();
        // Assert that the commentMarker is correctly set
        assertEquals(Character.valueOf('#'), csvFormat.getCommentMarker());
    }

    @Test
    public void testGetCommentMarkerWhenNull() {
        // Use the builder without setting a comment marker
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder().setDelimiter(COMMA).setQuote(DOUBLE_QUOTE_CHAR).setRecordSeparator(CRLF).build();
        // Assert that the commentMarker is null by default
        assertNull(csvFormat.getCommentMarker());
    }
}




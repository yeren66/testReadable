package org.apache.commons.csv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.csv.Constants.BACKSLASH;
import static org.apache.commons.csv.Constants.COMMA;
import static org.apache.commons.csv.Constants.COMMENT;
import static org.apache.commons.csv.Constants.CR;
import static org.apache.commons.csv.Constants.CRLF;
import static org.apache.commons.csv.Constants.DOUBLE_QUOTE_CHAR;
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

public class slice0_CSVFormat_valueOf_11_0_Test {

    @Test
    public void testValueOfRfc4180() {
        CSVFormat format = CSVFormat.valueOf("RFC4180");
        assertNotNull("The format should not be null", format);
        assertEquals("The format should be RFC4180", CSVFormat.RFC4180, format);
    }

    @Test
    public void testValueOfTdf() {
        CSVFormat format = CSVFormat.valueOf("TDF");
        assertNotNull("The format should not be null", format);
        assertEquals("The format should be TDF", CSVFormat.TDF, format);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValueOfInvalidFormat() {
        CSVFormat.valueOf("INVALID_FORMAT");
        fail("Expected IllegalArgumentException for invalid format");
    }
}




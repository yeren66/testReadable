package org.apache.commons.csv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
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

public class slice0_CSVFormat_getQuoteCharacter_32_0_Test {

    @Test
    public void testGetQuoteCharacterDefault() {
        CSVFormat format = CSVFormat.DEFAULT;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterExcel() {
        CSVFormat format = CSVFormat.EXCEL;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterInformixUnload() {
        CSVFormat format = CSVFormat.INFORMIX_UNLOAD;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterInformixUnloadCsv() {
        CSVFormat format = CSVFormat.INFORMIX_UNLOAD_CSV;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterMongodbCsv() {
        CSVFormat format = CSVFormat.MONGODB_CSV;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterMongodbTsv() {
        CSVFormat format = CSVFormat.MONGODB_TSV;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterMysql() {
        CSVFormat format = CSVFormat.MYSQL;
        Character expected = null;
        Character actual = format.getQuoteCharacter();
        assertNull(actual);
    }

    @Test
    public void testGetQuoteCharacterOracle() {
        CSVFormat format = CSVFormat.ORACLE;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterPostgresqlCsv() {
        CSVFormat format = CSVFormat.POSTGRESQL_CSV;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterPostgresqlText() {
        CSVFormat format = CSVFormat.POSTGRESQL_TEXT;
        Character expected = null;
        Character actual = format.getQuoteCharacter();
        assertNull(actual);
    }

    @Test
    public void testGetQuoteCharacterRfc4180() {
        CSVFormat format = CSVFormat.RFC4180;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetQuoteCharacterTdf() {
        CSVFormat format = CSVFormat.TDF;
        Character expected = Constants.DOUBLE_QUOTE_CHAR;
        Character actual = format.getQuoteCharacter();
        assertEquals(expected, actual);
    }
}




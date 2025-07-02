package org.apache.commons.csv;

import org.junit.Test;
import static org.junit.Assert.*;
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

public class slice0_CSVFormat_getTrailingDelimiter_36_0_Test {

    @Test
    public void testGetTrailingDelimiter_Default() {
        CSVFormat format = CSVFormat.DEFAULT;
        assertFalse("Default format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_Excel() {
        CSVFormat format = CSVFormat.EXCEL;
        assertFalse("Excel format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_InformixUnload() {
        CSVFormat format = CSVFormat.INFORMIX_UNLOAD;
        assertFalse("Informix Unload format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_InformixUnloadCSV() {
        CSVFormat format = CSVFormat.INFORMIX_UNLOAD_CSV;
        assertFalse("Informix Unload CSV format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_MongoDBCSV() {
        CSVFormat format = CSVFormat.MONGODB_CSV;
        assertFalse("MongoDB CSV format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_MongoDBTSV() {
        CSVFormat format = CSVFormat.MONGODB_TSV;
        assertFalse("MongoDB TSV format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_MySQL() {
        CSVFormat format = CSVFormat.MYSQL;
        assertFalse("MySQL format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_Oracle() {
        CSVFormat format = CSVFormat.ORACLE;
        assertFalse("Oracle format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_PostgreSQLCSV() {
        CSVFormat format = CSVFormat.POSTGRESQL_CSV;
        assertFalse("PostgreSQL CSV format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_PostgreSQLText() {
        CSVFormat format = CSVFormat.POSTGRESQL_TEXT;
        assertFalse("PostgreSQL Text format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_RFC4180() {
        CSVFormat format = CSVFormat.RFC4180;
        assertFalse("RFC4180 format should not have a trailing delimiter", format.getTrailingDelimiter());
    }

    @Test
    public void testGetTrailingDelimiter_TDF() {
        CSVFormat format = CSVFormat.TDF;
        assertFalse("TDF format should not have a trailing delimiter", format.getTrailingDelimiter());
    }
}




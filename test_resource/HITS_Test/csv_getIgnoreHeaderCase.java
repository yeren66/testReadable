package org.apache.commons.csv;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

public class slice0_CSVFormat_getIgnoreHeaderCase_29_0_Test {

    @Test
    public void testGetIgnoreHeaderCase_Default() {
        CSVFormat format = CSVFormat.DEFAULT;
        assertFalse("Default CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_Excel() {
        CSVFormat format = CSVFormat.EXCEL;
        assertFalse("Excel CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_InformixUnload() {
        CSVFormat format = CSVFormat.INFORMIX_UNLOAD;
        assertFalse("Informix Unload CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_InformixUnloadCSV() {
        CSVFormat format = CSVFormat.INFORMIX_UNLOAD_CSV;
        assertFalse("Informix Unload CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_MongoDB_CSV() {
        CSVFormat format = CSVFormat.MONGODB_CSV;
        assertFalse("MongoDB CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_MongoDB_TSV() {
        CSVFormat format = CSVFormat.MONGODB_TSV;
        assertFalse("MongoDB TSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_MySQL() {
        CSVFormat format = CSVFormat.MYSQL;
        assertFalse("MySQL CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_Oracle() {
        CSVFormat format = CSVFormat.ORACLE;
        assertFalse("Oracle CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_PostgreSQL_CSV() {
        CSVFormat format = CSVFormat.POSTGRESQL_CSV;
        assertFalse("PostgreSQL CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_PostgreSQL_Text() {
        CSVFormat format = CSVFormat.POSTGRESQL_TEXT;
        assertFalse("PostgreSQL Text Format should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_RFC4180() {
        CSVFormat format = CSVFormat.RFC4180;
        assertFalse("RFC4180 CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }

    @Test
    public void testGetIgnoreHeaderCase_TDF() {
        CSVFormat format = CSVFormat.TDF;
        assertFalse("TDF CSVFormat should not ignore header case", format.getIgnoreHeaderCase());
    }
}




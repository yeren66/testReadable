package org.apache.commons.csv;

import org.junit.Assert;
import org.junit.Test;

public class CSVFormatTest {

    @Test
    public void testGetQuoteCharacterDefaultFormat() {
        CSVFormat defaultFormat = CSVFormat.DEFAULT;
        // Default CSV format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), defaultFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterExcelFormat() {
        CSVFormat excelFormat = CSVFormat.EXCEL;
        // Excel format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), excelFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterInformixUnloadFormat() {
        CSVFormat informixUnloadFormat = CSVFormat.INFORMIX_UNLOAD;
        // Informix Unload format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), informixUnloadFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterInformixUnloadCsvFormat() {
        CSVFormat informixUnloadCsvFormat = CSVFormat.INFORMIX_UNLOAD_CSV;
        // Informix Unload CSV format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), informixUnloadCsvFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterMongoDbCsvFormat() {
        CSVFormat mongoDbCsvFormat = CSVFormat.MONGODB_CSV;
        // MongoDB CSV format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), mongoDbCsvFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterMongoDbTsvFormat() {
        CSVFormat mongoDbTsvFormat = CSVFormat.MONGODB_TSV;
        // MongoDB TSV format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), mongoDbTsvFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterMySqlFormat() {
        CSVFormat mysqlFormat = CSVFormat.MYSQL;
        // MySQL format does not use a quote character
        Assert.assertNull(mysqlFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterOracleFormat() {
        CSVFormat oracleFormat = CSVFormat.ORACLE;
        // Oracle format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), oracleFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterPostgreSqlCsvFormat() {
        CSVFormat postgreSqlCsvFormat = CSVFormat.POSTGRESQL_CSV;
        // PostgreSQL CSV format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), postgreSqlCsvFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterPostgreSqlTextFormat() {
        CSVFormat postgreSqlTextFormat = CSVFormat.POSTGRESQL_TEXT;
        // PostgreSQL Text format does not use a quote character
        Assert.assertNull(postgreSqlTextFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterRFC4180Format() {
        CSVFormat rfc4180Format = CSVFormat.RFC4180;
        // RFC4180 format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), rfc4180Format.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterTDFFormat() {
        CSVFormat tdfFormat = CSVFormat.TDF;
        // TDF format uses a double quote as the quote character
        Assert.assertEquals(Character.valueOf('"'), tdfFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterCustomFormatWithQuote() {
        CSVFormat customFormat = CSVFormat.DEFAULT.builder()
            .setQuote('*')
            .build();
        // Custom format with '*' as quote character should return '*'
        Assert.assertEquals(Character.valueOf('*'), customFormat.getQuoteCharacter());
    }

    @Test
    public void testGetQuoteCharacterCustomFormatWithoutQuote() {
        CSVFormat customFormat = CSVFormat.DEFAULT.builder()
            .setQuote(null)
            .build();
        // Custom format without quote character should return null
        Assert.assertNull(customFormat.getQuoteCharacter());
    }
}
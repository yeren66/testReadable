package org.apache.commons.csv;

// package org.apache.commons.csv;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CSVFormatTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testValueOf_Default() {
        CSVFormat format = CSVFormat.valueOf("Default");
        assertEquals(CSVFormat.DEFAULT, format);
    }

    @Test
    public void testValueOf_Excel() {
        CSVFormat format = CSVFormat.valueOf("Excel");
        assertEquals(CSVFormat.EXCEL, format);
    }

    @Test
    public void testValueOf_MySQL() {
        CSVFormat format = CSVFormat.valueOf("MySQL");
        assertEquals(CSVFormat.MYSQL, format);
    }

    @Test
    public void testValueOf_InvalidFormatName() {
        // Set up the expected exception rule
        thrown.expect(IllegalArgumentException.class);
        CSVFormat.valueOf("InvalidFormat");
    }

    @Test
    public void testValueOf_NullFormatName() {
        // Set up the expected exception rule
        thrown.expect(NullPointerException.class);
        CSVFormat.valueOf(null);
    }
}
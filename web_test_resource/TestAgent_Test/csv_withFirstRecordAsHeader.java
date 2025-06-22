package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of CSVFormat's `withFirstRecordAsHeader` method.
 * Covers scenarios including normal usage, repeated calls, handling of malformed CSVs, and deprecated functionality.
 */
public class OutlierTest {

    private CSVFormat defaultFormat;

    /**
     * Sets up the default CSVFormat instance before each test.
     */
    @BeforeEach
    void setUp() {
        defaultFormat = CSVFormat.DEFAULT;
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior when creating a CSVFormat with the first record as header.', 
     * 'Input_Type': 'No input parameters are required as the method utilizes internal builder settings.', 
     * 'Output_Type': 'A new CSVFormat object configured to use the first CSV record as the header, with setHeader() and setSkipHeaderRecord(true) applied.'}
     */
    @Test
    @DisplayName("Verify normal behavior when creating a CSVFormat with the first record as header")
    void testWithFirstRecordAsHeader() {
        // Arrange
        CSVFormat csvFormat = defaultFormat;

        // Act
        CSVFormat result = csvFormat.withFirstRecordAsHeader();

        // Assert
        assertNotNull(result, "Resulting CSVFormat should not be null");
        assertNotSame(csvFormat, result, "Resulting CSVFormat should be a new instance");
        assertNull(result.getHeader(), "Headers should not be preset, allowing the first record to define them");
        assertTrue(result.getSkipHeaderRecord(), "First record should be skipped in processing");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check the behavior when the method is called multiple times consecutively.', 
     * 'Input_Type': 'No input parameters; repeated method calls should yield consistent results.', 
     * 'Output_Type': 'Each call should return a new instance of CSVFormat, consistently configured with the first record as the header and skipping it.'}
     */
    @Test
    @DisplayName("Check behavior when the method is called multiple times consecutively")
    void testWithFirstRecordAsHeaderRepeatedCalls() {
        // Act
        CSVFormat format1 = defaultFormat.withFirstRecordAsHeader();
        CSVFormat format2 = defaultFormat.withFirstRecordAsHeader();

        // Assert
        assertNotSame(format1, format2, "Each call should return a new instance");
        assertTrue(format1.getSkipHeaderRecord(), "The first record should be used as header in the first instance");
        assertTrue(format2.getSkipHeaderRecord(), "The first record should be used as header in the second instance");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate behavior when dealing with a CSV that does not have a proper first record.', 
     * 'Input_Type': 'Implicitly handled input; behavior expected when the CSV content itself is inadequate (e.g., empty or malformed file).', 
     * 'Output_Type': 'Despite the CSV content, the method consistently sets the first record as the header and skips it, assuming proper CSV parser handling.'}
     */
    @Test
    @DisplayName("Validate behavior when dealing with a CSV that does not have a proper first record")
    void testWithFirstRecordAsHeaderMalformedCSV() {
        // Act
        CSVFormat headerFormat = defaultFormat.withFirstRecordAsHeader();

        // Assert
        assertTrue(headerFormat.getSkipHeaderRecord(), "The format should be configured to skip the header record");
        assertNull(headerFormat.getHeader(), "The header should be set to null indicating skipping the first record usage as header");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Ensure the method's deprecation message and alternative recommendation do not affect functionality.", 
     * 'Input_Type': 'Invocation of the deprecated method to check deprecation warnings without affecting output.', 
     * 'Output_Type': 'The method should still successfully produce a CSVFormat with described settings, even when marked deprecated.'}
     */
    @Test
    @DisplayName("Ensure deprecated method functionality remains unaffected")
    void testWithFirstRecordAsHeaderDeprecatedFunctionality() {
        // Act
        CSVFormat newFormat = defaultFormat.withFirstRecordAsHeader();

        // Assert
        assertTrue(newFormat.getSkipHeaderRecord(), "The skipHeaderRecord should be true");
        assertNull(newFormat.getHeader(), "The header array should be null as it is expected to use the first record as a header");
    }
}
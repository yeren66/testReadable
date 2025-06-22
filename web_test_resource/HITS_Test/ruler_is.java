package software.amazon.event.ruler.input;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import static software.amazon.event.ruler.input.DefaultParser.NINE_BYTE;
import static software.amazon.event.ruler.input.DefaultParser.ZERO_BYTE;

public class MultiByte_is_2_0_Test {

    private MultiByte multiByte;

    @Before
    public void setUp() {
        // Initialize the MultiByte object with a specific byte array
        multiByte = new MultiByte(new byte[] { 0x01, 0x02, 0x03 });
    }

    @Test
    public void testIsWithMatchingBytes() {
        // Test with a byte array that matches the internal byte array
        byte[] inputBytes = { 0x01, 0x02, 0x03 };
        assertTrue("The byte arrays should match", multiByte.is(inputBytes));
    }

    @Test
    public void testIsWithNonMatchingBytes() {
        // Test with a byte array that does not match the internal byte array
        byte[] inputBytes = { 0x01, 0x02, 0x04 };
        assertFalse("The byte arrays should not match", multiByte.is(inputBytes));
    }

    @Test
    public void testIsWithDifferentLengthBytes() {
        // Test with a byte array of different length
        byte[] inputBytes = { 0x01, 0x02 };
        assertFalse("The byte arrays should not match due to different lengths", multiByte.is(inputBytes));
    }

    @Test
    public void testIsWithEmptyBytes() {
        // Test with an empty byte array
        byte[] inputBytes = {};
        assertFalse("The byte arrays should not match when one is empty", multiByte.is(inputBytes));
    }

    @Test
    public void testIsWithNullBytes() {
        // Test with a null byte array
        byte[] inputBytes = null;
        assertFalse("The byte arrays should not match when one is null", multiByte.is(inputBytes));
    }
}

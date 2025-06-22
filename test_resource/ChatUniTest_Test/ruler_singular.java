package software.amazon.event.ruler.input;

// package software.amazon.event.ruler.input;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiByteTest {

    @Test
    public void testSingularSingleByte() {
        // Test with a valid single byte
        byte singleByte = 0x41;  // ASCII value for 'A'
        MultiByte multiByte = new MultiByte(singleByte);

        // Check that singular method returns the correct byte
        assertEquals(singleByte, multiByte.singular());
    }

    @Test(expected = IllegalStateException.class)
    public void testSingularThrowsExceptionForMultipleBytes() {
        // Test with multiple bytes
        byte[] multipleBytes = {0x41, 0x42};  // ASCII values for 'A' and 'B'
        MultiByte multiByte = new MultiByte(multipleBytes);

        // This should throw an IllegalStateException
        multiByte.singular();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionForZeroBytes() {
        // Test with no bytes

        byte[] noBytes = {};
        MultiByte multiByte = new MultiByte(noBytes);

        // Constructor should throw an IllegalArgumentException
    }
}
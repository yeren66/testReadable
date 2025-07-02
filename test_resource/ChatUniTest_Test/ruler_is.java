package software.amazon.event.ruler.input;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiByteTest {
    
    @Test
    public void testIsWithMatchingBytes() {
        MultiByte multiByte = new MultiByte((byte)0x61, (byte)0x62, (byte)0x63);
        // Test that the 'is' method correctly identifies matching byte sequences
        assertTrue("Expected bytes to match", multiByte.is((byte)0x61, (byte)0x62, (byte)0x63));
    }
    
    @Test
    public void testIsWithNonMatchingBytes() {
        MultiByte multiByte = new MultiByte((byte)0x61, (byte)0x62, (byte)0x63);
        // Test that the 'is' method correctly identifies non-matching byte sequences
        assertFalse("Expected bytes to not match", multiByte.is((byte)0x61, (byte)0x62, (byte)0x64));
    }
    
    @Test
    public void testIsWithDifferentLengthBytes() {
        MultiByte multiByte = new MultiByte((byte)0x61, (byte)0x62, (byte)0x63);
        // Test that the 'is' method correctly handles byte arrays of different lengths
        assertFalse("Expected bytes of different lengths to not match", multiByte.is((byte)0x61, (byte)0x62));
    }
    
    @Test
    public void testIsWithEmptyByteArray() {
        MultiByte multiByte = new MultiByte((byte)0x61);
        // Test that the 'is' method correctly handles comparison with an empty byte array
        assertFalse("Expected non-empty bytes to not match empty bytes", multiByte.is());
    }

    @Test
    public void testIsWithSingleMatchingByte() {
        MultiByte multiByte = new MultiByte((byte)0x61);
        // Test that the 'is' method correctly identifies when a single byte matches
        assertTrue("Expected single byte to match", multiByte.is((byte)0x61));
    }
    
    @Test
    public void testIsWithSingleNonMatchingByte() {
        MultiByte multiByte = new MultiByte((byte)0x61);
        // Test that the 'is' method correctly identifies when a single byte does not match
        assertFalse("Expected single non-matching byte to not match", multiByte.is((byte)0x62));
    }
}
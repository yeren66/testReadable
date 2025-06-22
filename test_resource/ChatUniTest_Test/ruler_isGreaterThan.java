package software.amazon.event.ruler.input;

import static org.junit.Assert.*;
import org.junit.Test;

public class MultiByteTest {

    @Test
    public void testIsGreaterThan_SingleByteComparison() {
        MultiByte multiByteA = new MultiByte((byte) 0x05);
        MultiByte multiByteB = new MultiByte((byte) 0x03);

        assertTrue("Expected multiByteA to be greater than multiByteB", multiByteA.isGreaterThan(multiByteB));
        assertFalse("Expected multiByteB not to be greater than multiByteA", multiByteB.isGreaterThan(multiByteA));
        
        MultiByte multiByteC = new MultiByte((byte) 0x05);
        assertFalse("Expected multiByteA not to be greater than itself", multiByteA.isGreaterThan(multiByteC));
    }

    @Test
    public void testIsGreaterThan_MultiByteComparison() {
        MultiByte multiByteA = new MultiByte((byte) 0x01, (byte) 0x02);
        MultiByte multiByteB = new MultiByte((byte) 0x01, (byte) 0x01);
        
        assertTrue("Expect multiByteA to be greater than multiByteB", multiByteA.isGreaterThan(multiByteB));

        MultiByte multiByteC = new MultiByte((byte) 0x01, (byte) 0x02);
        MultiByte multiByteD = new MultiByte((byte) 0x01, (byte) 0x02);
        
        assertFalse("Expected multiByteC not be greater than multiByteD", multiByteC.isGreaterThan(multiByteD));
    }
    
    @Test
    public void testIsGreaterThan_PrefixComparison() {
        MultiByte multiByteA = new MultiByte((byte) 0x01, (byte) 0x02, (byte) 0x03);
        MultiByte multiByteB = new MultiByte((byte) 0x01, (byte) 0x02);
        
        assertTrue("Expect multiByteA to be greater than multiByteB", multiByteA.isGreaterThan(multiByteB));

        MultiByte multiByteC = new MultiByte((byte) 0x01, (byte) 0x02);
        MultiByte multiByteD = new MultiByte((byte) 0x01, (byte) 0x02, (byte) 0x03);
        
        assertFalse("Expected multiByteC not to be greater than multiByteD", multiByteC.isGreaterThan(multiByteD));
    }
    
    @Test
    public void testIsGreaterThan_DifferingLengths() {
        MultiByte multiByteA = new MultiByte((byte) 0x01, (byte) 0x02);
        MultiByte multiByteB = new MultiByte((byte) 0x01, (byte) 0x02, (byte) 0x00);
        
        assertFalse("Expect multiByteA not to be greater than multiByteB", multiByteA.isGreaterThan(multiByteB));
        assertTrue("Expect multiByteB to be greater than multiByteA", multiByteB.isGreaterThan(multiByteA));
    }
}
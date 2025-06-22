package software.amazon.event.ruler.input;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class MultiByteTest {

    @Test
    public void testGetBytes_WithSingleByte() {
        byte singleByte = 0x01;
        MultiByte multiByte = new MultiByte(singleByte);
        byte[] expected = new byte[]{singleByte};

        assertArrayEquals("getBytes should return the correct single byte array", expected, multiByte.getBytes());
    }
    
    @Test
    public void testGetBytes_WithMultipleBytes() {
        byte[] byteArray = new byte[]{0x01, 0x02, 0x03};
        MultiByte multiByte = new MultiByte(byteArray);
        byte[] result = multiByte.getBytes();

        assertArrayEquals("getBytes should return a correct copy of the byte array", byteArray, result);

        // Assert that the array returned is a copy and not the original
        assertNotSame("getBytes should return a new array, not the original", byteArray, result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_WithNoBytes_ShouldThrowException() {
        new MultiByte(); // This should throw an IllegalArgumentException
    }
}
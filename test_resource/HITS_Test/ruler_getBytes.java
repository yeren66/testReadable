package software.amazon.event.ruler.input;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import static software.amazon.event.ruler.input.DefaultParser.NINE_BYTE;
import static software.amazon.event.ruler.input.DefaultParser.ZERO_BYTE;

public class slice0_MultiByte_getBytes_0_0_Test {

    @Test
    public void testGetBytes_SingleByteArray() {
        MultiByte multiByte = new MultiByte(new byte[] { 0x01 });
        byte[] result = multiByte.getBytes();
        assertArrayEquals(new byte[] { 0x01 }, result);
    }

    @Test
    public void testGetBytes_MultiByteArray() {
        byte[] inputBytes = new byte[] { 0x01, 0x02, 0x03, 0x04, 0x05 };
        MultiByte multiByte = new MultiByte(inputBytes);
        byte[] result = multiByte.getBytes();
        assertArrayEquals(inputBytes, result);
    }

    @Test
    public void testGetBytes_ImmutableArray() {
        byte[] inputBytes = new byte[] { 0x01, 0x02, 0x03 };
        MultiByte multiByte = new MultiByte(inputBytes);
        byte[] result = multiByte.getBytes();
        // Attempt to modify the result array
        result[0] = 0x00;
        // Original array should remain unchanged
        assertArrayEquals(new byte[] { 0x01, 0x02, 0x03 }, multiByte.getBytes());
    }
}




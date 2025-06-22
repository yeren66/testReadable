package software.amazon.event.ruler.input;

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

public class slice0_MultiByte_isGreaterThan_6_0_Test {

    @Test
    public void testIsGreaterThan_SingleByte_Greater() {
        // 127 in decimal
        MultiByte mb1 = new MultiByte((byte) 0x7F);
        // 0 in decimal
        MultiByte mb2 = new MultiByte((byte) 0x00);
        assertTrue(mb1.isGreaterThan(mb2));
    }

    @Test
    public void testIsGreaterThan_SingleByte_Less() {
        // 0 in decimal
        MultiByte mb1 = new MultiByte((byte) 0x00);
        // 127 in decimal
        MultiByte mb2 = new MultiByte((byte) 0x7F);
        assertFalse(mb1.isGreaterThan(mb2));
    }

    @Test
    public void testIsGreaterThan_SingleByte_Equal() {
        // 127 in decimal
        MultiByte mb1 = new MultiByte((byte) 0x7F);
        // 127 in decimal
        MultiByte mb2 = new MultiByte((byte) 0x7F);
        assertFalse(mb1.isGreaterThan(mb2));
    }

    @Test
    public void testIsGreaterThan_MultiByte_Greater() {
        // 2-byte character
        MultiByte mb1 = new MultiByte((byte) 0xC2, (byte) 0xA2);
        // 2-byte character
        MultiByte mb2 = new MultiByte((byte) 0xC2, (byte) 0xA1);
        assertTrue(mb1.isGreaterThan(mb2));
    }

    @Test
    public void testIsGreaterThan_MultiByte_Less() {
        // 2-byte character
        MultiByte mb1 = new MultiByte((byte) 0xC2, (byte) 0xA1);
        // 2-byte character
        MultiByte mb2 = new MultiByte((byte) 0xC2, (byte) 0xA2);
        assertFalse(mb1.isGreaterThan(mb2));
    }

    @Test
    public void testIsGreaterThan_MultiByte_Equal() {
        // 2-byte character
        MultiByte mb1 = new MultiByte((byte) 0xC2, (byte) 0xA2);
        // 2-byte character
        MultiByte mb2 = new MultiByte((byte) 0xC2, (byte) 0xA2);
        assertFalse(mb1.isGreaterThan(mb2));
    }
}




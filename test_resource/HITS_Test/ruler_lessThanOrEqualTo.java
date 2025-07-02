package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.function.Function;
import static software.amazon.event.ruler.Constants.BASE128_DIGITS;
import static software.amazon.event.ruler.Constants.HEX_DIGITS;
import static software.amazon.event.ruler.Constants.MAX_HEX_DIGIT;
import static software.amazon.event.ruler.Constants.MAX_NUM_DIGIT;
import static software.amazon.event.ruler.Constants.MIN_HEX_DIGIT;
import static software.amazon.event.ruler.Constants.MIN_NUM_DIGIT;

public class Range_lessThanOrEqualTo_1_0_Test {

    @Test
    public void testLessThanOrEqualToWithNumericString() {
        Range range = Range.lessThanOrEqualTo("12345");
        byte[] expectedBytes = stringToComparableBytes("12345");
        assertArrayEquals(expectedBytes, range.top);
    }

    private static byte[] stringToComparableBytes(String string) {
        return ComparableNumber.generate(string).getBytes(StandardCharsets.UTF_8);
    }
}

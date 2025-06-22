package software.amazon.event.ruler.input;

import org.junit.Test;
import org.junit.Assert;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InputMultiByteSetTest {

    @Test
    public void testGetMultiBytes() {
        // Arrange: Create a set of MultiByte objects
        MultiByte multiByte1 = new MultiByte(1);
        MultiByte multiByte2 = new MultiByte(2);
        Set<MultiByte> multiByteSet = new HashSet<>();
        multiByteSet.add(multiByte1);
        multiByteSet.add(multiByte2);

        // Act: Create an InputMultiByteSet object and call getMultiBytes
        InputMultiByteSet inputMultiByteSet = new InputMultiByteSet(multiByteSet);
        Set<MultiByte> result = inputMultiByteSet.getMultiBytes();

        // Assert: Check that the returned set matches the original set
        Assert.assertEquals("The returned set should have the same size as the original set", multiByteSet.size(), result.size());
        Assert.assertTrue("The returned set should contain multiByte1", result.contains(multiByte1));
        Assert.assertTrue("The returned set should contain multiByte2", result.contains(multiByte2));

        // Assert: Verify immutability of the returned set
        try {
            result.add(new MultiByte(3));
            Assert.fail("The returned set should be unmodifiable");
        } catch (UnsupportedOperationException e) {
            // Expected exception since the set is unmodifiable
        }
    }
}

// Hypothetical implementation of the MultiByte class for testing purposes
class MultiByte {
    private final int value;

    MultiByte(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MultiByte)) return false;
        MultiByte other = (MultiByte) obj;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
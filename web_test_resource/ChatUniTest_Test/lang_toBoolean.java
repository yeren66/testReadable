package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class MutableBooleanTest {

    @Test
    public void testToBooleanWhenTrue() {
        // Arrange: Create a MutableBoolean initialized to true.
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        
        // Act: Get the boolean value from toBoolean method.
        Boolean result = mutableBoolean.toBoolean();
        
        // Assert: The result should be a Boolean instance representing true.
        assertNotNull(result);
        assertTrue(result);
    }
    
    @Test
    public void testToBooleanWhenFalse() {
        // Arrange: Create a MutableBoolean initialized to false.
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        
        // Act: Get the boolean value from toBoolean method.
        Boolean result = mutableBoolean.toBoolean();
        
        // Assert: The result should be a Boolean instance representing false.
        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void testToBooleanAfterSetTrue() {
        // Arrange: Create a MutableBoolean initialized to false.
        MutableBoolean mutableBoolean = new MutableBoolean(false);
        
        // Act: Set the value to true and get the boolean value from toBoolean.
        mutableBoolean.setTrue();
        Boolean result = mutableBoolean.toBoolean();
        
        // Assert: The result should be a Boolean instance representing true.
        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void testToBooleanAfterSetFalse() {
        // Arrange: Create a MutableBoolean initialized to true.
        MutableBoolean mutableBoolean = new MutableBoolean(true);
        
        // Act: Set the value to false and get the boolean value from toBoolean.
        mutableBoolean.setFalse();
        Boolean result = mutableBoolean.toBoolean();
        
        // Assert: The result should be a Boolean instance representing false.
        assertNotNull(result);
        assertFalse(result);
    }
}
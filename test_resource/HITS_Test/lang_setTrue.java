package org.apache.commons.lang3.mutable;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import org.apache.commons.lang3.BooleanUtils;

public class slice0_MutableBoolean_setTrue_3_0_Test {

    private MutableBoolean mutableBoolean;

    @Before
    public void setUp() {
        mutableBoolean = new MutableBoolean();
    }

    @Test
    public void testSetTrue() {
        // Initially, the value should be false
        assertTrue(!mutableBoolean.isTrue());
        // Call the method under test
        mutableBoolean.setTrue();
        // Verify that the value is set to true
        assertTrue(mutableBoolean.isTrue());
    }
}




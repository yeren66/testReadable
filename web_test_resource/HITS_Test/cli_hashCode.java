package org.apache.commons.cli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.cli.Util.EMPTY_STRING_ARRAY;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Option_hashCode_26_0_Test {

    private Option option1;

    private Option option2;

    private Option option3;

    @Before
    public void setUp() {
        option1 = new Option("a", "alpha");
        option2 = new Option("b", "beta");
        option3 = new Option("a", "alpha");
    }

    @Test
    public void testHashCodeConsistency() {
        int initialHashCode = option1.hashCode();
        for (int i = 0; i < 10; i++) {
            assertEquals(initialHashCode, option1.hashCode());
        }
    }

    @Test
    public void testHashCodeEqualityForEqualObjects() {
        assertEquals(option1.hashCode(), option3.hashCode());
    }

    @Test
    public void testHashCodeInequalityForDifferentObjects() {
        assertNotEquals(option1.hashCode(), option2.hashCode());
    }

    @Test
    public void testHashCodeWithNullFields() {
        Option optionWithNulls = new Option("c", null);
        int expectedHashCode = Objects.hash(null, "c");
        assertEquals(expectedHashCode, optionWithNulls.hashCode());
    }
}

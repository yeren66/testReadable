package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;

public class MissingOptionException_getMissingOptions_1_0_Test {

    @Test
    public void testGetMissingOptionsWithNonNullList() {
        List<String> options = new ArrayList<>();
        options.add("option1");
        options.add("option2");
        MissingOptionException exception = new MissingOptionException(options);
        assertEquals(options, exception.getMissingOptions());
    }

    @Test
    public void testGetMissingOptionsWithEmptyList() {
        List<String> options = new ArrayList<>();
        MissingOptionException exception = new MissingOptionException(options);
        assertEquals(options, exception.getMissingOptions());
    }
}

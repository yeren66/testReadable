package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter_getOptionComparator_10_0_Test {

    @Test
    public void testGetOptionComparator() {
        // Arrange
        HelpFormatter helpFormatter = new HelpFormatter();
        // Act
        Comparator<Option> comparator = helpFormatter.getOptionComparator();
        // Assert
        assertNotNull("The comparator should not be null", comparator);
        // Creating dummy Option instances for comparison
        Option option1 = new Option("a", "optionA", false, "First option");
        Option option2 = new Option("b", "optionB", false, "Second option");
        // Assuming the comparator sorts based on option names
        assertTrue("Comparator should indicate option1 < option2", comparator.compare(option1, option2) < 0);
        assertTrue("Comparator should indicate option2 > option1", comparator.compare(option2, option1) > 0);
        assertEquals("Comparator should indicate option1 == option1", 0, comparator.compare(option1, option1));
    }
}

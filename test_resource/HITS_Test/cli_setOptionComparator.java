package org.apache.commons.cli;

import org.junit.Before;
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

public class HelpFormatter_setOptionComparator_37_0_Test {

    private HelpFormatter helpFormatter;

    @Before
    public void setUp() {
        helpFormatter = new HelpFormatter();
    }

    @Test
    public void testSetOptionComparatorWithCustomComparator() {
        Comparator<Option> customComparator = new Comparator<Option>() {

            @Override
            public int compare(Option o1, Option o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        };
        helpFormatter.setOptionComparator(customComparator);
        assertSame("The optionComparator should be the custom comparator set.", customComparator, helpFormatter.optionComparator);
    }

    @Test
    public void testSetOptionComparatorWithNull() {
        helpFormatter.setOptionComparator(null);
        assertNull("The optionComparator should be set to null.", helpFormatter.optionComparator);
    }

    @Test
    public void testSetOptionComparatorWithDefaultComparator() {
        Comparator<Option> defaultComparator = helpFormatter.optionComparator;
        helpFormatter.setOptionComparator(defaultComparator);
        assertSame("The optionComparator should be the default comparator set.", defaultComparator, helpFormatter.optionComparator);
    }
}

// Assuming Option is a class with a getKey method. This is a mock class to make the test compile.
class Option {

    private String key;

    public Option(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

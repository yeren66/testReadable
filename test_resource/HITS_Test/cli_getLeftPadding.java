package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
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
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class HelpFormatter_getLeftPadding_6_0_Test {

    @Test
    public void testGetLeftPadding() {
        HelpFormatter helpFormatter = new HelpFormatter();
        int expectedLeftPad = HelpFormatter.DEFAULT_LEFT_PAD;
        int actualLeftPad = helpFormatter.getLeftPadding();
        assertEquals("The left padding should be equal to the default left padding", expectedLeftPad, actualLeftPad);
    }
}

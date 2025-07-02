package org.apache.commons.cli;

import org.junit.Assert;
import org.junit.Test;
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

public class HelpFormatter_getWidth_13_0_Test {

    @Test
    public void testGetWidth_DefaultWidth() {
        // Arrange
        HelpFormatter helpFormatter = new HelpFormatter();
        // Act
        int width = helpFormatter.getWidth();
        // Assert
        Assert.assertEquals(HelpFormatter.DEFAULT_WIDTH, width);
    }
}

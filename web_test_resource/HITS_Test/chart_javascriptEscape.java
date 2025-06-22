package org.jfree.chart.imagemap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.StringUtils;

public class slice2_ImageMapUtils_javascriptEscape_6_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testJavascriptEscape_NullInput() {
        // Test with null input, expecting an IllegalArgumentException
        ImageMapUtils.javascriptEscape(null);
    }

    @Test
    public void testJavascriptEscape_EmptyString() {
        // Test with empty string input
        String input = "";
        String expected = "";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_NoSpecialCharacters() {
        // Test with input containing no special characters
        String input = "HelloWorld";
        String expected = "HelloWorld";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_DoubleQuotes() {
        // Test with input containing double quotes
        String input = "He said, \"Hello\"";
        String expected = "He said, \\\"Hello\\\"";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_SingleQuotes() {
        // Test with input containing single quotes
        String input = "It's a test";
        String expected = "It\\'s a test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_Backslashes() {
        // Test with input containing backslashes
        String input = "Path\\to\\file";
        String expected = "Path\\\\to\\\\file";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_MixedSpecialCharacters() {
        // Test with input containing mixed special characters
        String input = "\"Hello\", it's a \\ test";
        String expected = "\\\"Hello\\\", it\\'s a \\\\ test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }
}



package org.jfree.chart.imagemap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.StringUtils;

public class slice0_ImageMapUtils_javascriptEscape_6_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testJavascriptEscape_NullInput() {
        // Test with null input, expecting an IllegalArgumentException
        ImageMapUtils.javascriptEscape(null);
    }

    @Test
    public void testJavascriptEscape_EmptyString() {
        // Test with empty string input
        String input = "";
        String expected = "";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_NoSpecialCharacters() {
        // Test with input containing no special characters
        String input = "HelloWorld";
        String expected = "HelloWorld";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_DoubleQuotes() {
        // Test with input containing double quotes
        String input = "He said, \"Hello\"";
        String expected = "He said, \\\"Hello\\\"";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_SingleQuotes() {
        // Test with input containing single quotes
        String input = "It's a test";
        String expected = "It\\'s a test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_Backslashes() {
        // Test with input containing backslashes
        String input = "Path\\to\\file";
        String expected = "Path\\\\to\\\\file";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_MixedSpecialCharacters() {
        // Test with input containing mixed special characters
        String input = "\"Hello\", it's a \\ test";
        String expected = "\\\"Hello\\\", it\\'s a \\\\ test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }
}



package org.jfree.chart.imagemap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.IOException;
import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.StringUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@RunWith(MockitoJUnitRunner.class)
public class slice5_ImageMapUtils_javascriptEscape_6_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testJavascriptEscape_NullInput() {
        // Test with null input, expecting an IllegalArgumentException
        ImageMapUtils.javascriptEscape(null);
    }

    @Test
    public void testJavascriptEscape_EmptyString() {
        // Test with empty string input
        String input = "";
        String expected = "";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_NoSpecialCharacters() {
        // Test with input containing no special characters
        String input = "HelloWorld";
        String expected = "HelloWorld";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_DoubleQuotes() {
        // Test with input containing double quotes
        String input = "He said, \"Hello\"";
        String expected = "He said, \\\"Hello\\\"";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_SingleQuotes() {
        // Test with input containing single quotes
        String input = "It's a test";
        String expected = "It\\'s a test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_Backslashes() {
        // Test with input containing backslashes
        String input = "Path\\to\\file";
        String expected = "Path\\\\to\\\\file";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_MixedSpecialCharacters() {
        // Test with input containing mixed special characters
        String input = "\"Hello\", it's a \\ test";
        String expected = "\\\"Hello\\\", it\\'s a \\\\ test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }
}



package org.jfree.chart.imagemap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.StringUtils;

public class slice4_ImageMapUtils_javascriptEscape_6_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testJavascriptEscape_NullInput() {
        // Test with null input, expecting an IllegalArgumentException
        ImageMapUtils.javascriptEscape(null);
    }

    @Test
    public void testJavascriptEscape_EmptyString() {
        // Test with empty string input
        String input = "";
        String expected = "";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_NoSpecialCharacters() {
        // Test with input containing no special characters
        String input = "HelloWorld";
        String expected = "HelloWorld";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_DoubleQuotes() {
        // Test with input containing double quotes
        String input = "He said, \"Hello\"";
        String expected = "He said, \\\"Hello\\\"";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_SingleQuotes() {
        // Test with input containing single quotes
        String input = "It's a test";
        String expected = "It\\'s a test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_Backslashes() {
        // Test with input containing backslashes
        String input = "Path\\to\\file";
        String expected = "Path\\\\to\\\\file";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_MixedSpecialCharacters() {
        // Test with input containing mixed special characters
        String input = "\"Hello\", it's a \\ test";
        String expected = "\\\"Hello\\\", it\\'s a \\\\ test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }
}



package org.jfree.chart.imagemap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.StringUtils;

public class slice1_ImageMapUtils_javascriptEscape_6_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testJavascriptEscape_NullInput() {
        // Test with null input, expecting an IllegalArgumentException
        ImageMapUtils.javascriptEscape(null);
    }

    @Test
    public void testJavascriptEscape_EmptyString() {
        // Test with empty string input
        String input = "";
        String expected = "";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_NoSpecialCharacters() {
        // Test with input containing no special characters
        String input = "HelloWorld";
        String expected = "HelloWorld";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_DoubleQuotes() {
        // Test with input containing double quotes
        String input = "He said, \"Hello\"";
        String expected = "He said, \\\"Hello\\\"";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_SingleQuotes() {
        // Test with input containing single quotes
        String input = "It's a test";
        String expected = "It\\'s a test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_Backslashes() {
        // Test with input containing backslashes
        String input = "Path\\to\\file";
        String expected = "Path\\\\to\\\\file";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_MixedSpecialCharacters() {
        // Test with input containing mixed special characters
        String input = "\"Hello\", it's a \\ test";
        String expected = "\\\"Hello\\\", it\\'s a \\\\ test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }
}



package org.jfree.chart.imagemap;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.PrintWriter;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.StringUtils;

public class slice3_ImageMapUtils_javascriptEscape_6_0_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testJavascriptEscape_NullInput() {
        // Test with null input, expecting an IllegalArgumentException
        ImageMapUtils.javascriptEscape(null);
    }

    @Test
    public void testJavascriptEscape_EmptyString() {
        // Test with empty string input
        String input = "";
        String expected = "";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_NoSpecialCharacters() {
        // Test with input containing no special characters
        String input = "HelloWorld";
        String expected = "HelloWorld";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_DoubleQuotes() {
        // Test with input containing double quotes
        String input = "He said, \"Hello\"";
        String expected = "He said, \\\"Hello\\\"";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_SingleQuotes() {
        // Test with input containing single quotes
        String input = "It's a test";
        String expected = "It\\'s a test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_Backslashes() {
        // Test with input containing backslashes
        String input = "Path\\to\\file";
        String expected = "Path\\\\to\\\\file";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testJavascriptEscape_MixedSpecialCharacters() {
        // Test with input containing mixed special characters
        String input = "\"Hello\", it's a \\ test";
        String expected = "\\\"Hello\\\", it\\'s a \\\\ test";
        String actual = ImageMapUtils.javascriptEscape(input);
        assertEquals(expected, actual);
    }
}




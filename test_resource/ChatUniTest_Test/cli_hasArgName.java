package org.apache.commons.cli;

import org.junit.Assert;
import org.junit.Test;

public class OptionTest {

    @Test
    public void testHasArgNameWhenArgNameIsNull() {
        Option option = new Option(null, false, null);
        option.setArgName(null);
        Assert.assertFalse("Expected hasArgName() to return false when argName is null", option.hasArgName());
    }

    @Test
    public void testHasArgNameWhenArgNameIsEmpty() {
        Option option = new Option(null, false, null);
        option.setArgName("");
        Assert.assertFalse("Expected hasArgName() to return false when argName is empty", option.hasArgName());
    }

    @Test
    public void testHasArgNameWhenArgNameIsNonEmpty() {
        Option option = new Option(null, false, null);
        option.setArgName("argValue");
        Assert.assertTrue("Expected hasArgName() to return true when argName is non-empty", option.hasArgName());
    }

    @Test
    public void testHasArgNameWhenInitializedUsingBuilderWithNoArgName() {
        Option option = Option.builder("testOption").build();
        Assert.assertFalse("Expected hasArgName() to return false when no argName is set using builder", option.hasArgName());
    }

    @Test
    public void testHasArgNameWhenInitializedUsingBuilderWithArgName() {
        Option option = Option.builder("testOption").argName("argValue").build();
        Assert.assertTrue("Expected hasArgName() to return true when argName is set using builder", option.hasArgName());
    }
}
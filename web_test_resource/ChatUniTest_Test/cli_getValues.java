package org.apache.commons.cli;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class OptionTest {
    
    private Option.Builder builder;
    private Option option;
    
    @Before
    public void setUp() {
        builder = Option.builder("a");
    }
    
    @Test
    public void testGetValues_NoValues_ExpectNull() {
        option = builder.hasArg().desc("Test option").build();
        assertNull("Expected null when no values are set", option.getValues());
    }
    
    @Test
    public void testGetValues_SingleValue() {
        option = builder.hasArg().desc("Test option").build();
        option.addValueForProcessing("testValue1");
        
        String[] values = option.getValues();
        assertNotNull("Expected non-null when values are set", values);
        assertEquals("Expected one value", 1, values.length);
        assertEquals("Expected value 'testValue1'", "testValue1", values[0]);
    }
    
    @Test
    public void testGetValues_MultipleValues() {
        option = builder.hasArgs().desc("Test option").build();
        option.addValueForProcessing("testValue1");
        option.addValueForProcessing("testValue2");
        
        String[] values = option.getValues();
        assertNotNull("Expected non-null when values are set", values);
        assertEquals("Expected two values", 2, values.length);
        assertEquals("Expected first value 'testValue1'", "testValue1", values[0]);
        assertEquals("Expected second value 'testValue2'", "testValue2", values[1]);
    }
    
    @Test
    public void testGetValues_AfterClearValues_ExpectNull() {
        option = builder.hasArgs().desc("Test option").build();
        option.addValueForProcessing("testValue1");
        
        option.clearValues();        
        assertNull("Expected null after values are cleared", option.getValues());
    }
}
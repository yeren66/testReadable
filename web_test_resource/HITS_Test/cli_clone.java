package org.apache.commons.cli;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.cli.Util.EMPTY_STRING_ARRAY;
import java.io.Serializable;
import java.util.Objects;

public class Option_clone_7_0_Test {

    @Test
    public void testClone() throws Exception {
        // Corrected constructor usage
        Option original = new Option("o", "This is a test option");
        // Use reflection to set the private field 'longOption'
        Field longOptionField = Option.class.getDeclaredField("longOption");
        longOptionField.setAccessible(true);
        longOptionField.set(original, "option");
        original.setRequired(true);
        original.setOptionalArg(true);
        original.setArgName("arg");
        original.setArgs(2);
        original.setType(Integer.class);
        original.addValueForProcessing("value1");
        original.addValueForProcessing("value2");
        Option cloned = (Option) original.clone();
        // Ensure the cloned object is not the same as the original
        Assert.assertNotSame(original, cloned);
        // Ensure cloned object has the same attributes
        Assert.assertEquals(longOptionField.get(original), longOptionField.get(cloned));
        Assert.assertEquals(original.getDescription(), cloned.getDescription());
        Assert.assertEquals(original.isRequired(), cloned.isRequired());
        Assert.assertEquals(original.hasOptionalArg(), cloned.hasOptionalArg());
        Assert.assertEquals(original.getArgName(), cloned.getArgName());
        Assert.assertEquals(original.getArgs(), cloned.getArgs());
        Assert.assertEquals(original.getType(), cloned.getType());
        Assert.assertEquals(original.getValuesList(), cloned.getValuesList());
        // Ensure the values list is a different instance
        Assert.assertNotSame(original.getValuesList(), cloned.getValuesList());
        Assert.assertEquals(original.getValuesList(), cloned.getValuesList());
    }
}

package org.apache.commons.cli;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelpFormatterTest {

    @Test
    public void testDefaultLeftPadding() {
        HelpFormatter formatter = new HelpFormatter();
        int leftPadding = formatter.getLeftPadding();
        assertEquals("The default left padding should be equal to DEFAULT_LEFT_PAD constant value", HelpFormatter.DEFAULT_LEFT_PAD, leftPadding);
    }

    @Test
    public void testSetLeftPadding() {
        HelpFormatter formatter = new HelpFormatter();
        int newPadding = 5;
        formatter.setLeftPadding(newPadding);
        int leftPadding = formatter.getLeftPadding();
        assertEquals("The left padding should be updated to the new value", newPadding, leftPadding);
    }

    @Test
    public void testSetLeftPaddingToZero() {
        HelpFormatter formatter = new HelpFormatter();
        int newPadding = 0;
        formatter.setLeftPadding(newPadding);
        int leftPadding = formatter.getLeftPadding();
        assertEquals("The left padding should be updated to zero", newPadding, leftPadding);
    }

    @Test
    public void testNegativeLeftPadding() {
        HelpFormatter formatter = new HelpFormatter();
        int newPadding = -3;
        formatter.setLeftPadding(newPadding);
        int leftPadding = formatter.getLeftPadding();
        assertEquals("The left padding should be updated to the negative value", newPadding, leftPadding);
    }
}
package org.jfree.chart.ui;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice0_TextAnchor_isLeft_0_0_Test {

    @Test
    public void testIsLeftWithBaselineLeft() {
        // Test if BASELINE_LEFT is recognized as left
        TextAnchor anchor = TextAnchor.BASELINE_LEFT;
        assertTrue(anchor.isLeft());
    }

    @Test
    public void testIsLeftWithBottomLeft() {
        // Test if BOTTOM_LEFT is recognized as left
        TextAnchor anchor = TextAnchor.BOTTOM_LEFT;
        assertTrue(anchor.isLeft());
    }

    @Test
    public void testIsLeftWithCenterLeft() {
        // Test if CENTER_LEFT is recognized as left
        TextAnchor anchor = TextAnchor.CENTER_LEFT;
        assertTrue(anchor.isLeft());
    }

    @Test
    public void testIsLeftWithHalfAscentLeft() {
        // Test if HALF_ASCENT_LEFT is recognized as left
        TextAnchor anchor = TextAnchor.HALF_ASCENT_LEFT;
        assertTrue(anchor.isLeft());
    }

    @Test
    public void testIsLeftWithTopLeft() {
        // Test if TOP_LEFT is recognized as left
        TextAnchor anchor = TextAnchor.TOP_LEFT;
        assertTrue(anchor.isLeft());
    }

    @Test
    public void testIsLeftWithNonLeftAnchor() {
        // Test if a non-left anchor is not recognized as left
        TextAnchor anchor = TextAnchor.TOP_CENTER;
        assertFalse(anchor.isLeft());
    }
}



package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice3_TextAnchor_isLeft_0_0_Test {

    @Test
    public void testIsLeftWithBaselineLeft() {
        TextAnchor anchor = TextAnchor.BASELINE_LEFT;
        assertTrue("Expected BASELINE_LEFT to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithBottomLeft() {
        TextAnchor anchor = TextAnchor.BOTTOM_LEFT;
        assertTrue("Expected BOTTOM_LEFT to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithCenterLeft() {
        TextAnchor anchor = TextAnchor.CENTER_LEFT;
        assertTrue("Expected CENTER_LEFT to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithHalfAscentLeft() {
        TextAnchor anchor = TextAnchor.HALF_ASCENT_LEFT;
        assertTrue("Expected HALF_ASCENT_LEFT to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithTopLeft() {
        TextAnchor anchor = TextAnchor.TOP_LEFT;
        assertTrue("Expected TOP_LEFT to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithTopCenter() {
        TextAnchor anchor = TextAnchor.TOP_CENTER;
        assertFalse("Expected TOP_CENTER not to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithTopRight() {
        TextAnchor anchor = TextAnchor.TOP_RIGHT;
        assertFalse("Expected TOP_RIGHT not to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithCenter() {
        TextAnchor anchor = TextAnchor.CENTER;
        assertFalse("Expected CENTER not to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithBaselineCenter() {
        TextAnchor anchor = TextAnchor.BASELINE_CENTER;
        assertFalse("Expected BASELINE_CENTER not to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithBottomRight() {
        TextAnchor anchor = TextAnchor.BOTTOM_RIGHT;
        assertFalse("Expected BOTTOM_RIGHT not to be left", anchor.isLeft());
    }
}



package org.jfree.chart.ui;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice2_TextAnchor_isLeft_0_0_Test {

    @Test
    public void testIsLeftWithCENTER_LEFT() {
        TextAnchor anchor = TextAnchor.CENTER_LEFT;
        assertTrue("Expected CENTER_LEFT to be considered as left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithTOP_LEFT() {
        TextAnchor anchor = TextAnchor.TOP_LEFT;
        assertTrue("Expected TOP_LEFT to be considered as left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithBOTTOM_LEFT() {
        TextAnchor anchor = TextAnchor.BOTTOM_LEFT;
        assertTrue("Expected BOTTOM_LEFT to be considered as left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithHALF_ASCENT_LEFT() {
        TextAnchor anchor = TextAnchor.HALF_ASCENT_LEFT;
        assertTrue("Expected HALF_ASCENT_LEFT to be considered as left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithBASELINE_LEFT() {
        TextAnchor anchor = TextAnchor.BASELINE_LEFT;
        assertTrue("Expected BASELINE_LEFT to be considered as left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithCENTER() {
        TextAnchor anchor = TextAnchor.CENTER;
        assertFalse("Expected CENTER not to be considered as left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithTOP_CENTER() {
        TextAnchor anchor = TextAnchor.TOP_CENTER;
        assertFalse("Expected TOP_CENTER not to be considered as left", anchor.isLeft());
    }

    @Test
    public void testIsLeftWithBOTTOM_RIGHT() {
        TextAnchor anchor = TextAnchor.BOTTOM_RIGHT;
        assertFalse("Expected BOTTOM_RIGHT not to be considered as left", anchor.isLeft());
    }
}



package org.jfree.chart.ui;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice4_TextAnchor_isLeft_0_0_Test {

    @Test
    public void testIsLeftWithTOP_LEFT() {
        // Check if TOP_LEFT is considered left
        assertTrue(TextAnchor.TOP_LEFT.isLeft());
    }

    @Test
    public void testIsLeftWithTOP_CENTER() {
        // Check if TOP_CENTER is not considered left
        assertFalse(TextAnchor.TOP_CENTER.isLeft());
    }

    @Test
    public void testIsLeftWithTOP_RIGHT() {
        // Check if TOP_RIGHT is not considered left
        assertFalse(TextAnchor.TOP_RIGHT.isLeft());
    }

    @Test
    public void testIsLeftWithHALF_ASCENT_LEFT() {
        // Check if HALF_ASCENT_LEFT is considered left
        assertTrue(TextAnchor.HALF_ASCENT_LEFT.isLeft());
    }

    @Test
    public void testIsLeftWithHALF_ASCENT_CENTER() {
        // Check if HALF_ASCENT_CENTER is not considered left
        assertFalse(TextAnchor.HALF_ASCENT_CENTER.isLeft());
    }

    @Test
    public void testIsLeftWithHALF_ASCENT_RIGHT() {
        // Check if HALF_ASCENT_RIGHT is not considered left
        assertFalse(TextAnchor.HALF_ASCENT_RIGHT.isLeft());
    }

    @Test
    public void testIsLeftWithCENTER_LEFT() {
        // Check if CENTER_LEFT is considered left
        assertTrue(TextAnchor.CENTER_LEFT.isLeft());
    }

    @Test
    public void testIsLeftWithCENTER() {
        // Check if CENTER is not considered left
        assertFalse(TextAnchor.CENTER.isLeft());
    }

    @Test
    public void testIsLeftWithCENTER_RIGHT() {
        // Check if CENTER_RIGHT is not considered left
        assertFalse(TextAnchor.CENTER_RIGHT.isLeft());
    }

    @Test
    public void testIsLeftWithBASELINE_LEFT() {
        // Check if BASELINE_LEFT is considered left
        assertTrue(TextAnchor.BASELINE_LEFT.isLeft());
    }

    @Test
    public void testIsLeftWithBASELINE_CENTER() {
        // Check if BASELINE_CENTER is not considered left
        assertFalse(TextAnchor.BASELINE_CENTER.isLeft());
    }

    @Test
    public void testIsLeftWithBASELINE_RIGHT() {
        // Check if BASELINE_RIGHT is not considered left
        assertFalse(TextAnchor.BASELINE_RIGHT.isLeft());
    }

    @Test
    public void testIsLeftWithBOTTOM_LEFT() {
        // Check if BOTTOM_LEFT is considered left
        assertTrue(TextAnchor.BOTTOM_LEFT.isLeft());
    }

    @Test
    public void testIsLeftWithBOTTOM_CENTER() {
        // Check if BOTTOM_CENTER is not considered left
        assertFalse(TextAnchor.BOTTOM_CENTER.isLeft());
    }

    @Test
    public void testIsLeftWithBOTTOM_RIGHT() {
        // Check if BOTTOM_RIGHT is not considered left
        assertFalse(TextAnchor.BOTTOM_RIGHT.isLeft());
    }
}



package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class slice1_TextAnchor_isLeft_0_0_Test {

    @Test
    public void testIsLeftForBOTTOM_LEFT() {
        TextAnchor anchor = TextAnchor.BOTTOM_LEFT;
        assertTrue("Expected BOTTOM_LEFT to be left", anchor.isLeft());
    }

    @Test
    public void testIsLeftForNotLeftAnchors() {
        TextAnchor[] notLeftAnchors = { TextAnchor.TOP_CENTER, TextAnchor.TOP_RIGHT, TextAnchor.HALF_ASCENT_CENTER, TextAnchor.HALF_ASCENT_RIGHT, TextAnchor.CENTER, TextAnchor.CENTER_RIGHT, TextAnchor.BASELINE_CENTER, TextAnchor.BASELINE_RIGHT, TextAnchor.BOTTOM_CENTER, TextAnchor.BOTTOM_RIGHT };
        for (TextAnchor anchor : notLeftAnchors) {
            assertFalse("Expected " + anchor + " not to be left", anchor.isLeft());
        }
    }

    @Test
    public void testIsLeftForOtherLeftAnchors() {
        TextAnchor[] leftAnchors = { TextAnchor.BASELINE_LEFT, TextAnchor.CENTER_LEFT, TextAnchor.HALF_ASCENT_LEFT, TextAnchor.TOP_LEFT };
        for (TextAnchor anchor : leftAnchors) {
            assertTrue("Expected " + anchor + " to be left", anchor.isLeft());
        }
    }
}




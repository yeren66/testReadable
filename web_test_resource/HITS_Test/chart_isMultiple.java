package org.jfree.chart.renderer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class slice0_OutlierList_isMultiple_4_0_Test {

    private OutlierList outlierListWithMultipleTrue;

    private OutlierList outlierListWithMultipleFalse;

    @Before
    public void setUp() {
        // Assume Outlier is another class and we have a constructor that accepts it.
        // We are not provided with Outlier implementation, so we use null for simplicity.
        outlierListWithMultipleTrue = new OutlierList(null);
        outlierListWithMultipleFalse = new OutlierList(null);
        // Use reflection to set the 'multiple' field since we don't have setter method
        try {
            java.lang.reflect.Field multipleField = OutlierList.class.getDeclaredField("multiple");
            multipleField.setAccessible(true);
            multipleField.set(outlierListWithMultipleTrue, true);
            multipleField.set(outlierListWithMultipleFalse, false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIsMultipleReturnsTrue() {
        assertTrue(outlierListWithMultipleTrue.isMultiple());
    }

    @Test
    public void testIsMultipleReturnsFalse() {
        assertFalse(outlierListWithMultipleFalse.isMultiple());
    }
}




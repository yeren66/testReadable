package com.google.gson.internal;

// package com.google.gson.internal;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List; // Added import for java.util.List
import javax.swing.JButton; // Added import for javax.swing.JButton

import org.junit.Test;

public class ReflectionAccessFilterHelperTest {

    @Test
    public void testIsJavaTypeWithJavaLangClass() {
        // Test with a class from the java.lang // package
        assertTrue(ReflectionAccessFilterHelper.isJavaType(String.class));
    }

    @Test
    public void testIsJavaTypeWithJavaUtilClass() {
        // Test with a class from the java.util // package
        assertTrue(ReflectionAccessFilterHelper.isJavaType(List.class));
    }

    @Test
    public void testIsJavaTypeWithJavaxClass() {
        // Test with a class from the javax // package
        assertTrue(ReflectionAccessFilterHelper.isJavaType(JButton.class));
    }

    @Test
    public void testIsJavaTypeWithCustomClass() {
        // Test with a custom class not in java or javax // packages
        assertFalse(ReflectionAccessFilterHelper.isJavaType(ReflectionAccessFilterHelperTest.class));
    }
}
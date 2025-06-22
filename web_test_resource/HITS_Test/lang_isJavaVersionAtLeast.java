package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;

public class slice0_SystemUtils_isJavaVersionAtLeast_13_0_Test {

    @Test
    public void testIsJavaVersionAtLeast_Java8() {
        // Assuming the current Java version is set to 1.8 for testing purposes
        boolean result = SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_1_8);
        assertTrue("Java 1.8 should be at least 1.8", result);
    }

    @Test
    public void testIsJavaVersionAtLeast_Java9() {
        // Assuming the current Java version is set to 1.8 for testing purposes
        boolean result = SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_9);
        assertFalse("Java 1.8 should not be at least 9", result);
    }

    @Test
    public void testIsJavaVersionAtLeast_Java11() {
        // Assuming the current Java version is set to 11 for testing purposes
        boolean result = SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_9);
        assertTrue("Java 11 should be at least 9", result);
    }

    @Test
    public void testIsJavaVersionAtLeast_SameVersion() {
        // Test when both versions are the same
        boolean result = SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_11);
        assertTrue("Java 11 should be at least 11", result);
    }

    @Test
    public void testIsJavaVersionAtLeast_HigherVersion() {
        // Test when the required version is higher than the current version
        boolean result = SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_12);
        assertFalse("Java 11 should not be at least 12", result);
    }
}




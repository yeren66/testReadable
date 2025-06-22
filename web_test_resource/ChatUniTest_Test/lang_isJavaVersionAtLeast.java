package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class SystemUtilsTest {

    @Test
    public void testIsJavaVersionAtLeastExactMatch() {
        JavaVersion currentVersion = JavaVersion.get(SystemUtils.JAVA_SPECIFICATION_VERSION);
        assertTrue("Expected isJavaVersionAtLeast to return true for exact match", 
                   SystemUtils.isJavaVersionAtLeast(currentVersion));
    }

    @Test
    public void testIsJavaVersionAtLeastHigherVersion() {
        JavaVersion lowerVersion = JavaVersion.JAVA_1_7;
        assertTrue("Expected isJavaVersionAtLeast to return true for lower required version", 
                   SystemUtils.isJavaVersionAtLeast(lowerVersion));
    }

    @Test
    public void testIsJavaVersionAtLeastLowerVersion() {
        // Check if current version is lower than 1.9 to make the test meaningful
        JavaVersion currentVersion = JavaVersion.get(SystemUtils.JAVA_SPECIFICATION_VERSION);
        
        if (currentVersion != JavaVersion.JAVA_1_8) {
            System.out.println("Skipping test since current Java version is not 1.8, it is: " + currentVersion);
            return; // Skip the test if we're not on Java 1.8
        }

        JavaVersion higherVersion = JavaVersion.JAVA_1_9;
        assertFalse("Expected isJavaVersionAtLeast to return false for higher required version", 
                    SystemUtils.isJavaVersionAtLeast(higherVersion));
    }

    @Test(expected = NullPointerException.class)
    public void testIsJavaVersionAtLeastNullVersion() {
        SystemUtils.isJavaVersionAtLeast(null);
    }
}
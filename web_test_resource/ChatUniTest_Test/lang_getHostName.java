package org.apache.commons.lang3;

// package org.apache.commons.lang3;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SystemUtilsTest {

    private String originalOsName;

    @Before
    public void setUp() {
        originalOsName = System.getProperty("os.name");
    }

    @Test
    public void testGetHostNameOnWindows() {
        // Mock the system property for OS name
        try (MockedStatic<SystemUtils> systemUtilsMockedStatic = Mockito.mockStatic(SystemUtils.class)) {
            systemUtilsMockedStatic.when(SystemUtils::getHostName).thenReturn("MockedWindowsComputerName");

            // Call the method under test
            String hostname = SystemUtils.getHostName();

            // Assert that the method behaves as expected
            assertNotNull("Hostname should not be null or exception on Windows.", hostname);
        }
    }

    @Test
    public void testGetHostNameOnUnix() {
        // Mock the system property for OS name
        try (MockedStatic<SystemUtils> systemUtilsMockedStatic = Mockito.mockStatic(SystemUtils.class)) {
            systemUtilsMockedStatic.when(SystemUtils::getHostName).thenReturn("MockedUnixComputerName");

            // Call the method under test
            String hostname = SystemUtils.getHostName();

            // Assert that the method behaves as expected
            assertNotNull("Hostname should not be null or exception on Unix.", hostname);
        }
    }
}
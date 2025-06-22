package org.apache.commons.lang3;

import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static com.github.stefanbirkner.systemlambda.SystemLambda.withEnvironmentVariable;

/**
 * Test class for verifying the behavior of SystemUtils.getHostName() under various conditions.
 * Covers normal behavior, boundary conditions, and exceptional cases for both Windows and non-Windows OS.
 */
class OutlierTest {

    private static final String WINDOWS_ENV_VARIABLE = "COMPUTERNAME";
    private static final String NON_WINDOWS_ENV_VARIABLE = "HOSTNAME";

    @BeforeEach
    void setUp() {
        // Common setup logic can be added here if needed.
    }

    @Test
    @DisplayName("Retrieve host name on Windows OS with COMPUTERNAME set")
    void testGetHostNameOnWindows() {
        try (MockedStatic<System> mockedSystem = mockStatic(System.class)) {
            mockedSystem.when(() -> System.getenv(WINDOWS_ENV_VARIABLE)).thenReturn("TEST_COMPUTER_NAME");

            // Arrange
            String expectedHostName = "TEST_COMPUTER_NAME";

            // Act
            String actualHostName = SystemUtils.getHostName();

            // Assert
            assertNotNull(actualHostName, "Hostname should not be null");
            assertEquals(expectedHostName, actualHostName, "Hostname should match the expected environment variable value");
        }
    }

    @Test
    @DisplayName("Retrieve host name on non-Windows OS with HOSTNAME set")
    void testGetHostNameOnNonWindows() {
        try (MockedStatic<System> mockedSystem = mockStatic(System.class)) {
            mockedSystem.when(() -> System.getenv(NON_WINDOWS_ENV_VARIABLE)).thenReturn("mocked-hostname");

            // Arrange
            String expectedHostName = "mocked-hostname";

            // Act
            String actualHostName = SystemUtils.getHostName();

            // Assert
            assertNotNull(actualHostName, "Hostname should not be null");
            assertEquals(expectedHostName, actualHostName, "Hostname should match the expected environment variable value");
        }
    }

    @Test
    @DisplayName("Boundary condition: COMPUTERNAME not set on Windows OS")
    void testGetHostNameWhenComputerNameNotSetOnWindows() {
        try (MockedStatic<SystemUtils> mockedStatic = mockStatic(SystemUtils.class)) {
            mockedStatic.when(SystemUtils::getHostName).thenAnswer(invocation -> {
                if (SystemUtils.IS_OS_WINDOWS) {
                    return System.getenv(WINDOWS_ENV_VARIABLE);
                } else {
                    return System.getenv(NON_WINDOWS_ENV_VARIABLE);
                }
            });

            mockedStatic.when(() -> SystemUtils.IS_OS_WINDOWS).thenReturn(true);

            // Act
            String hostName = SystemUtils.getHostName();

            // Assert
            assertNull(hostName, "HostName should be null when COMPUTERNAME is not set on Windows");
        }
    }

    @Test
    @DisplayName("Boundary condition: HOSTNAME not set on non-Windows OS")
    void testGetHostNameWhenHostNameNotSetOnNonWindows() {
        try (MockedStatic<SystemUtils> mockedStatic = mockStatic(SystemUtils.class)) {
            mockedStatic.when(SystemUtils::getHostName).thenAnswer(invocation -> {
                if (!SystemUtils.IS_OS_WINDOWS) {
                    return System.getenv(NON_WINDOWS_ENV_VARIABLE);
                } else {
                    return System.getenv(WINDOWS_ENV_VARIABLE);
                }
            });

            mockedStatic.when(() -> SystemUtils.IS_OS_WINDOWS).thenReturn(false);

            // Act
            String hostName = SystemUtils.getHostName();

            // Assert
            assertNull(hostName, "HostName should be null when HOSTNAME is not set on non-Windows OS");
        }
    }

    @Test
    @DisplayName("Exceptional case: Environment variable contains special characters")
    void testGetHostNameWithSpecialCharacters() throws Exception {
        withEnvironmentVariable(NON_WINDOWS_ENV_VARIABLE, "special@Host!123")
            .and(WINDOWS_ENV_VARIABLE, "special@Host!123")
            .execute(() -> {
                // Arrange
                String expectedHostName = "special@Host!123";

                // Act
                String hostName = SystemUtils.getHostName();

                // Assert
                assertEquals(expectedHostName, hostName, "HostName should match the environment variable value, including special characters");
            });
    }
}
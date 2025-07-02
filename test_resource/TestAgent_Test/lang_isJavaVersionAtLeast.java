import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of SystemUtils.isJavaVersionAtLeast method.
 * Covers various scenarios including normal cases, boundary conditions, and exceptional inputs.
 */
public class OutlierTest {

    private JavaVersion currentJavaVersion;

    /**
     * Sets up common fixtures for the tests.
     * Assumes the current Java version is Java 11 for deterministic testing.
     */
    @BeforeEach
    void setUp() {
        currentJavaVersion = JavaVersion.JAVA_11; // Assume current Java version is Java 11
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method returns true for a normal case where the current Java version is greater than the required version.', 'Input_Type': 'A JavaVersion object representing a version less than the current Java version.', 'Output_Type': 'The method should return true.'}
     */
    @Test
    @DisplayName("Should return true when current Java version is greater than required version")
    void testIsJavaVersionAtLeast_GreaterThanRequiredVersion() {
        // Arrange
        JavaVersion requiredVersion = JavaVersion.JAVA_1_8; // Required version is less than current version

        // Act
        boolean result = SystemUtils.isJavaVersionAtLeast(requiredVersion);

        // Assert
        assertTrue(result, "Expected true when current Java version is greater than required version");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure that the method returns true in the boundary condition where the current Java version exactly matches the required version.', 'Input_Type': 'A JavaVersion object representing the current Java version.', 'Output_Type': 'The method should return true.'}
     */
    @Test
    @DisplayName("Should return true when current Java version matches required version")
    void testIsJavaVersionAtLeast_WhenCurrentVersionMatchesRequiredVersion_ShouldReturnTrue() {
        // Arrange
        JavaVersion requiredVersion = currentJavaVersion; // Required version matches current version

        // Act
        boolean result = SystemUtils.isJavaVersionAtLeast(requiredVersion);

        // Assert
        assertTrue(result, "Expected true when current Java version matches required version");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check that the method returns false for a normal case where the current Java version is less than the required version.', 'Input_Type': 'A JavaVersion object representing a version greater than the current Java version.', 'Output_Type': 'The method should return false.'}
     */
    @Test
    @DisplayName("Should return false when current Java version is less than required version")
    void testIsJavaVersionAtLeast_WhenCurrentVersionIsLessThanRequiredVersion_ShouldReturnFalse() {
        // Arrange
        JavaVersion requiredVersion = JavaVersion.JAVA_13; // Required version is greater than current version

        // Act
        boolean result = SystemUtils.isJavaVersionAtLeast(requiredVersion);

        // Assert
        assertFalse(result, "Expected false when current Java version is less than required version");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test the method's handling of exceptional input where the JavaVersion object is null.", 'Input_Type': 'A null JavaVersion object.', 'Output_Type': 'The method should handle this gracefully, potentially throwing an IllegalArgumentException or similar.'}
     */
    @Test
    @DisplayName("Should throw IllegalArgumentException when input is null")
    void testIsJavaVersionAtLeast_NullInput_ShouldThrowException() {
        // Arrange
        JavaVersion nullVersion = null; // Null input

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            SystemUtils.isJavaVersionAtLeast(nullVersion);
        }, "Expected IllegalArgumentException when input is null");

        // Verify exception message (optional, if applicable)
        assertNotNull(exception.getMessage(), "Exception message should not be null");
    }
}
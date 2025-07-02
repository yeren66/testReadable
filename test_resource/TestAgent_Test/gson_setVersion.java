import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link GsonBuilder#setVersion(double)} method.
 * <p>
 * This test class verifies the behavior of the setVersion method under various conditions:
 * - Normal conditions with valid positive version numbers.
 * - Boundary conditions with a version number of 0.0.
 * - Exceptional cases with invalid inputs such as negative numbers and NaN.
 */
public class OutlierTest {

    private GsonBuilder gsonBuilder;

    /**
     * Sets up a new {@link GsonBuilder} instance before each test.
     */
    @BeforeEach
    public void setUp() {
        gsonBuilder = new GsonBuilder();
    }

    /**
     * @implNote Test Purpose: Verify that the method behaves correctly under normal conditions
     * with a typical positive version number.
     * Input Type: A valid positive version number, such as 1.0.
     * Output Type: The method should return the same GsonBuilder instance without throwing
     * any exceptions, and the excluder should be set with the provided version.
     */
    @Test
    @DisplayName("setVersion with valid positive version should return the same GsonBuilder instance")
    public void setVersion_withValidPositiveVersion_shouldReturnSameInstance() {
        // Arrange
        double version = 1.0;

        // Act
        GsonBuilder returnedBuilder = gsonBuilder.setVersion(version);

        // Assert
        assertSame(gsonBuilder, returnedBuilder, "The method should return the same GsonBuilder instance.");
    }

    /**
     * @implNote Test Purpose: Check the method's behavior with a boundary condition where
     * the version number is zero.
     * Input Type: A version number of 0.0, which is the boundary of valid versions.
     * Output Type: The method should return the same GsonBuilder instance without throwing
     * any exceptions, and the excluder should be set with version 0.0.
     */
    @Test
    @DisplayName("setVersion with version 0.0 should return the same GsonBuilder instance")
    public void setVersion_withBoundaryZero_shouldReturnSameInstance() {
        // Arrange
        double version = 0.0;

        // Act
        GsonBuilder returnedBuilder = gsonBuilder.setVersion(version);

        // Assert
        assertNotNull(returnedBuilder, "The returned GsonBuilder instance should not be null.");
        assertSame(gsonBuilder, returnedBuilder, "The method should return the same GsonBuilder instance.");
    }

    /**
     * @implNote Test Purpose: Verify that the method handles and rejects an invalid input
     * where the version number is negative.
     * Input Type: A negative version number, such as -1.0.
     * Output Type: The method should throw an IllegalArgumentException due to the invalid version number.
     */
    @Test
    @DisplayName("setVersion with negative version should throw IllegalArgumentException")
    public void setVersion_withNegativeVersion_shouldThrowIllegalArgumentException() {
        // Arrange
        double version = -1.0;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gsonBuilder.setVersion(version);
        }, "Expected IllegalArgumentException to be thrown for negative version numbers.");
        assertNotNull(exception, "The exception should not be null.");
    }

    /**
     * @implNote Test Purpose: Test the exceptional case where the version number is NaN
     * to ensure it's properly handled.
     * Input Type: A version number that is NaN (Not-a-Number).
     * Output Type: The method should throw an IllegalArgumentException as NaN is considered invalid.
     */
    @Test
    @DisplayName("setVersion with NaN should throw IllegalArgumentException")
    public void setVersion_withNaN_shouldThrowIllegalArgumentException() {
        // Arrange
        double version = Double.NaN;

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gsonBuilder.setVersion(version);
        }, "Expected IllegalArgumentException to be thrown for NaN version numbers.");
        assertNotNull(exception, "The exception should not be null.");
    }
}
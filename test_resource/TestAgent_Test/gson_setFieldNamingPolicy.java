import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the GsonBuilder class, specifically focusing on the behavior of the
 * setFieldNamingPolicy method under various scenarios, including normal, null, and boundary inputs.
 */
public class OutlierTest {

    private GsonBuilder gsonBuilder;

    /**
     * Sets up a new GsonBuilder instance before each test.
     */
    @BeforeEach
    void setUp() {
        gsonBuilder = new GsonBuilder();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior by setting a valid FieldNamingPolicy.',
     * 'Input_Type': 'A standard, valid FieldNamingPolicy such as LOWER_CASE_WITH_UNDERSCORES.',
     * 'Output_Type': 'A GsonBuilder instance configured with the specified naming policy.'}
     */
    @Test
    @DisplayName("Setting a valid FieldNamingPolicy should return the same GsonBuilder instance")
    void setFieldNamingPolicy_validPolicy_returnsSameInstance() {
        // Arrange
        FieldNamingPolicy policy = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

        // Act
        GsonBuilder result = gsonBuilder.setFieldNamingPolicy(policy);

        // Assert
        assertNotNull(result, "The result should not be null");
        assertSame(gsonBuilder, result, "The returned GsonBuilder should be the same instance");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior with null input to check for handling of invalid input.',
     * 'Input_Type': 'A null value for FieldNamingPolicy.',
     * 'Output_Type': 'An exception should be thrown, preferably an IllegalArgumentException, indicating that the input is invalid.'}
     */
    @Test
    @DisplayName("Setting a null FieldNamingPolicy should throw IllegalArgumentException")
    void setFieldNamingPolicy_nullPolicy_throwsIllegalArgumentException() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            gsonBuilder.setFieldNamingPolicy(null);
        }, "Expected IllegalArgumentException to be thrown when setting a null FieldNamingPolicy");

        // Assert exception message (if applicable)
        assertNotNull(exception.getMessage(), "Exception message should not be null");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test with boundary input by passing a FieldNamingPolicy with minimum possible constraints.',
     * 'Input_Type': 'A simple and valid FieldNamingPolicy such as IDENTITY that performs no transformation.',
     * 'Output_Type': 'A GsonBuilder instance configured with the IDENTITY naming policy, ensuring that fields are serialized and deserialized with no renaming.'}
     */
    @Test
    @DisplayName("Setting the IDENTITY FieldNamingPolicy should return the same GsonBuilder instance")
    void setFieldNamingPolicy_identityPolicy_returnsSameInstance() {
        // Arrange
        FieldNamingPolicy policy = FieldNamingPolicy.IDENTITY;

        // Act
        GsonBuilder result = gsonBuilder.setFieldNamingPolicy(policy);

        // Assert
        assertNotNull(result, "The result should not be null");
        assertSame(gsonBuilder, result, "The returned GsonBuilder should be the same instance");
    }
}
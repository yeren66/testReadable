import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.JsonElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;

/**
 * Test class for verifying the behavior of GsonBuilder's setLongSerializationPolicy method.
 * Covers normal behavior, boundary conditions with custom policies, and exception handling for invalid inputs.
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
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior by setting a valid LongSerializationPolicy.', 
     * 'Input_Type': 'A valid instance of LongSerializationPolicy such as LongSerializationPolicy.DEFAULT.', 
     * 'Output_Type': 'The method should return the same GsonBuilder instance, indicating that the policy was set successfully.'}
     */
    @Test
    @DisplayName("Should return the same GsonBuilder instance when setting a valid LongSerializationPolicy")
    void setLongSerializationPolicy_withValidPolicy_returnsSameInstance() {
        // Arrange
        LongSerializationPolicy policy = LongSerializationPolicy.DEFAULT;

        // Act
        GsonBuilder returnedBuilder = gsonBuilder.setLongSerializationPolicy(policy);

        // Assert
        assertSame(gsonBuilder, returnedBuilder, 
            "The returned GsonBuilder instance should be the same as the original instance");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with a custom LongSerializationPolicy implementation.', 
     * 'Input_Type': 'A custom implementation of LongSerializationPolicy to ensure flexibility in accommodating different policies.', 
     * 'Output_Type': 'The method should return the same GsonBuilder instance, indicating the custom policy was set correctly.'}
     */
    @Test
    @DisplayName("Should return the same GsonBuilder instance when setting a custom LongSerializationPolicy")
    void setLongSerializationPolicy_withCustomPolicy_returnsSameInstance() {
        // Arrange
        LongSerializationPolicy customPolicy = mock(LongSerializationPolicy.class);
        JsonElement mockElement = mock(JsonElement.class);
        when(customPolicy.serialize(anyLong())).thenReturn(mockElement);

        // Act
        GsonBuilder returnedBuilder = gsonBuilder.setLongSerializationPolicy(customPolicy);

        // Assert
        assertSame(gsonBuilder, returnedBuilder, 
            "The method should return the same GsonBuilder instance when a custom policy is set");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure exception handling by providing a null LongSerializationPolicy.', 
     * 'Input_Type': 'A null value for LongSerializationPolicy, representing an invalid input scenario.', 
     * 'Output_Type': 'The method should throw a NullPointerException, ensuring that a null policy is not accepted.'}
     */
    @Test
    @DisplayName("Should throw NullPointerException when setting a null LongSerializationPolicy")
    void setLongSerializationPolicy_withNullPolicy_throwsException() {
        // Act & Assert
        assertThrows(NullPointerException.class, 
            () -> gsonBuilder.setLongSerializationPolicy(null), 
            "The method should throw a NullPointerException when a null policy is provided");
    }
}
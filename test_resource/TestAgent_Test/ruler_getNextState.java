package software.amazon.event.ruler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import software.amazon.event.ruler.NameState;
import software.amazon.event.ruler.SingleStateNameMatcher;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link SingleStateNameMatcher}.
 * Covers scenarios for normal behavior, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private SingleStateNameMatcher singleStateNameMatcher;

    /**
     * Sets up the test fixture before each test.
     * Initializes {@link SingleStateNameMatcher} and provides utility methods for manipulating private fields.
     */
    @BeforeEach
    void setUp() {
        singleStateNameMatcher = new SingleStateNameMatcher();
    }

    /**
     * Helper method to set the private field 'nameState' in {@link SingleStateNameMatcher}.
     *
     * @param matcher The instance of {@link SingleStateNameMatcher}.
     * @param state   The {@link NameState} instance to set.
     */
    private void setPrivateNameState(SingleStateNameMatcher matcher, NameState state) {
        try {
            Field field = SingleStateNameMatcher.class.getDeclaredField("nameState");
            field.setAccessible(true);
            field.set(matcher, state);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set nameState field", e);
        }
    }

    /**
     * Test normal behavior where nameState is set to a valid instance of NameState.
     *
     * @implNote {'Test_Purpose': 'Verify normal behavior where nameState is set to a valid instance of NameState.', 
     * 'Input_Type': 'A valid instance of NameState assigned to the nameState field.', 
     * 'Output_Type': 'The method should return the exact instance of NameState that is assigned to nameState.'}
     */
    @Test
    @DisplayName("Should return the exact instance of NameState when nameState is valid")
    void testGetNextState_ReturnsAssignedNameState() {
        // Arrange
        NameState nameStateMock = Mockito.mock(NameState.class);
        setPrivateNameState(singleStateNameMatcher, nameStateMock);

        // Act
        NameState result = singleStateNameMatcher.getNextState();

        // Assert
        assertSame(nameStateMock, result, "getNextState should return the exact instance set in nameState");
    }

    /**
     * Test boundary condition where nameState might be assigned a boundary value within the valid NameState range.
     *
     * @implNote {'Test_Purpose': 'Test boundary condition where nameState might be assigned a boundary value within the valid NameState range.', 
     * 'Input_Type': 'An edge case instance of NameState, such as the smallest valid value or one with minimum configurations.', 
     * 'Output_Type': 'The method should return the edge case instance, verifying that boundary values are handled properly.'}
     */
    @Test
    @DisplayName("Should return the edge case instance of NameState when nameState is a boundary value")
    void testGetNextState_BoundaryValue() {
        // Arrange
        NameState boundaryNameStateMock = Mockito.mock(NameState.class);
        setPrivateNameState(singleStateNameMatcher, boundaryNameStateMock);

        // Act
        NameState result = singleStateNameMatcher.getNextState();

        // Assert
        assertSame(boundaryNameStateMock, result, "The method should return the edge case instance.");
    }

    /**
     * Handle exceptional scenario where nameState is null.
     *
     * @implNote {'Test_Purpose': 'Handle exceptional scenario where nameState is null.', 
     * 'Input_Type': 'nameState is explicitly set to null.', 
     * 'Output_Type': 'The method should return null, testing the system’s resilience to null values.'}
     */
    @Test
    @DisplayName("Should return null when nameState is explicitly set to null")
    void testGetNextStateWhenNameStateIsNull() {
        // Arrange
        setPrivateNameState(singleStateNameMatcher, null);

        // Act
        NameState result = singleStateNameMatcher.getNextState();

        // Assert
        assertNull(result, "getNextState should return null when nameState is null");
    }
}
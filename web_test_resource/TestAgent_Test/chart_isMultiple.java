import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for OutlierList, focusing on the behavior of the 'multiple' variable.
 * Covers normal behavior, edge cases, and default initialization.
 */
public class OutlierTest {

    private OutlierList outlierList;

    /**
     * Common setup for all tests. Initializes the OutlierList instance.
     */
    @BeforeEach
    void setUp() {
        // Assuming null is a valid Outlier for initial setup
        outlierList = new OutlierList(null);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify normal behavior when 'multiple' is true, indicating the list contains multiple outliers.", 
     * 'Input_Type': "Valid input where the instance variable 'multiple' is set to true.", 
     * 'Output_Type': 'The method should return true.'}
     */
    @Test
    @DisplayName("When 'multiple' is true, isMultiple() should return true")
    void isMultiple_WhenMultipleIsTrue_ShouldReturnTrue() {
        // Arrange
        outlierList.setMultiple(true); // Setting the 'multiple' variable to true

        // Act
        boolean result = outlierList.isMultiple();

        // Assert
        assertTrue(result, "The method should return true when 'multiple' is set to true.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Verify normal behavior when 'multiple' is false, indicating the list does not contain multiple outliers.", 
     * 'Input_Type': "Valid input where the instance variable 'multiple' is set to false.", 
     * 'Output_Type': 'The method should return false.'}
     */
    @Test
    @DisplayName("When 'multiple' is false, isMultiple() should return false")
    void isMultiple_WhenMultipleIsFalse_ShouldReturnFalse() {
        // Arrange
        outlierList.setMultiple(false); // Setting the 'multiple' variable to false

        // Act
        boolean result = outlierList.isMultiple();

        // Assert
        assertFalse(result, "The method should return false when 'multiple' is set to false.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Ensure boundary conditions are correctly handled, testing if the method can handle changes to the variable 'multiple'.", 
     * 'Input_Type': "Edge case input where 'multiple' transitions from false to true.", 
     * 'Output_Type': 'The method should correctly reflect the change in its return value, returning true after modification.'}
     */
    @Test
    @DisplayName("Transition 'multiple' from false to true and verify isMultiple() reflects the change")
    void isMultiple_TransitionFromFalseToTrue_ShouldReflectChange() {
        // Arrange
        outlierList.setMultiple(false); // Initially set 'multiple' to false
        assertFalse(outlierList.isMultiple(), "Initial state of 'multiple' should be false.");

        // Act
        outlierList.setMultiple(true); // Change 'multiple' to true

        // Assert
        assertTrue(outlierList.isMultiple(), "The method should return true after 'multiple' is set to true.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test the exceptional case where the state of 'multiple' is left uninitialized.", 
     * 'Input_Type': "Invalid input where 'multiple' is not explicitly set prior to method invocation.", 
     * 'Output_Type': 'The expected behavior is determined by the default initialization; typically, false unless specified otherwise.'}
     */
    @Test
    @DisplayName("Default state of 'multiple' should be false when uninitialized")
    void isMultiple_DefaultState_ShouldBeFalse() {
        // Act
        boolean result = outlierList.isMultiple();

        // Assert
        assertFalse(result, "The default state of 'multiple' should be false when uninitialized.");
    }
}
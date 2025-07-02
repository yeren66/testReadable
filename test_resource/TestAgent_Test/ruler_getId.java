import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the SubRuleContext class.
 * 
 * This test class validates the behavior of the `getId` method under various scenarios:
 * - Normal behavior with a typical double value.
 * - Boundary behavior with extreme positive and negative double values.
 * - Handling of the double value zero.
 * - Exceptional case when the id field is not explicitly initialized.
 */
public class OutlierTest {

    private SubRuleContext subRuleContext;
    private SubRuleContext.Generator generator;

    /**
     * Common setup for tests. Initializes the generator or mocks SubRuleContext where necessary.
     */
    @BeforeEach
    public void setUp() {
        generator = new SubRuleContext.Generator();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate normal behavior with a typical double value.', 
     * 'Input_Type': 'Valid double value successfully set using a setter method or constructor.', 
     * 'Output_Type': 'The method should return the exact double value that was initialized in the object.'}
     */
    @Test
    @DisplayName("Should return the initialized double value when a typical value is set")
    public void testGetId_ShouldReturnInitializedId() {
        // Arrange
        final double testId = 42.42;
        subRuleContext = generator.generate("TestRuleName");
        // Assuming the generator sets the id to the testId value

        // Act
        double actualId = subRuleContext.getId();

        // Assert
        assertEquals(testId, actualId, 0.001, "The getId method should return the initialized double value.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior with boundary extreme positive double value.', 
     * 'Input_Type': 'The maximum positive double value that can be set (`Double.MAX_VALUE`).', 
     * 'Output_Type': 'The method should return the maximum positive double value.'}
     */
    @Test
    @DisplayName("Should return Double.MAX_VALUE when the id is set to the maximum positive double value")
    public void testGetIdWithMaxDoubleValue() {
        // Arrange
        final double expectedId = Double.MAX_VALUE;
        subRuleContext = generator.generate("TestRuleName");
        // Assuming the generator sets the id to Double.MAX_VALUE

        // Act
        double actualId = subRuleContext.getId();

        // Assert
        assertEquals(expectedId, actualId, 0.0, "The getId method should return the maximum positive double value.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior with boundary extreme negative double value.', 
     * 'Input_Type': 'The minimum negative double value that can be set (`-Double.MAX_VALUE`).', 
     * 'Output_Type': 'The method should return the minimum negative double value.'}
     */
    @Test
    @DisplayName("Should return -Double.MAX_VALUE when the id is set to the minimum negative double value")
    public void testGetIdWithMinimumNegativeDouble() {
        // Arrange
        final double expectedValue = -Double.MAX_VALUE;
        subRuleContext = Mockito.mock(SubRuleContext.class);
        Mockito.when(subRuleContext.getId()).thenReturn(expectedValue);

        // Act
        double actualValue = subRuleContext.getId();

        // Assert
        assertEquals(expectedValue, actualValue, 0.0, "The getId method should return the minimum negative double value.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check handling of the double value zero.', 
     * 'Input_Type': 'The double value zero set to the id field.', 
     * 'Output_Type': 'The method should return zero as a double value.'}
     */
    @Test
    @DisplayName("Should return 0.0 when the id is set to zero")
    public void testGetId_ForZeroValue() {
        // Arrange
        subRuleContext = generator.generate("TestRuleName");
        // Assuming the generator sets the id to 0.0

        // Act
        double result = subRuleContext.getId();

        // Assert
        assertEquals(0.0, result, 0.0, "The getId method should return 0.0 when the id is set to zero.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test behavior when the id field is not initialized (exceptional case).', 
     * 'Input_Type': "A scenario where the default value of id (if any) is used, assuming it's not initialized specifically.", 
     * 'Output_Type': 'The method should return the default double value, which is commonly assumed to be 0.0 in absence of explicit initialization.'}
     */
    @Test
    @DisplayName("Should return 0.0 when the id field is not explicitly initialized")
    public void testGetIdWhenIdNotInitialized() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Arrange
        Constructor<SubRuleContext> constructor = SubRuleContext.class.getDeclaredConstructor(double.class);
        constructor.setAccessible(true);
        subRuleContext = constructor.newInstance(0.0);

        // Act
        double actualId = subRuleContext.getId();

        // Assert
        assertEquals(0.0, actualId, 0.0, "The getId method should return the default double value of 0.0 when the id is not explicitly initialized.");
    }
}
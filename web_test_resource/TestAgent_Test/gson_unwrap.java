import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test class for verifying the behavior of the Primitives.unwrap method.
 * Covers various input types including wrapper types, primitive types, non-wrapper/non-primitive types,
 * Void wrapper type, and null input.
 */
public class OutlierTest {

    private Class<?> wrapperClass;
    private Class<?> primitiveClass;
    private Class<?> nonWrapperNonPrimitiveClass;
    private Class<?> voidWrapperClass;

    @BeforeEach
    void setUp() {
        // Common fixtures for tests
        wrapperClass = Integer.class; // Wrapper type
        primitiveClass = int.class; // Primitive type
        nonWrapperNonPrimitiveClass = String.class; // Non-wrapper, non-primitive type
        voidWrapperClass = Void.class; // Void wrapper type
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior when input is a wrapper type.',
     * 'Input_Type': 'Class object of a wrapper type, such as Integer.class.',
     * 'Output_Type': 'The primitive type corresponding to the wrapper type, such as int.class.'}
     */
    @Test
    @DisplayName("Unwrap wrapper type (Integer.class) to primitive type (int.class)")
    void unwrapWrapperTypeToPrimitive() {
        // Arrange
        Class<?> input = wrapperClass;

        // Act
        Class<?> result = Primitives.unwrap(input);

        // Assert
        assertEquals(int.class, result, "Expected primitive type corresponding to the wrapper type.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior when input is a primitive type.',
     * 'Input_Type': 'Class object of a primitive type, such as int.class.',
     * 'Output_Type': 'The same primitive type as input, such as int.class.'}
     */
    @Test
    @DisplayName("Unwrap primitive type (int.class) to itself")
    void unwrapPrimitiveTypeToItself() {
        // Arrange
        Class<?> input = primitiveClass;

        // Act
        Class<?> result = Primitives.unwrap(input);

        // Assert
        assertEquals(int.class, result, "Expected the same primitive type as input.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior for non-wrapper, non-primitive types.',
     * 'Input_Type': 'Class object of a non-wrapper and non-primitive type, such as String.class.',
     * 'Output_Type': 'The same type as input, such as String.class.'}
     */
    @Test
    @DisplayName("Unwrap non-wrapper, non-primitive type (String.class) to itself")
    void unwrapNonWrapperNonPrimitiveTypeToItself() {
        // Arrange
        Class<?> input = nonWrapperNonPrimitiveClass;

        // Act
        Class<?> result = Primitives.unwrap(input);

        // Assert
        assertEquals(String.class, result, "Expected the same class for non-wrapper, non-primitive type.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify boundary condition when input is the Void wrapper type.',
     * 'Input_Type': 'Class object of the Void wrapper type, Void.class.',
     * 'Output_Type': 'The primitive void type, void.class.'}
     */
    @Test
    @DisplayName("Unwrap Void wrapper type (Void.class) to primitive void type (void.class)")
    void unwrapVoidWrapperTypeToPrimitiveVoid() {
        // Arrange
        Class<?> input = voidWrapperClass;

        // Act
        Class<?> result = Primitives.unwrap(input);

        // Assert
        assertEquals(void.class, result, "Expected primitive void type corresponding to the Void wrapper type.");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check behavior on unexpected input type (boundary case).',
     * 'Input_Type': 'A null input representing no class at all.',
     * 'Output_Type': 'The method would raise a NullPointerException, as it cannot process null.'}
     */
    @Test
    @DisplayName("Unwrap null input should throw NullPointerException")
    void unwrapNullInputThrowsException() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> Primitives.unwrap(null), "Expected NullPointerException for null input.");
    }
}
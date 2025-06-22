import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the behavior of the MultiByte class.
 * Covers scenarios for normal behavior, edge cases, and exceptional cases.
 */
public class OutlierTest {

    private MultiByte nonEmptyMultiByte;

    /**
     * Sets up common fixtures for tests.
     * Initializes a MultiByte instance with a non-empty byte array.
     */
    @BeforeEach
    void setUp() {
        // Initialize MultiByte with a non-empty byte array
        byte[] initialBytes = {10, 20, 30, 40, 50};
        nonEmptyMultiByte = new MultiByte(initialBytes);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify normal behavior of copying a non-empty byte array.', 
     * 'Input_Type': 'A non-empty byte array with arbitrary data.', 
     * 'Output_Type': 'A new byte array with the same length and content as the original.'}
     */
    @Test
    @DisplayName("Verify copying a non-empty byte array returns a new array with identical content")
    void testGetBytesReturnsCopyOfNonEmptyByteArray() {
        // Arrange
        byte[] expectedBytes = {10, 20, 30, 40, 50};

        // Act
        byte[] resultBytes = nonEmptyMultiByte.getBytes();

        // Assert
        assertArrayEquals(expectedBytes, resultBytes, 
                "The returned byte array should have the same content as the original");
        assertNotSame(nonEmptyMultiByte.getBytes(), resultBytes, 
                "The returned byte array should be a different instance from the original");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Validate behavior when the byte array is empty.', 
     * 'Input_Type': 'An empty byte array.', 
     * 'Output_Type': 'An empty byte array should be returned, indicating no loss or modification of data.'}
     */
    @Test
    @DisplayName("Constructor with empty array should throw IllegalArgumentException")
    void testConstructorWithEmptyArrayThrowsException() {
        // Arrange & Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new MultiByte(new byte[0]),
                "Creating a MultiByte object with an empty array should throw IllegalArgumentException");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': "Test the method's response to the internal array being null (exceptional case).", 
     * 'Input_Type': 'A null byte array.', 
     * 'Output_Type': 'An exception should occur, likely a NullPointerException, indicating improper handling of null arrays.'}
     */
    @Test
    @DisplayName("Constructor with null byte array should throw NullPointerException")
    void testConstructorWithNullByteArrayThrowsException() {
        // Arrange & Act
        Exception exception = assertThrows(InvocationTargetException.class, () -> {
            MultiByte.class.getDeclaredConstructor(byte[].class).newInstance((Object) null);
        });

        // Assert
        assertTrue(exception.getCause() instanceof NullPointerException, 
                "The cause of the InvocationTargetException should be a NullPointerException");
    }
}
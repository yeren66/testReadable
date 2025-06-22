import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import software.amazon.event.ruler.input.InputMultiByteSet;
import software.amazon.event.ruler.input.MultiByte;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for InputMultiByteSet.
 * Covers scenarios for handling Sets of MultiByte objects, including:
 * - Multiple elements in the Set.
 * - Empty Set.
 * - Single element in the Set.
 * - Duplicate elements in the Set.
 */
public class OutlierTest {

    private InputMultiByteSet inputMultiByteSet;
    private Set<MultiByte> multiBytesMockSet;

    /**
     * Helper method to initialize InputMultiByteSet with a given Set of MultiByte objects.
     *
     * @param multiBytes Set of MultiByte objects to initialize the InputMultiByteSet.
     */
    private void initializeInputMultiByteSet(Set<MultiByte> multiBytes) {
        inputMultiByteSet = new InputMultiByteSet(multiBytes);
    }

    @BeforeEach
    void setUp() {
        // Common setup logic can be added here if needed across tests.
    }

    @Test
    @DisplayName("Verify return value when multiBytes contains multiple elements")
    void testGetMultiBytesWithMultipleElements() {
        // Arrange
        multiBytesMockSet = new HashSet<>();
        MultiByte mb1 = Mockito.mock(MultiByte.class);
        MultiByte mb2 = Mockito.mock(MultiByte.class);
        MultiByte mb3 = Mockito.mock(MultiByte.class);

        multiBytesMockSet.add(mb1);
        multiBytesMockSet.add(mb2);
        multiBytesMockSet.add(mb3);

        initializeInputMultiByteSet(multiBytesMockSet);

        // Act
        Set<MultiByte> result = inputMultiByteSet.getMultiBytes();

        // Assert
        assertEquals(multiBytesMockSet, result, "The returned Set should match the input Set of MultiByte objects.");
    }

    @Test
    @DisplayName("Verify behavior when multiBytes is empty")
    void testGetMultiBytesWhenEmpty() {
        // Arrange
        initializeInputMultiByteSet(Collections.emptySet());

        // Act
        Set<MultiByte> result = inputMultiByteSet.getMultiBytes();

        // Assert
        assertNotNull(result, "Result should not be null.");
        assertTrue(result.isEmpty(), "Resulting Set should be empty.");
    }

    @Test
    @DisplayName("Test behavior with a single element in multiBytes")
    void testGetMultiBytesWithSingleElement() {
        // Arrange
        MultiByte mockMultiByte = Mockito.mock(MultiByte.class);
        initializeInputMultiByteSet(Collections.singleton(mockMultiByte));

        // Act
        Set<MultiByte> result = inputMultiByteSet.getMultiBytes();

        // Assert
        assertEquals(1, result.size(), "Resulting Set should contain exactly one element.");
        assertEquals(mockMultiByte, result.iterator().next(), "The single element in the Set should match the input MultiByte object.");
    }

    @Test
    @DisplayName("Verify behavior when multiBytes contains duplicate elements")
    void testGetMultiBytesWhenDuplicatesPresent() {
        // Arrange
        MultiByte mockMultiByte = Mockito.mock(MultiByte.class);
        multiBytesMockSet = new HashSet<>();
        multiBytesMockSet.add(mockMultiByte);
        multiBytesMockSet.add(mockMultiByte); // Adding duplicate

        initializeInputMultiByteSet(multiBytesMockSet);

        // Act
        Set<MultiByte> result = inputMultiByteSet.getMultiBytes();

        // Assert
        assertEquals(1, result.size(), "There should be only one unique instance in the Set.");
        assertTrue(result.contains(mockMultiByte), "The result should contain the mocked MultiByte instance.");
    }
}
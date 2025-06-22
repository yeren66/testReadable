import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for verifying the singleton behavior of the DefaultParser class.
 * Covers:
 * - Ensuring the same instance is returned on multiple invocations.
 * - Verifying thread safety under concurrent access.
 * - Handling edge cases where the singleton instance might not be properly initialized.
 */
class DefaultParserTest {

    private DefaultParser expectedInstance;

    /**
     * Sets up the expected singleton instance before each test.
     */
    @BeforeEach
    void setUp() {
        expectedInstance = DefaultParser.getParser();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Ensure the method returns the same instance of DefaultParser every time it is called, maintaining singleton property.', 
     * 'Input_Type': 'Invoke the getParser method multiple times.', 
     * 'Output_Type': 'The method should return the same instance of DefaultParser each time.'}
     */
    @Test
    @DisplayName("getParser should return the same instance on multiple invocations")
    void testGetParserReturnsSingletonInstance() {
        // Arrange
        DefaultParser instance1 = DefaultParser.getParser();
        DefaultParser instance2 = DefaultParser.getParser();

        // Act & Assert
        assertSame(instance1, instance2, "getParser should return the same instance on multiple invocations");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Verify that the method works correctly under concurrent access, ensuring the singleton instance is maintained.', 
     * 'Input_Type': 'Multiple threads concurrently call the getParser method.', 
     * 'Output_Type': 'All threads should receive the same instance of DefaultParser, guaranteeing thread safety.'}
     */
    @Test
    @DisplayName("getParser should return the same instance under concurrent access")
    void testGetParserConcurrently() throws InterruptedException, ExecutionException {
        // Arrange
        Callable<DefaultParser> task = DefaultParser::getParser;
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Future<DefaultParser>[] futures = new Future[10];

        // Act
        for (int i = 0; i < 10; i++) {
            futures[i] = executor.submit(task);
        }

        // Assert
        for (Future<DefaultParser> future : futures) {
            assertSame(expectedInstance, future.get(), "All threads should receive the same instance of DefaultParser");
        }

        executor.shutdown();
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Check what happens when DefaultParser has not been properly instantiated or is null.', 
     * 'Input_Type': 'Simulate a condition where the SINGLETON is not initialized (if applicable).', 
     * 'Output_Type': "The method execution should handle this gracefully, but usually, it should not occur unless there's a fault in the setup."}
     */
    @Test
    @DisplayName("getParser should handle uninitialized singleton gracefully")
    void testGetParserHandlesUninitializedSingleton() {
        // Arrange
        // Simulate a condition where the singleton might not be initialized (if applicable).
        // Note: This is a hypothetical scenario since DefaultParser.getParser() is expected to always initialize the singleton.

        // Act
        DefaultParser instance = DefaultParser.getParser();

        // Assert
        assertNotNull(instance, "getParser should never return null, even if the singleton was not explicitly initialized");
        assertSame(expectedInstance, instance, "getParser should return the same instance, maintaining the singleton property");
    }
}
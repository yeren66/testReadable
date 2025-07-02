package software.amazon.event.ruler.input;

import org.junit.Assert;
import org.junit.Test;

public class DefaultParserTest {

    // Test for the singleton instance retrieval
    @Test
    public void testSingletonInstance() {
        // Retrieve the singleton instance
        DefaultParser parser1 = DefaultParser.getParser();
        DefaultParser parser2 = DefaultParser.getParser();
        
        // Assert that both retrieved instances are the same
        Assert.assertNotNull("Singleton instance should not be null", parser1);
        Assert.assertSame("getParser should always return the same instance", parser1, parser2);
    }
}
package software.amazon.event.ruler.input;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import software.amazon.event.ruler.MatchType;
import java.nio.charset.StandardCharsets;
import static software.amazon.event.ruler.MatchType.ANYTHING_BUT_IGNORE_CASE;
import static software.amazon.event.ruler.MatchType.ANYTHING_BUT_SUFFIX;
import static software.amazon.event.ruler.MatchType.ANYTHING_BUT_WILDCARD;
import static software.amazon.event.ruler.MatchType.EQUALS_IGNORE_CASE;
import static software.amazon.event.ruler.MatchType.PREFIX_EQUALS_IGNORE_CASE;
import static software.amazon.event.ruler.MatchType.SUFFIX;
import static software.amazon.event.ruler.MatchType.SUFFIX_EQUALS_IGNORE_CASE;
import static software.amazon.event.ruler.MatchType.WILDCARD;

public class slice0_DefaultParser_getParser_0_0_Test {

    @Test
    public void testGetParserSingleton() {
        // Test to ensure that getParser() returns a non-null instance
        DefaultParser parserInstance1 = DefaultParser.getParser();
        Assert.assertNotNull("The parser instance should not be null", parserInstance1);
        // Test to ensure that getParser() returns the same instance on subsequent calls
        DefaultParser parserInstance2 = DefaultParser.getParser();
        Assert.assertSame("The parser instances should be the same", parserInstance1, parserInstance2);
    }

    @Test
    public void testGetParserThreadSafety() throws InterruptedException {
        // Test to ensure thread-safe access to the singleton instance
        final DefaultParser[] parserInstances = new DefaultParser[2];
        Thread thread1 = new Thread(() -> parserInstances[0] = DefaultParser.getParser());
        Thread thread2 = new Thread(() -> parserInstances[1] = DefaultParser.getParser());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Assert.assertNotNull("The parser instance from thread1 should not be null", parserInstances[0]);
        Assert.assertNotNull("The parser instance from thread2 should not be null", parserInstances[1]);
        Assert.assertSame("The parser instances from both threads should be the same", parserInstances[0], parserInstances[1]);
    }
}




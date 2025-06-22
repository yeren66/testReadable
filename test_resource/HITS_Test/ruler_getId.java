package software.amazon.event.ruler;

import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class slice0_SubRuleContext_getId_0_0_Test {

    @Test
    public void testGetId() {
        // Using reflection to access the private constructor
        double expectedId = 123.45;
        SubRuleContext subRuleContext = createSubRuleContext(expectedId);
        // Call the method under test
        double actualId = subRuleContext.getId();
        // Assert the expected value
        Assert.assertEquals(expectedId, actualId, 0.0);
    }

    private SubRuleContext createSubRuleContext(double id) {
        try {
            Constructor<SubRuleContext> constructor = SubRuleContext.class.getDeclaredConstructor(double.class);
            constructor.setAccessible(true);
            return constructor.newInstance(id);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException("Failed to create instance of SubRuleContext", e);
        }
    }
}




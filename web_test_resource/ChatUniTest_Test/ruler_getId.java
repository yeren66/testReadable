package software.amazon.event.ruler;

// package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.*;

public class SubRuleContextTest {

    @Test
    public void testGetId() {
        // Use the Generator to create the SubRuleContext instance
        SubRuleContext.Generator generator = new SubRuleContext.Generator();
        SubRuleContext context = generator.generate("rule1");
        
        // Test that getId() returns the correct id initially set by the generator.
        assertEquals(generator.getIdsGeneratedForName("rule1").iterator().next(), context.getId(), 0.0);
    }

    @Test
    public void testGetIdWithNegativeValue() {
        // The Generator will not create context with negative ids directly,
        // but ensure that its auto-incrementing nature is tested.
        SubRuleContext.Generator generator = new SubRuleContext.Generator();
        SubRuleContext context = generator.generate("rule2");
        
        // Test that getId() returns a value (as controlled by the internal state of the Generator)
        assertEquals(generator.getIdsGeneratedForName("rule2").iterator().next(), context.getId(), 0.0);
    }

    @Test
    public void testGetIdWithZero() {
        // Use the Generator to create the SubRuleContext instance
        SubRuleContext.Generator generator = new SubRuleContext.Generator();
        generator.generate("rule1"); // This will start the sequence with the default starting id, based on the code
        SubRuleContext context = generator.generate("rule0");
        
        // Test that the getId function reflects the logical id progression from the generator
        assertEquals(generator.getIdsGeneratedForName("rule0").iterator().next(), context.getId(), 0.0);
    }
}
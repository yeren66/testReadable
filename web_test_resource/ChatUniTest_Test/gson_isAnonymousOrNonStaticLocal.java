package com.google.gson.internal.reflect;

// package com.google.gson.internal.reflect;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReflectionHelperTest {

    @Test
    public void testIsAnonymousOrNonStaticLocalWithRegularClass() {
        // Test with a regular class that is neither anonymous nor local nor static
        assertFalse("Expected regular class not to be anonymous or non-static local.",
                ReflectionHelper.isAnonymousOrNonStaticLocal(TestClass.class));
    }

    @Test
    public void testIsAnonymousOrNonStaticLocalWithAnonymousClass() {
        // Create an anonymous class
        Object anonymousClassInstance = new Object() {};
        Class<?> anonymousClass = anonymousClassInstance.getClass();
        
        assertTrue("Expected anonymous class to be anonymous or non-static local.",
                ReflectionHelper.isAnonymousOrNonStaticLocal(anonymousClass));
    }

    @Test
    public void testIsAnonymousOrNonStaticLocalWithNonStaticLocalClass() {
        // Create a local class inside a method, which is non-static by nature
        class LocalClass {}
        assertTrue("Expected non-static local class to be anonymous or non-static local.",
                ReflectionHelper.isAnonymousOrNonStaticLocal(LocalClass.class));
    }

    @Test
    public void testIsAnonymousOrNonStaticLocalWithStaticNestedClass() {
        assertFalse("Expected static nested class not to be anonymous or non-static local.",
                ReflectionHelper.isAnonymousOrNonStaticLocal(StaticNestedClass.class));
    }

    @Test
    public void testIsAnonymousOrNonStaticLocalWithInnerClass() {
        // Since InnerClass is now static, it is neither anonymous nor non-static local, thus the expectation is false.
        Class<?> innerClass = InnerClass.class;
        
        assertFalse("Expected static inner class not to be anonymous or non-static local.",
                ReflectionHelper.isAnonymousOrNonStaticLocal(innerClass));
    }

    // Test classes for testing purposes
    private static class StaticNestedClass {}

    private static class InnerClass {}

    private static class TestClass {}
}
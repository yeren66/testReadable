package com.google.gson.internal.reflect;

// package com.google.gson.internal.reflect;

import org.junit.Test;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class ReflectionHelperTest {

    @SuppressWarnings("unused")
    private static class TestClass {
        private int field;

        public TestClass() {}

        public void method() {} 
    }

    @Test
    public void testGetAccessibleObjectDescriptionWithField() throws NoSuchFieldException {
        Field field = TestClass.class.getDeclaredField("field");
        AccessibleObject obj = field;

        String description = ReflectionHelper.getAccessibleObjectDescription(obj, false);
        assertEquals("field 'com.google.gson.internal.reflect.ReflectionHelperTest$TestClass#field'", description);

        description = ReflectionHelper.getAccessibleObjectDescription(obj, true);
        assertEquals("Field 'com.google.gson.internal.reflect.ReflectionHelperTest$TestClass#field'", description);
    }

    @Test
    public void testGetAccessibleObjectDescriptionWithMethod() throws NoSuchMethodException {
        Method method = TestClass.class.getDeclaredMethod("method");
        AccessibleObject obj = method;

        String description = ReflectionHelper.getAccessibleObjectDescription(obj, false);
        assertEquals("method 'com.google.gson.internal.reflect.ReflectionHelperTest$TestClass#method()'", description);

        description = ReflectionHelper.getAccessibleObjectDescription(obj, true);
        assertEquals("Method 'com.google.gson.internal.reflect.ReflectionHelperTest$TestClass#method()'", description);
    }

    @Test
    public void testGetAccessibleObjectDescriptionWithConstructor() throws NoSuchMethodException {
        Constructor<TestClass> constructor = TestClass.class.getDeclaredConstructor();
        AccessibleObject obj = constructor;

        String description = ReflectionHelper.getAccessibleObjectDescription(obj, false);
        assertEquals("constructor 'com.google.gson.internal.reflect.ReflectionHelperTest$TestClass()'", description);

        description = ReflectionHelper.getAccessibleObjectDescription(obj, true);
        assertEquals("Constructor 'com.google.gson.internal.reflect.ReflectionHelperTest$TestClass()'", description);
    }

    @Test
    public void testGetAccessibleObjectDescriptionWithUnknownObject() throws NoSuchFieldException {
        Field field = TestClass.class.getDeclaredField("field");
        AccessibleObject obj = field;

        String description = ReflectionHelper.getAccessibleObjectDescription(obj, false);
        assertEquals("field 'com.google.gson.internal.reflect.ReflectionHelperTest$TestClass#field'", description);

        description = ReflectionHelper.getAccessibleObjectDescription(obj, true);
        assertEquals("Field 'com.google.gson.internal.reflect.ReflectionHelperTest$TestClass#field'", description);
    }
}
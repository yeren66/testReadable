package com.google.gson.internal;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.ReflectionAccessFilter.FilterResult;
import java.lang.reflect.AccessibleObject;
import java.util.List;

public class slice1_ReflectionAccessFilterHelper_isJavaType_1_0_Test {

    @Test
    public void testIsJavaType_withJavaPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(null, "java.util.List"));
        assertTrue((boolean) method.invoke(null, "java.lang.String"));
        assertTrue((boolean) method.invoke(null, "java.io.File"));
    }

    @Test
    public void testIsJavaType_withJavaxPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(null, "javax.swing.JButton"));
        assertTrue((boolean) method.invoke(null, "javax.xml.parsers.DocumentBuilder"));
    }

    @Test
    public void testIsJavaType_withoutJavaPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(null, "com.example.MyClass"));
        assertFalse((boolean) method.invoke(null, "org.apache.commons.StringUtils"));
        assertFalse((boolean) method.invoke(null, "net.sf.json.JSONObject"));
    }

    @Test
    public void testIsJavaType_withEmptyString() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(null, ""));
    }
}



package com.google.gson.internal;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.ReflectionAccessFilter.FilterResult;
import java.lang.reflect.AccessibleObject;
import java.util.List;

public class slice0_ReflectionAccessFilterHelper_isJavaType_1_0_Test {

    @Test
    public void testIsJavaType_withJavaPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(null, "java.util.List"));
        assertTrue((boolean) method.invoke(null, "java.lang.String"));
        assertTrue((boolean) method.invoke(null, "java.io.File"));
    }

    @Test
    public void testIsJavaType_withJavaxPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(null, "javax.swing.JButton"));
        assertTrue((boolean) method.invoke(null, "javax.xml.parsers.DocumentBuilder"));
    }

    @Test
    public void testIsJavaType_withoutJavaPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(null, "com.example.MyClass"));
        assertFalse((boolean) method.invoke(null, "org.apache.commons.StringUtils"));
        assertFalse((boolean) method.invoke(null, "net.sf.json.JSONObject"));
    }

    @Test
    public void testIsJavaType_withEmptyString() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(null, ""));
    }
}



package com.google.gson.internal;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.ReflectionAccessFilter.FilterResult;
import java.lang.reflect.AccessibleObject;
import java.util.List;

public class slice2_ReflectionAccessFilterHelper_isJavaType_1_0_Test {

    @Test
    public void testIsJavaType_withJavaPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(null, "java.util.List"));
        assertTrue((boolean) method.invoke(null, "java.lang.String"));
        assertTrue((boolean) method.invoke(null, "java.io.File"));
    }

    @Test
    public void testIsJavaType_withJavaxPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertTrue((boolean) method.invoke(null, "javax.swing.JButton"));
        assertTrue((boolean) method.invoke(null, "javax.xml.parsers.DocumentBuilder"));
    }

    @Test
    public void testIsJavaType_withoutJavaPrefix() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(null, "com.example.MyClass"));
        assertFalse((boolean) method.invoke(null, "org.apache.commons.StringUtils"));
        assertFalse((boolean) method.invoke(null, "net.sf.json.JSONObject"));
    }

    @Test
    public void testIsJavaType_withEmptyString() throws Exception {
        Method method = ReflectionAccessFilterHelper.class.getDeclaredMethod("isJavaType", String.class);
        method.setAccessible(true);
        assertFalse((boolean) method.invoke(null, ""));
    }
}




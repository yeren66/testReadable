package org.apache.commons.lang3;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
// Added import for Collections
import java.util.Collections;
import java.io.File;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class slice1_SystemUtils_getHostName_1_0_Test {

    private String originalOsName;

    @Before
    public void setUp() {
        originalOsName = System.getProperty("os.name");
    }

    @After
    public void tearDown() {
        // Reset the os.name system property to its original value
        System.setProperty("os.name", originalOsName);
        // Clear the environment variable set during the test
        setEnv(new HashMap<>());
    }

    @Test
    public void testGetHostNameOnWindows() {
        setOsName("Windows 10");
        String expectedHostName = "WINDOWS_HOSTNAME";
        setEnv("COMPUTERNAME", expectedHostName);
        String actualHostName = SystemUtils.getHostName();
        Assert.assertEquals(expectedHostName, actualHostName);
    }

    @Test
    public void testGetHostNameOnUnix() {
        setOsName("Linux");
        String expectedHostName = "UNIX_HOSTNAME";
        setEnv("HOSTNAME", expectedHostName);
        String actualHostName = SystemUtils.getHostName();
        Assert.assertEquals(expectedHostName, actualHostName);
    }

    private void setOsName(String osName) {
        System.setProperty("os.name", osName);
    }

    private void setEnv(String key, String value) {
        Map<String, String> newenv = new HashMap<>();
        newenv.put(key, value);
        setEnv(newenv);
    }

    private void setEnv(Map<String, String> newenv) {
        try {
            Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");
            Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
            theEnvironmentField.setAccessible(true);
            Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
            env.putAll(newenv);
            Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
            theCaseInsensitiveEnvironmentField.setAccessible(true);
            Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
            cienv.putAll(newenv);
        } catch (NoSuchFieldException e) {
            try {
                Class[] classes = Collections.class.getDeclaredClasses();
                Map<String, String> env = System.getenv();
                for (Class cl : classes) {
                    if ("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
                        Field field = cl.getDeclaredField("m");
                        field.setAccessible(true);
                        Object obj = field.get(env);
                        Map<String, String> map = (Map<String, String>) obj;
                        map.clear();
                        map.putAll(newenv);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}



package org.apache.commons.lang3;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
// Removed import for Collections
import java.io.File;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;

public class slice2_SystemUtils_getHostName_1_0_Test {

    private String originalOsName;

    @Before
    public void setUp() {
        originalOsName = System.getProperty("os.name");
    }

    @After
    public void tearDown() {
        // Reset the os.name system property to its original value
        System.setProperty("os.name", originalOsName);
        // Clear the environment variable set during the test
        clearEnv();
    }

    @Test
    public void testGetHostNameOnWindows() {
        setOsName("Windows 10");
        String expectedHostName = "WINDOWS_HOSTNAME";
        setEnv("COMPUTERNAME", expectedHostName);
        String actualHostName = SystemUtils.getHostName();
        Assert.assertEquals(expectedHostName, actualHostName);
    }

    @Test
    public void testGetHostNameOnUnix() {
        setOsName("Linux");
        String expectedHostName = "UNIX_HOSTNAME";
        setEnv("HOSTNAME", expectedHostName);
        String actualHostName = SystemUtils.getHostName();
        Assert.assertEquals(expectedHostName, actualHostName);
    }

    private void setOsName(String osName) {
        System.setProperty("os.name", osName);
    }

    private void setEnv(String key, String value) {
        try {
            Map<String, String> env = System.getenv();
            Field field = env.getClass().getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map<String, String>) field.get(env);
            writableEnv.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearEnv() {
        try {
            Map<String, String> env = System.getenv();
            Field field = env.getClass().getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map<String, String>) field.get(env);
            writableEnv.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




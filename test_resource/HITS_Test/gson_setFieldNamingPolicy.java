package com.google.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static com.google.gson.Gson.DEFAULT_COMPLEX_MAP_KEYS;
import static com.google.gson.Gson.DEFAULT_DATE_PATTERN;
import static com.google.gson.Gson.DEFAULT_ESCAPE_HTML;
import static com.google.gson.Gson.DEFAULT_FORMATTING_STYLE;
import static com.google.gson.Gson.DEFAULT_JSON_NON_EXECUTABLE;
import static com.google.gson.Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
import static com.google.gson.Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
import static com.google.gson.Gson.DEFAULT_SERIALIZE_NULLS;
import static com.google.gson.Gson.DEFAULT_SPECIALIZE_FLOAT_VALUES;
import static com.google.gson.Gson.DEFAULT_STRICTNESS;
import static com.google.gson.Gson.DEFAULT_USE_JDK_UNSAFE;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class slice0_GsonBuilder_setFieldNamingPolicy_8_0_Test {

    private GsonBuilder gsonBuilder;

    @Before
    public void setUp() {
        gsonBuilder = new GsonBuilder();
    }

    @Test
    public void testSetFieldNamingPolicy_identity() throws Exception {
        // Arrange
        FieldNamingPolicy namingPolicy = FieldNamingPolicy.IDENTITY;
        // Act
        GsonBuilder result = gsonBuilder.setFieldNamingPolicy(namingPolicy);
        // Assert
        assertNotNull(result);
        assertEquals(namingPolicy, getFieldNamingPolicy(gsonBuilder));
    }

    @Test
    public void testSetFieldNamingPolicy_upperCamelCase() throws Exception {
        // Arrange
        FieldNamingPolicy namingPolicy = FieldNamingPolicy.UPPER_CAMEL_CASE;
        // Act
        GsonBuilder result = gsonBuilder.setFieldNamingPolicy(namingPolicy);
        // Assert
        assertNotNull(result);
        assertEquals(namingPolicy, getFieldNamingPolicy(gsonBuilder));
    }

    @Test
    public void testSetFieldNamingPolicy_upperCamelCaseWithSpaces() throws Exception {
        // Arrange
        FieldNamingPolicy namingPolicy = FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES;
        // Act
        GsonBuilder result = gsonBuilder.setFieldNamingPolicy(namingPolicy);
        // Assert
        assertNotNull(result);
        assertEquals(namingPolicy, getFieldNamingPolicy(gsonBuilder));
    }

    @Test
    public void testSetFieldNamingPolicy_lowerCaseWithUnderscores() throws Exception {
        // Arrange
        FieldNamingPolicy namingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
        // Act
        GsonBuilder result = gsonBuilder.setFieldNamingPolicy(namingPolicy);
        // Assert
        assertNotNull(result);
        assertEquals(namingPolicy, getFieldNamingPolicy(gsonBuilder));
    }

    @Test
    public void testSetFieldNamingPolicy_lowerCaseWithDashes() throws Exception {
        // Arrange
        FieldNamingPolicy namingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_DASHES;
        // Act
        GsonBuilder result = gsonBuilder.setFieldNamingPolicy(namingPolicy);
        // Assert
        assertNotNull(result);
        assertEquals(namingPolicy, getFieldNamingPolicy(gsonBuilder));
    }

    @Test
    public void testSetFieldNamingPolicy_lowerCaseWithDots() throws Exception {
        // Arrange
        FieldNamingPolicy namingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_DOTS;
        // Act
        GsonBuilder result = gsonBuilder.setFieldNamingPolicy(namingPolicy);
        // Assert
        assertNotNull(result);
        assertEquals(namingPolicy, getFieldNamingPolicy(gsonBuilder));
    }

    // Utility method to access the private field using reflection
    private FieldNamingPolicy getFieldNamingPolicy(GsonBuilder gsonBuilder) throws Exception {
        Field field = GsonBuilder.class.getDeclaredField("fieldNamingPolicy");
        field.setAccessible(true);
        return (FieldNamingPolicy) field.get(gsonBuilder);
    }
}




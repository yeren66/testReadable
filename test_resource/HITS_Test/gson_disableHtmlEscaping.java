package com.google.gson;

import org.junit.Test;
import static org.junit.Assert.*;
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

public class slice0_GsonBuilder_disableHtmlEscaping_19_0_Test {

    @Test
    public void testDisableHtmlEscaping() {
        // Arrange
        GsonBuilder gsonBuilder = new GsonBuilder();
        // Act
        gsonBuilder.disableHtmlEscaping();
        // Assert
        assertFalse("HTML escaping should be disabled", isEscapeHtmlCharsEnabled(gsonBuilder));
    }

    @Test
    public void testDisableHtmlEscaping_DefaultValue() {
        // Arrange
        GsonBuilder gsonBuilder = new GsonBuilder();
        // Assert the default value before disabling HTML escaping
        assertTrue("Default value of escapeHtmlChars should be true", isEscapeHtmlCharsEnabled(gsonBuilder));
        // Act
        gsonBuilder.disableHtmlEscaping();
        // Assert the value after disabling HTML escaping
        assertFalse("HTML escaping should be disabled", isEscapeHtmlCharsEnabled(gsonBuilder));
    }

    private boolean isEscapeHtmlCharsEnabled(GsonBuilder gsonBuilder) {
        try {
            Field field = GsonBuilder.class.getDeclaredField("escapeHtmlChars");
            field.setAccessible(true);
            return field.getBoolean(gsonBuilder);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}



package com.google.gson;

import org.junit.Test;
import static org.junit.Assert.*;
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

public class slice1_GsonBuilder_disableHtmlEscaping_19_0_Test {

    @Test
    public void testDisableHtmlEscaping() {
        // Arrange
        GsonBuilder gsonBuilder = new GsonBuilder();
        // Act
        gsonBuilder.disableHtmlEscaping();
        // Assert
        assertFalse("HTML escaping should be disabled", isEscapeHtmlCharsEnabled(gsonBuilder));
    }

    @Test
    public void testDisableHtmlEscaping_DefaultValue() {
        // Arrange
        GsonBuilder gsonBuilder = new GsonBuilder();
        // Assert the default value before disabling HTML escaping
        assertTrue("Default value of escapeHtmlChars should be true", isEscapeHtmlCharsEnabled(gsonBuilder));
        // Act
        gsonBuilder.disableHtmlEscaping();
        // Assert the value after disabling HTML escaping
        assertFalse("HTML escaping should be disabled", isEscapeHtmlCharsEnabled(gsonBuilder));
    }

    private boolean isEscapeHtmlCharsEnabled(GsonBuilder gsonBuilder) {
        try {
            Field field = GsonBuilder.class.getDeclaredField("escapeHtmlChars");
            field.setAccessible(true);
            return field.getBoolean(gsonBuilder);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}




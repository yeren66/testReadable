package com.google.gson;

// package com.google.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals; // Specify the needed import

public class GsonBuilderTest {

    @Test
    public void testDisableHtmlEscaping() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // Verify default state (HTML escaping enabled)
        Gson defaultGson = gsonBuilder.create();
        String htmlEscapedJson = defaultGson.toJson("<tag>");
        assertEquals("\"\\u003ctag\\u003e\"", htmlEscapedJson);

        // Call disableHtmlEscaping and verify state change
        gsonBuilder.disableHtmlEscaping();
        Gson gsonWithDisabledHtmlEscaping = gsonBuilder.create();
        String nonEscapedJson = gsonWithDisabledHtmlEscaping.toJson("<tag>");
        assertEquals("\"<tag>\"", nonEscapedJson);
    }
}
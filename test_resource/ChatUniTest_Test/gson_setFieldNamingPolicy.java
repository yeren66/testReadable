package com.google.gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GsonBuilderTest {

    @Test
    public void testSetFieldNamingPolicyIDENTITY() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        
        // Set FieldNamingPolicy to IDENTITY
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);

        // Verify if the fieldNamingPolicy in GsonBuilder is set to IDENTITY
        FieldNamingStrategy expected = FieldNamingPolicy.IDENTITY;
        FieldNamingStrategy actual = gsonBuilder.create().fieldNamingStrategy;
        
        assertEquals("Expects field naming strategy to be IDENTITY", expected, actual);
    }

    @Test
    public void testSetFieldNamingPolicyUPPER_CAMEL_CASE() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        
        // Set FieldNamingPolicy to UPPER_CAMEL_CASE
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE);

        // Verify if the fieldNamingPolicy in GsonBuilder is set to UPPER_CAMEL_CASE
        FieldNamingStrategy expected = FieldNamingPolicy.UPPER_CAMEL_CASE;
        FieldNamingStrategy actual = gsonBuilder.create().fieldNamingStrategy;

        assertEquals("Expects field naming strategy to be UPPER_CAMEL_CASE", expected, actual);
    }

    @Test
    public void testSetFieldNamingPolicyUPPER_CAMEL_CASE_WITH_SPACES() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        
        // Set FieldNamingPolicy to UPPER_CAMEL_CASE_WITH_SPACES
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES);

        // Verify if the fieldNamingPolicy in GsonBuilder is set to UPPER_CAMEL_CASE_WITH_SPACES
        FieldNamingStrategy expected = FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES;
        FieldNamingStrategy actual = gsonBuilder.create().fieldNamingStrategy;
        
        assertEquals("Expects field naming strategy to be UPPER_CAMEL_CASE_WITH_SPACES", expected, actual);
    }

    @Test
    public void testSetFieldNamingPolicyLOWER_CASE_WITH_UNDERSCORES() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        
        // Set FieldNamingPolicy to LOWER_CASE_WITH_UNDERSCORES
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        // Verify if the fieldNamingPolicy in GsonBuilder is set to LOWER_CASE_WITH_UNDERSCORES
        FieldNamingStrategy expected = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
        FieldNamingStrategy actual = gsonBuilder.create().fieldNamingStrategy;
        
        assertEquals("Expects field naming strategy to be LOWER_CASE_WITH_UNDERSCORES", expected, actual);
    }

    @Test
    public void testSetFieldNamingPolicyLOWER_CASE_WITH_DOTS() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        
        // Set FieldNamingPolicy to LOWER_CASE_WITH_DOTS
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DOTS);

        // Verify if the fieldNamingPolicy in GsonBuilder is set to LOWER_CASE_WITH_DOTS
        FieldNamingStrategy expected = FieldNamingPolicy.LOWER_CASE_WITH_DOTS;
        FieldNamingStrategy actual = gsonBuilder.create().fieldNamingStrategy;
        
        assertEquals("Expects field naming strategy to be LOWER_CASE_WITH_DOTS", expected, actual);
    }
}
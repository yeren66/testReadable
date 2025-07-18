/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 08:52:46 GMT 2025
 */

package com.google.gson.internal;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.Strictness;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Excluder_ESTest extends Excluder_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Excluder excluder0 = new Excluder();
      Excluder excluder1 = excluder0.withVersion((-674.58039732328));
      Gson gson0 = new Gson();
      Class<Object> class0 = Object.class;
      TypeToken<Object> typeToken0 = TypeToken.get(class0);
      TypeAdapter<Object> typeAdapter0 = excluder1.create(gson0, typeToken0);
      assertNotSame(excluder1, excluder0);
      assertNull(typeAdapter0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      int[] intArray0 = new int[4];
      intArray0[0] = 14;
      intArray0[2] = 1691;
      Excluder excluder1 = excluder0.withModifiers(intArray0);
      assertNotSame(excluder1, excluder0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      Gson gson0 = new Gson();
      Class<Object> class0 = Object.class;
      TypeToken<Object> typeToken0 = TypeToken.get(class0);
      TypeAdapter<Object> typeAdapter0 = excluder0.create(gson0, typeToken0);
      assertNull(typeAdapter0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      Excluder excluder1 = excluder0.clone();
      assertNotSame(excluder0, excluder1);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Excluder excluder0 = new Excluder();
      // Undeclared exception!
      try { 
        excluder0.withModifiers((int[]) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.google.gson.internal.Excluder", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      // Undeclared exception!
      try { 
        excluder0.excludeField((Field) null, true);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.google.gson.internal.Excluder", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Excluder excluder0 = new Excluder();
      Excluder excluder1 = excluder0.withExclusionStrategy((ExclusionStrategy) null, false, true);
      Class<Object> class0 = Object.class;
      // Undeclared exception!
      try { 
        excluder1.excludeClass(class0, false);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.google.gson.internal.Excluder", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Excluder excluder0 = new Excluder();
      Gson gson0 = new Gson();
      // Undeclared exception!
      try { 
        excluder0.DEFAULT.create(gson0, (TypeToken<Excluder>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.google.gson.internal.Excluder", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Excluder excluder0 = new Excluder();
      Class<Object> class0 = Object.class;
      ExclusionStrategy exclusionStrategy0 = mock(ExclusionStrategy.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(exclusionStrategy0).shouldSkipClass(any(java.lang.Class.class));
      Excluder excluder1 = excluder0.withExclusionStrategy(exclusionStrategy0, true, true);
      boolean boolean0 = excluder1.excludeClass(class0, true);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Excluder excluder0 = new Excluder();
      Class<Strictness> class0 = Strictness.class;
      boolean boolean0 = excluder0.excludeClass(class0, false);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      ExclusionStrategy exclusionStrategy0 = mock(ExclusionStrategy.class, new ViolatedAssumptionAnswer());
      doReturn(false).when(exclusionStrategy0).shouldSkipClass(any(java.lang.Class.class));
      Excluder excluder1 = excluder0.withExclusionStrategy(exclusionStrategy0, true, true);
      Class<Strictness> class0 = Strictness.class;
      boolean boolean0 = excluder1.excludeClass(class0, true);
      assertFalse(boolean0);
      assertNotSame(excluder1, excluder0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Gson gson0 = new Gson();
      Class<Excluder> class0 = Excluder.class;
      try { 
        gson0.fromJson("tjA+I612']1<v*Ov", (Type) class0);
        fail("Expecting exception: RuntimeException");
      
      } catch(RuntimeException e) {
         //
         // org.evosuite.runtime.mock.java.lang.MockThrowable: Expected BEGIN_OBJECT but was STRING at line 1 column 1 path $
         // See https://github.com/google/gson/blob/main/Troubleshooting.md#unexpected-json-structure
         //
         verifyException("com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      Excluder excluder1 = excluder0.withExclusionStrategy((ExclusionStrategy) null, false, false);
      assertNotSame(excluder1, excluder0);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      Excluder excluder1 = excluder0.disableInnerClassSerialization();
      Class<Object> class0 = Object.class;
      boolean boolean0 = excluder1.excludeClass(class0, false);
      assertNotSame(excluder1, excluder0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      Excluder excluder1 = excluder0.withVersion(0);
      Class<Strictness> class0 = Strictness.class;
      boolean boolean0 = excluder1.excludeClass(class0, true);
      assertFalse(boolean0);
      assertNotSame(excluder1, excluder0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Excluder excluder0 = new Excluder();
      Excluder excluder1 = excluder0.excludeFieldsWithoutExposeAnnotation();
      assertNotSame(excluder1, excluder0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Excluder excluder0 = Excluder.DEFAULT;
      Gson gson0 = new Gson();
      Class<Strictness> class0 = Strictness.class;
      ExclusionStrategy exclusionStrategy0 = mock(ExclusionStrategy.class, new ViolatedAssumptionAnswer());
      doReturn(true, true).when(exclusionStrategy0).shouldSkipClass(any(java.lang.Class.class));
      Excluder excluder1 = excluder0.withExclusionStrategy(exclusionStrategy0, true, true);
      TypeToken<Strictness> typeToken0 = TypeToken.get(class0);
      TypeAdapter<Strictness> typeAdapter0 = excluder1.create(gson0, typeToken0);
      assertNotNull(typeAdapter0);
      assertNotSame(excluder0, excluder1);
  }
}

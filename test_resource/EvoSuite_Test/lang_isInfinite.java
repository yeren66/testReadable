/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 09:26:20 GMT 2025
 */

package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.lang3.mutable.MutableDouble;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class MutableDouble_ESTest extends MutableDouble_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-572.61417016));
      mutableDouble0.hashCode();
      assertEquals((-572.61417016), mutableDouble0.getValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Double double0 = new Double((-1836.996443499197));
      MutableDouble mutableDouble0 = new MutableDouble((Number) double0);
      MutableDouble mutableDouble1 = new MutableDouble((-810.0561875));
      boolean boolean0 = mutableDouble0.equals(mutableDouble1);
      assertFalse(boolean0);
      assertFalse(mutableDouble1.equals((Object)mutableDouble0));
      assertEquals((-810.0561875), mutableDouble1.doubleValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      mutableDouble0.subtract((Number) short0);
      assertEquals("0.0", mutableDouble0.toString());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-572.61417016));
      mutableDouble0.add((Number) mutableDouble0);
      assertEquals((byte) (-121), mutableDouble0.byteValue());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      Double double0 = mutableDouble0.toDouble();
      assertEquals(0.0, (double)double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-572.61417016));
      Double double0 = mutableDouble0.toDouble();
      assertEquals((-572.61417016), (double)double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1.0));
      mutableDouble0.subtract((-2170.93313));
      long long0 = mutableDouble0.longValue();
      assertEquals(2169L, long0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      mutableDouble0.decrementAndGet();
      long long0 = mutableDouble0.longValue();
      assertEquals((byte) (-1), mutableDouble0.byteValue());
      assertEquals((-1L), long0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      mutableDouble0.incrementAndGet();
      int int0 = mutableDouble0.intValue();
      assertEquals(1L, mutableDouble0.longValue());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1751.34620644035));
      int int0 = mutableDouble0.intValue();
      assertEquals((-1751), int0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      mutableDouble0.decrementAndGet();
      double double0 = mutableDouble0.incrementAndGet();
      assertEquals((byte)0, mutableDouble0.byteValue());
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-572.61417016));
      double double0 = mutableDouble0.incrementAndGet();
      assertEquals((-571.61417016), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      Double double0 = mutableDouble0.getValue();
      assertEquals(0.0, (double)double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      mutableDouble0.decrementAndGet();
      mutableDouble0.getValue();
      assertEquals((-1.0), mutableDouble0.getValue(), 0.01);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      mutableDouble0.getAndAdd(1891.111705256361);
      double double0 = mutableDouble0.getAndIncrement();
      assertEquals(1892.111705256361, mutableDouble0.getValue(), 0.01);
      assertEquals(1891.111705256361, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      mutableDouble0.getAndDecrement();
      double double0 = mutableDouble0.getAndIncrement();
      assertEquals((byte)0, mutableDouble0.byteValue());
      assertEquals((-1.0), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1751.34620644035));
      double double0 = mutableDouble0.getAndDecrement();
      assertEquals((-1752.3462F), mutableDouble0.floatValue(), 0.01F);
      assertEquals((-1751.34620644035), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-2568.6203456));
      mutableDouble0.subtract((-2568.6203456));
      Long long0 = new Long(0L);
      double double0 = mutableDouble0.getAndAdd((Number) long0);
      assertEquals(0L, mutableDouble0.longValue());
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      mutableDouble0.getAndAdd(1891.111705256361);
      double double0 = mutableDouble0.getAndAdd((Number) mutableDouble0);
      assertEquals((byte) (-58), mutableDouble0.byteValue());
      assertEquals(1891.111705256361, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-2268.3));
      Double double0 = new Double(0.0);
      double double1 = mutableDouble0.getAndAdd((Number) double0);
      assertEquals((-2268.3), double1, 0.01);
      assertEquals((-2268.3F), mutableDouble0.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      mutableDouble0.getAndDecrement();
      double double0 = mutableDouble0.getAndAdd((-1.0));
      assertEquals((short) (-2), mutableDouble0.shortValue());
      assertEquals((-1.0), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-2816.14189222));
      float float0 = mutableDouble0.floatValue();
      assertEquals((-2816.1418F), float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      mutableDouble0.getAndAdd(3313.4188);
      double double0 = mutableDouble0.doubleValue();
      assertEquals(3313.4187F, mutableDouble0.floatValue(), 0.01F);
      assertEquals(3313.4188, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1751.34620644035));
      double double0 = mutableDouble0.doubleValue();
      assertEquals((-1751.34620644035), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      int int0 = mutableDouble0.compareTo(mutableDouble0);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      MutableDouble mutableDouble1 = new MutableDouble(mutableDouble0);
      mutableDouble0.decrementAndGet();
      int int0 = mutableDouble1.compareTo(mutableDouble0);
      assertEquals((-1L), mutableDouble0.longValue());
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1751.34620644035));
      MutableDouble mutableDouble1 = new MutableDouble();
      int int0 = mutableDouble0.compareTo(mutableDouble1);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      Integer integer0 = new Integer(3205);
      double double0 = mutableDouble0.addAndGet((Number) integer0);
      assertEquals(3205, mutableDouble0.intValue());
      assertEquals(3205.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      mutableDouble0.getAndDecrement();
      double double0 = mutableDouble0.addAndGet((Number) short0);
      assertEquals((-1), mutableDouble0.intValue());
      assertEquals((-1.0), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble(0.0);
      mutableDouble0.add((-1.0));
      double double0 = mutableDouble0.addAndGet(1.0);
      assertEquals(0.0F, mutableDouble0.floatValue(), 0.01F);
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1751.34620644035));
      double double0 = mutableDouble0.addAndGet((-1751.34620644035));
      assertEquals((-3502.6924128807), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      // Undeclared exception!
      try { 
        mutableDouble0.subtract((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableDouble", e);
      }
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      // Undeclared exception!
      try { 
        mutableDouble0.setValue((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableDouble", e);
      }
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      // Undeclared exception!
      try { 
        mutableDouble0.addAndGet((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableDouble", e);
      }
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      // Undeclared exception!
      try { 
        mutableDouble0.add((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableDouble", e);
      }
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      MutableDouble mutableDouble0 = null;
      try {
        mutableDouble0 = new MutableDouble("");
        fail("Expecting exception: NumberFormatException");
      
      } catch(NumberFormatException e) {
      }
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      MutableDouble mutableDouble0 = null;
      try {
        mutableDouble0 = new MutableDouble((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
      }
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      MutableDouble mutableDouble0 = null;
      try {
        mutableDouble0 = new MutableDouble((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableDouble", e);
      }
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      double double0 = mutableDouble0.doubleValue();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1751.34620644035));
      MutableDouble mutableDouble1 = new MutableDouble();
      boolean boolean0 = mutableDouble0.equals(mutableDouble1);
      assertFalse(boolean0);
      assertFalse(mutableDouble1.equals((Object)mutableDouble0));
      assertEquals((-1751), mutableDouble0.intValue());
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble(0.0);
      boolean boolean0 = mutableDouble0.equals(mutableDouble0);
      assertTrue(boolean0);
      assertEquals(0.0, mutableDouble0.toDouble(), 0.01);
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      boolean boolean0 = mutableDouble0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      double double0 = mutableDouble0.decrementAndGet();
      assertEquals(7.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      double double0 = mutableDouble0.addAndGet((Number) short0);
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1751.34620644035));
      mutableDouble0.setValue((-1751.34620644035));
      assertEquals((-1751L), mutableDouble0.longValue());
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      double double0 = mutableDouble0.addAndGet(0.0);
      assertEquals(8.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      Short short0 = Short.valueOf((short)0);
      MutableDouble mutableDouble0 = new MutableDouble((Number) short0);
      mutableDouble0.increment();
      assertEquals(1.0, mutableDouble0.toDouble(), 0.01);
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      double double0 = mutableDouble0.getAndDecrement();
      assertEquals("7.0", mutableDouble0.toString());
      assertEquals(8.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      int int0 = mutableDouble0.intValue();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      double double0 = mutableDouble0.getAndAdd((-1.0));
      assertEquals(7, mutableDouble0.intValue());
      assertEquals(8.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      Double double0 = mutableDouble0.toDouble();
      mutableDouble0.subtract((Number) double0);
      assertEquals(0L, mutableDouble0.longValue());
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      // Undeclared exception!
      try { 
        mutableDouble0.getAndAdd((Number) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableDouble", e);
      }
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble((-1.0));
      mutableDouble0.isInfinite();
      assertEquals("-1.0", mutableDouble0.toString());
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      mutableDouble0.decrement();
      assertEquals(7.0F, mutableDouble0.floatValue(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      String string0 = mutableDouble0.toString();
      assertEquals("8.0", string0);
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      long long0 = mutableDouble0.longValue();
      assertEquals(0L, long0);
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      mutableDouble0.getAndIncrement();
      float float0 = mutableDouble0.floatValue();
      assertEquals(1.0, mutableDouble0.doubleValue(), 0.01);
      assertEquals(1.0F, float0, 0.01F);
  }

  @Test(timeout = 4000)
  public void test57()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      boolean boolean0 = mutableDouble0.isNaN();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test58()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      Double double0 = mutableDouble0.toDouble();
      assertEquals(8.0, (double)double0, 0.01);
      
      mutableDouble0.setValue((Number) double0);
      assertEquals((byte)8, mutableDouble0.byteValue());
  }

  @Test(timeout = 4000)
  public void test59()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble("8");
      Double double0 = mutableDouble0.getValue();
      assertEquals(8.0, (double)double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test60()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble(0.0);
      // Undeclared exception!
      try { 
        mutableDouble0.compareTo((MutableDouble) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.lang3.mutable.MutableDouble", e);
      }
  }

  @Test(timeout = 4000)
  public void test61()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      mutableDouble0.incrementAndGet();
      double double0 = mutableDouble0.decrementAndGet();
      assertEquals(0.0, mutableDouble0.getValue(), 0.01);
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test62()  throws Throwable  {
      MutableDouble mutableDouble0 = new MutableDouble();
      float float0 = mutableDouble0.floatValue();
      assertEquals(0.0F, float0, 0.01F);
  }
}

/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 07:53:00 GMT 2025
 */

package org.apache.commons.cli;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import org.apache.commons.cli.Option;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Option_ESTest extends Option_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt("bwG*9nyFc'akb");
      option_Builder0.numberOfArgs(45);
      Option.Builder option_Builder1 = option_Builder0.valueSeparator('*');
      Option option0 = option_Builder1.build();
      option0.addValueForProcessing("bwG*9nyFc'akb");
      assertEquals(45, option0.getArgs());
      assertEquals("bwG", option0.getValue());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Option option0 = new Option((String) null, true, "i]$A.dl");
      option0.setArgs((-1776));
      boolean boolean0 = option0.requiresArg();
      assertEquals((-1776), option0.getArgs());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder("");
      Option.Builder option_Builder1 = option_Builder0.required(true);
      assertSame(option_Builder0, option_Builder1);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Option option0 = new Option("vyhW", "vyhW", true, "vyhW");
      option0.setRequired(true);
      boolean boolean0 = option0.isRequired();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Option option0 = new Option("", true, "Either opt or longOpt must be specified");
      option0.setOptionalArg(true);
      boolean boolean0 = option0.hasOptionalArg();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Option option0 = new Option("", true, "");
      option0.addValueForProcessing("[ option:   [ARG] ::  :: class java.lang.String ]");
      option0.getValuesList();
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Option option0 = new Option("", true, "");
      String string0 = option0.getValue("");
      assertNotNull(string0);
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.hasArgs();
      option_Builder1.longOpt("bwG*9nyFc'akb");
      Option option0 = option_Builder1.build();
      option0.addValueForProcessing("bwG*9nyFc'akb");
      String string0 = option0.getValue(0);
      assertNotNull(string0);
      assertTrue(option0.hasArg());
      assertEquals((-2), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Option option0 = new Option("", true, "");
      option0.addValueForProcessing("[ option:   [ARG] ::  :: class java.lang.String ]");
      String string0 = option0.getValue();
      assertNotNull(string0);
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Option option0 = new Option((String) null, false, (String) null);
      option0.setType((Object) null);
      option0.getType();
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Option option0 = new Option((String) null, true, "g]`3yU:");
      option0.getOpt();
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Option option0 = new Option("Th", false, "Th");
      option0.getOpt();
      assertEquals((-1), option0.getArgs());
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt(",/+{oK3*S?E}");
      Option option0 = option_Builder0.build();
      option0.getLongOpt();
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Option option0 = new Option((String) null, true, (String) null);
      String string0 = option0.getKey();
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt(",/+{oK3*S?E}");
      Option option0 = option_Builder0.build();
      option0.getKey();
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Option option0 = new Option("", true, "");
      option0.getKey();
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Option option0 = new Option("N", "N");
      option0.getId();
      assertFalse(option0.hasLongOpt());
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Option option0 = new Option("", true, "Either opt or longOpt must be specified");
      String string0 = option0.getDescription();
      assertEquals("Either opt or longOpt must be specified", string0);
      assertNotNull(string0);
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Option option0 = new Option("", "", true, "");
      String string0 = option0.getDescription();
      assertEquals("", string0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder("");
      option_Builder0.numberOfArgs(0);
      Option option0 = option_Builder0.build();
      int int0 = option0.getArgs();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.longOpt("");
      option_Builder1.hasArg();
      Option option0 = option_Builder1.build();
      int int0 = option0.getArgs();
      assertEquals(1, int0);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt("#SO");
      option_Builder0.argName("#SO");
      Option option0 = option_Builder0.build();
      option0.getArgName();
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder("");
      Option.Builder option_Builder1 = option_Builder0.hasArgs();
      Option option0 = option_Builder1.build();
      option0.acceptsArg();
      assertTrue(option0.hasArgs());
      assertTrue(option0.hasArg());
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Option option0 = new Option("", "");
      boolean boolean0 = option0.acceptsArg();
      assertFalse(option0.hasLongOpt());
      assertFalse(boolean0);
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Option option0 = new Option("", "");
      option0.setArgs((-2));
      option0.addValueForProcessing("");
      try { 
        option0.getValue(2815);
        fail("Expecting exception: IndexOutOfBoundsException");
      
      } catch(IndexOutOfBoundsException e) {
         //
         // Index: 2815, Size: 1
         //
         verifyException("java.util.ArrayList", e);
      }
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      // Undeclared exception!
      try { 
        Option.builder("f[DYL|US");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The option 'f[DYL|US' contains an illegal character : '['
         //
         verifyException("org.apache.commons.cli.OptionValidator", e);
      }
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.hasArgs();
      option_Builder0.longOpt("t4HxJ");
      option_Builder0.valueSeparator(']');
      Option option0 = option_Builder0.build();
      // Undeclared exception!
      try { 
        option0.addValueForProcessing((String) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.cli.Option", e);
      }
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Option option0 = null;
      try {
        option0 = new Option("Either opt or longOpt must be specified", true, "Either opt or longOpt must be specified");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // The option 'Either opt or longOpt must be specified' contains an illegal character : ' '
         //
         verifyException("org.apache.commons.cli.OptionValidator", e);
      }
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Option option0 = null;
      try {
        option0 = new Option("\"", "\"", true, "\"");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal option name '\"'
         //
         verifyException("org.apache.commons.cli.OptionValidator", e);
      }
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Option option0 = null;
      try {
        option0 = new Option("'", "'");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Illegal option name '''
         //
         verifyException("org.apache.commons.cli.OptionValidator", e);
      }
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Option option0 = new Option((String) null, (String) null);
      option0.hasValueSeparator();
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt(",/+{oK3*S?E}");
      option_Builder0.valueSeparator(',');
      Option option0 = option_Builder0.build();
      boolean boolean0 = option0.hasValueSeparator();
      assertEquals((-1), option0.getArgs());
      assertEquals(',', option0.getValueSeparator());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt(",/+{oK3*S?E}");
      Option.Builder option_Builder1 = option_Builder0.hasArgs();
      Option option0 = option_Builder1.build();
      boolean boolean0 = option0.hasArgs();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Option option0 = new Option("", "", true, "9V2C|S-y");
      option0.setArgs(3220);
      boolean boolean0 = option0.hasArgs();
      assertEquals(3220, option0.getArgs());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Option option0 = new Option((String) null, false, "i]$A.dl");
      boolean boolean0 = option0.hasArgs();
      assertFalse(boolean0);
      assertFalse(option0.hasLongOpt());
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      Option option0 = new Option((String) null, false, (String) null);
      boolean boolean0 = option0.hasArg();
      assertFalse(boolean0);
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt(",/+{oK3*S?E}");
      Option option0 = option_Builder0.build();
      option0.setArgs(63);
      boolean boolean0 = option0.hasArg();
      assertEquals(63, option0.getArgs());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      Option option0 = new Option((String) null, false, (String) null);
      assertFalse(option0.hasArgs());
      
      option0.setArgs((-2));
      boolean boolean0 = option0.hasArg();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      Option option0 = new Option("", false, "");
      option0.getValue();
      assertFalse(option0.hasLongOpt());
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      Option option0 = new Option("", true, (String) null);
      option0.addValueForProcessing("");
      String string0 = option0.getValue();
      assertFalse(option0.hasLongOpt());
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      Option option0 = new Option("", "");
      option0.getValueSeparator();
      assertEquals((-1), option0.getArgs());
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      Option option0 = new Option("", true, "Either opt or longOpt must be specified");
      option0.hasOptionalArg();
      assertFalse(option0.hasLongOpt());
      assertEquals("Either opt or longOpt must be specified", option0.getDescription());
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder("N");
      Option.Builder option_Builder1 = option_Builder0.option("N");
      assertSame(option_Builder1, option_Builder0);
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Option option0 = new Option("J", "J");
      String string0 = option0.toString();
      assertEquals((-1), option0.getArgs());
      assertEquals("[ option: J  :: J :: class java.lang.String ]", string0);
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      Option option0 = new Option("", true, "");
      String string0 = option0.toString();
      assertEquals("[ option:   [ARG] ::  :: class java.lang.String ]", string0);
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      Option option0 = new Option("", "");
      assertFalse(option0.hasArgs());
      
      option0.setArgs((-2));
      option0.addValueForProcessing("");
      boolean boolean0 = option0.requiresArg();
      assertEquals((-2), option0.getArgs());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      Option option0 = new Option("Qop", "Qop");
      boolean boolean0 = option0.requiresArg();
      assertFalse(boolean0);
      assertEquals((-1), option0.getArgs());
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.optionalArg(true);
      option_Builder0.longOpt("bwG*9nyFc'akb");
      Option.Builder option_Builder1 = option_Builder0.valueSeparator('*');
      Option option0 = option_Builder1.build();
      option0.addValueForProcessing("bwG*9nyFc'akb");
      assertEquals(1, option0.getArgs());
      assertEquals('*', option0.getValueSeparator());
      assertTrue(option0.hasValueSeparator());
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt("Either opt or longOpt must be specified");
      Option option0 = option_Builder0.build();
      boolean boolean0 = option0.hasLongOpt();
      assertEquals((-1), option0.getArgs());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      Option option0 = new Option("", "");
      boolean boolean0 = option0.hasLongOpt();
      assertFalse(boolean0);
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      Option option0 = new Option("", "", true, "");
      option0.setArgs((-2));
      option0.toString();
      assertEquals((-2), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      Option option0 = new Option("", "");
      option0.setArgName("");
      boolean boolean0 = option0.hasArgName();
      assertEquals((-1), option0.getArgs());
      assertFalse(option0.hasLongOpt());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      Option option0 = new Option("Qop", "Qop");
      option0.setArgName("Qop");
      boolean boolean0 = option0.hasArgName();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.longOpt("bwG*9nyFc'akb");
      Option option0 = option_Builder0.build();
      boolean boolean0 = option0.hasArgName();
      assertEquals((-1), option0.getArgs());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      Option option0 = new Option("", "");
      String[] stringArray0 = option0.getValues();
      assertNull(stringArray0);
      assertFalse(option0.hasLongOpt());
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      Option option0 = new Option("", true, "");
      option0.addValueForProcessing("[ option:   [ARG] ::  :: class java.lang.String ]");
      String[] stringArray0 = option0.getValues();
      assertNotNull(stringArray0);
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.hasArgs();
      option_Builder1.longOpt("bwG*9nyFc'akb");
      Option option0 = option_Builder1.build();
      option0.addValueForProcessing("bwG*9nyFc'akb");
      option0.getValue("bwG*9nyFc'akb");
      assertTrue(option0.hasArgs());
      assertTrue(option0.hasArg());
  }

  @Test(timeout = 4000)
  public void test57()  throws Throwable  {
      Option option0 = new Option((String) null, false, (String) null);
      option0.getValue(0);
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test58()  throws Throwable  {
      Option option0 = new Option((String) null, true, (String) null);
      option0.addValueForProcessing((String) null);
      try { 
        option0.getValue((-519));
        fail("Expecting exception: ArrayIndexOutOfBoundsException");
      
      } catch(ArrayIndexOutOfBoundsException e) {
         //
         // no message in exception (getMessage() returned null)
         //
      }
  }

  @Test(timeout = 4000)
  public void test59()  throws Throwable  {
      Option option0 = new Option((String) null, true, (String) null);
      option0.addValueForProcessing((String) null);
      String string0 = option0.getValue((String) null);
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test60()  throws Throwable  {
      Option option0 = new Option((String) null, "The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. ");
      // Undeclared exception!
      try { 
        option0.getId();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.apache.commons.cli.Option", e);
      }
  }

  @Test(timeout = 4000)
  public void test61()  throws Throwable  {
      Option option0 = new Option("", false, "Po?+B6");
      Option option1 = new Option((String) null, (String) null, false, "");
      boolean boolean0 = option0.equals(option1);
      assertEquals((-1), option1.getArgs());
      assertEquals("Po?+B6", option0.getDescription());
      assertFalse(option0.hasLongOpt());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test62()  throws Throwable  {
      Option option0 = new Option((String) null, true, (String) null);
      Option option1 = new Option((String) null, "", true, "7");
      boolean boolean0 = option0.equals(option1);
      assertEquals("7", option1.getDescription());
      assertEquals(1, option1.getArgs());
      assertFalse(boolean0);
      assertEquals("", option1.getLongOpt());
  }

  @Test(timeout = 4000)
  public void test63()  throws Throwable  {
      Option option0 = new Option((String) null, (String) null, true, "p[1l(@m}=mI<");
      Option option1 = new Option((String) null, (String) null, true, "p[1l(@m}=mI<");
      boolean boolean0 = option0.equals(option1);
      assertTrue(boolean0);
      assertTrue(option1.hasArg());
      assertFalse(option1.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test64()  throws Throwable  {
      Option option0 = new Option((String) null, (String) null, true, "p[1l(@m}=mI<");
      boolean boolean0 = option0.equals(option0);
      assertTrue(boolean0);
      assertFalse(option0.hasLongOpt());
      assertEquals(1, option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test65()  throws Throwable  {
      Option option0 = new Option("N", "N");
      // Undeclared exception!
      try { 
        option0.addValueForProcessing("N");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // NO_ARGS_ALLOWED
         //
         verifyException("org.apache.commons.cli.Option", e);
      }
  }

  @Test(timeout = 4000)
  public void test66()  throws Throwable  {
      Option option0 = new Option("6G", true, "6G");
      option0.addValueForProcessing("6G");
      // Undeclared exception!
      try { 
        option0.addValueForProcessing("6G");
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Cannot add value, list full.
         //
         verifyException("org.apache.commons.cli.Option", e);
      }
  }

  @Test(timeout = 4000)
  public void test67()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      option_Builder0.optionalArg(true);
      Option.Builder option_Builder1 = option_Builder0.numberOfArgs(0);
      option_Builder0.longOpt("bwG*9nyFc'akb");
      Option option0 = option_Builder1.build();
      assertTrue(option0.hasOptionalArg());
      
      option0.addValueForProcessing("bwG*9nyFc'akb");
      assertFalse(option0.hasValueSeparator());
      assertEquals(0, option0.getArgs());
      assertFalse(option0.hasArgs());
      assertFalse(option0.hasArg());
  }

  @Test(timeout = 4000)
  public void test68()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.optionalArg(false);
      assertSame(option_Builder1, option_Builder0);
  }

  @Test(timeout = 4000)
  public void test69()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.hasArg(false);
      assertSame(option_Builder1, option_Builder0);
  }

  @Test(timeout = 4000)
  public void test70()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      // Undeclared exception!
      try { 
        option_Builder0.build();
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Either opt or longOpt must be specified
         //
         verifyException("org.apache.commons.cli.Option$Builder", e);
      }
  }

  @Test(timeout = 4000)
  public void test71()  throws Throwable  {
      Option option0 = new Option("", true, "");
      assertFalse(option0.hasLongOpt());
      
      option0.setLongOpt(" ");
      assertEquals(1, option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test72()  throws Throwable  {
      Option option0 = new Option("", "", true, "");
      option0.getOpt();
      assertEquals(1, option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test73()  throws Throwable  {
      Option option0 = new Option((String) null, true, (String) null);
      Object object0 = option0.getType();
      boolean boolean0 = option0.equals(object0);
      assertEquals(1, option0.getArgs());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test74()  throws Throwable  {
      Option option0 = new Option("", "");
      // Undeclared exception!
      try { 
        option0.addValue("");
        fail("Expecting exception: UnsupportedOperationException");
      
      } catch(UnsupportedOperationException e) {
         //
         // The addValue method is not intended for client use. Subclasses should use the addValueForProcessing method instead. 
         //
         verifyException("org.apache.commons.cli.Option", e);
      }
  }

  @Test(timeout = 4000)
  public void test75()  throws Throwable  {
      Option option0 = new Option("", "");
      String string0 = option0.getLongOpt();
      assertEquals((-1), option0.getArgs());
      assertNull(string0);
  }

  @Test(timeout = 4000)
  public void test76()  throws Throwable  {
      Option option0 = new Option("", "");
      option0.hashCode();
      assertEquals((-1), option0.getArgs());
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test77()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.longOpt(") .R1O/");
      Option option0 = option_Builder1.build();
      option0.isRequired();
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test78()  throws Throwable  {
      Option option0 = new Option((String) null, false, (String) null);
      option0.getDescription();
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test79()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder("");
      Option option0 = option_Builder0.build();
      int int0 = option0.getArgs();
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test80()  throws Throwable  {
      Option option0 = new Option("N", "N");
      option0.clearValues();
      assertFalse(option0.hasLongOpt());
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test81()  throws Throwable  {
      Option option0 = new Option("", "");
      option0.setDescription("");
      assertFalse(option0.hasLongOpt());
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test82()  throws Throwable  {
      Option option0 = new Option("", "");
      Option option1 = (Option)option0.clone();
      assertEquals((-1), option1.getArgs());
      assertFalse(option1.hasLongOpt());
      assertNotSame(option1, option0);
  }

  @Test(timeout = 4000)
  public void test83()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder("");
      Option option0 = option_Builder0.build();
      // Undeclared exception!
      try { 
        option0.getId();
        fail("Expecting exception: StringIndexOutOfBoundsException");
      
      } catch(StringIndexOutOfBoundsException e) {
      }
  }

  @Test(timeout = 4000)
  public void test84()  throws Throwable  {
      Option option0 = new Option("", true, "");
      option0.getValuesList();
      assertFalse(option0.hasLongOpt());
      assertTrue(option0.hasArg());
  }

  @Test(timeout = 4000)
  public void test85()  throws Throwable  {
      Option option0 = new Option("N", "N");
      Class<Object> class0 = Object.class;
      option0.setType(class0);
      assertFalse(option0.hasLongOpt());
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test86()  throws Throwable  {
      Option option0 = new Option("", "");
      assertFalse(option0.hasArg());
      
      option0.setArgs((-2));
      boolean boolean0 = option0.requiresArg();
      assertTrue(option0.hasArgs());
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test87()  throws Throwable  {
      Option option0 = new Option("", "");
      option0.setOptionalArg(true);
      boolean boolean0 = option0.requiresArg();
      assertTrue(option0.hasOptionalArg());
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test88()  throws Throwable  {
      Option option0 = new Option("", true, "");
      option0.getArgName();
      assertTrue(option0.hasArg());
      assertFalse(option0.hasLongOpt());
  }

  @Test(timeout = 4000)
  public void test89()  throws Throwable  {
      Option option0 = new Option("6G", true, "6G");
      option0.setValueSeparator('v');
      assertEquals('v', option0.getValueSeparator());
  }

  @Test(timeout = 4000)
  public void test90()  throws Throwable  {
      Option option0 = new Option("", "");
      // Undeclared exception!
      try { 
        option0.setType((Object) option0);
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // org.apache.commons.cli.Option cannot be cast to java.lang.Class
         //
         verifyException("org.apache.commons.cli.Option", e);
      }
  }

  @Test(timeout = 4000)
  public void test91()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Class<Object> class0 = Object.class;
      Option.Builder option_Builder1 = option_Builder0.type(class0);
      assertSame(option_Builder0, option_Builder1);
  }

  @Test(timeout = 4000)
  public void test92()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.hasArgs();
      option_Builder1.longOpt("bwG*9nyFc'akb");
      Option.Builder option_Builder2 = option_Builder0.valueSeparator('*');
      Option option0 = option_Builder2.build();
      option0.addValueForProcessing("bwG*9nyFc'akb");
      assertTrue(option0.hasArg());
      assertEquals("bwG", option0.getValue());
  }

  @Test(timeout = 4000)
  public void test93()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.desc("bwG*9nyFc'akb");
      assertSame(option_Builder0, option_Builder1);
  }

  @Test(timeout = 4000)
  public void test94()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.required();
      assertSame(option_Builder1, option_Builder0);
  }

  @Test(timeout = 4000)
  public void test95()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder("");
      option_Builder0.argName("");
      Option option0 = option_Builder0.build();
      option0.getArgName();
      assertEquals((-1), option0.getArgs());
  }

  @Test(timeout = 4000)
  public void test96()  throws Throwable  {
      Option.Builder option_Builder0 = Option.builder();
      Option.Builder option_Builder1 = option_Builder0.valueSeparator();
      assertSame(option_Builder0, option_Builder1);
  }
}

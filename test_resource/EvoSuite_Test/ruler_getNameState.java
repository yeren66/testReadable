/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 09:02:25 GMT 2025
 */

package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.LinkedHashSet;
import java.util.Set;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import software.amazon.event.ruler.AnythingButValuesSet;
import software.amazon.event.ruler.NameState;
import software.amazon.event.ruler.NameStateWithPattern;
import software.amazon.event.ruler.Patterns;
import software.amazon.event.ruler.ValuePatterns;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class NameStateWithPattern_ESTest extends NameStateWithPattern_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      NameState nameState0 = new NameState();
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, (Patterns) null);
      Patterns patterns0 = nameStateWithPattern0.getPattern();
      assertNull(patterns0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      ValuePatterns valuePatterns0 = Patterns.equalsIgnoreCaseMatch("fzq~21X;R");
      NameStateWithPattern nameStateWithPattern0 = null;
      try {
        nameStateWithPattern0 = new NameStateWithPattern((NameState) null, valuePatterns0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Objects", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      ValuePatterns valuePatterns0 = Patterns.equalsIgnoreCaseMatch("fzq~21X;R");
      NameState nameState0 = new NameState();
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, valuePatterns0);
      boolean boolean0 = nameStateWithPattern0.equals(nameStateWithPattern0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      NameState nameState0 = new NameState();
      LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>();
      AnythingButValuesSet anythingButValuesSet0 = Patterns.anythingButPrefix((Set<String>) linkedHashSet0);
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, anythingButValuesSet0);
      AnythingButValuesSet anythingButValuesSet1 = Patterns.anythingButPrefix("N");
      NameStateWithPattern nameStateWithPattern1 = new NameStateWithPattern(nameState0, anythingButValuesSet1);
      boolean boolean0 = nameStateWithPattern1.equals(nameStateWithPattern0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      ValuePatterns valuePatterns0 = Patterns.equalsIgnoreCaseMatch("fzq~21X;R");
      NameState nameState0 = new NameState();
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, valuePatterns0);
      NameState nameState1 = new NameState();
      NameStateWithPattern nameStateWithPattern1 = new NameStateWithPattern(nameState1, valuePatterns0);
      boolean boolean0 = nameStateWithPattern1.equals(nameStateWithPattern0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      ValuePatterns valuePatterns0 = Patterns.equalsIgnoreCaseMatch("fzq~21X;R");
      NameState nameState0 = new NameState();
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, valuePatterns0);
      boolean boolean0 = nameStateWithPattern0.equals(valuePatterns0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      NameState nameState0 = new NameState();
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, (Patterns) null);
      // Undeclared exception!
      try { 
        nameStateWithPattern0.equals(nameStateWithPattern0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("software.amazon.event.ruler.NameStateWithPattern", e);
      }
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      NameState nameState0 = new NameState();
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, (Patterns) null);
      boolean boolean0 = nameStateWithPattern0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      NameState nameState0 = new NameState();
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, (Patterns) null);
      nameStateWithPattern0.hashCode();
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>();
      NameState nameState0 = new NameState();
      AnythingButValuesSet anythingButValuesSet0 = Patterns.anythingButPrefix((Set<String>) linkedHashSet0);
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, anythingButValuesSet0);
      Patterns patterns0 = nameStateWithPattern0.getPattern();
      assertNull(patterns0.pattern());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      NameState nameState0 = new NameState();
      NameStateWithPattern nameStateWithPattern0 = new NameStateWithPattern(nameState0, (Patterns) null);
      NameState nameState1 = nameStateWithPattern0.getNameState();
      assertSame(nameState1, nameState0);
  }
}

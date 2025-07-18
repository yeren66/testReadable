/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 09:02:35 GMT 2025
 */

package software.amazon.event.ruler;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedHashSet;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import software.amazon.event.ruler.AnythingBut;
import software.amazon.event.ruler.NameState;
import software.amazon.event.ruler.Patterns;
import software.amazon.event.ruler.SingleStateNameMatcher;
import software.amazon.event.ruler.ValuePatterns;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class SingleStateNameMatcher_ESTest extends SingleStateNameMatcher_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>();
      AnythingBut anythingBut0 = Patterns.anythingButNumbersMatch(linkedHashSet0);
      NameState nameState0 = new NameState();
      singleStateNameMatcher0.addPattern(anythingBut0, nameState0);
      NameState nameState1 = singleStateNameMatcher0.getNextState();
      assertNotNull(nameState1);
      assertFalse(singleStateNameMatcher0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>();
      AnythingBut anythingBut0 = Patterns.anythingButNumbersMatch(linkedHashSet0);
      NameState nameState0 = new NameState();
      singleStateNameMatcher0.addPattern(anythingBut0, nameState0);
      NameState nameState1 = singleStateNameMatcher0.findPattern(anythingBut0);
      assertNotNull(nameState1);
      assertFalse(singleStateNameMatcher0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      ValuePatterns valuePatterns0 = Patterns.prefixMatch("");
      NameState nameState0 = singleStateNameMatcher0.addPattern(valuePatterns0, (NameState) null);
      assertNull(nameState0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>();
      AnythingBut anythingBut0 = Patterns.anythingButNumbersMatch(linkedHashSet0);
      NameState nameState0 = new NameState();
      NameState nameState1 = singleStateNameMatcher0.addPattern(anythingBut0, nameState0);
      NameState nameState2 = singleStateNameMatcher0.addPattern(anythingBut0, nameState1);
      assertNotNull(nameState2);
      assertFalse(singleStateNameMatcher0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      boolean boolean0 = singleStateNameMatcher0.isEmpty();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>();
      AnythingBut anythingBut0 = Patterns.anythingButNumbersMatch(linkedHashSet0);
      NameState nameState0 = new NameState();
      singleStateNameMatcher0.addPattern(anythingBut0, nameState0);
      boolean boolean0 = singleStateNameMatcher0.isEmpty();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>();
      AnythingBut anythingBut0 = Patterns.anythingButNumbersMatch(linkedHashSet0);
      NameState nameState0 = singleStateNameMatcher0.findPattern(anythingBut0);
      assertNull(nameState0);
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>();
      AnythingBut anythingBut0 = Patterns.anythingButNumbersMatch(linkedHashSet0);
      singleStateNameMatcher0.deletePattern(anythingBut0);
      assertTrue(singleStateNameMatcher0.isEmpty());
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      SingleStateNameMatcher singleStateNameMatcher0 = new SingleStateNameMatcher();
      NameState nameState0 = singleStateNameMatcher0.getNextState();
      assertNull(nameState0);
  }
}

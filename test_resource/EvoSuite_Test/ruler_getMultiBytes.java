/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 09:02:05 GMT 2025
 */

package software.amazon.event.ruler.input;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.util.LinkedHashSet;
import java.util.Set;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;
import software.amazon.event.ruler.input.InputCharacter;
import software.amazon.event.ruler.input.InputCharacterType;
import software.amazon.event.ruler.input.InputMultiByteSet;
import software.amazon.event.ruler.input.InputWildcard;
import software.amazon.event.ruler.input.MultiByte;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class InputMultiByteSet_ESTest extends InputMultiByteSet_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      InputMultiByteSet inputMultiByteSet0 = InputMultiByteSet.cast((InputCharacter) null);
      assertNull(inputMultiByteSet0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      InputWildcard inputWildcard0 = new InputWildcard();
      // Undeclared exception!
      try { 
        InputMultiByteSet.cast(inputWildcard0);
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // software.amazon.event.ruler.input.InputWildcard cannot be cast to software.amazon.event.ruler.input.InputMultiByteSet
         //
         verifyException("software.amazon.event.ruler.input.InputMultiByteSet", e);
      }
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      InputMultiByteSet inputMultiByteSet0 = null;
      try {
        inputMultiByteSet0 = new InputMultiByteSet((Set<MultiByte>) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("java.util.Collections$UnmodifiableCollection", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      LinkedHashSet<MultiByte> linkedHashSet0 = new LinkedHashSet<MultiByte>();
      InputMultiByteSet inputMultiByteSet0 = new InputMultiByteSet(linkedHashSet0);
      Set<MultiByte> set0 = inputMultiByteSet0.getMultiBytes();
      assertEquals(0, set0.size());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      LinkedHashSet<MultiByte> linkedHashSet0 = new LinkedHashSet<MultiByte>();
      InputMultiByteSet inputMultiByteSet0 = new InputMultiByteSet(linkedHashSet0);
      boolean boolean0 = inputMultiByteSet0.equals(inputMultiByteSet0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      LinkedHashSet<MultiByte> linkedHashSet0 = new LinkedHashSet<MultiByte>();
      InputMultiByteSet inputMultiByteSet0 = new InputMultiByteSet(linkedHashSet0);
      Object object0 = new Object();
      boolean boolean0 = inputMultiByteSet0.equals(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      LinkedHashSet<MultiByte> linkedHashSet0 = new LinkedHashSet<MultiByte>();
      InputMultiByteSet inputMultiByteSet0 = new InputMultiByteSet(linkedHashSet0);
      boolean boolean0 = inputMultiByteSet0.equals((Object) null);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      LinkedHashSet<MultiByte> linkedHashSet0 = new LinkedHashSet<MultiByte>();
      InputMultiByteSet inputMultiByteSet0 = new InputMultiByteSet(linkedHashSet0);
      InputCharacterType inputCharacterType0 = inputMultiByteSet0.getType();
      assertEquals(InputCharacterType.MULTI_BYTE_SET, inputCharacterType0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      LinkedHashSet<MultiByte> linkedHashSet0 = new LinkedHashSet<MultiByte>();
      InputMultiByteSet inputMultiByteSet0 = new InputMultiByteSet(linkedHashSet0);
      inputMultiByteSet0.hashCode();
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      LinkedHashSet<MultiByte> linkedHashSet0 = new LinkedHashSet<MultiByte>();
      InputMultiByteSet inputMultiByteSet0 = new InputMultiByteSet(linkedHashSet0);
      String string0 = inputMultiByteSet0.toString();
      assertNotNull(string0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      LinkedHashSet<MultiByte> linkedHashSet0 = new LinkedHashSet<MultiByte>();
      InputMultiByteSet inputMultiByteSet0 = new InputMultiByteSet(linkedHashSet0);
      InputMultiByteSet inputMultiByteSet1 = InputMultiByteSet.cast(inputMultiByteSet0);
      assertSame(inputMultiByteSet0, inputMultiByteSet1);
  }
}

/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 07:25:37 GMT 2025
 */

package org.jfree.chart.renderer;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.geom.Point2D;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jfree.chart.renderer.Outlier;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class Outlier_ESTest extends Outlier_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 54.200000000000045, 54.200000000000045);
      Point2D point2D0 = outlier0.getPoint();
      Outlier outlier1 = new Outlier(0.0, 54.200000000000045, 0.0);
      outlier1.setPoint(point2D0);
      boolean boolean0 = outlier1.equals(outlier0);
      assertEquals((-54.200000000000045), outlier1.getX(), 0.01);
      assertEquals(0.0, outlier1.getY(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      boolean boolean0 = outlier0.overlaps(outlier0);
      assertEquals(0.0, outlier0.getRadius(), 0.01);
      assertTrue(boolean0);
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertEquals(0.0, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      Outlier outlier1 = new Outlier(0.0, (-822.6938410394237), 0.0);
      int int0 = outlier0.compareTo(outlier1);
      assertEquals(0.0, outlier1.getX(), 0.01);
      assertEquals(0.0, outlier1.getRadius(), 0.01);
      assertEquals(1, int0);
      assertEquals(0.0, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Outlier outlier0 = new Outlier(1124.9, 4114.4109, 3662.80669436594);
      double double0 = outlier0.getY();
      assertEquals(3662.80669436594, outlier0.getRadius(), 0.01);
      assertEquals(451.6042056340598, double0, 0.01);
      assertEquals((-2537.90669436594), outlier0.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      assertEquals(0.0, outlier0.getY(), 0.01);
      
      Point2D.Float point2D_Float0 = new Point2D.Float((-747.637F), (-747.637F));
      outlier0.setPoint(point2D_Float0);
      outlier0.getY();
      assertEquals(0.0, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Outlier outlier0 = new Outlier(957.0, 957.0, 0.0);
      double double0 = outlier0.getX();
      assertEquals(957.0, outlier0.getY(), 0.01);
      assertEquals(0.0, outlier0.getRadius(), 0.01);
      assertEquals(957.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 54.200000000000045, 54.200000000000045);
      double double0 = outlier0.getX();
      assertEquals((-54.200000000000045), double0, 0.01);
      assertEquals(54.200000000000045, outlier0.getRadius(), 0.01);
      assertEquals(0.0, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 54.200000000000045, 54.200000000000045);
      double double0 = outlier0.getRadius();
      assertEquals(0.0, outlier0.getY(), 0.01);
      assertEquals(54.200000000000045, double0, 0.01);
      assertEquals((-54.200000000000045), outlier0.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 1972.7315601333823, (-205.01293344785));
      double double0 = outlier0.getRadius();
      assertEquals(205.01293344785, outlier0.getX(), 0.01);
      assertEquals((-205.01293344785), double0, 0.01);
      assertEquals(2177.7444935812323, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Outlier outlier0 = new Outlier(1124.9, 4114.4109, 3662.80669436594);
      assertEquals(451.6042056340598, outlier0.getY(), 0.01);
      assertEquals((-2537.90669436594), outlier0.getX(), 0.01);
      
      outlier0.setPoint((Point2D) null);
      outlier0.getPoint();
      assertEquals(3662.80669436594, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      Outlier outlier0 = new Outlier((-189.43884260008417), (-189.43884260008417), (-189.43884260008417));
      outlier0.setPoint((Point2D) null);
      // Undeclared exception!
      try { 
        outlier0.toString();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jfree.chart.renderer.Outlier", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      Outlier outlier0 = new Outlier(1639.7935125328595, 1639.7935125328595, 1639.7935125328595);
      // Undeclared exception!
      try { 
        outlier0.overlaps((Outlier) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jfree.chart.renderer.Outlier", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      Outlier outlier0 = new Outlier(3362.35819834348, (-1708.0), (-1744.14718));
      outlier0.setPoint((Point2D) null);
      // Undeclared exception!
      try { 
        outlier0.getY();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jfree.chart.renderer.Outlier", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      Outlier outlier0 = new Outlier(1124.9, 4114.4109, 3662.80669436594);
      outlier0.setPoint((Point2D) null);
      // Undeclared exception!
      try { 
        outlier0.getX();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jfree.chart.renderer.Outlier", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Outlier outlier0 = new Outlier(1650.48, 1650.48, 1650.48);
      // Undeclared exception!
      try { 
        outlier0.compareTo((Object) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jfree.chart.renderer.Outlier", e);
      }
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      // Undeclared exception!
      try { 
        outlier0.compareTo("{0.0,0.0}");
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.String cannot be cast to org.jfree.chart.renderer.Outlier
         //
         verifyException("org.jfree.chart.renderer.Outlier", e);
      }
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      double double0 = outlier0.getX();
      assertEquals(0.0, outlier0.getY(), 0.01);
      assertEquals(0.0, double0, 0.01);
      assertEquals(0.0, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      double double0 = outlier0.getY();
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertEquals(0.0, double0, 0.01);
      assertEquals(0.0, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      Outlier outlier1 = new Outlier(0.0, 0.0, 0.0);
      boolean boolean0 = outlier0.equals(outlier1);
      assertEquals(0.0, outlier1.getX(), 0.01);
      assertEquals(0.0, outlier1.getY(), 0.01);
      assertEquals(0.0, outlier1.getRadius(), 0.01);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Outlier outlier0 = new Outlier((-781.242045995), (-781.242045995), (-3596.60639183287));
      Point2D point2D0 = outlier0.getPoint();
      Outlier outlier1 = new Outlier(0.0, 2637.0, (-2572.1289079221488));
      outlier1.setPoint(point2D0);
      boolean boolean0 = outlier1.equals(outlier0);
      assertEquals(2815.36434583787, outlier1.getX(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Outlier outlier0 = new Outlier(1932.63790803467, 1932.63790803467, 1932.63790803467);
      boolean boolean0 = outlier0.equals("{1932.63790803467,1932.63790803467}");
      assertFalse(boolean0);
      assertEquals(1932.63790803467, outlier0.getRadius(), 0.01);
      assertEquals(0.0, outlier0.getY(), 0.01);
      assertEquals(0.0, outlier0.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Outlier outlier0 = new Outlier(1932.63790803467, 1932.63790803467, 1932.63790803467);
      boolean boolean0 = outlier0.equals(outlier0);
      assertEquals(1932.63790803467, outlier0.getRadius(), 0.01);
      assertEquals(0.0, outlier0.getY(), 0.01);
      assertTrue(boolean0);
      assertEquals(0.0, outlier0.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Outlier outlier0 = new Outlier((-781.242045995), (-781.242045995), (-3596.60639183287));
      Outlier outlier1 = new Outlier(0.0, 2637.0, (-2572.1289079221488));
      boolean boolean0 = outlier1.equals(outlier0);
      assertEquals((-2572.1289079221488), outlier1.getRadius(), 0.01);
      assertEquals(5209.128907922149, outlier1.getY(), 0.01);
      assertEquals(2572.1289079221488, outlier1.getX(), 0.01);
      assertEquals(2815.36434583787, outlier0.getX(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      Outlier outlier1 = new Outlier(0.0, (-822.6938410394237), 0.0);
      boolean boolean0 = outlier1.overlaps(outlier0);
      assertFalse(boolean0);
      assertEquals((-822.6938410394237), outlier1.getY(), 0.01);
      assertEquals(0.0, outlier1.getRadius(), 0.01);
      assertEquals(0.0, outlier1.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Outlier outlier0 = new Outlier(488.28993702, 488.28993702, 488.28993702);
      Outlier outlier1 = new Outlier(488.28993702, (-1433.5187654850204), 488.28993702);
      boolean boolean0 = outlier0.overlaps(outlier1);
      assertFalse(boolean0);
      assertEquals((-1921.8087025050204), outlier1.getY(), 0.01);
      assertEquals(0.0, outlier1.getX(), 0.01);
      assertEquals(488.28993702, outlier1.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Outlier outlier0 = new Outlier(1654.1602221881, 1654.1602221881, 1654.1602221881);
      Outlier outlier1 = new Outlier(1654.1602221881, 1098.865659690176, (-1187.56144));
      boolean boolean0 = outlier0.overlaps(outlier1);
      assertEquals(2841.7216621881, outlier1.getX(), 0.01);
      assertEquals(2286.427099690176, outlier1.getY(), 0.01);
      assertEquals((-1187.56144), outlier1.getRadius(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Outlier outlier0 = new Outlier(2470.5580908896, (-2118.9014526), (-2118.9014526));
      boolean boolean0 = outlier0.overlaps(outlier0);
      assertEquals(4589.4595434896, outlier0.getX(), 0.01);
      assertFalse(boolean0);
      assertEquals(0.0, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Outlier outlier0 = new Outlier(1650.48, 1650.48, 1650.48);
      Outlier outlier1 = new Outlier((-1838.9278), 1650.48, (-1838.9278));
      int int0 = outlier0.compareTo(outlier1);
      assertEquals((-1838.9278), outlier1.getRadius(), 0.01);
      assertEquals(0.0, outlier1.getX(), 0.01);
      assertEquals((-1), int0);
      assertEquals(3489.4078, outlier1.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Outlier outlier0 = new Outlier(1653.848656090572, 1653.848656090572, 1653.848656090572);
      Outlier outlier1 = new Outlier(1653.848656090572, 1.0, 1.0);
      int int0 = outlier0.compareTo(outlier1);
      assertEquals(1652.848656090572, outlier1.getX(), 0.01);
      assertEquals(1.0, outlier1.getRadius(), 0.01);
      assertEquals((-1), int0);
      assertEquals(0.0, outlier1.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Outlier outlier0 = new Outlier(1648.6914487887584, 1648.6914487887584, 1648.6914487887584);
      int int0 = outlier0.compareTo(outlier0);
      assertEquals(0.0, outlier0.getY(), 0.01);
      assertEquals(1648.6914487887584, outlier0.getRadius(), 0.01);
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Outlier outlier0 = new Outlier(1639.7935125328595, 1639.7935125328595, 1639.7935125328595);
      Outlier outlier1 = new Outlier(953.1104354438133, 1639.7935125328595, 1639.7935125328595);
      int int0 = outlier0.compareTo(outlier1);
      assertEquals(1639.7935125328595, outlier1.getRadius(), 0.01);
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertEquals(1, int0);
      assertEquals(0.0, outlier1.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      String string0 = outlier0.toString();
      assertEquals("{0.0,0.0}", string0);
      assertEquals(0.0, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      outlier0.setRadius(0.0);
      assertEquals(0.0, outlier0.getRadius(), 0.01);
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertEquals(0.0, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      double double0 = outlier0.getRadius();
      assertEquals(0.0, double0, 0.01);
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertEquals(0.0, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      Outlier outlier0 = new Outlier(1639.7935125328595, 1639.7935125328595, 1639.7935125328595);
      boolean boolean0 = outlier0.overlaps(outlier0);
      assertEquals(0.0, outlier0.getY(), 0.01);
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertTrue(boolean0);
  }
}

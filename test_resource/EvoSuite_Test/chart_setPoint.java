/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 07:28:06 GMT 2025
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
      Outlier outlier0 = new Outlier(1.0, 1.0, 1.0);
      Point2D.Float point2D_Float0 = new Point2D.Float();
      Outlier outlier1 = new Outlier(1.0, (-3772.22621344), 0.0);
      assertEquals((-3772.22621344), outlier1.getY(), 0.01);
      
      outlier1.setPoint(point2D_Float0);
      boolean boolean0 = outlier1.equals(outlier0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, (-787.92), (-787.92));
      assertEquals((-787.92), outlier0.getRadius(), 0.01);
      
      outlier0.setRadius(0.0F);
      boolean boolean0 = outlier0.overlaps(outlier0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 571.72);
      Outlier outlier1 = new Outlier((-1143.44), (-571.72), 0.0);
      int int0 = outlier0.compareTo(outlier1);
      assertEquals((-571.72), outlier0.getY(), 0.01);
      assertEquals(0.0, outlier1.getRadius(), 0.01);
      assertEquals(1, int0);
      assertEquals((-571.72), outlier0.getX(), 0.01);
      assertEquals((-571.72), outlier1.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, (-787.92), (-787.92));
      double double0 = outlier0.getY();
      assertEquals((-787.92), outlier0.getRadius(), 0.01);
      assertEquals(0.0, double0, 0.01);
      assertEquals(787.92, outlier0.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Outlier outlier0 = new Outlier((-209.0), 1.1, 1.0);
      double double0 = outlier0.getY();
      assertEquals(0.10000000000000009, double0, 0.01);
      assertEquals((-210.0), outlier0.getX(), 0.01);
      assertEquals(1.0, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      double double0 = outlier0.getX();
      assertEquals(0.0, double0, 0.01);
      assertEquals(0.0, outlier0.getRadius(), 0.01);
      assertEquals(0.0, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      assertEquals(0.0, outlier0.getX(), 0.01);
      
      Point2D.Float point2D_Float0 = new Point2D.Float();
      point2D_Float0.setLocation(1.1, 1814.26987221804);
      outlier0.setPoint(point2D_Float0);
      outlier0.getX();
      assertEquals(0.0, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, (-787.92), (-787.92));
      assertEquals((-787.92), outlier0.getRadius(), 0.01);
      
      outlier0.setRadius(0.0F);
      double double0 = outlier0.getRadius();
      assertEquals(0.0, double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, (-2721.0), 780.963193699);
      assertEquals((-780.963193699), outlier0.getX(), 0.01);
      assertEquals((-3501.963193699), outlier0.getY(), 0.01);
      
      outlier0.setPoint((Point2D) null);
      outlier0.getPoint();
      assertEquals(780.963193699, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      Outlier outlier0 = new Outlier((-26.309773142031794), (-26.309773142031794), (-26.309773142031794));
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
  public void test10()  throws Throwable  {
      Outlier outlier0 = new Outlier(1.0, 1.0, 1.0);
      outlier0.setPoint((Point2D) null);
      // Undeclared exception!
      try { 
        outlier0.overlaps(outlier0);
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
      Outlier outlier0 = new Outlier((-1.0), (-1.0), 0.0);
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
  public void test12()  throws Throwable  {
      Outlier outlier0 = new Outlier(3618.451418447589, 3618.451418447589, 6.970477);
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
  public void test13()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 571.72);
      Object object0 = new Object();
      // Undeclared exception!
      try { 
        outlier0.compareTo(object0);
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // java.lang.Object cannot be cast to org.jfree.chart.renderer.Outlier
         //
         verifyException("org.jfree.chart.renderer.Outlier", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 571.72);
      double double0 = outlier0.getX();
      assertEquals((-571.72), double0, 0.01);
      assertEquals((-571.72), outlier0.getY(), 0.01);
      assertEquals(571.72, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 571.72);
      double double0 = outlier0.getY();
      assertEquals((-571.72), double0, 0.01);
      assertEquals(571.72, outlier0.getRadius(), 0.01);
      assertEquals((-571.72), outlier0.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      Outlier outlier0 = new Outlier((-1.0), (-1.0), (-1194.1096604649574));
      assertEquals((-1194.1096604649574), outlier0.getRadius(), 0.01);
      
      outlier0.setRadius((-1.0));
      Outlier outlier1 = new Outlier((-1.0), (-1.0), (-1194.1096604649574));
      boolean boolean0 = outlier0.equals(outlier1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      Outlier outlier0 = new Outlier(1892.300442644968, 1892.300442644968, 1892.300442644968);
      Outlier outlier1 = new Outlier(1892.300442644968, 1892.300442644968, (-3522.7477));
      boolean boolean0 = outlier0.equals(outlier1);
      assertEquals(5415.048142644968, outlier1.getY(), 0.01);
      assertEquals(5415.048142644968, outlier1.getX(), 0.01);
      assertFalse(boolean0);
      assertEquals((-3522.7477), outlier1.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      Outlier outlier0 = new Outlier((-1.0), (-1.0), (-1194.1096604649574));
      Outlier outlier1 = new Outlier((-1.0), (-1.0), (-1194.1096604649574));
      boolean boolean0 = outlier0.equals(outlier1);
      assertEquals(1193.1096604649574, outlier1.getY(), 0.01);
      assertEquals((-1194.1096604649574), outlier1.getRadius(), 0.01);
      assertTrue(boolean0);
      assertEquals(1193.1096604649574, outlier1.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      Outlier outlier0 = new Outlier((-1.0), (-1.0), (-1194.1096604649574));
      boolean boolean0 = outlier0.equals(outlier0);
      assertEquals(1193.1096604649574, outlier0.getY(), 0.01);
      assertEquals(1193.1096604649574, outlier0.getX(), 0.01);
      assertEquals((-1194.1096604649574), outlier0.getRadius(), 0.01);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 571.72);
      Object object0 = new Object();
      boolean boolean0 = outlier0.equals(object0);
      assertEquals((-571.72), outlier0.getX(), 0.01);
      assertEquals((-571.72), outlier0.getY(), 0.01);
      assertFalse(boolean0);
      assertEquals(571.72, outlier0.getRadius(), 0.01);
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      Outlier outlier0 = new Outlier(1.0, 1.0, 1.0);
      Outlier outlier1 = new Outlier(1.0, (-3772.22621344), 0.0);
      outlier1.setRadius(2481.0);
      boolean boolean0 = outlier1.overlaps(outlier0);
      assertEquals(2481.0, outlier1.getRadius(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      Outlier outlier0 = new Outlier(780.963193699, 0.0, 780.963193699);
      assertEquals((-780.963193699), outlier0.getY(), 0.01);
      
      Point2D.Double point2D_Double0 = new Point2D.Double(780.963193699, 780.963193699);
      outlier0.setPoint(point2D_Double0);
      Outlier outlier1 = new Outlier(780.963193699, 0.0, 780.963193699);
      boolean boolean0 = outlier0.overlaps(outlier1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      Outlier outlier1 = new Outlier(1498.61784098268, (-576.015595), (-576.015595));
      boolean boolean0 = outlier0.overlaps(outlier1);
      assertEquals((-576.015595), outlier1.getRadius(), 0.01);
      assertEquals(0.0, outlier1.getY(), 0.01);
      assertEquals(2074.63343598268, outlier1.getX(), 0.01);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      Outlier outlier0 = new Outlier(780.963193699, 0.0, 780.963193699);
      boolean boolean0 = outlier0.overlaps(outlier0);
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertEquals(780.963193699, outlier0.getRadius(), 0.01);
      assertTrue(boolean0);
      assertEquals((-780.963193699), outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, (-787.92), (-787.92));
      boolean boolean0 = outlier0.overlaps(outlier0);
      assertEquals(787.92, outlier0.getX(), 0.01);
      assertFalse(boolean0);
      assertEquals(0.0, outlier0.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      Outlier outlier0 = new Outlier(1228.5316372733214, 1228.5316372733214, 1228.5316372733214);
      Outlier outlier1 = new Outlier((-3149.796295041933), 1228.5316372733214, (-3149.796295041933));
      int int0 = outlier0.compareTo(outlier1);
      assertEquals((-1), int0);
      assertEquals(0.0, outlier1.getX(), 0.01);
      assertEquals((-3149.796295041933), outlier1.getRadius(), 0.01);
      assertEquals(4378.327932315255, outlier1.getY(), 0.01);
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      Outlier outlier0 = new Outlier(3463.75, 3463.75, 3463.75);
      Outlier outlier1 = new Outlier(3463.75, 3463.75, 1.0);
      int int0 = outlier0.compareTo(outlier1);
      assertEquals(1.0, outlier1.getRadius(), 0.01);
      assertEquals(3462.75, outlier1.getY(), 0.01);
      assertEquals(3462.75, outlier1.getX(), 0.01);
      assertEquals((-1), int0);
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 0.0);
      int int0 = outlier0.compareTo(outlier0);
      assertEquals(0.0, outlier0.getRadius(), 0.01);
      assertEquals(0.0, outlier0.getY(), 0.01);
      assertEquals(0.0, outlier0.getX(), 0.01);
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 571.72);
      Outlier outlier1 = new Outlier((-571.72), (-571.72), 571.72);
      int int0 = outlier0.compareTo(outlier1);
      assertEquals((-571.72), outlier0.getY(), 0.01);
      assertEquals(571.72, outlier1.getRadius(), 0.01);
      assertEquals(1, int0);
      assertEquals((-1143.44), outlier1.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 571.72);
      assertEquals(571.72, outlier0.getRadius(), 0.01);
      
      outlier0.setRadius((-571.72));
      double double0 = outlier0.getRadius();
      assertEquals((-571.72), double0, 0.01);
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      Outlier outlier0 = new Outlier(0.0, 0.0, 571.72);
      double double0 = outlier0.getRadius();
      assertEquals((-571.72), outlier0.getY(), 0.01);
      assertEquals(571.72, double0, 0.01);
      assertEquals((-571.72), outlier0.getX(), 0.01);
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      Outlier outlier0 = new Outlier((-26.309773142031794), (-26.309773142031794), (-26.309773142031794));
      String string0 = outlier0.toString();
      assertEquals((-26.309773142031794), outlier0.getRadius(), 0.01);
      assertEquals("{0.0,0.0}", string0);
  }
}

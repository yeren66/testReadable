/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 07:19:42 GMT 2025
 */

package org.jfree.chart.ui;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JTree;
import javax.swing.JViewport;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.jfree.chart.ui.GradientPaintTransformType;
import org.jfree.chart.ui.StandardGradientPaintTransformer;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class StandardGradientPaintTransformer_ESTest extends StandardGradientPaintTransformer_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      GradientPaintTransformType gradientPaintTransformType0 = GradientPaintTransformType.CENTER_VERTICAL;
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer(gradientPaintTransformType0);
      Point2D.Float point2D_Float0 = new Point2D.Float(1253.65F, 1253.65F);
      SystemColor systemColor0 = SystemColor.menuText;
      GradientPaint gradientPaint0 = new GradientPaint(point2D_Float0, systemColor0, point2D_Float0, systemColor0);
      JTree jTree0 = new JTree();
      Rectangle rectangle0 = jTree0.getRowBounds(0);
      GradientPaint gradientPaint1 = standardGradientPaintTransformer0.transform(gradientPaint0, rectangle0);
      assertTrue(gradientPaint1.isCyclic());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      GradientPaintTransformType gradientPaintTransformType0 = GradientPaintTransformType.CENTER_HORIZONTAL;
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer(gradientPaintTransformType0);
      standardGradientPaintTransformer0.hashCode();
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer();
      GradientPaintTransformType gradientPaintTransformType0 = GradientPaintTransformType.CENTER_HORIZONTAL;
      StandardGradientPaintTransformer standardGradientPaintTransformer1 = new StandardGradientPaintTransformer(gradientPaintTransformType0);
      boolean boolean0 = standardGradientPaintTransformer0.equals(standardGradientPaintTransformer1);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      GradientPaintTransformType gradientPaintTransformType0 = GradientPaintTransformType.CENTER_HORIZONTAL;
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer(gradientPaintTransformType0);
      Object object0 = new Object();
      boolean boolean0 = standardGradientPaintTransformer0.equals(object0);
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer();
      boolean boolean0 = standardGradientPaintTransformer0.equals(standardGradientPaintTransformer0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      GradientPaintTransformType gradientPaintTransformType0 = GradientPaintTransformType.CENTER_VERTICAL;
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer(gradientPaintTransformType0);
      Line2D.Float line2D_Float0 = new Line2D.Float();
      // Undeclared exception!
      try { 
        standardGradientPaintTransformer0.transform((GradientPaint) null, line2D_Float0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jfree.chart.ui.StandardGradientPaintTransformer", e);
      }
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      GradientPaintTransformType gradientPaintTransformType0 = GradientPaintTransformType.HORIZONTAL;
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer(gradientPaintTransformType0);
      JViewport jViewport0 = new JViewport();
      Point point0 = jViewport0.getViewPosition();
      SystemColor systemColor0 = SystemColor.inactiveCaptionBorder;
      GradientPaint gradientPaint0 = new GradientPaint(point0, systemColor0, point0, systemColor0, false);
      Line2D.Double line2D_Double0 = new Line2D.Double();
      Rectangle2D rectangle2D0 = line2D_Double0.getBounds2D();
      GradientPaint gradientPaint1 = standardGradientPaintTransformer0.transform(gradientPaint0, rectangle2D0);
      assertNotSame(gradientPaint1, gradientPaint0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer();
      GridBagLayout gridBagLayout0 = new GridBagLayout();
      Point point0 = gridBagLayout0.getLayoutOrigin();
      Color color0 = Color.green;
      GradientPaint gradientPaint0 = new GradientPaint(point0, color0, point0, color0);
      Rectangle2D.Double rectangle2D_Double0 = new Rectangle2D.Double();
      GradientPaint gradientPaint1 = standardGradientPaintTransformer0.transform(gradientPaint0, rectangle2D_Double0);
      assertNotSame(gradientPaint1, gradientPaint0);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      GradientPaintTransformType gradientPaintTransformType0 = GradientPaintTransformType.CENTER_HORIZONTAL;
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer(gradientPaintTransformType0);
      JViewport jViewport0 = new JViewport();
      Point point0 = jViewport0.getViewPosition();
      SystemColor systemColor0 = SystemColor.inactiveCaptionBorder;
      GradientPaint gradientPaint0 = new GradientPaint(point0, systemColor0, point0, systemColor0, true);
      Line2D.Double line2D_Double0 = new Line2D.Double();
      Rectangle2D rectangle2D0 = line2D_Double0.getBounds2D();
      GradientPaint gradientPaint1 = standardGradientPaintTransformer0.transform(gradientPaint0, rectangle2D0);
      assertTrue(gradientPaint1.isCyclic());
      assertNotSame(gradientPaint1, gradientPaint0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = null;
      try {
        standardGradientPaintTransformer0 = new StandardGradientPaintTransformer((GradientPaintTransformType) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Null 'type' argument.
         //
         verifyException("org.jfree.chart.ui.StandardGradientPaintTransformer", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      GradientPaintTransformType gradientPaintTransformType0 = GradientPaintTransformType.CENTER_HORIZONTAL;
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer(gradientPaintTransformType0);
      Object object0 = standardGradientPaintTransformer0.clone();
      boolean boolean0 = standardGradientPaintTransformer0.equals(object0);
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      StandardGradientPaintTransformer standardGradientPaintTransformer0 = new StandardGradientPaintTransformer();
      GradientPaintTransformType gradientPaintTransformType0 = standardGradientPaintTransformer0.getType();
      assertEquals("GradientPaintTransformType.VERTICAL", gradientPaintTransformType0.toString());
  }
}

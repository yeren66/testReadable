/*
 * This file was automatically generated by EvoSuite
 * Wed Jun 18 07:24:14 GMT 2025
 */

package org.jfree.chart;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import java.sql.Connection;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartTheme;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.CombinedRangeCategoryPlot;
import org.jfree.chart.plot.CombinedRangeXYPlot;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.SlidingGanttCategoryDataset;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.jfree.data.general.DefaultKeyedValuesDataset;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.jdbc.JDBCPieDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.statistics.DefaultStatisticalCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.time.TimePeriodValues;
import org.jfree.data.time.TimePeriodValuesCollection;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.CategoryTableXYDataset;
import org.jfree.data.xy.DefaultIntervalXYDataset;
import org.jfree.data.xy.DefaultOHLCDataset;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.DefaultWindDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.DefaultXYZDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.MatrixSeries;
import org.jfree.data.xy.MatrixSeriesCollection;
import org.jfree.data.xy.OHLCDataItem;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XIntervalSeriesCollection;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYIntervalSeriesCollection;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYZDataset;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class ChartFactory_ESTest extends ChartFactory_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      PlotOrientation plotOrientation0 = PlotOrientation.VERTICAL;
      XYSeriesCollection xYSeriesCollection0 = new XYSeriesCollection();
      JFreeChart jFreeChart0 = ChartFactory.createXYStepAreaChart("%", "^", "n]T:vO/>g6YE3be", (XYDataset) xYSeriesCollection0, plotOrientation0, true, true, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      LogarithmicAxis logarithmicAxis0 = new LogarithmicAxis("qr(xI5XI](In)C");
      XYBubbleRenderer xYBubbleRenderer0 = new XYBubbleRenderer();
      XYPlot xYPlot0 = new XYPlot((XYDataset) null, logarithmicAxis0, logarithmicAxis0, xYBubbleRenderer0);
      PlotOrientation plotOrientation0 = xYPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYBarChart("", "k$kU*n:dZ.d", false, "k$kU*n:dZ.d", (IntervalXYDataset) null, plotOrientation0, false, true, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      FastScatterPlot fastScatterPlot0 = new FastScatterPlot();
      PlotOrientation plotOrientation0 = fastScatterPlot0.getOrientation();
      WaferMapDataset waferMapDataset0 = new WaferMapDataset(10, 10);
      JFreeChart jFreeChart0 = ChartFactory.createWaferMapChart("JFree", waferMapDataset0, plotOrientation0, false, false, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      DefaultTableXYDataset defaultTableXYDataset0 = new DefaultTableXYDataset();
      PolarPlot polarPlot0 = new PolarPlot();
      PlotOrientation plotOrientation0 = polarPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createStackedXYAreaChart("}rnn;4", "", "J^np9\"7S=I|f7o", (TableXYDataset) defaultTableXYDataset0, plotOrientation0, false, true, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Connection connection0 = mock(Connection.class, new ViolatedAssumptionAnswer());
      JDBCPieDataset jDBCPieDataset0 = new JDBCPieDataset(connection0);
      JFreeChart jFreeChart0 = ChartFactory.createRingChart("Legacy", (PieDataset) jDBCPieDataset0, true, true, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      TimePeriodValues timePeriodValues0 = new TimePeriodValues("");
      TimePeriodValuesCollection timePeriodValuesCollection0 = new TimePeriodValuesCollection(timePeriodValues0);
      XYBarDataset xYBarDataset0 = new XYBarDataset(timePeriodValuesCollection0, 0.5F);
      JFreeChart jFreeChart0 = ChartFactory.createPolarChart("org.jfree.chart.ui.Layer", xYBarDataset0, true, false, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      TableOrder tableOrder0 = TableOrder.BY_ROW;
      JFreeChart jFreeChart0 = ChartFactory.createMultiplePieChart("T9KLrs=Nd%bJ.@1A6j", taskSeriesCollection0, tableOrder0, true, true, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      DefaultBoxAndWhiskerCategoryDataset defaultBoxAndWhiskerCategoryDataset0 = new DefaultBoxAndWhiskerCategoryDataset();
      JFreeChart jFreeChart0 = ChartFactory.createBoxAndWhiskerChart("*%pUa+7`HhO", "*%pUa+7`HhO", "*%pUa+7`HhO", (BoxAndWhiskerCategoryDataset) defaultBoxAndWhiskerCategoryDataset0, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      // Undeclared exception!
      try { 
        ChartFactory.setChartTheme((ChartTheme) null);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Null 'theme' argument.
         //
         verifyException("org.jfree.chart.util.Args", e);
      }
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      XIntervalSeriesCollection xIntervalSeriesCollection0 = new XIntervalSeriesCollection();
      // Undeclared exception!
      try { 
        ChartFactory.createXYLineChart("gi]9C(aEXKzykq", "order", "order", (XYDataset) xIntervalSeriesCollection0, (PlotOrientation) null, true, true, true);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Null 'orientation' argument.
         //
         verifyException("org.jfree.chart.util.Args", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      SlidingGanttCategoryDataset slidingGanttCategoryDataset0 = new SlidingGanttCategoryDataset(taskSeriesCollection0, 0, (-1015));
      // Undeclared exception!
      try { 
        ChartFactory.createWaterfallChart("\"Iv!F<=h7", "ax)Pf", "JFree", slidingGanttCategoryDataset0, (PlotOrientation) null, true, true, true);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Null 'orientation' argument.
         //
         verifyException("org.jfree.chart.util.Args", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      DefaultStatisticalCategoryDataset defaultStatisticalCategoryDataset0 = new DefaultStatisticalCategoryDataset();
      // Undeclared exception!
      try { 
        ChartFactory.createLineChart("ChartChangeEventType.DATASET_UPDATED", "", "BACKGROUND", (CategoryDataset) defaultStatisticalCategoryDataset0, (PlotOrientation) null, false, false, false);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Null 'orientation' argument.
         //
         verifyException("org.jfree.chart.util.Args", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      OHLCDataItem[] oHLCDataItemArray0 = new OHLCDataItem[2];
      DateAxis dateAxis0 = new DateAxis("Z]2E&NYc15Uw&i'sP");
      Date date0 = dateAxis0.getMinimumDate();
      OHLCDataItem oHLCDataItem0 = new OHLCDataItem(date0, 2.0F, (-64.612), 500, (-731.213215), 500);
      oHLCDataItemArray0[0] = oHLCDataItem0;
      oHLCDataItemArray0[1] = oHLCDataItemArray0[0];
      DefaultOHLCDataset defaultOHLCDataset0 = new DefaultOHLCDataset((Comparable) null, oHLCDataItemArray0);
      // Undeclared exception!
      try { 
        ChartFactory.createCandlestickChart((String) null, (String) null, "3tV[f7`}J^U~", defaultOHLCDataset0, false);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Range(double, double): require lower (500.0) <= upper (-64.612).
         //
         verifyException("org.jfree.data.Range", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      MatrixSeriesCollection matrixSeriesCollection0 = new MatrixSeriesCollection((MatrixSeries) null);
      CombinedDomainCategoryPlot combinedDomainCategoryPlot0 = new CombinedDomainCategoryPlot();
      PlotOrientation plotOrientation0 = combinedDomainCategoryPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYStepAreaChart("", "", "\"Iv!F<=h7", (XYDataset) matrixSeriesCollection0, plotOrientation0, false, true, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      DefaultWindDataset defaultWindDataset0 = new DefaultWindDataset();
      DefaultValueDataset defaultValueDataset0 = new DefaultValueDataset();
      ThermometerPlot thermometerPlot0 = new ThermometerPlot(defaultValueDataset0);
      PlotOrientation plotOrientation0 = thermometerPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYLineChart("positions", "D]Hv$}c", "D]Hv$}c", (XYDataset) defaultWindDataset0, plotOrientation0, false, true, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      TimeSeries timeSeries0 = new TimeSeries("org.jfree.chart.title.DateTitle", (String) null, "T^OhWIQtjgD%A");
      SimpleTimeZone simpleTimeZone0 = new SimpleTimeZone(3357, "WC");
      TimeSeriesCollection timeSeriesCollection0 = new TimeSeriesCollection(timeSeries0, simpleTimeZone0);
      FastScatterPlot fastScatterPlot0 = new FastScatterPlot();
      PlotOrientation plotOrientation0 = fastScatterPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYAreaChart("org.jfree.chart.title.DateTitle", "org.jfree.chart.title.DateTitle", "osqT6z0,&", (XYDataset) timeSeriesCollection0, plotOrientation0, true, true, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      HistogramDataset histogramDataset0 = new HistogramDataset();
      PeriodAxis periodAxis0 = new PeriodAxis("");
      CombinedDomainXYPlot combinedDomainXYPlot0 = new CombinedDomainXYPlot(periodAxis0);
      PlotOrientation plotOrientation0 = combinedDomainXYPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYAreaChart("Series Title", "piNkr./8", "piNkr./8", (XYDataset) histogramDataset0, plotOrientation0, false, true, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      JFreeChart jFreeChart0 = ChartFactory.createGanttChart("6V`l$!s", "x(q", "6V`l$!s", (IntervalCategoryDataset) taskSeriesCollection0, true, true, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      CombinedRangeCategoryPlot combinedRangeCategoryPlot0 = new CombinedRangeCategoryPlot();
      PlotOrientation plotOrientation0 = combinedRangeCategoryPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createLineChart("'Y", "@FjI._h_", "JFree", (CategoryDataset) taskSeriesCollection0, plotOrientation0, true, true, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test19()  throws Throwable  {
      ThermometerPlot thermometerPlot0 = new ThermometerPlot();
      PlotOrientation plotOrientation0 = thermometerPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createBarChart("U~", "U~", "U~", (CategoryDataset) null, plotOrientation0, true, true, false);
      assertEquals(0.5F, JFreeChart.DEFAULT_BACKGROUND_IMAGE_ALPHA, 0.01F);
  }

  @Test(timeout = 4000)
  public void test20()  throws Throwable  {
      MatrixSeriesCollection matrixSeriesCollection0 = new MatrixSeriesCollection();
      DefaultValueDataset defaultValueDataset0 = new DefaultValueDataset();
      ThermometerPlot thermometerPlot0 = new ThermometerPlot(defaultValueDataset0);
      PlotOrientation plotOrientation0 = thermometerPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createBubbleChart("d\"p*Pk.De&", "d\"p*Pk.De&", "d\"p*Pk.De&", (XYZDataset) matrixSeriesCollection0, plotOrientation0, true, true, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test21()  throws Throwable  {
      DefaultXYZDataset defaultXYZDataset0 = new DefaultXYZDataset();
      PlotOrientation plotOrientation0 = PlotOrientation.VERTICAL;
      JFreeChart jFreeChart0 = ChartFactory.createBubbleChart("%", "^", (String) null, (XYZDataset) defaultXYZDataset0, plotOrientation0, false, false, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test22()  throws Throwable  {
      DefaultXYDataset defaultXYDataset0 = new DefaultXYDataset();
      JFreeChart jFreeChart0 = ChartFactory.createTimeSeriesChart("=THSY0xS", "6V`l$!s", "v/5:P,euv0.7=B!Vh", (XYDataset) defaultXYDataset0, false, true, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test23()  throws Throwable  {
      TimeSeries timeSeries0 = new TimeSeries("", (String) null, "`O8");
      TimeZone timeZone0 = TimeZone.getTimeZone("");
      TimeSeriesCollection timeSeriesCollection0 = new TimeSeriesCollection(timeSeries0, timeZone0);
      JFreeChart jFreeChart0 = ChartFactory.createTimeSeriesChart("color", "`O8", "k", (XYDataset) timeSeriesCollection0, true, false, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test24()  throws Throwable  {
      DefaultXYDataset defaultXYDataset0 = new DefaultXYDataset();
      LogarithmicAxis logarithmicAxis0 = new LogarithmicAxis((String) null);
      float[][] floatArray0 = new float[5][7];
      float[] floatArray1 = new float[2];
      floatArray1[0] = (float) 15;
      floatArray1[1] = 0.5F;
      floatArray0[0] = floatArray1;
      FastScatterPlot fastScatterPlot0 = new FastScatterPlot(floatArray0, logarithmicAxis0, logarithmicAxis0);
      PlotOrientation plotOrientation0 = fastScatterPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYStepAreaChart("DatasetRenderingOrder.REVERSE", "", "uK\"xC", (XYDataset) defaultXYDataset0, plotOrientation0, false, false, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test25()  throws Throwable  {
      DefaultXYDataset defaultXYDataset0 = new DefaultXYDataset();
      LogarithmicAxis logarithmicAxis0 = new LogarithmicAxis((String) null);
      DefaultPolarItemRenderer defaultPolarItemRenderer0 = new DefaultPolarItemRenderer();
      PolarPlot polarPlot0 = new PolarPlot(defaultXYDataset0, logarithmicAxis0, defaultPolarItemRenderer0);
      PlotOrientation plotOrientation0 = polarPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYStepChart("=THSY0xS", "", "v/5:P,euv0.7=B!Vh", (XYDataset) defaultXYDataset0, plotOrientation0, true, true, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test26()  throws Throwable  {
      TimeSeries timeSeries0 = new TimeSeries("", (String) null, "`O8");
      TimeZone timeZone0 = TimeZone.getTimeZone("");
      TimeSeriesCollection timeSeriesCollection0 = new TimeSeriesCollection(timeSeries0, timeZone0);
      CategoryPlot categoryPlot0 = new CategoryPlot();
      PlotOrientation plotOrientation0 = categoryPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYStepChart("", ")Nf:fp:VM<):#i;l0_", "", (XYDataset) timeSeriesCollection0, plotOrientation0, false, false, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test27()  throws Throwable  {
      DefaultTableXYDataset defaultTableXYDataset0 = new DefaultTableXYDataset();
      PolarPlot polarPlot0 = new PolarPlot();
      PlotOrientation plotOrientation0 = polarPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createStackedXYAreaChart("orientation", "orientation", "bZEu", (TableXYDataset) defaultTableXYDataset0, plotOrientation0, true, true, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test28()  throws Throwable  {
      DefaultTableXYDataset defaultTableXYDataset0 = new DefaultTableXYDataset();
      PolarPlot polarPlot0 = new PolarPlot();
      PlotOrientation plotOrientation0 = polarPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createStackedXYAreaChart("orientation", "orientation", "", (TableXYDataset) defaultTableXYDataset0, plotOrientation0, true, false, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test29()  throws Throwable  {
      DefaultIntervalXYDataset defaultIntervalXYDataset0 = new DefaultIntervalXYDataset();
      PlotOrientation plotOrientation0 = PlotOrientation.VERTICAL;
      JFreeChart jFreeChart0 = ChartFactory.createXYAreaChart("b:P=\"h8#rERRP", "b:P=\"h8#rERRP", "b:P=\"h8#rERRP", (XYDataset) defaultIntervalXYDataset0, plotOrientation0, false, false, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test30()  throws Throwable  {
      MatrixSeriesCollection matrixSeriesCollection0 = new MatrixSeriesCollection();
      LogarithmicAxis logarithmicAxis0 = new LogarithmicAxis("qr(xI5XI](In)C");
      XYBubbleRenderer xYBubbleRenderer0 = new XYBubbleRenderer();
      XYPlot xYPlot0 = new XYPlot(matrixSeriesCollection0, logarithmicAxis0, logarithmicAxis0, xYBubbleRenderer0);
      PlotOrientation plotOrientation0 = xYPlot0.getOrientation();
      TimePeriodValues timePeriodValues0 = new TimePeriodValues("qr(xI5XI](In)C", "JFree", "{4fI_p0Q]TRL6vQ");
      TimePeriodValuesCollection timePeriodValuesCollection0 = new TimePeriodValuesCollection(timePeriodValues0);
      JFreeChart jFreeChart0 = ChartFactory.createXYBarChart("]m0`EKu-NL]D+?M", "Yuo6%18pUYMGETG{>_|", true, (String) null, (IntervalXYDataset) timePeriodValuesCollection0, plotOrientation0, true, true, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test31()  throws Throwable  {
      PlotOrientation plotOrientation0 = PlotOrientation.VERTICAL;
      XYIntervalSeriesCollection xYIntervalSeriesCollection0 = new XYIntervalSeriesCollection();
      JFreeChart jFreeChart0 = ChartFactory.createXYBarChart("<AOQtkO(k", "%", true, ",):0{g", (IntervalXYDataset) xYIntervalSeriesCollection0, plotOrientation0, true, false, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test32()  throws Throwable  {
      HistogramDataset histogramDataset0 = new HistogramDataset();
      PeriodAxis periodAxis0 = new PeriodAxis("");
      CombinedDomainXYPlot combinedDomainXYPlot0 = new CombinedDomainXYPlot(periodAxis0);
      PlotOrientation plotOrientation0 = combinedDomainXYPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createXYBarChart("{3} - {4}", "", false, "$kE5@QE", (IntervalXYDataset) histogramDataset0, plotOrientation0, true, true, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test33()  throws Throwable  {
      FastScatterPlot fastScatterPlot0 = new FastScatterPlot();
      PlotOrientation plotOrientation0 = fastScatterPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createScatterPlot("=change >=+", "yaIu%,:G%(0", "Y1", (XYDataset) null, plotOrientation0, false, true, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test34()  throws Throwable  {
      DefaultXYZDataset defaultXYZDataset0 = new DefaultXYZDataset();
      PlotOrientation plotOrientation0 = PlotOrientation.VERTICAL;
      JFreeChart jFreeChart0 = ChartFactory.createScatterPlot("yaIu%,:G%(0", "#0O8:%~", "\"Iv!F<=h7", (XYDataset) defaultXYZDataset0, plotOrientation0, true, false, false);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test35()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      LogarithmicAxis logarithmicAxis0 = new LogarithmicAxis("org.jfree.data.xy.XIntervalSeriesCollection");
      CombinedRangeXYPlot combinedRangeXYPlot0 = new CombinedRangeXYPlot(logarithmicAxis0);
      PlotOrientation plotOrientation0 = combinedRangeXYPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createWaterfallChart("\"Iv!F<=h7", "\"Iv!F<=h7", "\"Iv!F<=h7", taskSeriesCollection0, plotOrientation0, true, false, true);
      assertEquals(0.5F, jFreeChart0.getBackgroundImageAlpha(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test36()  throws Throwable  {
      DefaultXYDataset defaultXYDataset0 = new DefaultXYDataset();
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      LogarithmicAxis logarithmicAxis0 = new LogarithmicAxis((String) null);
      DefaultPolarItemRenderer defaultPolarItemRenderer0 = new DefaultPolarItemRenderer();
      PolarPlot polarPlot0 = new PolarPlot(defaultXYDataset0, logarithmicAxis0, defaultPolarItemRenderer0);
      PlotOrientation plotOrientation0 = polarPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createWaterfallChart("", "sWE.%S?|o_", ")", taskSeriesCollection0, plotOrientation0, false, true, false);
      assertFalse(jFreeChart0.isBorderVisible());
  }

  @Test(timeout = 4000)
  public void test37()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      JFreeChart jFreeChart0 = ChartFactory.createGanttChart("t", (String) null, "1+Si44E9F", (IntervalCategoryDataset) taskSeriesCollection0, false, false, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test38()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      PlotOrientation plotOrientation0 = PlotOrientation.HORIZONTAL;
      JFreeChart jFreeChart0 = ChartFactory.createLineChart("dwszIIcJ#nJ4", "UnitType.RELATIVE", "qXHjKf", (CategoryDataset) taskSeriesCollection0, plotOrientation0, true, true, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test39()  throws Throwable  {
      CategoryPlot categoryPlot0 = new CategoryPlot();
      PlotOrientation plotOrientation0 = categoryPlot0.getOrientation();
      JFreeChart jFreeChart0 = ChartFactory.createBarChart((String) null, "org.jfree.chart.ui.Layer", (String) null, (CategoryDataset) null, plotOrientation0, false, false, true);
      assertEquals(0.5F, jFreeChart0.getBackgroundImageAlpha(), 0.01F);
  }

  @Test(timeout = 4000)
  public void test40()  throws Throwable  {
      TableOrder tableOrder0 = TableOrder.BY_COLUMN;
      JFreeChart jFreeChart0 = ChartFactory.createMultiplePieChart3D((String) null, (CategoryDataset) null, tableOrder0, true, true, true);
      assertFalse(jFreeChart0.isBorderVisible());
  }

  @Test(timeout = 4000)
  public void test41()  throws Throwable  {
      TableOrder tableOrder0 = TableOrder.BY_COLUMN;
      JFreeChart jFreeChart0 = ChartFactory.createMultiplePieChart3D("\"Iv!F<=h7", (CategoryDataset) null, tableOrder0, false, false, false);
      assertEquals(0.5F, JFreeChart.DEFAULT_BACKGROUND_IMAGE_ALPHA, 0.01F);
  }

  @Test(timeout = 4000)
  public void test42()  throws Throwable  {
      Locale locale0 = Locale.FRENCH;
      JFreeChart jFreeChart0 = ChartFactory.createPieChart3D("$:8dZ|?RB$n", (PieDataset) null, true, true, locale0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test43()  throws Throwable  {
      Locale locale0 = Locale.FRENCH;
      JFreeChart jFreeChart0 = ChartFactory.createPieChart3D("qXHjKf", (PieDataset) null, false, false, locale0);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test44()  throws Throwable  {
      TableOrder tableOrder0 = TableOrder.BY_ROW;
      JFreeChart jFreeChart0 = ChartFactory.createMultiplePieChart("Ul$j(l&CWvD", (CategoryDataset) null, tableOrder0, false, true, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test45()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      SlidingGanttCategoryDataset slidingGanttCategoryDataset0 = new SlidingGanttCategoryDataset(taskSeriesCollection0, 0, 0);
      TableOrder tableOrder0 = TableOrder.BY_ROW;
      JFreeChart jFreeChart0 = ChartFactory.createMultiplePieChart("", slidingGanttCategoryDataset0, tableOrder0, false, false, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test46()  throws Throwable  {
      Connection connection0 = mock(Connection.class, new ViolatedAssumptionAnswer());
      JDBCPieDataset jDBCPieDataset0 = new JDBCPieDataset(connection0);
      JFreeChart jFreeChart0 = ChartFactory.createRingChart("Legacy", (PieDataset) jDBCPieDataset0, false, true, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test47()  throws Throwable  {
      JFreeChart jFreeChart0 = ChartFactory.createRingChart("$:8dZ|?RB$n", (PieDataset) null, false, false, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test48()  throws Throwable  {
      DefaultKeyedValuesDataset defaultKeyedValuesDataset0 = new DefaultKeyedValuesDataset();
      JFreeChart jFreeChart0 = ChartFactory.createPieChart("H/\"ka:hCSn-k", (PieDataset) defaultKeyedValuesDataset0, false, false, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test49()  throws Throwable  {
      JFreeChart jFreeChart0 = ChartFactory.createPieChart("%", (PieDataset) null, true, true, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test50()  throws Throwable  {
      StandardChartTheme standardChartTheme0 = new StandardChartTheme("U~");
      ChartFactory.setChartTheme(standardChartTheme0);
      assertFalse(standardChartTheme0.isShadowVisible());
  }

  @Test(timeout = 4000)
  public void test51()  throws Throwable  {
      DefaultWindDataset defaultWindDataset0 = new DefaultWindDataset();
      JFreeChart jFreeChart0 = ChartFactory.createXYAreaChart("D]Hv$}c", "!3G~SZ]t;WNi4+B", "D]Hv$}c", (XYDataset) defaultWindDataset0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test52()  throws Throwable  {
      CategoryTableXYDataset categoryTableXYDataset0 = new CategoryTableXYDataset();
      JFreeChart jFreeChart0 = ChartFactory.createStackedXYAreaChart("Unrecognised columnKey: ", "Unrecognised columnKey: ", (String) null, (TableXYDataset) categoryTableXYDataset0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test53()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      JFreeChart jFreeChart0 = ChartFactory.createGanttChart("+", "Series Titl'", "6EV_QJon", (IntervalCategoryDataset) taskSeriesCollection0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test54()  throws Throwable  {
      TaskSeriesCollection taskSeriesCollection0 = new TaskSeriesCollection();
      SlidingGanttCategoryDataset slidingGanttCategoryDataset0 = new SlidingGanttCategoryDataset(taskSeriesCollection0, 0, (-1015));
      JFreeChart jFreeChart0 = ChartFactory.createBarChart("Y1", "Y1", "Y1", (CategoryDataset) slidingGanttCategoryDataset0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test55()  throws Throwable  {
      JFreeChart jFreeChart0 = ChartFactory.createPieChart3D("oB'c&2C7jOgISJrI=+", (PieDataset) null);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test56()  throws Throwable  {
      DefaultBoxAndWhiskerCategoryDataset defaultBoxAndWhiskerCategoryDataset0 = new DefaultBoxAndWhiskerCategoryDataset();
      JFreeChart jFreeChart0 = ChartFactory.createBoxAndWhiskerChart("org.jfree.chart.labels.IntervalCategoryItemLabelGenerator", "##Z", "^#HqpP", (BoxAndWhiskerCategoryDataset) defaultBoxAndWhiskerCategoryDataset0, true);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test57()  throws Throwable  {
      CategoryTableXYDataset categoryTableXYDataset0 = new CategoryTableXYDataset();
      JFreeChart jFreeChart0 = ChartFactory.createTimeSeriesChart("w#<|Q_A@Ba1=4*wj", "", "w#<|Q_A@Ba1=4*wj", (XYDataset) categoryTableXYDataset0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test58()  throws Throwable  {
      XYSeriesCollection xYSeriesCollection0 = new XYSeriesCollection();
      JFreeChart jFreeChart0 = ChartFactory.createScatterPlot((String) null, "1+Si44E9F", "1+Si44E9F", (XYDataset) xYSeriesCollection0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test59()  throws Throwable  {
      MatrixSeriesCollection matrixSeriesCollection0 = new MatrixSeriesCollection();
      JFreeChart jFreeChart0 = ChartFactory.createXYStepAreaChart("", (String) null, "", (XYDataset) matrixSeriesCollection0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test60()  throws Throwable  {
      MatrixSeriesCollection matrixSeriesCollection0 = new MatrixSeriesCollection();
      JFreeChart jFreeChart0 = ChartFactory.createXYLineChart("{3} - {4}", "{3} - {4}", "{3} - {4}", (XYDataset) matrixSeriesCollection0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test61()  throws Throwable  {
      JFreeChart jFreeChart0 = ChartFactory.createStackedBarChart("qXHjKf", "org.jfree.data.time.TimeSeriesTableModel", "", (CategoryDataset) null);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test62()  throws Throwable  {
      StandardChartTheme standardChartTheme0 = (StandardChartTheme)ChartFactory.getChartTheme();
      assertFalse(standardChartTheme0.isShadowVisible());
  }

  @Test(timeout = 4000)
  public void test63()  throws Throwable  {
      JFreeChart jFreeChart0 = ChartFactory.createLineChart("\"Iv!F<=Pah7", "\"Iv!F<=Pah7", "The 'row'{argument iT outMof bounds.", (CategoryDataset) null);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test64()  throws Throwable  {
      TimeSeries timeSeries0 = new TimeSeries("W");
      TimeSeriesCollection timeSeriesCollection0 = new TimeSeriesCollection(timeSeries0);
      JFreeChart jFreeChart0 = ChartFactory.createHistogram("Legacy", "O{<Qm+_z_WQo]3bs@", "{3} - {4}", (IntervalXYDataset) timeSeriesCollection0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test65()  throws Throwable  {
      DefaultBoxAndWhiskerXYDataset defaultBoxAndWhiskerXYDataset0 = new DefaultBoxAndWhiskerXYDataset(0.5F);
      JFreeChart jFreeChart0 = ChartFactory.createBoxAndWhiskerChart("n_%(4nOW9d", "Y1", "n_%(4nOW9d", (BoxAndWhiskerXYDataset) defaultBoxAndWhiskerXYDataset0, false);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test66()  throws Throwable  {
      DefaultXYZDataset defaultXYZDataset0 = new DefaultXYZDataset();
      JFreeChart jFreeChart0 = ChartFactory.createXYStepChart(",aeFXAgzY~C/)L}E", "`/42ib(i6jR,U&`5", ",aeFXAgzY~C/)L}E", (XYDataset) defaultXYZDataset0);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test67()  throws Throwable  {
      WaferMapDataset waferMapDataset0 = new WaferMapDataset(0, 0);
      // Undeclared exception!
      try { 
        ChartFactory.createWaferMapChart("5Z{&4/]$#o2tlU&d_o9", waferMapDataset0, (PlotOrientation) null, false, false, true);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Null 'orientation' argument.
         //
         verifyException("org.jfree.chart.util.Args", e);
      }
  }

  @Test(timeout = 4000)
  public void test68()  throws Throwable  {
      JFreeChart jFreeChart0 = ChartFactory.createBubbleChart("`<a%;?2p0]VRcj)2t~", "theme", "Series Title", (XYZDataset) null);
      assertEquals(1, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test69()  throws Throwable  {
      TimeSeries timeSeries0 = new TimeSeries("", (String) null, "`O8");
      TimeZone timeZone0 = TimeZone.getTimeZone("");
      TimeSeriesCollection timeSeriesCollection0 = new TimeSeriesCollection(timeSeries0, timeZone0);
      JFreeChart jFreeChart0 = ChartFactory.createPolarChart("", timeSeriesCollection0, false, false, true);
      assertEquals(0, jFreeChart0.getSubtitleCount());
  }

  @Test(timeout = 4000)
  public void test70()  throws Throwable  {
      DefaultOHLCDataset defaultOHLCDataset0 = new DefaultOHLCDataset("Ul$j(l&CWvD", (OHLCDataItem[]) null);
      // Undeclared exception!
      try { 
        ChartFactory.createHighLowChart("Ul$j(l&CWvD", "AFG20v", "labelOutlineStroke", defaultOHLCDataset0, true);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("org.jfree.data.xy.DefaultOHLCDataset", e);
      }
  }
}

package org.jfree.chart;

import static org.junit.Assert.assertNotNull;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.Layer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.urls.StandardXYZURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYZDataset;

public class slice4_ChartFactory_createWindPlot_52_0_Test {

    @Test
    public void testCreateWindPlot() {
        // Arrange
        String title = "Wind Plot";
        String xAxisLabel = "Time";
        String yAxisLabel = "Speed";
        WindDataset dataset = Mockito.mock(WindDataset.class);
        boolean legend = true;
        boolean tooltips = true;
        boolean urls = true;
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);
        // Assert
        assertNotNull("Chart should not be null", chart);
        assertNotNull("Chart title should not be null", chart.getTitle());
        assertNotNull("Chart plot should not be null", chart.getPlot());
        XYPlot plot = chart.getXYPlot();
        assertNotNull("Plot should not be null", plot);
        assertNotNull("Plot dataset should not be null", plot.getDataset());
        assertNotNull("Plot xAxis should not be null", plot.getDomainAxis());
        assertNotNull("Plot yAxis should not be null", plot.getRangeAxis());
        ValueAxis xAxis = plot.getDomainAxis();
        ValueAxis yAxis = plot.getRangeAxis();
        assertNotNull("xAxis should not be null", xAxis);
        assertNotNull("yAxis should not be null", yAxis);
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull("Renderer should not be null", renderer);
        if (tooltips) {
            assertNotNull("ToolTipGenerator should not be null", renderer.getDefaultToolTipGenerator());
        }
        if (urls) {
            assertNotNull("URLGenerator should not be null", renderer.getURLGenerator());
        }
    }
}



package org.jfree.chart;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.data.xy.WindDataset;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.Layer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.urls.StandardXYZURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

public class slice5_ChartFactory_createWindPlot_52_0_Test {

    private WindDataset mockDataset;

    private ChartTheme mockTheme;

    @Before
    public void setUp() throws Exception {
        // Mocking the dependencies
        mockDataset = mock(WindDataset.class);
        mockTheme = mock(ChartTheme.class);
        // Use reflection to set the private currentTheme field
        Field themeField = ChartFactory.class.getDeclaredField("currentTheme");
        themeField.setAccessible(true);
        themeField.set(null, mockTheme);
    }

    @Test
    public void testCreateWindPlotWithLegendAndTooltipsAndUrls() {
        // Arrange
        String title = "Wind Chart";
        String xAxisLabel = "Time";
        String yAxisLabel = "Wind Speed";
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, mockDataset, true, true, true);
        // Assert
        assertNotNull("Chart should not be null", chart);
        verify(mockTheme, times(1)).apply(chart);
        XYPlot plot = chart.getXYPlot();
        assertNotNull("Plot should not be null", plot);
        // Verify xAxis and yAxis
        assertNotNull("xAxis should not be null", plot.getDomainAxis());
        assertNotNull("yAxis should not be null", plot.getRangeAxis());
        // Verify renderer
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull("Renderer should not be null", renderer);
        assertNotNull("Tooltip generator should not be null", renderer.getDefaultToolTipGenerator());
        assertNotNull("URL generator should not be null", renderer.getURLGenerator());
    }

    @Test
    public void testCreateWindPlotWithoutLegendAndTooltipsAndUrls() {
        // Arrange
        String title = "Wind Chart";
        String xAxisLabel = "Time";
        String yAxisLabel = "Wind Speed";
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, mockDataset, false, false, false);
        // Assert
        assertNotNull("Chart should not be null", chart);
        verify(mockTheme, times(1)).apply(chart);
        XYPlot plot = chart.getXYPlot();
        assertNotNull("Plot should not be null", plot);
        // Verify xAxis and yAxis
        assertNotNull("xAxis should not be null", plot.getDomainAxis());
        assertNotNull("yAxis should not be null", plot.getRangeAxis());
        // Verify renderer
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull("Renderer should not be null", renderer);
        assertNull("Tooltip generator should be null", renderer.getDefaultToolTipGenerator());
        assertNull("URL generator should be null", renderer.getURLGenerator());
    }
}



package org.jfree.chart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.data.xy.WindDataset;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.Layer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.urls.StandardXYZURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

public class slice1_ChartFactory_createWindPlot_52_0_Test {

    @Test
    public void testCreateWindPlotYAxisConfiguration() {
        // Arrange
        String title = "Wind Plot";
        String xAxisLabel = "Date";
        String yAxisLabel = "Wind Speed";
        WindDataset dataset = Mockito.mock(WindDataset.class);
        boolean legend = true;
        boolean tooltips = false;
        boolean urls = false;
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);
        // Assert
        assertNotNull("Chart should not be null", chart);
        XYPlot plot = chart.getXYPlot();
        assertNotNull("Plot should not be null", plot);
        ValueAxis yAxis = plot.getRangeAxis();
        assertNotNull("Y-axis should not be null", yAxis);
        assertTrue("Y-axis should be an instance of NumberAxis", yAxis instanceof NumberAxis);
        assertEquals("Y-axis label should match", yAxisLabel, yAxis.getLabel());
        assertEquals("Y-axis lower bound should be -12.0", -12.0, yAxis.getLowerBound(), 0.001);
        assertEquals("Y-axis upper bound should be 12.0", 12.0, yAxis.getUpperBound(), 0.001);
    }

    @Test
    public void testCreateWindPlotRendererConfiguration() {
        // Arrange
        String title = "Wind Plot";
        String xAxisLabel = "Date";
        String yAxisLabel = "Wind Speed";
        WindDataset dataset = Mockito.mock(WindDataset.class);
        boolean legend = true;
        boolean tooltips = true;
        boolean urls = true;
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);
        // Assert
        assertNotNull("Chart should not be null", chart);
        XYPlot plot = chart.getXYPlot();
        assertNotNull("Plot should not be null", plot);
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull("Renderer should not be null", renderer);
        assertNotNull("ToolTipGenerator should be set", renderer.getDefaultToolTipGenerator());
        assertNotNull("URLGenerator should be set", renderer.getURLGenerator());
    }
}



package org.jfree.chart;

import static org.junit.Assert.assertNotNull;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.Layer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.urls.StandardXYZURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

public class slice3_ChartFactory_createWindPlot_52_0_Test {

    private WindDataset dataset;

    private String title;

    private String xAxisLabel;

    private String yAxisLabel;

    private boolean legend;

    private boolean tooltips;

    private boolean urls;

    @Before
    public void setUp() {
        dataset = Mockito.mock(WindDataset.class);
        title = "Wind Plot";
        xAxisLabel = "Time";
        yAxisLabel = "Wind Speed";
        legend = true;
        tooltips = true;
        urls = true;
    }

    @Test
    public void testCreateWindPlot() {
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);
        // Assert
        assertNotNull("The chart should not be null", chart);
        // Verify the plot
        XYPlot plot = (XYPlot) chart.getPlot();
        assertNotNull("The plot should not be null", plot);
        assertNotNull("The dataset should not be null", plot.getDataset());
        assertNotNull("The x-axis should not be null", plot.getDomainAxis());
        assertNotNull("The y-axis should not be null", plot.getRangeAxis());
        assertNotNull("The renderer should not be null", plot.getRenderer());
        // Verify x-axis and y-axis
        ValueAxis xAxis = plot.getDomainAxis();
        ValueAxis yAxis = plot.getRangeAxis();
        assertNotNull("The x-axis should be a DateAxis", xAxis);
        assertNotNull("The y-axis should be a NumberAxis", yAxis);
        // Verify renderer
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull("The renderer should be a WindItemRenderer", renderer);
        // Verify tooltips and URLs
        if (tooltips) {
            assertNotNull("ToolTips should be set", renderer.getDefaultToolTipGenerator());
        }
        if (urls) {
            assertNotNull("URLs should be set", renderer.getURLGenerator());
        }
    }
}



package org.jfree.chart;

import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.data.xy.WindDataset;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.Layer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.urls.StandardXYZURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

public class slice0_ChartFactory_createWindPlot_52_0_Test {

    private WindDataset mockDataset;

    @Before
    public void setUp() {
        // Create a mock WindDataset
        mockDataset = Mockito.mock(WindDataset.class);
    }

    @Test
    public void testCreateWindPlot_withAllParameters() {
        // Test with all parameters set to true
        JFreeChart chart = ChartFactory.createWindPlot("Wind Plot Title", "Time", "Wind Speed", mockDataset, true, true, true);
        // Verify that the chart is not null
        assertNotNull("The chart should not be null", chart);
        // Verify that the plot is an instance of XYPlot
        assertTrue("The plot should be an instance of XYPlot", chart.getPlot() instanceof XYPlot);
        // Verify that the renderer is an instance of WindItemRenderer
        XYPlot plot = (XYPlot) chart.getPlot();
        assertTrue("The renderer should be an instance of WindItemRenderer", plot.getRenderer() instanceof WindItemRenderer);
        // Verify that the x-axis is a DateAxis
        assertTrue("The x-axis should be an instance of DateAxis", plot.getDomainAxis() instanceof DateAxis);
        // Verify that the y-axis is a NumberAxis
        assertTrue("The y-axis should be an instance of NumberAxis", plot.getRangeAxis() instanceof NumberAxis);
        // Verify that the tooltip generator is set
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertTrue("The tooltip generator should be an instance of StandardXYToolTipGenerator", renderer.getDefaultToolTipGenerator() instanceof StandardXYToolTipGenerator);
        // Verify that the URL generator is set
        assertTrue("The URL generator should be an instance of StandardXYURLGenerator", renderer.getURLGenerator() instanceof StandardXYURLGenerator);
    }

    @Test
    public void testCreateWindPlot_withoutTooltipsAndUrls() {
        // Test with tooltips and URLs set to false
        JFreeChart chart = ChartFactory.createWindPlot("Wind Plot Title", "Time", "Wind Speed", mockDataset, true, false, false);
        // Verify that the chart is not null
        assertNotNull("The chart should not be null", chart);
        // Verify that the plot is an instance of XYPlot
        assertTrue("The plot should be an instance of XYPlot", chart.getPlot() instanceof XYPlot);
        // Verify that the renderer is an instance of WindItemRenderer
        XYPlot plot = (XYPlot) chart.getPlot();
        assertTrue("The renderer should be an instance of WindItemRenderer", plot.getRenderer() instanceof WindItemRenderer);
        // Verify that the x-axis is a DateAxis
        assertTrue("The x-axis should be an instance of DateAxis", plot.getDomainAxis() instanceof DateAxis);
        // Verify that the y-axis is a NumberAxis
        assertTrue("The y-axis should be an instance of NumberAxis", plot.getRangeAxis() instanceof NumberAxis);
        // Verify that the tooltip generator is not set
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertTrue("The tooltip generator should be null", renderer.getDefaultToolTipGenerator() == null);
        // Verify that the URL generator is not set
        assertTrue("The URL generator should be null", renderer.getURLGenerator() == null);
    }
}



package org.jfree.chart;

import static org.junit.Assert.assertNotNull;
import org.jfree.chart.renderer.xy.WindItemRenderer;
import org.jfree.chart.urls.StandardXYURLGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.data.xy.WindDataset;
import org.junit.Test;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.labels.HighLowItemLabelGenerator;
import org.jfree.chart.labels.IntervalCategoryToolTipGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieToolTipGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.labels.StandardXYZToolTipGenerator;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Marker;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.WaferMapPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.DefaultPolarItemRenderer;
import org.jfree.chart.renderer.WaferMapRenderer;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.chart.renderer.category.GradientBarPainter;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StackedAreaRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.renderer.category.WaterfallBarRenderer;
import org.jfree.chart.renderer.xy.CandlestickRenderer;
import org.jfree.chart.renderer.xy.GradientXYBarPainter;
import org.jfree.chart.renderer.xy.HighLowRenderer;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer2;
import org.jfree.chart.renderer.xy.StandardXYBarPainter;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYBoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.XYBubbleRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.Layer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.chart.urls.PieURLGenerator;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.chart.urls.StandardXYZURLGenerator;
import org.jfree.chart.urls.XYURLGenerator;
import org.jfree.chart.util.Args;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.general.WaferMapDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerXYDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.OHLCDataset;
import org.jfree.data.xy.TableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYZDataset;

public class slice2_ChartFactory_createWindPlot_52_0_Test {

    @Test
    public void testCreateWindPlot_WithTooltipsAndUrls() {
        // Arrange
        String title = "Wind Plot";
        String xAxisLabel = "X Axis";
        String yAxisLabel = "Y Axis";
        WindDataset dataset = mock(WindDataset.class);
        boolean legend = true;
        boolean tooltips = true;
        boolean urls = true;
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);
        // Assert
        assertNotNull(chart);
        XYPlot plot = chart.getXYPlot();
        assertNotNull(plot);
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull(renderer);
        // Verify that the renderer has the correct tool tip generator and URL generator
        assertNotNull(renderer.getDefaultToolTipGenerator());
        assertNotNull(renderer.getURLGenerator());
    }

    @Test
    public void testCreateWindPlot_WithTooltipsOnly() {
        // Arrange
        String title = "Wind Plot";
        String xAxisLabel = "X Axis";
        String yAxisLabel = "Y Axis";
        WindDataset dataset = mock(WindDataset.class);
        boolean legend = true;
        boolean tooltips = true;
        boolean urls = false;
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);
        // Assert
        assertNotNull(chart);
        XYPlot plot = chart.getXYPlot();
        assertNotNull(plot);
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull(renderer);
        // Verify that the renderer has the correct tool tip generator and no URL generator
        assertNotNull(renderer.getDefaultToolTipGenerator());
        assertNotNull(renderer.getURLGenerator());
    }

    @Test
    public void testCreateWindPlot_WithUrlsOnly() {
        // Arrange
        String title = "Wind Plot";
        String xAxisLabel = "X Axis";
        String yAxisLabel = "Y Axis";
        WindDataset dataset = mock(WindDataset.class);
        boolean legend = true;
        boolean tooltips = false;
        boolean urls = true;
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);
        // Assert
        assertNotNull(chart);
        XYPlot plot = chart.getXYPlot();
        assertNotNull(plot);
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull(renderer);
        // Verify that the renderer has no tool tip generator and the correct URL generator
        assertNotNull(renderer.getDefaultToolTipGenerator());
        assertNotNull(renderer.getURLGenerator());
    }

    @Test
    public void testCreateWindPlot_WithoutTooltipsAndUrls() {
        // Arrange
        String title = "Wind Plot";
        String xAxisLabel = "X Axis";
        String yAxisLabel = "Y Axis";
        WindDataset dataset = mock(WindDataset.class);
        boolean legend = true;
        boolean tooltips = false;
        boolean urls = false;
        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);
        // Assert
        assertNotNull(chart);
        XYPlot plot = chart.getXYPlot();
        assertNotNull(plot);
        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull(renderer);
        // Verify that the renderer has no tool tip generator and no URL generator
        assertNotNull(renderer.getDefaultToolTipGenerator());
        assertNotNull(renderer.getURLGenerator());
    }
}




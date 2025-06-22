package org.jfree.chart;

import static org.junit.Assert.*;

import org.junit.Test;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.DefaultWindDataset;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.WindItemRenderer;

public class ChartFactoryTest {
    @Test
    public void testCreateWindPlot_withLegendAndTooltipsAndUrls() {
        WindDataset dataset = createSampleDataset();
        JFreeChart chart = ChartFactory.createWindPlot("Sample Wind Plot", "Time", "Wind Speed", dataset, true, true, true);

        assertNotNull("Chart should not be null", chart);
        assertEquals("Chart title should match", "Sample Wind Plot", chart.getTitle().getText());

        XYPlot plot = chart.getXYPlot();
        assertNotNull("XYPlot should not be null", plot);
        
        DateAxis xAxis = (DateAxis) plot.getDomainAxis();
        assertEquals("XAxis label should match", "Time", xAxis.getLabel());

        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        assertEquals("YAxis label should match", "Wind Speed", yAxis.getLabel());
        assertEquals("YAxis range lower bound should match", -12.0, yAxis.getRange().getLowerBound(), 0.001);
        assertEquals("YAxis range upper bound should match", 12.0, yAxis.getRange().getUpperBound(), 0.001);

        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull("Renderer should not be null", renderer);
        assertNotNull("ToolTipGenerator should be initialized", renderer.getDefaultToolTipGenerator());
        assertNotNull("URLGenerator should be initialized", renderer.getURLGenerator());
    }

    @Test
    public void testCreateWindPlot_withoutLegendAndTooltipsAndUrls() {
        WindDataset dataset = createSampleDataset();
        JFreeChart chart = ChartFactory.createWindPlot("Sample Wind Plot", "Time", "Wind Speed", dataset, false, false, false);

        assertNotNull("Chart should not be null", chart);
        assertEquals("Chart title should match", "Sample Wind Plot", chart.getTitle().getText());

        XYPlot plot = chart.getXYPlot();
        assertNotNull("XYPlot should not be null", plot);

        DateAxis xAxis = (DateAxis) plot.getDomainAxis();
        assertEquals("XAxis label should match", "Time", xAxis.getLabel());

        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        assertEquals("YAxis label should match", "Wind Speed", yAxis.getLabel());
        assertEquals("YAxis range lower bound should match", -12.0, yAxis.getRange().getLowerBound(), 0.001);
        assertEquals("YAxis range upper bound should match", 12.0, yAxis.getRange().getUpperBound(), 0.001);

        WindItemRenderer renderer = (WindItemRenderer) plot.getRenderer();
        assertNotNull("Renderer should not be null", renderer);
        assertNull("ToolTipGenerator should not be initialized", renderer.getDefaultToolTipGenerator());
        assertNull("URLGenerator should not be initialized", renderer.getURLGenerator());
    }

    private WindDataset createSampleDataset() {
        // Create a simple dataset with sample data
        // Replace this with actual dataset creation logic if necessary
        return new DefaultWindDataset();
    }
}
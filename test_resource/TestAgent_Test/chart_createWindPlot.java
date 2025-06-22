package org.jfree.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.WindDataset;
import org.jfree.data.xy.DefaultWindDataset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the ChartFactory.createWindPlot method.
 * Covers various scenarios including normal behavior, boundary conditions, and exceptional cases.
 */
public class OutlierTest {

    private WindDataset mockDataset;

    /**
     * Sets up a mock WindDataset for use in the tests.
     */
    @BeforeEach
    public void setUp() {
        mockDataset = Mockito.mock(DefaultWindDataset.class);
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior with all valid inputs to ensure the chart is created with default settings.', 
     * 'Input_Type': 'A valid title, valid x-axis and y-axis labels, a valid WindDataset, and true for legend, tooltips, and URLs.', 
     * 'Output_Type': 'A JFreeChart instance with the specified title, axes labeled, dataset plot, tooltips, URL generation, and legend.'}
     */
    @Test
    @DisplayName("Create Wind Plot with Valid Inputs - Chart Created with Default Settings")
    public void testCreateWindPlotWithValidInputs() {
        // Arrange
        String title = "Wind Plot";
        String xAxisLabel = "Time";
        String yAxisLabel = "Wind Speed";
        boolean legend = true;
        boolean tooltips = true;
        boolean urls = true;

        // Act
        JFreeChart chart = ChartFactory.createWindPlot(
                title, xAxisLabel, yAxisLabel, mockDataset, legend, tooltips, urls);

        // Assert
        assertNotNull(chart, "Chart should not be null");
        assertEquals(title, chart.getTitle().getText(), "Chart title should match the input title");
        assertNotNull(chart.getPlot(), "Chart plot should not be null");
        assertTrue(chart.getPlot() instanceof XYPlot, "Chart plot should be an instance of XYPlot");

        XYPlot plot = (XYPlot) chart.getPlot();
        assertEquals(mockDataset, plot.getDataset(), "Dataset in the plot should match the input dataset");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test boundary condition with null values for title, xAxisLabel, and yAxisLabel to verify if the method handles nullable parameters.', 
     * 'Input_Type': 'Null values for title, xAxisLabel, and yAxisLabel, valid WindDataset, and false for legend, tooltips, and URLs.', 
     * 'Output_Type': 'A JFreeChart instance with no title or axis labels shown, no legend, tooltips, or URLs in the chart.'}
     */
    @Test
    @DisplayName("Create Wind Plot with Null Labels - Handles Nullable Parameters")
    public void testCreateWindPlotWithNullLabels() {
        // Arrange
        boolean legend = false;
        boolean tooltips = false;
        boolean urls = false;

        // Act
        JFreeChart chart = ChartFactory.createWindPlot(null, null, null, mockDataset, legend, tooltips, urls);

        // Assert
        assertNotNull(chart, "Chart should not be null");
        assertNull(chart.getTitle(), "Title should be null when created with null title");
        assertEquals("", chart.getXYPlot().getDomainAxis().getLabel(), "Domain axis label should be blank when created with null label");
        assertEquals("", chart.getXYPlot().getRangeAxis().getLabel(), "Range axis label should be blank when created with null label");
        assertNull(chart.getLegend(), "Legend should be null when created with legend flag set to false");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test exceptional case where the dataset is null to check if the plot handles null datasets.', 
     * 'Input_Type': 'A valid title and axis labels with null WindDataset and any combination of boolean settings.', 
     * 'Output_Type': 'A JFreeChart instance is still created, but XYPlot contains no data points due to the null dataset.'}
     */
    @Test
    @DisplayName("Create Wind Plot with Null Dataset - Handles Null Dataset Gracefully")
    public void testCreateWindPlotWithNullDataset() {
        // Arrange
        String title = "Test Wind Chart";
        String xAxisLabel = "X-Axis";
        String yAxisLabel = "Y-Axis";
        WindDataset dataset = null; // Null dataset
        boolean legend = true;
        boolean tooltips = false;
        boolean urls = false;

        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, dataset, legend, tooltips, urls);

        // Assert
        assertNotNull(chart, "The chart should not be null");
        XYPlot plot = chart.getXYPlot();
        assertNotNull(plot, "The plot should not be null");
        assertNull(plot.getDataset(), "The plot should have no dataset when created with a null dataset");
    }

    /**
     * @implNote Test Purpose: {'Test_Purpose': 'Test normal behavior with various combinations of tooltips and URLs enabled or disabled.', 
     * 'Input_Type': 'Valid title, axis labels, and dataset, with different boolean values for legend, tooltips, and URLs.', 
     * 'Output_Type': 'A JFreeChart instance with appropriate setting configurations for tooltips and URLs based on input flags.'}
     */
    @Test
    @DisplayName("Create Wind Plot with Legend, Tooltips, and URLs - Configurations Applied Correctly")
    public void testCreateWindPlotWithLegendTooltipsURLs() {
        // Arrange
        String title = "Wind Plot Title";
        String xAxisLabel = "Time";
        String yAxisLabel = "Velocity";
        boolean legend = true;
        boolean tooltips = true;
        boolean urls = true;

        // Act
        JFreeChart chart = ChartFactory.createWindPlot(title, xAxisLabel, yAxisLabel, mockDataset, legend, tooltips, urls);

        // Assert
        assertNotNull(chart, "The chart should not be null");
        assertNotNull(chart.getLegend(), "Chart should have a legend when legend flag is true");
        // Additional assertions for tooltips and URLs can be added if ChartFactory exposes such configurations
    }
}
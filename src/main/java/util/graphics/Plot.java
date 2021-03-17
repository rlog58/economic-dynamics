package util.graphics;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Plot {

    private final Color[] colorMap = new Color[]{
            new Color(94, 129, 181),
            new Color(225, 156, 36),
            new Color(143, 177, 49),
            new Color(236, 98, 53),
            new Color(135, 120, 179)
    };

    private final String title;
    private final String xAxisLabel;
    private final String yAxisLabel;
    private final boolean legend;
    private final boolean grid;

    private JFreeChart chart;
    private XYSeriesCollection seriesCollection = new XYSeriesCollection();
    private LinkedList<String> plotLabels = new LinkedList<>();

    private int size = 0;

    public Plot(String title, String xAxisLabel, String yAxisLabel, boolean legend, boolean grid) {
        this.title = title;
        this.xAxisLabel = xAxisLabel;
        this.yAxisLabel = yAxisLabel;
        this.legend = legend;
        this.grid = grid;
    }

    public Plot Plot(String title, String xAxisLabel, String yAxisLabel) {
        return new Plot(title, xAxisLabel, yAxisLabel, true, false);
    }

    public void addPlotX(Double[] data, String label) {
        if (size < 5) {
            XYSeries series = new XYSeries(label);
            Double num = 0.0;
            for (int i = 0; i < data.length; i++) {
                series.add(num, data[i]);
                num += 1.0;
            }
            seriesCollection.addSeries(series);
            size++;
        } else {
            throw new RuntimeException("Only 5 charts are supported");
        }
    }
    public void addPlotX(Double[] data, String label, Double step) {
        if (size < 5) {
            XYSeries series = new XYSeries(label,false);
            Double num = 0.0;
            for (Double datum : data) {
                series.add(num, datum);
                num += step;
            }
            seriesCollection.addSeries(series);
            size++;
        } else {
            throw new RuntimeException("Only 5 charts are supported");
        }
    }

    public void addPlotXY(Double[][] data, String label) {
        if (size < 5) {
            XYSeries series = new XYSeries(label,false);
            for (Double[] datum : data) {
                series.add(datum[0], datum[1]);
            }
            seriesCollection.addSeries(series);
            size++;
        } else {
            throw new RuntimeException("Only 5 charts are supported");
        }
    }

    public void show() {
        SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("");

                    frame.setSize(1280,720);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);

                    JFreeChart chart = ChartFactory.createXYLineChart(title,
                            xAxisLabel,
                            yAxisLabel,
                            seriesCollection,
                            PlotOrientation.VERTICAL,
                            legend,
                            true,
                            false
                    );
                    if (legend) {
                        LegendTitle legend = chart.getLegend();
                        legend.setPosition(RectangleEdge.RIGHT);
                    }

                    XYPlot plot = chart.getXYPlot();

                    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

                    for (int i = 0; i < size; i++) {
                        renderer.setSeriesPaint(i, colorMap[i]);
                        renderer.setSeriesStroke(i, new BasicStroke(2.0f));
                        renderer.setSeriesShapesVisible(i, false);
                    }

                    plot.setRenderer(renderer);

                    plot.setBackgroundPaint(Color.white);

                    plot.setDomainGridlinePaint(Color.black);
                    plot.setRangeGridlinePaint(Color.black);

                    plot.setRangeGridlinesVisible(grid);
                    plot.setDomainGridlinesVisible(grid);

                    chart.setAntiAlias(true);

                    frame.getContentPane().add(new ChartPanel(chart));
                }
        );
    }

}

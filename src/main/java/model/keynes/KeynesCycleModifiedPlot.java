package model.keynes;

import util.DSolver;
import util.graphics.Plot;

public class KeynesCycleModifiedPlot {
    public static void plot1() {
        Plot plot = new Plot("y(t)", "t", "y", true, true);

        KeynesCycleModifiedModel model = new KeynesCycleModifiedModel(2.0, 7.0, 2.0, 1.0, 0.005, 0.0, 0.35, 0.2, 4.0, 1.0);

        DSolver solver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void plot2() {
        Plot plot = new Plot("r(t)", "t", "r", true, true);

        KeynesCycleModifiedModel model = new KeynesCycleModifiedModel(2.0, 7.0, 2.0, 1.0, 0.005, 0.0, 0.35, 0.2, 4.0, 1.0);

        DSolver solver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void main(String[] args) {

        plot1();

        plot2();

    }
}

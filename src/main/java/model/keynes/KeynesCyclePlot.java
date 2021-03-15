package model.keynes;

import util.DSolver;
import util.graphics.Plot;

public class KeynesCyclePlot {
    public static void plot1() {
        Plot plot = new Plot("y(t)", "t", "y", true, true);

        KeynesCycleModel model = new KeynesCycleModel(10.0, 0.1, 2.0, 0.1, 1.0);

        DSolver solver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void plot2() {
        Plot plot = new Plot("r(t)", "t", "r", true, true);

        KeynesCycleModel model = new KeynesCycleModel(10.0, 0.1, 2.0, 0.1, 1.0);

        DSolver solver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void main(String[] args) {

        plot1();

        plot2();

    }
}

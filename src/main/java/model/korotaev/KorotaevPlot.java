package model.korotaev;

import util.DSolver;
import util.graphics.Plot;


public class KorotaevPlot {
    public static void plot1() {
        Plot plot = new Plot("N", "t", "N", true, true);

        KorotaevModel model = new KorotaevModel(0.001, 0.002, 0.04, 0.4);

        DSolver solver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void plot2() {
        Plot plot = new Plot("T", "t", "T", true, true);

        KorotaevModel model = new KorotaevModel(0.001, 0.002, 0.04, 0.4);

        DSolver solver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void plot3() {
        Plot plot = new Plot("E", "t", "E", true, true);

        KorotaevModel model = new KorotaevModel(0.001, 0.002, 0.04, 0.4);

        DSolver solver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void plot4() {
        Plot plot = new Plot("E", "t", "E", true, true);

        KorotaevModel model = new KorotaevModel(0.001, 0.002, 0.04, 0.4);

        DSolver solver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void main(String[] args) {

        plot1();

        plot2();

        plot3();

        plot4();

    }
}

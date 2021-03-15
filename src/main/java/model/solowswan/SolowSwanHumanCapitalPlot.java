package model.solowswan;

import util.DSolver;
import util.Plot;

public class SolowSwanHumanCapitalPlot {
    public static void plot1() {
        Plot plot = new Plot("k(t)", "t", "k", true, true);

        SolowSwanHumanCapitalModel model = new SolowSwanHumanCapitalModel(0.01, 0.02, 0.04, 0.3, 0.5, 0.33, 0.33);

        DSolver dSolver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void plot2() {
        Plot plot = new Plot("h(t)", "t", "h", true, true);

        SolowSwanHumanCapitalModel model = new SolowSwanHumanCapitalModel(0.01, 0.02, 0.04, 0.3, 0.5, 0.33, 0.33);

        DSolver dSolver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void plot3() {
        Plot plot = new Plot("y(t)", "t", "y", true, true);

        SolowSwanHumanCapitalModel model = new SolowSwanHumanCapitalModel(0.01, 0.02, 0.04, 0.3, 0.5, 0.33, 0.33);

        DSolver dSolver = new DSolver(0.0, 100.0, 0.01);

        plot.show();
    }

    public static void main(String[] args) {

        plot1();

        plot2();

        plot3();

    }
}

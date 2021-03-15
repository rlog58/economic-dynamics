package model.ramseycasskoopmans;

import util.DSolver;
import util.Plot;

import java.util.Arrays;


public class RamseyCassKoopmansPlot {

    public static void plot1() {
        Plot plot = new Plot("Phase portrait", "k", "c", true, true);

        RamseyCassKoopmansModel model = new RamseyCassKoopmansModel(0.01, 0.02, 0.04, 0.3, 0.5);

        DSolver dSolver = new DSolver(0.0, 100.0, 0.01);

        Double[][] data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.8});
        plot.addPlotXY(data, "(k0 = 100; c0 = 5.8)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.85});
        plot.addPlotXY(data, "(k0 = 100; c0 = 5.85)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.90});
        plot.addPlotXY(data, "(k0 = 100; c0 = 5.9)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.95});
        plot.addPlotXY(data, "(k0 = 100; c0 = 5.95)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 6.00});
        plot.addPlotXY(data, "(k0 = 100; c0 = 6.0)");

        plot.show();
    }

    public static void plot2() {
        Plot plot = new Plot("Reduced capital", "t", "k", true, true);

        RamseyCassKoopmansModel model = new RamseyCassKoopmansModel(0.01, 0.02, 0.04, 0.3, 0.5);

        DSolver dSolver = new DSolver(0.0, 100.0, 0.01);

        Double[][] data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.8});
        plot.addPlotX(Arrays.stream(data).map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 5.8)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.85});
        plot.addPlotX(Arrays.stream(data).map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 5.85)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.90});
        plot.addPlotX(Arrays.stream(data).map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 5.9)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.95});
        plot.addPlotX(Arrays.stream(data).map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 5.95)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 6.00});
        plot.addPlotX(Arrays.stream(data).map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 6.0)");

        plot.show();
    }

    public static void plot3() {
        Plot plot = new Plot("Reduced consumption", "t", "c", true, true);

        RamseyCassKoopmansModel model = new RamseyCassKoopmansModel(0.01, 0.02, 0.04, 0.3, 0.5);

        DSolver dSolver = new DSolver(0.0, 100.0, 0.01);

        Double[][] data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.8});
        plot.addPlotX(Arrays.stream(data).map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 5.8)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.85});
        plot.addPlotX(Arrays.stream(data).map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 5.85)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.90});
        plot.addPlotX(Arrays.stream(data).map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 5.9)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 5.95});
        plot.addPlotX(Arrays.stream(data).map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 5.95)");

        data = dSolver.solve(model.getDSystem(), new Double[]{100.0, 6.00});
        plot.addPlotX(Arrays.stream(data).map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 6.0)");

        plot.show();
    }

    public static void main(String[] args) {

        plot1();

        plot2();

        plot3();


    }
}

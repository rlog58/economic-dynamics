package model.ramseycasskoopmans;

import util.DSolver;
import util.Model;
import util.Plot;

import java.util.LinkedList;

import static util.Numeric.RK4;

public class RamseyCassKoopmansPlot {

    public static void plotPhasePortrait() {
        Plot plot = new Plot("Phase portrait",
                "k",
                "c",
                true,
                true);

        Model model = new RamseyCassKoopmansModel(0.01, 0.02, 0.04, 0.3, 0.5);

        DSolver dSolver = new DSolver(0.0, 100.0, 0.0);

        Double[][] data = dSolver.solve(model.getEqSystem(), new Double[]{100.0, 5.8});

        plot.addPlotXY(data, "(k0 = 100; c0 = 5.8)");

        data = dSolver.solve(model.getEqSystem(), new Double[]{100.0, 5.85});
        plot.addPlotXY(data.stream().toArray(Double[][]::new), "(k0 = 100; c0 = 5.85)");

        data = RK4(model.getEqSystem(), new Double[]{100.0, 5.9}, 0.0, 100.0, 0.01);
        plot.addPlotXY(data.stream().toArray(Double[][]::new), "(k0 = 100; c0 = 5.9)");

        data = RK4(model.getEqSystem(), new Double[]{100.0, 5.95}, 0.0, 100.0, 0.01);
        plot.addPlotXY(data.stream().toArray(Double[][]::new), "(k0 = 100; c0 = 5.95)");

        data = RK4(model.getEqSystem(), new Double[]{100.0, 6.0}, 0.0, 100.0, 0.01);
        plot.addPlotXY(data.stream().toArray(Double[][]::new), "(k0 = 100; c0 = 6.0)");

        plot.show();
    }

    public static void plotReducedСapital() {
        Plot plot = new Plot("Reduced capital",
                "t",
                "k",
                true,
                true);

        RamseyCassKoopmansModel model = new RamseyCassKoopmansModel(0.01, 0.02, 0.04, 0.3, 0.5);

        LinkedList<Double[]> data = RK4(model.getEqSystem(), new Double[]{100.0, 5.8}, 0.0, 100.0, 0.01);
        plot.addPlotX(data.stream().map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 5.8)");

        data = RK4(model.getEqSystem(), new Double[]{100.0, 5.85}, 0.0, 100.0, 0.01);
        plot.addPlotX(data.stream().map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 5.85)");

        data = RK4(model.getEqSystem(), new Double[]{100.0, 5.9}, 0.0, 100.0, 0.01);
        plot.addPlotX(data.stream().map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 5.9)");

        data = RK4(model.getEqSystem(), new Double[]{100.0, 5.95}, 0.0, 100.0, 0.01);
        plot.addPlotX(data.stream().map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 5.95)");

        data = RK4(model.getEqSystem(), new Double[]{100.0, 6.0}, 0.0, 100.0, 0.01);
        plot.addPlotX(data.stream().map(x -> x[0]).toArray(Double[]::new), "(k0 = 100; c0 = 6.0)");

        plot.show();
    }

    public static void plotReducedСonsumption() {
        Plot plot = new Plot("Reduced consumption",
                "t",
                "c",
                true,
                true);

        Double t0 = 0.0;
        Double tLim = 1000.0;
        Double delta = 0.01;

        RamseyCassKoopmansModel model = new RamseyCassKoopmansModel(0.01, 0.02, 0.04, 0.3, 0.5);

        LinkedList<Double[]> data = RK4(model.getEqSystem(), new Double[]{100.0, 5.8}, 0.0, 1000.0, 0.01);
        plot.addPlotX(data.stream().map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 5.8)",0.01);

        data = RK4(model.getEqSystem(), new Double[]{100.0, 5.85}, 0.0, 1000.0,  0.01);
        plot.addPlotX(data.stream().map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 5.85)",0.01);

        data = RK4(model.getEqSystem(), new Double[]{100.0, 5.9}, 0.0, 1000.0, 0.01);
        plot.addPlotX(data.stream().map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 5.9)",0.01);

        data = RK4(model.getEqSystem(), new Double[]{100.0, 5.95}, 0.0, 1000.0, 0.01);
        plot.addPlotX(data.stream().map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 5.95)",0.01);

        data = RK4(model.getEqSystem(), new Double[]{100.0, 6.0}, 0.0, 1000.0,  0.01);
        plot.addPlotX(data.stream().map(x -> x[1]).toArray(Double[]::new), "(k0 = 100; c0 = 6.0)",0.01);

        plot.show();
    }

    public static void main(String[] args) {

        plotPhasePortrait();

        plotReducedСapital();

        plotReducedСonsumption();


    }
}

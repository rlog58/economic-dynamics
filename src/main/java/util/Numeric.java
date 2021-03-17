package util;

import java.util.LinkedList;

final class Numeric {

    private Numeric() {
    }

    private static Double[] RK4Step(Expression[] dSystem, Double t, Double[] x, Double h) {
        int n = dSystem.length;
        int m = x.length;

        Double[] k1 = new Double[n];
        Double[] k2 = new Double[n];
        Double[] k3 = new Double[n];
        Double[] k4 = new Double[n];

        Double[] tmp = new Double[m];

        for (int i = 0; i < n; i++) k1[i] = h * dSystem[i].evaluate(t, x);

        for (int i = 0; i < m; i++) tmp[i] = x[i] + k1[i] / 2;
        for (int i = 0; i < n; i++) k2[i] = h * dSystem[i].evaluate(t + h / 2, tmp);

        for (int i = 0; i < m; i++) tmp[i] = x[i] + k2[i] / 2;
        for (int i = 0; i < n; i++) k3[i] = h * dSystem[i].evaluate(t + h / 2, tmp);

        for (int i = 0; i < m; i++) tmp[i] = x[i] + k3[i];
        for (int i = 0; i < n; i++) k4[i] = h * dSystem[i].evaluate(t + h, tmp);

        for (int i = 0; i < m; i++) tmp[i] = x[i] + (k1[i] + k2[i] + k3[i] + k4[i]) / 6;

        return tmp;

    }

    public static LinkedList<Double[]> RK4(Expression[] dSystem, Double[] x0, Double t0, Double tn, Double h) {
        LinkedList<Double[]> points = new LinkedList<>();
        points.add(x0);

        for (int t = 1; t < (int) ((tn - t0) / h) + 1; t++) {
            points.add(RK4Step(dSystem, t0 + h * t, points.getLast(), h));
        }

        return points;
    }
}

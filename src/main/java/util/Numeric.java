package util;

import java.util.LinkedList;

public final class Numeric {

    private Numeric() {}

    private static Double[] RK4Step(Expression[] f, Double[] x, Double delta) {
        int n = f.length;
        int m = x.length;

        Double[] k1 = new Double[n];
        Double[] k2 = new Double[n];
        Double[] k3 = new Double[n];
        Double[] k4 = new Double[n];
        Double[] tmp = new Double[m];

        for (int i = 0; i < n; i++) k1[i] = delta * f[i].evaluate(x);

        for (int i = 0; i < m; i++) tmp[i] = x[i] + k1[i] / 2;
        for (int i = 0; i < n; i++) k2[i] = delta * f[i].evaluate(tmp);

        for (int i = 0; i < m; i++) tmp[i] = x[i] + k2[i] / 2;
        for (int i = 0; i < n; i++) k3[i] = delta * f[i].evaluate(tmp);

        for (int i = 0; i < m; i++) tmp[i] = x[i] + k3[i];
        for (int i = 0; i < n; i++) k4[i] = delta * f[i].evaluate(tmp);

        for (int i = 0; i < m; i++) tmp[i] = x[i] + (k1[i] + k2[i] + k3[i] + k4[i]) / 6;

        return tmp;

    }

    public static LinkedList<Double[]> RK4(Expression[] f, Double[] x0, Double t0, Double tLim, Double delta) {
        LinkedList<Double[]> points = new LinkedList<>();
        points.add(x0);

        for (int i = 1; i < (int) ((tLim - t0) / delta) + 1; i++) {
            points.add(RK4Step(f, points.getLast(), delta));
        }

        return points;
    }
}

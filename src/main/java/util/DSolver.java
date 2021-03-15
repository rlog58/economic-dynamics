package util;

import java.security.InvalidParameterException;
import java.util.Arrays;


public class DSolver {

    private final String[] methods = new String[]{"RK4"};
    private Double t0;
    private Double tLim;
    private Double delta;
    private String method = "RK4";

    public DSolver(Double t0, Double tLim, Double delta) {
        this.t0 = t0;
        this.tLim = tLim;
        this.delta = delta;
    }

    public DSolver(Double t0, Double tLim, Double delta, String method) {
        this.t0 = t0;
        this.tLim = tLim;
        this.delta = delta;
        this.method = method;
    }

    public void setMethod(String method) {
        if (Arrays.stream(methods).anyMatch(method::equals)) {
            this.method = method;
        } else {
            throw new InvalidParameterException();
        }
    }

    public Double[][] solve(Expression[] f, Double[] x0) {
        return Numeric.RK4(f, x0, t0, tLim, delta).toArray(Double[][]::new);
    }


}

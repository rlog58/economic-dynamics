package util;

import java.security.InvalidParameterException;
import java.util.Arrays;


public class DSolver {

    private final String[] methods = new String[]{"RK4","RK4t"};

    private Double t0;
    private Double tn;
    private Double h;
    private String method = "RK4";

    public DSolver(Double t0, Double tn, Double h) {
        this.t0 = t0;
        this.tn = tn;
        this.h = h;
    }

    public DSolver(Double t0, Double tn, Double h, String method) {
        this.t0 = t0;
        this.tn = tn;
        this.h = h;
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
        return Numeric.RK4(f, x0, t0, tn, h).toArray(Double[][]::new);
    }


}

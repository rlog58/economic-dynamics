package util;

@FunctionalInterface
public interface Expression {
    Double evaluate(Double t, Double[] x);
}

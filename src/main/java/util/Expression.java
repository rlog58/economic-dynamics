package util;

@FunctionalInterface
public interface Expression {
    Double evaluate(Double[] args);
}

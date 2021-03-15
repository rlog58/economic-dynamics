package model.keynes;

import util.Expression;
import util.Model;

public class KeynesCycleModifiedModel extends Model {

    public KeynesCycleModifiedModel(Double alpha, Double beta, Double beta12, Double beta3,
                                    Double l0, Double l1, Double l2, Double ls,
                                    Double a1, Double k) {

        this.eqSystem = new Expression[]{};

        this.dSystem = new Expression[]{
                // y
                (args) -> {
                    Double y = args[0];
                    Double r = args[1];

                    return alpha * (l0 * k / (l0 + (k - l0) * Math.exp(-a1 * y)) - l1 * y - r * y * beta12);
                },
                // r
                (args) -> {
                    Double y = args[0];
                    Double r = args[1];

                    return beta * r * (l2 * y - r * beta3 - ls);
                }
        };
    }
}

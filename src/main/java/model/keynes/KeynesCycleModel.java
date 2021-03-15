package model.keynes;

import util.Expression;
import util.Model;

public class KeynesCycleModel extends Model {

    public KeynesCycleModel(Double alpha, Double l1, Double l2, Double ls, Double beta12) {
        this.eqSystem = new Expression[]{};

        this.dSystem = new Expression[]{
                // y
                (args) -> {
                    Double y = args[0];
                    Double r = args[1];

                    return alpha * (1 / (1 + Math.exp(-y)) - l1 * y - r * beta12);
                },
                // r
                (args) -> {
                    Double y = args[0];
                    Double r = args[1];

                    return l2 * y - r - ls;
                }
        };
    }
}

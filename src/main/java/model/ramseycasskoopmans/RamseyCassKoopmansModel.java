package model.ramseycasskoopmans;

import util.Expression;
import util.Model;

public class RamseyCassKoopmansModel extends Model {

    public RamseyCassKoopmansModel(Double n, Double g, Double ro, Double theta, Double alpha) {

        this.eqSystem = new Expression[]{};

        this.dSystem = new Expression[]{
                // k
                (args) -> {
                    Double k = args[0];
                    Double c = args[1];

                    return Math.pow(k, alpha) - c - (n + g) * k;
                },
                // c
                (args) -> {
                    Double k = args[0];
                    Double c = args[1];

                    return c * (alpha * Math.pow(k, alpha - 1) - ro - theta * g) / theta;
                }
        };

    }

}

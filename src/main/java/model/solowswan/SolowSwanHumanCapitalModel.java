package model.solowswan;

import util.Expression;
import util.Model;

public class SolowSwanHumanCapitalModel extends Model {

    public SolowSwanHumanCapitalModel(Double sk, Double sh, Double delta, Double g, Double n, Double alpha, Double beta) {

        this.eqSystem = new Expression[]{
                // y
                (args) -> {
                    Double k = args[0];
                    Double h = args[1];

                    return Math.pow(k, alpha) * Math.pow(h, beta);
                }
        };

        this.dSystem = new Expression[]{
                // k
                (args) -> {
                    Double k = args[0];
                    Double y = eqSystem[0].evaluate(args);

                    return sk * y - (delta + g + n) * k;
                },
                // h
                (args) -> {
                    Double h = args[1];
                    Double y = eqSystem[0].evaluate(args);

                    return sh * y - (delta + g + n) * h;
                }
        };

    }
}

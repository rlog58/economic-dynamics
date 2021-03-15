package model.korotaev;

import util.Expression;
import util.Model;

public class KorotaevModel extends Model {

    public KorotaevModel(Double a, Double b, Double c, Double e) {

        this.eqSystem = new Expression[]{
                // Y
                (args) -> {
                    Double T = args[1];
                    Double E = args[2];

                    return e * T * E;
                }
        };

        this.dSystem = new Expression[]{
                // N
                (args) -> {
                    Double N = args[0];
                    Double T = args[1];
                    Double E = args[2];

                    return a * T * N * (1 - E);
                },
                // T
                (args) -> {
                    Double T = args[1];
                    Double E = args[2];

                    return b * T * E;
                },
                // E
                (args) -> {
                    Double T = args[1];
                    Double E = args[2];

                    return c * T * E * (1 - E);
                }
        };


    }
}

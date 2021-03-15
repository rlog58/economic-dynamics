package model.ramseycasskoopmans;

import util.Expression;
import util.Model;

public class RamseyCassKoopmansModel extends Model {

    public RamseyCassKoopmansModel(Double n, Double g, Double ro, Double theta, Double alpha) {
        this.eqSystem = new Expression[]{
                // dk/dt
                (args) -> (Math.pow(args[0], alpha) - args[1] - (n + g) * args[0]),
                // dc/dt
                (args) -> (args[1] * (alpha * Math.pow(args[0], alpha - 1) - ro - theta * g) / theta)
        };

        this.resSystem = new Expression[]{};

    }

}

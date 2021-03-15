package util;

public abstract class Model {
    protected Expression[] eqSystem;
    protected Expression[] dSystem;

    public void setEqSystem(Expression[] eqSystem) {
        this.eqSystem = eqSystem;
    }

    public Expression[] getEqSystem() {
        return eqSystem;
    }

    public void setDSystem(Expression[] dSystem) {
        this.dSystem = dSystem;
    }

    public Expression[] getDSystem() {
        return dSystem;
    }
}

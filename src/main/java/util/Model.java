package util;

public abstract class Model {
    protected Expression[] eqSystem;
    protected Expression[] resSystem;

    public void setEqSystem(Expression[] eqSystem) {
        this.eqSystem = eqSystem;
    }

    public Expression[] getEqSystem() {
        return eqSystem;
    }

    public void setResSystem(Expression[] resSystem) {
        this.resSystem = resSystem;
    }

    public Expression[] getResSystem() {
        return resSystem;
    }
}

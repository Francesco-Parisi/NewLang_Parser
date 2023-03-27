package esercitazione4.Expressions;

public class IdExpr {

    private Id id;
    private Expr expr;

    public IdExpr(Id id) {
        this.id = id;
    }

    public IdExpr(Id id, Expr expr) {
        this.id = id;
        this.expr = expr;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Expr getExpr() {
        return expr;
    }

}

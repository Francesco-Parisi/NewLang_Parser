package esercitazione4.Expressions;
import esercitazione4.Visitor.Visitor;

public class IdInitObbOp extends Expr {

    private Id id;
    private Expr expr;

    public IdInitObbOp(Id id, Expr expr){
        this.id=id;
        this.expr=expr;
    }

    public Id getId() {
        return id;
    }
    public void setId(Id id) {
        this.id=id;
    }
    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr=expr;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }

}

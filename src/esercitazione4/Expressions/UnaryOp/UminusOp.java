package esercitazione4.Expressions.UnaryOp;
import esercitazione4.Expressions.Expr;
import esercitazione4.Visitor.Visitor;
public class UminusOp extends Expr {
    private Expr e;

    public UminusOp(Expr e){
        this.e=e;
    }

    public Expr getExpr() {
        return e;
    }
    public void setExpr(Expr e) {
        this.e = e;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
}

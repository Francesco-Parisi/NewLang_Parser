package esercitazione4.Expressions.UnaryOp;
import esercitazione4.Expressions.Expr;
import esercitazione4.Visitor.Visitor;
public class NotOp extends Expr {
    private Expr e;

    public NotOp(Expr e){
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

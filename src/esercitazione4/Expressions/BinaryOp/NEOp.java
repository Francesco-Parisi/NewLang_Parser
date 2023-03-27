package esercitazione4.Expressions.BinaryOp;
import esercitazione4.Expressions.Expr;
import esercitazione4.Visitor.Visitor;

public class NEOp extends Expr {
    private Expr e1, e2;

    public NEOp(Expr e1, Expr e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public Expr getE1() {
        return e1;
    }

    public void setE1(Expr e1) {
        this.e1 = e1;
    }

    public Expr getE2() {
        return e2;
    }

    public void setE2(Expr e2) {
        this.e2 = e2;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v) {
        return v.visit(this);
    }
}
package esercitazione4.Expressions.ConstOp;
import esercitazione4.Visitor.Visitor;
import esercitazione4.Expressions.Expr;

public abstract class Const extends Expr {
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
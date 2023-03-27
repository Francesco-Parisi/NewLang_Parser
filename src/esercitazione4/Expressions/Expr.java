package esercitazione4.Expressions;
import esercitazione4.Visitor.Visitor;

public class Expr {
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }

}
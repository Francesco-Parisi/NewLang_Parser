package esercitazione4.Statement;
import esercitazione4.Visitor.Visitor;

public abstract class Statement {
    public String toString() { return super.toString(); }
    public Object accept(Visitor v){
        return v.visit(this);
    }

}

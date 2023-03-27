package esercitazione4.Statement;
import esercitazione4.Visitor.Visitor;

public class Statement {
    public String toString() { return super.toString(); }
    public Object accept(Visitor v){
        return v.visit(this);
    }

}

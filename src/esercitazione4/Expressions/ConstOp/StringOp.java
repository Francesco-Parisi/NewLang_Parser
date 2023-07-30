package esercitazione4.Expressions.ConstOp;
import esercitazione4.Visitor.Visitor;

public class StringOp extends Const {

    private String attribute;

    public StringOp(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Object accept(Visitor visitor){
        return visitor.visit(this);
    }
}
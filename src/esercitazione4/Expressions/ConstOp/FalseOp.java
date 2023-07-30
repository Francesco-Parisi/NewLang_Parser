package esercitazione4.Expressions.ConstOp;
import esercitazione4.Visitor.Visitor;
public class FalseOp extends Const {

    public FalseOp() {
    }

    public Object accept(Visitor visitor){
        return visitor.visit(this);
    }
}


package esercitazione4.Expressions.ConstOp;
import esercitazione4.Visitor.Visitor;

public class TrueOp extends Const {

    public TrueOp() {
    }

    public Object accept(Visitor visitor){
        return visitor.visit(this);
    }
}


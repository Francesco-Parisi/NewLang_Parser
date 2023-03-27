package esercitazione4.Statement;
import esercitazione4.Expressions.Expr;
import esercitazione4.Node.BodyOp;
import esercitazione4.Visitor.Visitor;

public class WhileStatOp extends Statement{
    private Expr expr;
    private BodyOp bodyOp;

    public WhileStatOp(Expr expr, BodyOp bodyOp) {
        this.expr = expr;
        this.bodyOp = bodyOp;
    }
    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr = expr;
    }
    public BodyOp getBodyOp() {
        return bodyOp;
    }
    public void setBodyOp(BodyOp bodyOp) {
        this.bodyOp = bodyOp;
    }
    public Object accept(Visitor v){ return v.visit(this); }

}
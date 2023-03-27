package esercitazione4.Statement;
import esercitazione4.Expressions.Expr;
import esercitazione4.Node.BodyOp;
import esercitazione4.Visitor.Visitor;

public class IfStatOp extends Statement{

    private Expr expr;
    private BodyOp bodyOp;
    private BodyOp bodyOpElse;

    public IfStatOp(Expr expr, BodyOp bodyOp, BodyOp bodyOpElse){
        this.expr=expr;
        this.bodyOp=bodyOp;
        this.bodyOpElse=bodyOpElse;
    }

    public IfStatOp(Expr expr, BodyOp bodyOp){
        this.expr=expr;
        this.bodyOp = bodyOp;
        this.bodyOpElse = null;
    }

    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr=expr;
    }
    public BodyOp getBodyOp() { return bodyOp; }
    public void setBodyOp(BodyOp bodyOp) {
        this.bodyOp=bodyOp;
    }
    public BodyOp getBodyElse() {
        return bodyOpElse;
    }
    public void setBodyElse(BodyOp bodyOpElse) {
        this.bodyOpElse=bodyOpElse;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }

}

package esercitazione4.Statement;
import esercitazione4.Expressions.Expr;
import esercitazione4.Visitor.Visitor;

public class ReturnStatOp extends Statement{

    private Expr expr;
    public ReturnStatOp(){
        this.expr=null;
    }

    public ReturnStatOp(Expr expr){
        this.expr=expr;
    }
    public Expr getExpr() {
        return expr;
    }
    public void setExpr(Expr expr) {
        this.expr=expr;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }

}
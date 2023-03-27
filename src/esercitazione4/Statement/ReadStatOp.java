package esercitazione4.Statement;
import esercitazione4.Expressions.Expr;
import esercitazione4.Expressions.Id;
import esercitazione4.Visitor.Visitor;
import java.util.ArrayList;

public class ReadStatOp extends Statement {
    private ArrayList<Id> idList;
    private Expr expr;

    public ReadStatOp(ArrayList<Id> idList) {
        this.idList = idList;
    }

    public ReadStatOp(ArrayList<Id> idList, Expr expr) {
        this.idList = idList;
        this.expr = expr;
    }

    public ArrayList<Id> getIdList() {
        return idList;
    }

    public void setIdList(ArrayList<Id> idList) {
        this.idList = idList;
    }
    public Expr getExpr() {
        return expr;
    }

    public void setExpr(Expr expr) {
        this.expr = expr;
    }
    public String toString() {
        return super.toString();
    }
    public Object accept(Visitor v) {
        return v.visit(this);
    }

}
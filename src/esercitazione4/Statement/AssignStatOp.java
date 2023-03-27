package esercitazione4.Statement;
import esercitazione4.Expressions.Expr;
import esercitazione4.Expressions.Id;
import esercitazione4.Visitor.Visitor;

import java.util.ArrayList;

public class AssignStatOp extends Statement{
    private ArrayList<Id> idList;
    private ArrayList<Expr> exprList;

    public AssignStatOp(ArrayList<Id> idList, ArrayList<Expr> exprList) {
        this.idList=idList;
        this.exprList=exprList;
    }

    public ArrayList<Id> getIdList() {
        return idList;
    }
    public void setIdList(ArrayList<Id> idList) {
        this.idList = idList;
    }
    public ArrayList<Expr> getExprList() {
        return exprList;
    }
    public void setExprList(ArrayList<Expr> exprList) {
        this.exprList = exprList;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
}

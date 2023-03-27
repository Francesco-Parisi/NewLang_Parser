package esercitazione4.Expressions;
import esercitazione4.Visitor.Visitor;

import java.util.ArrayList;

public class FunCallOpExpr extends Expr{
    private Id id;
    private ArrayList<Expr> exprList;

    public FunCallOpExpr(Id id){
        this.id=id;
        this.exprList=null;
    }

    public FunCallOpExpr(Id id, ArrayList<Expr> exprList){
        this.id=id;
        this.exprList=exprList;
    }

    public Id getId() {
        return id;
    }
    public void setId(Id id) {
        this.id = id;
    }
    public ArrayList<Expr> getExprList() { return exprList;}
    public void setExprList(ArrayList<Expr> exprList) { this.exprList=exprList;}
    public String toString() { return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
}

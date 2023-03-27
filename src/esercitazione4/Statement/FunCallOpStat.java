package esercitazione4.Statement;
import esercitazione4.Expressions.Expr;
import esercitazione4.Expressions.Id;
import esercitazione4.Visitor.Visitor;
import java.util.ArrayList;

public class FunCallOpStat extends Statement{
    private Id id;
    private ArrayList<Expr> exprList;

    public FunCallOpStat(Id id, ArrayList<Expr> exprList) {
        this.id = id;
        this.exprList = exprList;
    }

    public FunCallOpStat(Id id){
        this.id=id;
        this.exprList=null;
    }
    public Id getId() {
        return id;
    }
    public void setId(Id id) { this.id=id; }
    public ArrayList<Expr> getExprList() {return exprList;}
    public void setExprList(ArrayList<Expr> exprList) {this.exprList=exprList;}
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
}

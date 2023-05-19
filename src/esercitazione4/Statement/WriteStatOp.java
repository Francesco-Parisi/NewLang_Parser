package esercitazione4.Statement;
import esercitazione4.Expressions.Expr;
import esercitazione4.Visitor.Visitor;
import java.util.ArrayList;

public class WriteStatOp extends Statement{

    private boolean write;
    private ArrayList<Expr> exprList;

    public WriteStatOp(boolean write, ArrayList<Expr> exprList){
        if(exprList.isEmpty())
            throw new RuntimeException("Deve essere presente exprList!");
        this.write=write;
        this.exprList=exprList;
    }

    public boolean getWriteFlag() {
        return write;
    }
    public void setWriteFlag(boolean write) {
        this.write=write;
    }
    public ArrayList<Expr> getListExpr() {
        return exprList;
    }
    public void setListExpr(ArrayList<Expr> exprList) {
        this.exprList=exprList;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){ return v.visit(this); }

}

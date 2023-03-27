package esercitazione4.Node;
import esercitazione4.Expressions.IdExpr;
import esercitazione4.Visitor.Visitor;
import java.util.ArrayList;

public class VarDeclOp {
    private TypeOp type;
    private ArrayList<IdExpr> exprList;
    public VarDeclOp(TypeOp type, ArrayList<IdExpr> exprList) {
        this.type = type;
        this.exprList = exprList;
    }
    public TypeOp getType() { return type; }
    public void setType(TypeOp type) { this.type=type; }
    public ArrayList<IdExpr> getListExpr() { return exprList; }
    public void setListExpr(ArrayList<IdExpr> exprList) { this.exprList=exprList; }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }

}

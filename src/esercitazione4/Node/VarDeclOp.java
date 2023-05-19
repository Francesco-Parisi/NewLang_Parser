package esercitazione4.Node;
import esercitazione4.Expressions.IdExpr;
import esercitazione4.Type.Type;
import esercitazione4.Visitor.Visitor;
import java.util.ArrayList;

public class VarDeclOp {
    private TypeOp type;
    private ArrayList<IdExpr> exprList;
    public VarDeclOp(TypeOp type, ArrayList<IdExpr> exprList) {
        if(!checkTypeOp(type))
            throw new RuntimeException("Il TypeOp inserito non è valido!");
        if(exprList.isEmpty())
            throw new RuntimeException("Deve essere presente idAndExprList!");
        this.type = type;
        this.exprList = exprList;
    }
    public TypeOp getType() { return type; }
    public void setType(TypeOp type) {
        if(!checkTypeOp(type))
            throw new RuntimeException("Il TypeOp inserito non è valido!");
        this.type=type;
    }
    public ArrayList<IdExpr> getListExpr() { return exprList; }
    public void setListExpr(ArrayList<IdExpr> exprList) { this.exprList=exprList; }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
    private boolean checkTypeOp(TypeOp typeOp) {
        String type = typeOp.getType();
        return Type.basicTypes.contains(type) || type.equals(Type.VAR);
    }

}

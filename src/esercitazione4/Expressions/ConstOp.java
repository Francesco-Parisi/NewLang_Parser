package esercitazione4.Expressions;
import esercitazione4.Visitor.Visitor;

public class ConstOp extends Expr{

    private String lessema;
    private String typeConst;

    public ConstOp(String typeConst, String lessema){
        this.typeConst=typeConst;
        this.lessema=lessema;
    }

    public ConstOp(String typeConst){
        this.typeConst=typeConst;
        this.lessema=null;
    }

    public String getTypeConst() {
        return typeConst;
    }
    public void setTypeConst(String typeConst) {
        this.typeConst=typeConst;
    }
    public String getLessema() {
        String s = '"'+ lessema+ '"';
        return s;
    }
    public void setLessema(String lessema) {
        this.lessema=lessema;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
}
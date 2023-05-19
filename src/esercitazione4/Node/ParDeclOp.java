package esercitazione4.Node;
import esercitazione4.Expressions.Id;
import esercitazione4.Type.Type;
import esercitazione4.Visitor.Visitor;

import java.util.ArrayList;

public class ParDeclOp {
    private boolean out;
    private TypeOp type;
    private ArrayList<Id> IdList;

    public ParDeclOp(boolean out,TypeOp type, ArrayList<Id> idList) {
        if(idList.isEmpty())
            throw new RuntimeException("idList non può essere vuota");
        if(!checkTypeOp(type))
            throw new RuntimeException("Il TypeOp inserito non è valido.");

        this.out=out;
        this.type = type;
        this.IdList = idList;
    }
    public boolean getOut() {
        return out;
    }
    public void setOut(boolean isOut) {
        out = isOut;
    }
    public TypeOp getType() { return type; }

    public void setType(TypeOp type) {
        if(!checkTypeOp(type))
            throw new RuntimeException("Il TypeOp inserito non è valido.");
        this.type = type;
    }

    public ArrayList<Id> getIdList() {
        return IdList;
    }

    public void setIdList(ArrayList<Id> idList) {
        IdList = idList;
    }
    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
    private boolean checkTypeOp(TypeOp typeOp) {
        return Type.basicTypes.contains(typeOp.getType());
    }

}

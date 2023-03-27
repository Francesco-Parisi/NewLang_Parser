package esercitazione4.Node;
import esercitazione4.Expressions.Id;
import esercitazione4.Visitor.Visitor;

import java.util.ArrayList;

public class ParDeclOp {
    TypeOp currentType;
    TypeOp type;
    ArrayList<Id> IdList;

    public ParDeclOp(TypeOp currentType,TypeOp type, ArrayList<Id> idList) {
        this.currentType=currentType;
        this.type = type;
        this.IdList = idList;
    }
    public ParDeclOp(TypeOp type, ArrayList<Id> idList) {
        this.currentType=null;
        this.type = type;
        this.IdList = idList;
    }
    public TypeOp getCurrentType() { return currentType; }

    public void setCurrentType(TypeOp currentType) {
        this.currentType = currentType;
    }
    public TypeOp getType() { return type; }

    public void setType(TypeOp type) {
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

}

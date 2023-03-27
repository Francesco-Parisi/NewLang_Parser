package esercitazione4.Node;
import esercitazione4.Expressions.Id;
import esercitazione4.Visitor.Visitor;

import java.util.ArrayList;

public class FunDeclOp {
    boolean main;
    private Id id;
    private ArrayList<ParDeclOp> pdList;
    private TypeOp type;
    private BodyOp body;

    public FunDeclOp(boolean main, Id id, ArrayList<ParDeclOp> pdList, TypeOp type, BodyOp body) {
        this.main=main;
        this.id = id;
        this.pdList=pdList;
        this.type = type;
        this.body = body;
    }
    public FunDeclOp(Id id, ArrayList<ParDeclOp> pdList, TypeOp type, BodyOp body) {
        this.main=false;
        this.id = id;
        this.pdList=pdList;
        this.type = type;
        this.body = body;
    }

    public FunDeclOp(Id id, TypeOp type, BodyOp body) {
        this.id = id;
        this.pdList=null;
        this.type = type;
        this.body = body;
    }

    public boolean getMain() {
        return main;
    }

    public void setMain(boolean main) {
        this.main = main;
    }
    public Id getId() {
        return id;
    }
    public void setId(Id id) {
        this.id = id;
    }
    public ArrayList<ParDeclOp> getPdList() {
        return pdList;
    }
    public void setPdList(ArrayList<ParDeclOp> pdList) {
        this.pdList = pdList;
    }
    public TypeOp getType() { return type; }
    public void setType(TypeOp type) { this.type=type; }
    public BodyOp getBodyOp() {
        return body;
    }
    public void setBodyOp(BodyOp body) {
        this.body = body;
    }

    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
}

package esercitazione4.Node;
import esercitazione4.Statement.Statement;
import esercitazione4.Visitor.Visitor;
import java.util.ArrayList;

public class BodyOp {
    private ArrayList<VarDeclOp> varDeclOpList;
    private ArrayList<Statement> statList;
    public BodyOp(ArrayList<VarDeclOp> varDeclOpList) {
        this.varDeclOpList = varDeclOpList;
        this.statList = new ArrayList<>();
    }

    public BodyOp(ArrayList<VarDeclOp> varDeclOpList, ArrayList<Statement> statList) {
        if(varDeclOpList!=null){
            this.varDeclOpList = varDeclOpList;
        } else{
            this.varDeclOpList = null;
        }
        if(statList!= null){
            this.statList = statList;
        } else{
            this.statList = null;
        }
    }
    public ArrayList<Statement> getStatList() {
        return statList;
    }
    public void setStatList(ArrayList<Statement> statList) {
        this.statList = statList;
    }
    public ArrayList<VarDeclOp> getVarDeclOpList() { return varDeclOpList; }
    public void setVarDeclOpList(ArrayList<VarDeclOp> varDeclOpList) { this.varDeclOpList = varDeclOpList; }
    public String toString() { return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }

}

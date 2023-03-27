package esercitazione4.Node;
import java.util.ArrayList;

public class DeclList {

    private ArrayList<VarDeclOp> varDeclOpList;
    private ArrayList<FunDeclOp> funDeclOpList;

    public DeclList(){
        this.varDeclOpList= new ArrayList<>();
        this.funDeclOpList= new ArrayList<>();
    }

    public DeclList(ArrayList<VarDeclOp> varDeclOpList, ArrayList<FunDeclOp> funDeclOpList){
        this.varDeclOpList=varDeclOpList;
        this.funDeclOpList=funDeclOpList;
    }

    public ArrayList<VarDeclOp> getVarDeclOpList() {return varDeclOpList;}
    public void setVarDeclOpList(ArrayList<VarDeclOp> varDeclOpList) {this.varDeclOpList=varDeclOpList;}
    public ArrayList<FunDeclOp> getFunDeclOpList() {return funDeclOpList;}
    public void setFunDeclOpList(ArrayList<FunDeclOp> funDeclOpList) {this.funDeclOpList=funDeclOpList;}
    public String toString() {return super.toString();}

}

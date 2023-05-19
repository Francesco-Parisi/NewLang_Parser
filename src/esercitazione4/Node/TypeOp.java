package esercitazione4.Node;
import esercitazione4.Type.Type;
import esercitazione4.Visitor.Visitor;

public class TypeOp {
    private String type;

    public TypeOp(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type=type;
    }

    public String toString() {return super.toString();}
    public Object accept(Visitor v){
        return v.visit(this);
    }
    private boolean checkType(String type) {
        return (Type.VAR.equals(type) || Type.VOID.equals(type) || Type.basicTypes.contains(type));
    }
}

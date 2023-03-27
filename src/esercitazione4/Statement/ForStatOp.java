package esercitazione4.Statement;
import esercitazione4.Expressions.ConstOp;
import esercitazione4.Expressions.Id;
import esercitazione4.Node.BodyOp;
import esercitazione4.Visitor.Visitor;

public class ForStatOp extends Statement{

    private Id id;
    private ConstOp cons1, cons2;
    private BodyOp bodyOp;

    public ForStatOp(Id id,ConstOp cons1,ConstOp cons2,BodyOp bodyOp){
        this.id=id;
        this.cons1=cons1;
        this.cons2=cons2;
        this.bodyOp=bodyOp;
    }

    public Id getId() {
        return id;
    }
    public void setId(Id id) { this.id= id; }
    public ConstOp getConst1() {
        return cons1;
    }
    public void setConst1(ConstOp cons1) { this.cons1=cons1; }
    public ConstOp getConst2() {
        return cons2;
    }
    public void setConst(ConstOp cons2) { this.cons2=cons2; }
    public BodyOp getBodyOp() { return bodyOp; }
    public void setBodyOp(BodyOp bodyOp) { this.bodyOp=bodyOp; }
    public String toString() { return super.toString(); }
    public Object accept(Visitor v){
        return v.visit(this);
    }

}

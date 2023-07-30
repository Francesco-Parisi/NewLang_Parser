package esercitazione4.Statement;
import esercitazione4.Expressions.ConstOp.IntegerOp;
import esercitazione4.Expressions.Id;
import esercitazione4.Node.BodyOp;
import esercitazione4.Visitor.Visitor;

public class ForStatOp extends Statement{

    private Id id;
    private IntegerOp cons1;
    private IntegerOp cons2;
    private BodyOp bodyOp;

    public ForStatOp(Id id, IntegerOp cons1, IntegerOp cons2, BodyOp bodyOp){
        this.id=id;
        this.cons1=cons1;
        this.cons2=cons2;
        this.bodyOp=bodyOp;
    }

    public Id getId() {
        return id;
    }
    public void setId(Id id) { this.id= id; }
    public IntegerOp getConst1() {
        return cons1;
    }
    public void setConst1(IntegerOp cons1) { this.cons1=cons1; }
    public IntegerOp getConst2() {
        return cons2;
    }
    public void setConst(IntegerOp cons2) { this.cons2=cons2; }
    public BodyOp getBodyOp() { return bodyOp; }
    public void setBodyOp(BodyOp bodyOp) { this.bodyOp=bodyOp; }
    public String toString() { return super.toString(); }
    public Object accept(Visitor v){
        return v.visit(this);
    }

}
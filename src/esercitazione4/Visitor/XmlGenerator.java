package esercitazione4.Visitor;
import esercitazione4.Expressions.*;
import esercitazione4.Expressions.BinaryOp.*;
import esercitazione4.Expressions.ConstOp.*;
import esercitazione4.Expressions.UnaryOp.*;
import esercitazione4.Node.*;
import esercitazione4.Statement.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

/**
 * XmlGenerator viene utilizzata per generare un documento XML a partire da un oggetto di tipo ProgramOp.
 * All'interno della classe, viene creato un oggetto Document utilizzando le classi DocumentBuilderFactory
 * e DocumentBuilder per creare un nuovo documento XML. Infine, il documento XML completo viene restituito
 * come risultato della visita.
 * */

public class XmlGenerator implements Visitor {
    private Document document;

    public XmlGenerator () throws ParserConfigurationException {

        // Crea il DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Crea un nuovo documento
        document = builder.newDocument();
    }

    @Override
    public Object visit(ProgramOp programOp) {
        Element programOpElement = document.createElement("ProgramOp");

        //Append dei nodi VarDecl
        Element varDeclOpElement = document.createElement("VarDeclOpList");
        for (VarDeclOp varDecl :programOp.getVarDeclOpList() ) {
            Element var= (Element) varDecl.accept(this);
            varDeclOpElement.appendChild(var);
        }
        programOpElement.appendChild(varDeclOpElement);

        //Append dei nodi FunDecl
        Element funDeclOpElement = document.createElement("FunDeclOpList");
        for (FunDeclOp funDecl: programOp.getFunDeclOpList()) {
            Element fun= (Element) funDecl.accept(this);
            funDeclOpElement.appendChild(fun);
        }
        programOpElement.appendChild(funDeclOpElement);

        document.appendChild(programOpElement);
        return document;
    }

    @Override
    public Object visit(ParDeclOp parDeclOp) {
        Element parDeclOpElement = document.createElement("ParDeclOp");

        //Append del nodo Out
        Element outElement = document.createElement("Out");
        String out = Boolean.toString(parDeclOp.getOut());
        outElement.appendChild(document.createTextNode(out));
        parDeclOpElement.appendChild(outElement);

        //Append del nodo Type
        parDeclOpElement.appendChild((Element) parDeclOp.getType().accept(this));

        //Append dei nodi Id
        Element idElement = document.createElement("IdList");
        for (Id id: parDeclOp.getIdList()) {
            Element idList= (Element) id.accept(this);
            idElement.appendChild(idList);
        }
        parDeclOpElement.appendChild(idElement);


        return parDeclOpElement;
    }

    @Override
    public Object visit(VarDeclOp varDeclOp) {
        Element varDeclOpElement = document.createElement("VarDeclOp");

        //Append del nodo Type
        varDeclOpElement.appendChild((Element) varDeclOp.getType().accept(this));

        //Append dei nodi in IdExpr
        varDeclOpElement.appendChild((Element) IdExprVisit(varDeclOp.getListExpr()));

        return varDeclOpElement;
    }

    @Override
    public Object visit(FunDeclOp funDeclOp) {
        Element funDeclOpElement = document.createElement("FunDeclOp");

        //Append del nodo Main
        Element mainElement = document.createElement("Main");
        String main = Boolean.toString(funDeclOp.getMain());
        mainElement.appendChild(document.createTextNode(main));
        funDeclOpElement.appendChild(mainElement);

        //Append del nodo Id
        funDeclOpElement.appendChild((Element) funDeclOp.getId().accept(this));

        //Append dei nodi ParDeclOp
        Element parDeclOpElement = document.createElement("ParDeclOpList");
        for (ParDeclOp parDecl: funDeclOp.getPdList()) {
            Element pdList= (Element) parDecl.accept(this);
            parDeclOpElement.appendChild(pdList);
        }
        funDeclOpElement.appendChild(parDeclOpElement);

        //Append del nodo Type
        funDeclOpElement.appendChild((Element) funDeclOp.getType().accept(this));

        //Append del nodo BodyOp
        funDeclOpElement.appendChild((Element) funDeclOp.getBodyOp().accept(this));

        return funDeclOpElement;
    }
    @Override
    public Object visit(BodyOp bodyOp) {
        Element bodyOpElement = document.createElement("BodyOp");

        //Append dei nodi VarDeclList
        Element varDeclOpElement = document.createElement("VarDeclOpList");
        for (VarDeclOp varDecl :bodyOp.getVarDeclOpList() ) {
            Element var= (Element) varDecl.accept(this);
            varDeclOpElement.appendChild(var);
        }
        bodyOpElement.appendChild(varDeclOpElement);

        //Append dei nodi Statement
        Element statElement = document.createElement("StatementList");
        for (Statement statList: bodyOp.getStatList()) {
            Element stat= (Element) statList.accept(this);
            statElement.appendChild(stat);
        }
        bodyOpElement.appendChild(statElement);

        return bodyOpElement;
    }

    @Override
    public Object visit(AssignStatOp assignStatOp) {
        Element assignStatOpElement = document.createElement("AssignStatOp");

        //Append dei nodi Id
        Element idElement = document.createElement("IdList");
        for(Id id : assignStatOp.getIdList()) {
            Element s= (Element) id.accept(this);
            idElement.appendChild(s);
        }
        assignStatOpElement.appendChild(idElement);

        //Append dei nodi Expr
        Element exprElement= document.createElement("ExprList");
        for(Expr expr : assignStatOp.getExprList()) {
            Object obj = expr.accept(this);
            if(obj instanceof String) exprElement.appendChild(document.createTextNode((String)obj));
            if(obj instanceof Element)  exprElement.appendChild((Element)obj);
        }
        assignStatOpElement.appendChild(exprElement);

        return assignStatOpElement;
    }

    @Override
    public Object visit(ForStatOp forStatOp) {
        Element forStatOpElement = document.createElement("ForStatOp");

        //Append del nodo Id
        forStatOpElement.appendChild((Element) forStatOp.getId().accept(this));

        //Append del nodo Const1
        forStatOpElement.appendChild((Element) forStatOp.getConst1().accept(this));

        //Append del nodo Const2
        forStatOpElement.appendChild((Element) forStatOp.getConst2().accept(this));

        //Append del nodo Bodyop
        forStatOpElement.appendChild((Element) forStatOp.getBodyOp().accept(this));

        return forStatOpElement;
    }

    @Override
    public Object visit(FunCallOpStat funCallOpStat) {
        Element funCallOpStatElement = document.createElement("FunCallOpStat");

        //Append del nodo Id
        funCallOpStatElement.appendChild((Element) funCallOpStat.getId().accept(this));

        //Append dei nodi Expr
        Element exprElement= document.createElement("ExprList");
        for (Expr expr: funCallOpStat.getExprList()) {
            Element exprList= (Element) expr.accept(this);
            exprElement.appendChild(exprList);
        }
        funCallOpStatElement.appendChild(exprElement);

        return funCallOpStatElement;
    }

    @Override
    public Object visit(IfStatOp ifStatOp) {
        Element ifStatOpElement = document.createElement("IfStatOp");

        //Append del nodo Expr
        ifStatOpElement.appendChild((Element) ifStatOp.getExpr().accept(this));

        //Append del nodo BodyOp
        ifStatOpElement.appendChild((Element) ifStatOp.getBodyOp().accept(this));

        //Append del nodo BodyOpElse
        BodyOp bodyElse = ifStatOp.getBodyElse();
        if (bodyElse!=null){
            ifStatOpElement.appendChild((Element) bodyElse.accept(this));
        }

        return ifStatOpElement;
    }

    @Override
    public Object visit(ReadStatOp readStatOp) {
        Element readStatOpElement = document.createElement("ReadStatOp");

        //Append dei nodi Id
        Element idElement = document.createElement("IdList");
        for(Id id : readStatOp.getIdList()) {
            Element s= (Element) id.accept(this);
            idElement.appendChild(s);
        }
        readStatOpElement.appendChild(idElement);

        //Append del nodo Expr
        Expr expr = readStatOp.getExpr();
        if(expr!=null){
            readStatOpElement.appendChild((Element) expr.accept(this));
        }

        return readStatOpElement;
    }
    @Override
    public Object visit(ReturnStatOp returnStatOp) {
        Element returnStatOpElement = document.createElement("ReturnStatOp");

        //Append del nodo Expr
        Expr expr = returnStatOp.getExpr();
        if(expr!=null){
            returnStatOpElement.appendChild((Element) expr.accept(this));
        }
        return returnStatOpElement;
    }

    @Override
    public Object visit(Statement statement) {
        return null;
    }

    @Override
    public Object visit(WhileStatOp whileStatOp) {
        Element whileStatOpElement = document.createElement("WhileStatOp");

        //Append del nodo Expr
        whileStatOpElement.appendChild((Element) whileStatOp.getExpr().accept(this));

        //Append del nodo BodyOp
        whileStatOpElement.appendChild((Element) whileStatOp.getBodyOp().accept(this));

        return whileStatOpElement;
    }

    @Override
    public Object visit(WriteStatOp writeStatOp) {
        Element writeStatOpElement = document.createElement("WriteStatOp");

        //Append del nodo WriteFlag
        Element writeElement = document.createElement("WriteFlag");
        String flag = Boolean.toString(writeStatOp.getWriteFlag());
        writeElement.appendChild(document.createTextNode(flag));
        writeStatOpElement.appendChild(writeElement);

        //Append dei nodi Expr
        Element exprElement= document.createElement("ExprList");
        for(Expr expr : writeStatOp.getListExpr()) {
            Element e = (Element) expr.accept(this);
            exprElement.appendChild(e);
        }
        writeStatOpElement.appendChild(exprElement);

        return writeStatOpElement;
    }

    @Override
    public Object visit(Const Const) {
        return null;
    }


    @Override
    public Object visit(TrueOp trueOp) {
        Element trueOpElement = document.createElement("TrueOp");

        return trueOpElement;
    }

    @Override
    public Object visit(FalseOp falseOp) {
        Element falseOpElement = document.createElement("FalseOp");

        return falseOpElement;
    }

    @Override
    public Object visit(IntegerOp integerOp) {
        Element integerOpElement = document.createElement("IntegerOp");

        //Append del nodo con l'attributo
        integerOpElement.appendChild(document.createTextNode(integerOp.getAttribute()));

        return integerOpElement;
    }

    @Override
    public Object visit(RealOp realOp) {
        Element realOpOpElement = document.createElement("RealOp");

        //Append del nodo con l'attributo
        realOpOpElement.appendChild(document.createTextNode(realOp.getAttribute()));

        return realOpOpElement;
    }

    @Override
    public Object visit(StringOp stringOp) {
        Element stringOpElement = document.createElement("StringOp");

        //Append del nodo con l'attributo
        stringOpElement.appendChild(document.createTextNode(stringOp.getAttribute()));

        return stringOpElement;
    }
    @Override
    public Object visit(CharOp charOp) {
        Element charOpElement = document.createElement("CharOp");

        //Append del nodo con l'attributo
        charOpElement.appendChild(document.createTextNode(charOp.getAttribute()));

        return charOpElement;
    }

    @Override
    public Object visit(TypeOp typeOp) {
        Element typeOpElement = document.createElement("TypeOp");

        //Append del nodo con l'attributo
        typeOpElement.appendChild(document.createTextNode(typeOp.getType()));

        return typeOpElement;
    }

    @Override
    public Object visit(FunCallOpExpr funCallOpExpr) {
        Element funCallOpExprElement = document.createElement("FunCallOpExpr");

        //Append del nodo Id
        funCallOpExprElement.appendChild((Element) funCallOpExpr.getId().accept(this));

        //Append dei nodi Expr
        Element exprElement= document.createElement("ExprList");
        for(Expr expr : funCallOpExpr.getExprList()) {
            Element e = (Element) expr.accept(this);
            exprElement.appendChild(e);
        }
        funCallOpExprElement.appendChild(exprElement);

        return funCallOpExprElement;
    }

    /**
     @Override
     public Object visit(IdInitObbOp idInitObbOp) {
     Element idInitObbOpElement = document.createElement("IdInitObbOp");

     //Append del nodo Id
     idInitObbOpElement.appendChild((Element)(idInitObbOp.getId().accept(this)));

     //Append del nodo Expr
     idInitObbOpElement.appendChild((Element) idInitObbOp.getExpr().accept(this));

     return idInitObbOpElement;
     }

     @Override
     public Object visit(IdInitOp idInitOp) {
     Element idInitOpElement = document.createElement("IdInitObbOp");

     //Append del nodo Id
     idInitOpElement.appendChild((Element)(idInitOp.getId().accept(this)));

     //Append del nodo Expr
     idInitOpElement.appendChild((Element) idInitOp.getExpr().accept(this));

     return idInitOpElement;
     }
     */

    @Override
    public Object visit(Id id) {

        //Append del nodo Id
        Element idElement = document.createElement("Id");
        idElement.appendChild(document.createTextNode(id.getId()));

        return idElement;
    }

    @Override
    public Object visit(Expr expr) {
        return null;
    }
    @Override
    public Object visit(AddOp addOp) {
        Element addOpElement = document.createElement("AddOp");

        Object e1 = addOp.getE1().accept(this);
        if(e1 instanceof String) addOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  addOpElement.appendChild((Element)e1);

        Object e2 = addOp.getE2().accept(this);
        if(e2 instanceof String) addOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  addOpElement.appendChild((Element)e2);

        return addOpElement;
    }

    @Override
    public Object visit(AndOp andOp) {
        Element andOpElement = document.createElement("AndOp");

        Object e1 = andOp.getE1().accept(this);
        if(e1 instanceof String) andOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  andOpElement.appendChild((Element)e1);

        Object e2 = andOp.getE2().accept(this);
        if(e2 instanceof String) andOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  andOpElement.appendChild((Element)e2);
        return andOpElement;
    }

    //Da finire
    @Override
    public Object visit(DiffOp diffOp) {
        Element diffOpElement = document.createElement("DiffOp");

        Object e1 = diffOp.getE1().accept(this);
        if(e1 instanceof String) diffOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  diffOpElement.appendChild((Element)e1);

        Object e2 = diffOp.getE2().accept(this);
        if(e2 instanceof String) diffOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  diffOpElement.appendChild((Element)e2);
        return diffOpElement;
    }

    @Override
    public Object visit(DivOp divOp) {
        Element divOpElement = document.createElement("DivOp");

        Object e1 = divOp.getE1().accept(this);
        if(e1 instanceof String) divOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  divOpElement.appendChild((Element)e1);

        Object e2 = divOp.getE2().accept(this);
        if(e2 instanceof String) divOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  divOpElement.appendChild((Element)e2);
        return divOpElement;
    }

    @Override
    public Object visit(EQOp eqOp) {
        Element eqOpElement = document.createElement("EqOp");

        Object e1 = eqOp.getE1().accept(this);
        if(e1 instanceof String) eqOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  eqOpElement.appendChild((Element)e1);

        Object e2 = eqOp.getE2().accept(this);
        if(e2 instanceof String) eqOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  eqOpElement.appendChild((Element)e2);
        return eqOpElement;
    }

    @Override
    public Object visit(GEOp geOp) {
        Element geOpElement = document.createElement("GEOp");

        Object e1 = geOp.getE1().accept(this);
        if(e1 instanceof String) geOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  geOpElement.appendChild((Element)e1);

        Object e2 = geOp.getE2().accept(this);
        if(e2 instanceof String) geOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  geOpElement.appendChild((Element)e2);
        return geOpElement;
    }

    @Override
    public Object visit(GTOp gtOp) {
        Element gtOpElement = document.createElement("GTOp");

        Object e1 = gtOp.getE1().accept(this);
        if(e1 instanceof String) gtOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  gtOpElement.appendChild((Element)e1);

        Object e2 = gtOp.getE2().accept(this);
        if(e2 instanceof String) gtOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  gtOpElement.appendChild((Element)e2);
        return gtOpElement;
    }

    @Override
    public Object visit(LEOp leOp) {
        Element leOpElement = document.createElement("LEOp");

        Object e1 = leOp.getE1().accept(this);
        if(e1 instanceof String) leOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  leOpElement.appendChild((Element)e1);

        Object e2 = leOp.getE2().accept(this);
        if(e2 instanceof String) leOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  leOpElement.appendChild((Element)e2);
        return leOpElement;
    }

    @Override
    public Object visit(LTOp ltOp) {
        Element ltOpElement = document.createElement("LTOp");

        Object e1 = ltOp.getE1().accept(this);
        if(e1 instanceof String) ltOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  ltOpElement.appendChild((Element)e1);

        Object e2 = ltOp.getE2().accept(this);
        if(e2 instanceof String) ltOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  ltOpElement.appendChild((Element)e2);
        return ltOpElement;
    }

    @Override
    public Object visit(MulOp mulOp) {
        Element mulOpElement = document.createElement("MulOp");

        Object e1 = mulOp.getE1().accept(this);
        if(e1 instanceof String) mulOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  mulOpElement.appendChild((Element)e1);

        Object e2 = mulOp.getE2().accept(this);
        if(e2 instanceof String) mulOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  mulOpElement.appendChild((Element)e2);
        return mulOpElement;
    }

    @Override
    public Object visit(NEOp neOp) {
        Element neOpElement = document.createElement("NEOp");

        Object e1 = neOp.getE1().accept(this);
        if(e1 instanceof String) neOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  neOpElement.appendChild((Element)e1);

        Object e2 = neOp.getE2().accept(this);
        if(e2 instanceof String) neOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  neOpElement.appendChild((Element)e2);
        return neOpElement;
    }

    @Override
    public Object visit(OrOp orOp) {
        Element orOpElement = document.createElement("OrOp");

        Object e1 = orOp.getE1().accept(this);
        if(e1 instanceof String) orOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  orOpElement.appendChild((Element)e1);

        Object e2 = orOp.getE2().accept(this);
        if(e2 instanceof String) orOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  orOpElement.appendChild((Element)e2);
        return orOpElement;
    }

    @Override
    public Object visit(PowOp powOp) {
        Element powOpElement = document.createElement("PowOp");

        Object e1 = powOp.getE1().accept(this);
        if(e1 instanceof String) powOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  powOpElement.appendChild((Element)e1);

        Object e2 = powOp.getE2().accept(this);
        if(e2 instanceof String) powOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  powOpElement.appendChild((Element)e2);
        return powOpElement;
    }

    @Override
    public Object visit(StrCatOp strCatOp) {
        Element strCatOpElement = document.createElement("StrCatOp");

        Object e1 = strCatOp.getE1().accept(this);
        if(e1 instanceof String) strCatOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  strCatOpElement.appendChild((Element)e1);

        Object e2 = strCatOp.getE2().accept(this);
        if(e2 instanceof String) strCatOpElement.appendChild(document.createTextNode((String)e2));
        if(e2 instanceof Element)  strCatOpElement.appendChild((Element)e2);
        return strCatOpElement;
    }

    @Override
    public Object visit(NotOp notOp) {
        Element notOpElement = document.createElement("NotOp");

        Object e1 = notOp.getExpr().accept(this);
        if(e1 instanceof String) notOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  notOpElement.appendChild((Element)e1);
        return notOpElement;
    }

    @Override
    public Object visit(UminusOp uminusOp) {
        Element uminusOpElement = document.createElement("UminusOp");

        Object e1 = uminusOp.getExpr().accept(this);
        if(e1 instanceof String) uminusOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  uminusOpElement.appendChild((Element)e1);
        return uminusOpElement;
    }

    @Override
    public Object visit(ParOp parOp) {
        Element parOpElement = document.createElement("ParOp");

        Object e1 = parOp.getExpr().accept(this);
        if(e1 instanceof String) parOpElement.appendChild(document.createTextNode((String)e1));
        if(e1 instanceof Element)  parOpElement.appendChild((Element)e1);
        return parOpElement;
    }
    private Object IdExprVisit(ArrayList<IdExpr> idExprList) {
        // creo un nuovo element
        Element idExprListElement = document.createElement("IdExprList");

        // appendo i nodi contenuti nel wrapper IdExpr
        for(IdExpr idExpr : idExprList) {
            // creo un idExprElement
            Element idExprElement = document.createElement("IdExpr");

            // appendo Id all'elemento idExprElement
            idExprElement.appendChild((Element) idExpr.getId().accept(this));

            //Appendo Expr all'elemento idExprElement
            Expr expr = idExpr.getExpr();
            if(expr != null) {
                idExprElement.appendChild((Element) expr.accept(this));
            }

            idExprListElement.appendChild(idExprElement);
        }

        return idExprListElement;
    }


}

package esercitazione4.Visitor;

import esercitazione4.Expressions.*;
import esercitazione4.Expressions.BinaryOp.*;
import esercitazione4.Expressions.UnaryOp.*;
import esercitazione4.Expressions.ConstOp.*;
import esercitazione4.Node.*;
import esercitazione4.Statement.*;
/**
 * Visitor è un'interfaccia utilizzata per implementare il pattern Visitor, il quale definisce un insieme di
 * metodi di visita. Ogni metodo di visita accetta un argomento del tipo corrispondente all'elemento da visitare
 * e restituisce un oggetto di tipo Object.
 * */

public interface Visitor {

    Object visit(ProgramOp programOp);
    Object visit(ParDeclOp parDeclOp);
    Object visit(VarDeclOp varDeclOp);
    Object visit(FunDeclOp funDeclOp);
    Object visit(BodyOp bodyOp);
    Object visit(AssignStatOp assignStatOp);
    Object visit(ForStatOp forStatOp);
    Object visit(FunCallOpStat funCallOpStat);
    Object visit(IfStatOp ifStatOp);
    Object visit(ReadStatOp readStatOp);
    Object visit(ReturnStatOp returnStatOp);
    Object visit(Statement statement);
    Object visit(WhileStatOp whileStatOp);
    Object visit(WriteStatOp writeStatOp);
    Object visit(Const constOp);
    Object visit(TrueOp trueOp);
    Object visit(FalseOp falseOp);
    Object visit(IntegerOp integerOp);
    Object visit(RealOp realOp);
    Object visit(StringOp stringOp);
    Object visit(CharOp charOp);
    Object visit(TypeOp typeOp);
    Object visit(FunCallOpExpr funCallOpExpr);
    /**
    Object visit(IdInitObbOp idInitObbOp);

    Object visit(IdInitOp idInitOp);
     */
    Object visit(Id id);
    Object visit(Expr expr);
    Object visit(AddOp addOp);
    Object visit(AndOp andOp);
    Object visit(DiffOp diffOp);
    Object visit(DivOp divIntOp);
    Object visit(EQOp eqOp);
    Object visit(GEOp geOp);
    Object visit(GTOp gtOp);
    Object visit(LEOp leOp);
    Object visit(LTOp ltOp);
    Object visit(MulOp mulOp);
    Object visit(NEOp neOp);
    Object visit(OrOp orOp);
    Object visit(PowOp powOp);
    Object visit(StrCatOp strCatOp);
    Object visit(NotOp notOp);
    Object visit(UminusOp uminusOp);
    Object visit(ParOp parOp);
}

//Parte 1 - Codice Utente
package esercitazione4;
import java_cup.runtime.*;
%%

//Parte 2 - Opzioni e Dichiarazioni
%public
%class Lexer
%cupsym ParserSym
%cup

%unicode

%{
  StringBuffer string = new StringBuffer();
  //Gestione dei Token riconosciuti
  private Symbol symbol(int type) {
       return new Symbol(type);
  }

  private Symbol symbol(int type, Object value) {
       return new Symbol(type, value);
  }

  //Inizializzazione della classe esercitazione4.Lexer per Tester
  Lexer(){}
%}

//Definizioni regolari *****************

LineTerminator = \r|\n|\r\n   //Sequenza di escape
Whitespace = {LineTerminator} | [ \t\f]

//jletter e jletterdigit sono classi di caratteri predefinite
Identifier = [$_A-Za-z][$_A-Za-z0-9]*
IntegerLiteral = 0|([1-9][0-9]*)(E[+|-]?[0-9]+)?
RealLiteral = ((0|[1-9][0-9]*)) \. [0-9]+(E[+|-]?[0-9]+)?

%state STRING_LITERAL
%state CHAR_LITERAL
%state TRADIT_COMMENT
%state ONE_LINE_COMMENT
%%

//Parte 3 - Regole Lessicali
<YYINITIAL> { //Lo stato in cui il lexer inizia la scansione.

//Keywords
"start:"    { return symbol(ParserSym.MAIN); }
"def"       { return symbol(ParserSym.DEF); }
"var"       { return symbol(ParserSym.VAR); }
"true"      { return symbol(ParserSym.TRUE);}
"false"     { return symbol(ParserSym.FALSE);}
"out"       { return symbol(ParserSym.OUT); }
"<--"       { return symbol(ParserSym.READ); }
"-->"       { return symbol(ParserSym.WRITE); }
"-->!"      { return symbol(ParserSym.WRITELN); }
"return"    { return symbol(ParserSym.RETURN);}

//Condizioni
"if" 		{ return symbol(ParserSym.IF); }
"then" 		{ return symbol(ParserSym.THEN); }
"else" 		{ return symbol(ParserSym.ELSE); }
"for" 		{ return symbol(ParserSym.FOR); }
"while" 	{ return symbol(ParserSym.WHILE); }
"to"        { return symbol(ParserSym.TO); }
"loop"      { return symbol(ParserSym.LOOP); }

//Tipi
"integer"   { return symbol(ParserSym.INT); }
"float"     { return symbol(ParserSym.REAL); }
"string"    { return symbol(ParserSym.STRING); }
"boolean"   { return symbol(ParserSym.BOOL);}
"char"      { return symbol(ParserSym.CHAR);}
"void"      { return symbol(ParserSym.VOID);}

//Separatori
"(" 	{ return symbol(ParserSym.LPAR); }
")" 	{ return symbol(ParserSym.RPAR); }
"{" 	{ return symbol(ParserSym.LBRAC); }
"}" 	{ return symbol(ParserSym.RBRAC); }
"," 	{ return symbol(ParserSym.COMMA); }
";" 	{ return symbol(ParserSym.SEMI); }
"|" 	{ return symbol(ParserSym.PIPE); }
":" 	{ return symbol(ParserSym.COLON); }

//Relop
"<" 	{ return symbol(ParserSym.LT); }
"<=" 	{ return symbol(ParserSym.LE); }
"=" 	{ return symbol(ParserSym.EQ); }
"!=" 	{ return symbol(ParserSym.NE); }
">" 	{ return symbol(ParserSym.GT); }
">=" 	{ return symbol(ParserSym.GE); }

//Operatori Aritmetici
"+" 	{ return symbol(ParserSym.PLUS); }
"-" 	{ return symbol(ParserSym.MINUS); }
"*" 	{ return symbol(ParserSym.TIMES); }
"<<" 	{ return symbol(ParserSym.ASSIGN); }
"/" 	{ return symbol(ParserSym.DIV); }
"^"     { return symbol(ParserSym.POW); }
"&"     { return symbol(ParserSym.STR_CONCAT); }

//Operatori Logici
"and" 	{ return symbol(ParserSym.AND); }
"or" 	{ return symbol(ParserSym.OR); }
"not" 	{ return symbol(ParserSym.NOT); }

//Identificatori
{Identifier} { return symbol(ParserSym.ID, yytext()); }

//Letterali
{IntegerLiteral}	{ return symbol(ParserSym.INTEGER_CONST, yytext()); }
{RealLiteral}	    { return symbol(ParserSym.REAL_CONST, yytext()); }

//Strings
\"      { string.setLength(0); yybegin(STRING_LITERAL);}
\'      { string.setLength(0); yybegin(CHAR_LITERAL); }

//Whitespace
{Whitespace} { /* ignore */ }

//Commenti
"|*"    {yybegin(TRADIT_COMMENT);}
"||"     { yybegin(ONE_LINE_COMMENT); }

}
<<EOF>> { return null;}

<STRING_LITERAL> {

      \"    { yybegin(YYINITIAL); return symbol(ParserSym.STRING_CONST, string.toString()); }
      [^\n\r\"\\]+      { string.append(yytext()); }
      \\t               { string.append('\t'); }
      \\n               { string.append('\n'); }
      \\r               { string.append('\r'); }
      \\                { string.append('\\'); }
      \\\"              { string.append('\"'); }
      <<EOF>>           { throw new Error("Illegal line end in string literal"); }

}

<CHAR_LITERAL> {

     \'                                 { yybegin(YYINITIAL); return symbol(ParserSym.CHAR_CONST,string.toString()); }
      [^\']                           { string.append(yytext());}
      \\t                               { string.append("\\t"); }
      \\n                               { string.append("\\n"); }
      \\r                               { string.append("\\r"); }
      \\\"                                { string.append("\""); }
      \\                                { string.append("\\"); }
      [^\']+                           { throw new Error("Illegal line in char literal"); }

}

<TRADIT_COMMENT> {
     \|                { yybegin(YYINITIAL); }
     [^|]              { /* ignore */ }
     <<EOF>>           { throw new Error("Unclosed comment"); }

}

<ONE_LINE_COMMENT> {
    {LineTerminator}    { yybegin(YYINITIAL); }
    [^]                 { /* ignore */ }

}

//Error fallback
[^] {throw new Error("Illegal character '" + yytext() + "'");}

<<EOF>>     {return symbol(ParserSym.EOF);}
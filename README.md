# NewLang Programming Language

Esercitazione 4 del Corso Compilatori dell'Università degli studi di Salerno.

## Analisi lessicale e sintattica di NewLang

Date le specifiche lessicali e sintattiche del linguaggio NewLang:

1. Scrivere un programma NewLang che visualizzi un menu in cui un utente può scegliere l' operazione aritmetica da svolgere richieda all'utente gli input (interi o double) necessari per svolgere l'operazione scelta esegua l'operazione, restituisca il risultato e chieda se si vuol continuare all'input 0 oppure 1 il programma conclude oppure mostra il menu iniziale, rispettivamente.
N.B. si utilizzino almeno due funzioni. In generale, si cerchi di utilizzare tutte le caratteristiche del linguaggio.

2. Allo scopo di poter verificare la correttezza e compilare il programma appena scritto, si costruisca un parser completo di lexer e parser per NewLang tramite Jflex e CUP. L'analizzatore sintattico può interrompersi al primo errore sintattico incontrato.

3. Utilizzare la grammatica implementata al punto 2 per costruire gli alberi sintattici secondo la specifica stabilita.

### Lexical Specification

| Token         | Lexeme                   |
|---------------|--------------------------|
| MAIN          | "start:"                 |
| SEMI          | ";"                      |
| COMMA         | ","                      |
| PIPE          | "&#124;"                 |                 
| VAR           | "var"                    |
| INT           | "integer"                |
| REAL          | "float"                  |
| STRING        | "string"                 |
| BOOL          | "boolean"                |
| CHAR          | "char"                   |
| VOID          | "void"                   |
| DEF           | "def"                    |
| OUT           | "out"                    |
| FOR           | "for"                    |
| IF            | "if"                     |
| ELSE          | "else"                   |
| WHILE         | "while"                  |
| TO            | "to"                     |
| LOOP          | "loop"                   |
| READ          | "<--"                    |
| WRITE         | "-->"                    |
| WRITELN       | "-->!"                   |
| LPAR          | "("                      |
| RPAR          | ")"                      |
| LBRAC         | "{"                      |
| RBRAC         | "}"                      |
| COLON         | ":"                      |
| ASSIGN        | "<<"                     |
| RETURN        | "return"                 |
| ID            | [$_A-Za-z][$_A-Za-z0-9]* |
| INTEGER_CONST | IntegerLiteral           |
| REAL_CONST    | RealLiteral              |
| STRING_CONST  | " "                      |
| CHAR_CONST    | ' '                      |
| TRUE          | true                     |
| FALSE         | false                    |
| PLUS          | "+"                      |
| MINUS         | "-"                      |
| TIMES         | "*"                      |
| DIV           | "/"                      |
| AND           | "and"                    |
| OR            | "or"                     |
| GT            | ">"                      | 
| GE            | ">="                     |
| LT            | "<"                      |
| LE            | "<="                     |
| EQ            | "="                      |
| NE            | "!="                     |
| NOT           | "not"                    |
| STR_CONCAT    | "&"                      |


## Grammar Specification
```cup
Program ::= DeclList MainFunDecl DeclList;
DeclList ::= VarDecl DeclList | FunDecl DeclList | /* empty */;
MainFunDecl ::= MAIN FunDecl;

VarDecl ::= Type IdInitList SEMI
	| VAR IdInitObblList SEMI;

Type ::= INTEGER | BOOL | REAL | STRING | CHAR;

IdInitList ::= ID 
	| IdInitList COMMA ID
	| ID ASSIGN Expr
	| IdInitList COMMA ID ASSIGN Expr;

IdInitObblList ::= ID ASSIGN Const
	| IdInitObblList COMMA ID ASSIGN Const;

Const ::= INTEGER_CONST | REAL_CONST | TRUE | FALSE | STRING_CONST | CHAR_CONST;

FunDecl ::= DEF ID LPAR ParamDeclList RPAR COLON TypeOrVoid Body;

Body ::= LBRAC VarDeclList StatList RBRAC;

ParamDeclList ::= /*empty */ 
	| NonEmptyParamDeclList;

NonEmptyParamDeclList ::= ParDecl
	| NonEmptyParamDeclList PIPE ParDecl;

ParDecl ::= Type IdList
	| OUT Type IdList;
	
TypeOrVoid ::= Type | VOID;

VarDeclList ::= /* empty */ 
	| VardDecl VarDeclList;
	
StatList ::= Stat 
	 | Stat StatList;
	

Stat ::= IfStat 
	| ForStat 
	| ReadStat SEMI
	| WriteStat SEMI
	| AssignStat SEMI
        | WhileStat 
	| FunCall SEMI
	| RETURN Expr SEMI
	| RETURN SEMI
	| /* empty */;
	
IfStat ::= IF Expr THEN Body Else;

Else ::= /* empty */ 
	| ELSE Body;

WhileStat ::= WHILE Expr LOOP Body;
	
ForStat ::= FOR ID ASSIGN INTEGER_CONST TO INTEGER_CONST LOOP Body;

ReadStat ::= IdList READ STRING_CONST 
	|  IdList READ;

IdList ::= ID 
	| IdList COMMA ID;

WriteStat ::= LPAR ExprList RPAR WRITE         
	   | LPAR ExprList RPAR WRITELN;      

	
AssignStat ::=  IdList ASSIGN ExprList;

FunCall ::= ID LPAR ExprList RPAR   
	| ID LPAR RPAR;
  
ExprList ::= Expr	
	| Expr COMMA ExprList;
	
Expr ::= TRUE                            
	| FALSE                           
	| INTEGER_CONST                    
	| REAL_CONST
	| STRING_CONST
	| CHAR_CONST
	| ID
	| FunCall
	| Expr  PLUS Expr
	| Expr  MINUS Expr
	| Expr  TIMES Expr
	| Expr  DIV Expr
	| Expr  AND Expr
	| Expr POW Expr
	| Expr STR_CONCAT Expr
	| Expr  OR Expr
	| Expr  GT Expr
	| Expr  GE Expr
	| Expr  LT Expr
	| Expr  LE Expr
	| Expr  EQ Expr
	| Expr  NE Expr
	| MINUS Expr
	| NOT Expr
	| LPAR Expr RPAR;
```

## Notes

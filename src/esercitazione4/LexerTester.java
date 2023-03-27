package esercitazione4;

import java_cup.runtime.Symbol; 		//This is how we pass tokens to the parser
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LexerTester {

    public static void main(String[] args) throws FileNotFoundException {
        Lexer lexicalAnalyzer = new Lexer(new FileReader(args[0]));

        Symbol token;
        try {
            while ((token = lexicalAnalyzer.next_token()) != null) {
                if(token.sym == ParserSym.EOF) { //Se il file è terminato
                    break;
                }
                if(token.value == null) { //Se il token appartiene alle KeyWords
                    System.out.println("<" + ParserSym.terminalNames[token.sym] + ">");
                }else{ //Se è presente un valore lo stampa insieme al Token riconosciuto
                    System.out.println("<"+ ParserSym.terminalNames[token.sym]+"," +token.value+">");
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Parsing Ended");
        }
    }

}
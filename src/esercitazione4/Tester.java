package esercitazione4;

import esercitazione4.Node.ProgramOp;
import esercitazione4.Visitor.XmlGenerator;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;

public class Tester {

    public static void main(String[] args) {

        try {

            //Crea un oggetto FileReader che legge il contenuto del file specificato nel primo argomento
            FileReader inFile = new FileReader(args[0]);

            //Crea un oggetto Lexer che analizza il contenuto del file letto dal FileReader
            Lexer lexer = new Lexer(inFile);

            //Crea un oggetto Parser che utilizza i token individuati dal Lexer per costruire una struttura sintattica.
            Parser parser = new Parser(lexer);

            ProgramOp program =  (ProgramOp) parser.parse().value;

            XmlGenerator xml = new XmlGenerator();
            Document doc = (Document) program.accept(xml);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(doc);

            StreamResult streamResult = new StreamResult(new File(System.getProperty("user.dir")+"\\albero_sintattico.xml"));
            transformer.transform(domSource, streamResult);
            System.out.println("Il File XML è stato generato correttamente.");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

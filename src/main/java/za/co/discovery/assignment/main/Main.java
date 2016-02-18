package za.co.discovery.assignment.main;

import org.apache.log4j.Logger;
import za.co.discovery.assignment.fibonacci.EvenFibonacciSeries;
import za.co.discovery.assignment.transformer.JAXBXMLParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amar on 2015/08/31.
 */
public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        List<Integer> evenFibonacci = new ArrayList<Integer>();
        int i = 1;
        long sum = 0;
        System.out.println("Assignment #1: ");
        EvenFibonacciSeries.printValueUsingRecursion(evenFibonacci, i, sum);
        System.out.print("=========================================================================\n");

        evenFibonacci = new ArrayList<Integer>();
        EvenFibonacciSeries.printValueUsingLoop(evenFibonacci, i, sum);

        System.out.print("=========================================================================\n");
        System.out.println("Assignment #2: ");
        String userInput;
        StringBuilder content = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the file name. \n");

        try {
            userInput = br.readLine();
            String sCurrentLine;
            br = new BufferedReader(new FileReader(userInput));

            //Reading the file name
            while ((sCurrentLine = br.readLine()) != null) {
                content.append(sCurrentLine).append("\n");
            }

            //Parsing it with the given Schema
            JAXBXMLParser.parseTheContent(content);

        } catch (Exception e) {
            logger.error("Error occurred while doing assignments... \n");
            e.printStackTrace();
        }
        System.out.print("=========================================================================\n");
        System.out.println("Assignment #3: ");
        System.out.println("We can use Java XML validation API to validate the XSD." +
                "As there are number of XML schema available in JAVA but we must take care that we will use" +
                "a validating parser than non-validating parser. Non-validating parsers hardly cars about the " +
                "Data Types in DTD as long as the Structure of the XML is welformed. Whereas Validating Parser looks for" +
                "the validation rules in DTD or Schema. Does checks the validation rules designed on Schema." +
                "Validation can always be performed on either against DTD or XML Schema. In this code we can also validate" +
                "the schema prior to the XML generated using any given APIs" +
                "Such as:" +
                "import javax.xml.validation.Schema;\n" +
                "import javax.xml.validation.SchemaFactory;\n" +
                "import javax.xml.validation.Validator;");

    }
}

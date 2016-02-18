package za.co.discovery.assignment.transformer;

import org.apache.log4j.Logger;
import za.co.discovery.test.List;
import za.co.discovery.test.ObjectFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Amar on 2015/08/31.
 */
public class JAXBXMLParser {

    private static Logger logger = Logger.getLogger(JAXBXMLParser.class);
    private static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * Prints the converted xml of the input.txt file
     *
     * @param content The content of the file that needs to be parsed
     */
    public static void parseTheContent(StringBuilder content) throws ParseException, JAXBException {
        int i = 0;
        String[] lines = content.toString().split("\n");
        ObjectFactory factory = new ObjectFactory();
        List list = factory.createList();

        //This is more Specific to the given input.txt
        while (i < 3) {
            List.Item item = factory.createListItem();
            String[] messagesInALine = lines[i].split(" ", 3);
            String dateInString = messagesInALine[0] + " " + messagesInALine[1];
            Calendar c = Calendar.getInstance();
            c.setTime(DATE_TIME_FORMAT.parse(dateInString));
            item.setDate(c);
            String label = messagesInALine.length > 2 ? messagesInALine[2] : "";
            item.setLabel(label);
            list.getItems().add(item);
            i++;
        }
        JAXBContext context = JAXBContext.newInstance(List.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        System.out.println("\nThe resulted XMl file is: ");
        marshaller.marshal(list, System.out);
    }
}

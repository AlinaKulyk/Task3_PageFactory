package util;

import model.RozetkaFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XMLtoObject {

    public static void main(String[] args) {

        try {
            String xmlstr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                    "<rozetkaFilter>\n" +
                    "    <productGroup>Ноутбуки</productGroup>\n" +
                    "    <brand>Apple</brand>\n" +
                    "    <sum>50000</sum>\n" +
                    "</rozetkaFilter>";

            JAXBContext jaxbContext = JAXBContext.newInstance(RozetkaFilter.class);
            Unmarshaller unmarshaller  = jaxbContext.createUnmarshaller();

            RozetkaFilter rozetkaFilter = (RozetkaFilter) unmarshaller.unmarshal(new StringReader(xmlstr));
            System.out.println(rozetkaFilter.getProductGroup());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

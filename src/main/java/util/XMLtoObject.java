package util;

import model.RozetkaFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLtoObject {

    public RozetkaFilter convert() {

        try {

            File file = new File( "src/main/resources/rozetkaFilter.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(RozetkaFilter.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            RozetkaFilter rozetkaFilter = (RozetkaFilter) jaxbUnmarshaller.unmarshal(file);
            return rozetkaFilter;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

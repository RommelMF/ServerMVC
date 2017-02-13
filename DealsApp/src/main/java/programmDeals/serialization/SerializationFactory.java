package programmDeals.serialization;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * Class SerializationFactory
 */
public class SerializationFactory {

    static final String PACKAGE = StorageTransformers.class.getPackage().getName();
    JAXBContext jc;
    private File file;

    public SerializationFactory() {
        file = new File("src/main/resources/StorageData.xml");
    }

    public void serialization(StorageTransformers st) {
        try {
            jc = JAXBContext.newInstance(PACKAGE);
            Marshaller m = jc.createMarshaller();
            Unmarshaller um = jc.createUnmarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(st, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public StorageTransformers unSerialization() {
        StorageTransformers storageTransformers = null;

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            jc = JAXBContext.newInstance(PACKAGE);
            Unmarshaller um = jc.createUnmarshaller();
            storageTransformers = (StorageTransformers) um.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return storageTransformers;
    }
}

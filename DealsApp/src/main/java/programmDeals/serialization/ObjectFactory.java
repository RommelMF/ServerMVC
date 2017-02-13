package programmDeals.serialization;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * Class ObjectFactory
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName qNameST = new QName(XMLConstants.NULL_NS_URI, "ST");

    @XmlElementDecl(name = "StorageTransformer")
    public JAXBElement<StorageTransformers> createST(StorageTransformers value) {
        return new JAXBElement<StorageTransformers>(qNameST, StorageTransformers.class, null, value);
    }
}

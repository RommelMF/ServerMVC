package programmDeals.serialization;

import javax.xml.bind.annotation.*;

/**
 * Class FotoProductTransformer
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "FPTransformer")
public class FPTranformer {

    @XmlAttribute(name = "title")
    private String titleT;
    @XmlElement(name = "price")
    private double priceT;
    @XmlElement(name = "megapx")
    private double megapxT;
    @XmlElement(name = "digital")
    private boolean digitalT;

    public String getTitleT() {
        return titleT;
    }

    public void setTitleT(String titleT) {
        this.titleT = titleT;
    }

    public double getPriceT() {
        return priceT;
    }

    public void setPriceT(double priceT) {
        this.priceT = priceT;
    }

    public double getMegapxT() {
        return megapxT;
    }

    public void setMegapxT(double megapxT) {
        this.megapxT = megapxT;
    }

    public boolean isDigitalT() {
        return digitalT;
    }

    public void setDigitalT(boolean digitalT) {
        this.digitalT = digitalT;
    }
}

package programmDeals.serialization;

import javax.xml.bind.annotation.*;

/**
 * Class BotinkProductTransformer
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "BPTransformer")
public class BPTransformer {

    @XmlAttribute(name = "title")
    private String titleT;
    @XmlElement(name = "price")
    private double priceT;
    @XmlElement(name = "size")
    private int sizeT;
    @XmlElement(name = "colour")
    private String colourT;

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

    public int getSizeT() {
        return sizeT;
    }

    public void setSizeT(int sizeT) {
        this.sizeT = sizeT;
    }

    public String getColourT() {
        return colourT;
    }

    public void setColourT(String colourT) {
        this.colourT = colourT;
    }
}

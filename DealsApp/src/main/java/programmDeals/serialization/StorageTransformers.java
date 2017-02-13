package programmDeals.serialization;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class StorageTransformers
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "StorageTransformer")
public class StorageTransformers {

    @XmlElement(name = "BPTransformerList")
    @XmlElementWrapper(name = "BPObjects")
    private List<BPTransformer> bpTransformerList;
    @XmlElement(name = "FPTransformerList")
    @XmlElementWrapper(name = "FPObjects")
    private List<FPTranformer> fpTranformerList;

    public List<BPTransformer> getBpTransformerList() {
        return bpTransformerList;
    }

    public void setBpTransformerList(List<BPTransformer> bpTransformerList) {
        this.bpTransformerList = bpTransformerList;
    }

    public List<FPTranformer> getFpTranformerList() {
        return fpTranformerList;
    }

    public void setFpTranformerList(List<FPTranformer> fpTranformerList) {
        this.fpTranformerList = fpTranformerList;
    }
}

package programmDeals.serialization;

import programmDeals.programm.BotinkProduct;
import programmDeals.programm.FotoProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Class TransformerFactory
 */
public class TransformerFactory {

    private List<FotoProduct> fList;
    private List<BotinkProduct> bList;
    private StorageTransformers st;
    private SerializationFactory sf;

    public TransformerFactory(List<FotoProduct> fList, List<BotinkProduct> bList) {
        this.fList = fList;
        this.bList = bList;
        sf = new SerializationFactory();
    }

    public void transformToXML() {
        st = new StorageTransformers();
        if (!fList.isEmpty()) {
            List<FPTranformer> fTList = transformFP();
            st.setFpTranformerList(fTList);
        } else {
            System.out.println("FList is empty!");
        }
        if (!bList.isEmpty()) {
            List<BPTransformer> bTList = transformBP();
            st.setBpTransformerList(bTList);
        } else {
            System.out.println("Flist is empty!");
        }
        sf.serialization(st);
    }

    public void transformToObjects() {
        StorageTransformers storageT = sf.unSerialization();
        List<BPTransformer> bpTList = storageT.getBpTransformerList();
        List<FPTranformer> fpTList = storageT.getFpTranformerList();
        if(!bpTList.isEmpty()) {
            for (BPTransformer bpT : bpTList) {
                BotinkProduct b = new BotinkProduct();
                b.setTitle(bpT.getTitleT());
                b.setPrice(bpT.getPriceT());
                b.setSize(bpT.getSizeT());
                b.setColor(bpT.getColourT());
                bList.add(b);
            }
        } else {
            System.out.println("BTList is empty!");
        }
        if(!fpTList.isEmpty()) {
            for (FPTranformer fpT : fpTList) {
                FotoProduct f = new FotoProduct();
                f.setTitle(fpT.getTitleT());
                f.setPrice(fpT.getPriceT());
                f.setDigital(fpT.isDigitalT());
                f.setMegapx(fpT.getMegapxT());
                fList.add(f);
            }
        } else {
            System.out.println("FTlist is empty!");
        }


    }

    private List<FPTranformer> transformFP() {
        List<FPTranformer> list = new ArrayList<>();

        for (FotoProduct fotoProduct : fList) {
            FPTranformer ft = new FPTranformer();
            ft.setTitleT(fotoProduct.getTitle());
            ft.setPriceT(fotoProduct.getPrice());
            ft.setMegapxT(fotoProduct.getMegapx());
            ft.setDigitalT(fotoProduct.isDigital());
            list.add(ft);
        }
        return list;
    }

    private List<BPTransformer> transformBP() {
        List<BPTransformer> list = new ArrayList<>();

        for (BotinkProduct botinkProduct : bList) {
            BPTransformer bt = new BPTransformer();
            bt.setTitleT(botinkProduct.getTitle());
            bt.setPriceT(botinkProduct.getPrice());
            bt.setSizeT((botinkProduct.getSize()));
            bt.setColourT(botinkProduct.getColor());
            list.add(bt);
        }
        return list;
    }
}

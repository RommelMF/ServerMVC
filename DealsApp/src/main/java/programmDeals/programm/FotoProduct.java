package programmDeals.programm;

/**
 * Class photo devices
 */
public class FotoProduct extends Product {

    private double megapx;
    private boolean digital;

    @Override
    protected int calcDiscount(int quantity) {
        int def = super.calcDiscount(quantity);
        if (!digital) {
            def += 20;
        }
        return def;
    }

    public double getMegapx() {
        return megapx;
    }

    public void setMegapx(double megapx) {
        this.megapx = megapx;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }
}

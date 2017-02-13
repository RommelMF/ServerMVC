package programmDeals.programm;

/**
 * Class product of the deals
 */
public abstract class Product {

    private static final int DISCOUNT = 10;
    private String title;
    private double price;

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        return title.equals(p.getTitle());
    }

    public double getCost(int quantity) {
        double realCost = quantity * price;
        return realCost - (realCost * calcDiscount(quantity) / 100);
    }

    protected int calcDiscount(int quantity) {
        if (quantity > 10) {
            return DISCOUNT;
        } else {
            return 0;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}



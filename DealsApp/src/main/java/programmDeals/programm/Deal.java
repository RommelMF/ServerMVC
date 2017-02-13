package programmDeals.programm;

import java.util.Date;
import java.util.Map;

/**
 * Class Deal
 */
public class Deal {

    private Date date;
    private Party buyer;
    private Party seller;
    private Map<Product, Integer> products;

    public Deal(Party buyer, Party seller, Map<Product, Integer> products) {
        this.date = new Date();
        this.buyer = buyer;
        this.seller = seller;
        this.products = products;
    }

    public double getSum() {
        double res = 0;
        int quantity = 0;
        for (Map.Entry<Product, Integer> productIntegerEntry : products.entrySet()) {
            quantity = productIntegerEntry.getValue();
            res += productIntegerEntry.getKey().getCost(quantity);
        }
        return res;
    }

    public Date getDate() {
        return date;
    }

    public Party getBuyer() {
        return buyer;
    }

    public Party getSeller() {
        return seller;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
}

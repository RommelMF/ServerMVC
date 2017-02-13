package avito.repositories;

import avito.models.Product;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Home on 13.01.2017.
 */
public class ProductsRepository implements StorageProducts {

    private static int ids = 0;

    private static final ProductsRepository INSTANSE = new ProductsRepository();

    private List<Product> products = new CopyOnWriteArrayList<Product>();

    public static ProductsRepository getINSTANSE() {
        return INSTANSE;
    }

    public List<Product> getAll() {
        return this.products;
    }

    public void addProduct(String title, int quantity, double price, String specification) {
        Product product = new Product();
        product.setTitle(title);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setSpecification(specification);
        product.setId(++ids);
        products.add(product);
    }

    public boolean removeProduct(int id) {
        for (Product product : products) {
            if(product.getId() == id) {
                products.remove(product);

            }
        }
        return true;
    }

    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public boolean editProduct(int id, String title, int quantity, double price, String specification) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setTitle(title);
                product.setQuantity(quantity);
                product.setPrice(price);
                product.setSpecification(specification);
            }
        }
        return true;
    }

    public void close() {

    }
}

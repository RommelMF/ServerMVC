package avito.repositories;

import avito.models.Product;

import java.util.List;

/**
 * Created by Home on 18.01.2017.
 */
public class StorageProductImpl implements StorageProducts{
    private static final StorageProductImpl INSTANCE = new StorageProductImpl();
//    Можно менять реалицации репозиториев
//    public static final StorageProducts StorageProducts = new ProductsRepository();

    public static final StorageProducts storageProducts = new JdbcProductsStorage();

    public static StorageProductImpl getINSTANCE() {
        return INSTANCE;
    }

    public List<Product> getAll() {
        return this.storageProducts.getAll();
    }

    public void addProduct(String title, int quantity, double price, String specification) {
        this.storageProducts.addProduct(title, quantity, price, specification);

    }

    public boolean removeProduct(int id) {
        return this.storageProducts.removeProduct(id);
    }

    public Product getById(int id) {
        return this.storageProducts.getById(id);
    }

    public boolean editProduct(int id, String title, int quantity, double price, String specification) {
        return this.storageProducts.editProduct(id, title, quantity, price, specification);
    }

    public void close() {
        this.storageProducts.close();
    }
}

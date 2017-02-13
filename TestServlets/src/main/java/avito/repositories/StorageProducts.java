package avito.repositories;

import avito.models.Product;

import java.util.List;

/**
 * Created by Home on 14.01.2017.
 */
public interface StorageProducts {

   public List<Product> getAll();

   public void addProduct(String title, int quantity, double price, String specification);

   public boolean removeProduct(int id);

   public Product getById(int id);

   public boolean editProduct(int id, String title, int quantity, double price, String specification);

   public void close();
}

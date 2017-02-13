package avito.models;

/**
 *  модель объекта Product(товары пользователя) с параметрами :
 *  @param 'id'- идентификатор
 *  @param 'title'- название
 *  @param 'quantity'- количество
 *  @param 'price'- стоимость
 *  @param 'specification'- описание
 */
public class Product {

    private int id;
    private String title;
    private int quantity;
    private double price;
    private String specification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}

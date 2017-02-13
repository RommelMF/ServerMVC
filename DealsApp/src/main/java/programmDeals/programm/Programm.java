package programmDeals.programm;


import programmDeals.serialization.TransformerFactory;

import java.util.*;

/**
 * Class Programm
 */
public class Programm {

    private List<Deal> deals;
    private List<Product> prStorage;
    private List<FotoProduct> fList;
    private List<BotinkProduct> bList;
    private Map<Product, Integer> products;
    private Console console;
    private TransformerFactory tFactory;
    private Map<String, String> fieldsParty;
    private int quantityFields;

    public Programm() {
        console = new Console();
        deals = new ArrayList<>();
        fList = new ArrayList<>();
        bList = new ArrayList<>();
        products = new HashMap<>();
        prStorage = new ArrayList<>();
        fieldsParty = new HashMap<>();
        tFactory = new TransformerFactory(fList, bList);
    }

    public void startProgramm() {
        controllerProgramm();
    }

    public void controllerProgramm() {
        unTransform();
        while (true) {
            System.out.println("");
            System.out.println("Select actions: ");
            System.out.println("0 - Creation of the deal");
            System.out.println("1 - Input the product");
            System.out.println("2 - Output the information of the deals");
            System.out.println("3 - Out of a programm");
            int command = Integer.parseInt(console.keyboard(""));
            if (command == 0) {
                Deal deal = input();
                deals.add(deal);
            } else if (command == 1) {
                Product product = inputProduct("Input the product");
                prStorage.add(product);
            } else if (command == 2) {
                output();
            } else if (command == 3) {
                transform();
                break;
            }
        }
    }

    public void output() {
        System.out.println("Information about deals: ");
        for (Deal dl : deals) {
            if (dl != null) {
                System.out.println("Date: " + dl.getDate());
                System.out.println("Name buyer: " + dl.getBuyer().getName());
                System.out.println("Address: " + dl.getBuyer().getAddress());
                System.out.println("Name seller: " + dl.getSeller().getName());
                System.out.println("Address: " + dl.getSeller().getAddress());

                if (!fieldsParty.isEmpty()) {
                    System.out.println("Additional information: ");
                    for (Map.Entry<String, String> entry : fieldsParty.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + "; ");
                    }
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
                }
                System.out.println("Products: ");
                double cost = 0;
                double sumCosts = 0;
                for (Map.Entry<Product, Integer> entry : products.entrySet()) {
                    int quantity = entry.getValue();
                    cost = entry.getKey().getCost(quantity);
                    sumCosts += cost;
                    System.out.println("Title: " + entry.getKey().getTitle() + "; " + "quantity: " + quantity + "; " + "cost: " + cost + " $");
                }                System.out.println("The total amount of deal: " + sumCosts);
            } else {
                System.out.println("No more deals!");
            }
        }
    }

    public Deal input() {
        Party buyer = inputParty("Input name buyer");
        Party seller = inputParty("Input name seller");
        int quantityPr = Integer.parseInt(console.keyboard("Input the quantity of kinds products: "));
        for (int i = 0; i < quantityPr; i++) {
            System.out.println("Select action: ");
            System.out.println("0 -  create a new product");
            System.out.println("1 -  use from the store");
            int action = Integer.parseInt(console.keyboard(""));
            int quantity = 0;
            Product product = null;
            if (action == 0) {
                while (product == null) {
                    product = inputProduct("Input Product: ");
                    quantity = Integer.parseInt(console.keyboard("Input the quantity of the product: "));
                    products.put(product, quantity);
                    prStorage.add(product);
                }
            } else if (action == 1) {
                if (!prStorage.isEmpty()) {
                    System.out.println("List of the products");
                    int count = 0;
                    for (Product product1 : prStorage) {
                        System.out.println(count++ + " - " + product1.getTitle());
                    }
                    while (product == null) {
                        int numberPr = Integer.parseInt(console.keyboard("Input number of the product: "));
                        product = prStorage.get(numberPr);
                        quantity = Integer.parseInt(console.keyboard("Input the quantity of the product: "));
                        products.put(product, quantity);
                    }
                } else {
                    System.out.println("No products!");
                }
            }
        }
        Deal deal = new Deal(buyer, seller, products);
        return deal;
    }

    public Party inputParty(String role) {
        String roleName = console.keyboard(role);
        String address = console.keyboard("Input address: ");
        quantityFields = Integer.parseInt(console.keyboard("Input quantity additional fields: "));

        if (quantityFields > 0) {
            for (int i = 0; i < quantityFields; i++) {
                String key = console.keyboard("Input title field: ");
                String value = console.keyboard("Input value field: ");
                fieldsParty.put(key, value);
            }
        }
        Party party = new Party(quantityFields);
        party.setName(roleName);
        party.setAddress(address);
        party.setFields(fieldsParty);
        return party;
    }

    public Product inputProduct(String message) {
        String type = console.keyboard("Input type product(photo/shoes): ");
        String title = console.keyboard("Input title: ");
        double price = Double.parseDouble(console.keyboard("Input price: "));
        if (type.equals("photo")) {
            double megapx = Double.parseDouble(console.keyboard("Input the number megapixels: "));
            boolean digital = Boolean.parseBoolean(console.keyboard("Digital or not(true/false): "));
            FotoProduct product = new FotoProduct();
            product.setTitle(title);
            product.setPrice(price);
            product.setMegapx(megapx);
            product.setDigital(digital);
            fList.add(product);
            return product;
        } else if (type.equals("shoes")) {
            int size = Integer.parseInt(console.keyboard("Input size: "));
            String colour = console.keyboard("Input colour: ");
            BotinkProduct product = new BotinkProduct();
            product.setTitle(title);
            product.setPrice(price);
            product.setSize(size);
            product.setColor(colour);
            bList.add(product);
            return product;
        } else {
            System.out.println("There is no such type product!");
        }
        return null;
    }

    public void transform() {
        if (!fList.isEmpty() | !bList.isEmpty()) {
            tFactory.transformToXML();
        }
    }

    public void unTransform() {
        tFactory.transformToObjects();
        prStorage.addAll(fList);
        prStorage.addAll(bList);
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public List<FotoProduct> getfList() {
        return fList;
    }

    public void setfList(List<FotoProduct> fList) {
        this.fList = fList;
    }

    public List<BotinkProduct> getbList() {
        return bList;
    }

    public void setbList(List<BotinkProduct> bList) {
        this.bList = bList;
    }
}

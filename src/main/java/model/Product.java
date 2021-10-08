package model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int quantity;
    private String color;
    private String description;
    private int id_Category;

    public Product() {
    }

    public Product(String name, float price, int quantity, String color, String description, int id_Category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_Category = id_Category;
    }

    public Product(int id, String name, float price, int quantity, String color, String description, int id_Category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.id_Category = id_Category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_Category() {
        return id_Category;
    }

    public void setId_Category(int id_Category) {
        this.id_Category = id_Category;
    }
}

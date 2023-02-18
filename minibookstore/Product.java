package mini_projects.minibookstore;

public class Product {
    //tüm ürünlerin ortak özellikleri ve methodları

    private String name;
    private String price;
    private int stock;
    private static  int count=0;
    private int id;
    public Product( String name, String price, int stock) {
        count++;
        this.id = count;
        this.name = name;
        this.price = price;
        this.stock = stock;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



}

package mini_projects.minibookstore;

public class Notebook extends Product {
    private String brand;
    private int sheet;
    private int code;

    public Notebook( String name, String price, int stock, String brand, int sheet, int code) {
        super( name, price, stock);
        this.brand = brand;
        this.sheet = sheet;
        this.code = code;
    }
}

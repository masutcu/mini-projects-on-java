package mini_projects.retaurantBillGenerator;

public class Dish {
    //yiyeceklerin field leri  (özellikleri) okunsun değiştirilmesin
    private int code;
    private String name;
    private double price;

    //yiyecekler oluşturulurken özellikleride set edilsin

    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

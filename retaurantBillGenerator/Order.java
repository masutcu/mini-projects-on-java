package mini_projects.retaurantBillGenerator;

public class Order {
    public  static int count=999;
    public int orderCode;
    public int numOfDish;
    public double orderPrice;
    public Dish dish;
    //yemek ve adet parametreleri ile obje cons oluşturalım
    public Order(Dish dish, int numOfDish){
        count++;
        this.orderCode=count;
        this.dish=dish;
        this.numOfDish=numOfDish;
    }
   // siparişin fiyatını hesaplamak için
    public void setPrice(){
        this.orderPrice=this.dish.getPrice()*this.numOfDish;
    }
}

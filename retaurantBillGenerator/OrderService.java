package mini_projects.retaurantBillGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {
    Scanner inp=new Scanner(System.in);
    List<Order> orderList=new ArrayList<>();//1000,Adana*2

    //11:sipariş oluşturma
    public void createOrder(DishService dishService){
        int dishCode;
        do {
            System.out.println("Lütfen ürün kodu giriniz:(ÇIKIŞ için 0 giriniz.) ");
            dishCode=inp.nextInt();//code ile ürünü bulmamız gerekiyor--->12
            if(dishService.findByDishCode(dishCode)!=null){
                Dish dish=dishService.findByDishCode(dishCode);
                System.out.println("Adet giriniz:");
                int number=inp.nextInt();
                //bu yemek daha önce sipariş edilmiş mi--->13
                Order order;
                if(findByOrderByDish(dish)!=null){
                    order=findByOrderByDish(dish);
                    order.numOfDish+=number;
                    order.setPrice();
                }else{
                    order=new Order(dish,number);//orderCode:otomatik:1000 Adana
                    order.setPrice();
                    this.orderList.add(order);
                }
            }//sipariş oluşunca altta sipariş listesini görüntüle--->14
            listOrders();

        }while(dishCode!=0);

    }
    //14:siparişleri listele
    private void listOrders() {
        this.orderList.
                forEach(order-> System.out.printf("Sipariş kodu:%-5s  Lezzet kodu:%-4s Lezzet adı:%-15s Adet:%-2s\n",
                        order.orderCode,order.dish.getCode(),order.dish.getName(),order.numOfDish));
    }

    //13:dish bilgisi ile sipariş bulma
    private Order findByOrderByDish(Dish dish){
        for (Order order:this.orderList){
            if(order.dish.equals(dish)){
                return order;
            }
        }
        return null;
    }

    //15:sipariş iptali
    public void deleteOrder(){

        System.out.println("İptal etmek istediğiniz siparişin kodunu giriniz:");
        int code= inp.nextInt();
        boolean isValid=true;
        for (Order order:this.orderList){
            if(order.orderCode==code){
                System.out.println("İptal etmek istediğiniz miktarı giriniz:");//3 Urfa:600
                int num= inp.nextInt();//2
                if(order.numOfDish>num){
                    order.numOfDish-=num;
                    order.setPrice();
                    System.out.println("Sipariş iptal edildi: "+order.dish.getName());
                }else if(order.numOfDish==num){
                    this.orderList.remove(order);
                    System.out.println("Sipariş iptal edildi:"+order.dish.getName());
                }else {
                    System.out.println("Hatalı giriş!");
                }
                isValid=true;
                break;
            }else {
                isValid=false;
            }
        }
        if (!isValid){
            System.out.println("Sipariş kodu geçersiz!!!");
        }
        System.out.println("               Mevcut Siparişler            ");
        listOrders();
    }

    //16:hesabı oluşturma
    public void printBill(){
        double total=0;
        System.out.println("                        Lezzet Fişiniz            ");
        for (Order order:this.orderList){
            System.out.printf("Sipariş Kodu:%-6s Lezzet Kodu:%-4s Lezzet adı:%-15s Adet:%-2s Tutar:%-6s Lira\n",
                    order.orderCode,order.dish.getCode(),order.dish.getName(),order.numOfDish,order.orderPrice);
            total+=order.orderPrice;
        }
        System.out.println("Toplam Tutar:"+total);
        System.out.println("Afiyet olsun...");
        this.orderList.clear();
    }

}
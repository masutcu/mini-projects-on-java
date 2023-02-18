package mini_projects.retaurantBillGenerator;

import java.util.Scanner;

public class RestaurantBillGenarator {
    /*
Proje: Restaurant Fiş Üretme Uygulaması(BillGenerator)
       1-Bir restaurantın online sipariş sisteminde hesabı
       yazdıran uygulama tasarlayınız.

       2-Restauranttaki yiyecekler bir listte tutulsun.
         Yiyeceklerin kodu, ismi ve ücreti olsun.

       3-Yiyecek menüsü, sipariş oluşturma/iptal ve hesap
         oluşturma için seçim menüsü gösterilsin.

       4-Yiyecek menü:Listedeki yiyecekler menü şeklinde listelensin
         Sipariş girme:Yiyeceğin kodu ve istenilen adet girilerek sipariş oluşturulsun
                       Her sipariş için kod üretilsin(başlangıç 1000 artarak devam eder)
                       Her bir yiyecek siparişi için tutar hesaplansın

         Sipariş iptal:Sipariş kodu girilerek sipariş silinsin
         Hesap oluşturma: Tutarları ile birlikte tüm siparişleri ve
                          toplam tutarı gösteren bir hesap fişi yazdırılsın.
*/
    public static void main(String[] args) {
        getSelectionMenu();
    }
    //1-işlem seçimi için menü gösterelim
    public static void getSelectionMenu(){
        Scanner inp=new Scanner(System.in);
        DishService dishService=new DishService();//listede 10 tane dish var.
        OrderService orderService=new OrderService();

        //2-menü tekrar tekrar gösterilsin
        //3-yiyecekler için class oluştur
        //7-sipariş için class oluştur
        int select=1;
        while(select!=0){
            System.out.println("-----------------------------------------------");
            System.out.println(" *** Lezzet Restaurant Sipariş Uygulaması ***");
            System.out.println("1-Menü");
            System.out.println("2-Sipariş gir");
            System.out.println("3-Siparişi iptal et");
            System.out.println("4-Hesap oluştur");
            System.out.println("0-ÇIKIŞ");
            System.out.println("Seçiminiz: ");
            select=inp.nextInt();
            System.out.println("-----------------------------------------------");
            switch (select){
                case 1:
                    //menü göster
                    dishService.showMenu();
                    break;
                case 2:
                    //sipariş oluştur
                    orderService.createOrder(dishService);
                    break;
                case 3:
                    //sipariş iptal
                    orderService.deleteOrder();
                    break;
                case 4:
                    //hesap
                    orderService.printBill();
                    break;
                case 0:
                    System.out.println("İyi günler...");
                    break;
                default:
                    System.out.println("Hatalı giriş!");
                    break;
            }
        }

    }
}
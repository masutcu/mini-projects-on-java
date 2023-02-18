package mini_projects.biletrezervasyon;

import java.util.Scanner;

public class BiletRezervasyon {
    /*
Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
         Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         koltuk no  bilgilerini alın.
         Mesafe başına ücret 1 Lira / km olarak alın.(Gidiş-Dönüş için *2)
         Tekli Koltuk ücreti:Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 daha fazladır(1.2 Lira).
         32 koltuk adedi
         İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;

         Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
         Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

         1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
         2-Yaş indirimi:
         Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
         Kişi 12-24 yaşları arasında ise son bilet fiyatı üzerinden %10 indirim uygulanır.
         Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */
    public static void main(String[] args) {
        //bilet rezervasyonuiçin otobüs objesine ihtiyaç var
        Bus bus=new Bus("34 ASD 78");
        //bilet objesi oluşturalım
        Bilet bilet =new Bilet();

        start(bus,bilet);

    }
    public static void start(Bus bus, Bilet bilet){
        Scanner scan=new Scanner(System.in);
        int select;
        do{

            System.out.println("Bilet rezervasyon uygulamasına hoşgeldiniz");
            System.out.println("Lütfen gideceğiniz mesafe bilgisini km olarak giriniz");
            double distance=scan.nextDouble();
            System.out.println("Lütfen yolculuk tipini seçiniz");
            System.out.println("Tek yön için -1-\n gidiş-dönüş için -2-");
            int type=scan.nextInt();
            System.out.println("lütfen yaşınızı giriniz");
            int age=scan.nextInt();
            System.out.println("koltuk no seçiniz : ");
            System.out.println("Tekli koltuk ücreti %20 daha fazladır ");
            System.out.println(bus.seats);
            int seat=scan.nextInt();
            //seçilen koltuk listeden kaldırılmalı
            bus.seats.remove(String.valueOf(seat));//int olarak alsak index kullanmalıydık.
            //kullanıcıdan alınan değerler geçerlimi
            boolean check= type==1 || type==2;
            if(distance>0 && age>0 && check){
                //bilet fiyatı hesapla
                bilet.distance=distance;
                bilet.typeNo=type;
                bilet.seatNo=seat;
                bilet.price=getTotal(bilet,age);
                bilet.printBilet(bus);
            }else{
                System.out.println("Hatalı giriş yaptınız!");

            }
            System.out.println("yeni işlem için 1, çıkış için 0 giriniz");
             select=scan.nextInt();


        }while (select!=0);

    }
    private static double getTotal(Bilet bilet, int age){
        double dist= bilet.distance;
        int type= bilet.typeNo;
        int seat= bilet.seatNo;
        double total=0;
        switch (type){
            case 1:
                if(seat%3==0){
                    total=dist*1.2;

                }break;
            case 2:
                if(seat%3==0){
                    total=dist*2.4;

                }else {
                    total=dist*2;
                }
                total=total*0.8;
                System.out.println("çift yön indirimli tutar : "+total);
                break;
        }
        if(age<12){
            total=total*0.5;
            System.out.println("yas indirimli tutar : "+ total);
        } else if (age>12 && age<24) {
            total=total*0.9;
            System.out.println("yaş indirimli tıtar :"+total);
        } else if (age>65) {
            total=total*0.7;
            System.out.println("yaşlı indirimli tutar :" + total);
        }return total;
    }
}

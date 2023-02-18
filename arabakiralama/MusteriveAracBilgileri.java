package mini_projects.arabakiralama;

import java.util.*;

public class MusteriveAracBilgileri {
    /*
    Araba Kiralama Projesi TASK   ***********
            Bir araç kiralama projesi hazırlayınız.        Arac Talebi adında bir POJO class oluşturunuz.
             -  alınacaksehir, alınacakgun, alıssaati, teslimGunu, teslimSaati (kiralama ile ilgili bilgiler)
             -  marka, model, yakitTipi, vites ve gunlukUcret (araç ile ilgili bilgiler).
            -   Kiralama ile ilgili variable'ları içeren parametreli bir constructor oluşturun.
            -   Araç ile ilgili variable'ları içeren parametreli bir constructor oluşturun.,
            -   Tum variable'lar için Getter ve Setter method'ları oluşturun (Encapsulation).
            MusteriveAracBilgileri adında method'ları içeren bir class oluşturunuz.
            -   aracTalep() adında bir method oluşturunuz.        Bu method'da alinacak sehir, teslim edilecek sehir,
    alinacak gun ve teslim edilecek gun ve teslim saati bilgilerini aliniz.        Odenecek toplam gun sayisini yazdırın.
            o   Dikkat: Teslim gunu, alis gününden daha once olamaz.
            -   arabalar() create ederek, tüm araç modellerini bir list'e atınız.
     (parametre olarak araç ile bilgileri alan <marka, model, yakıt tipi, vites, gunlukUcret> objeleri list'e atınız.)
    Bu list'i göstererek bir aracı kiralamasını sağlayın.
            -   getAraba() metodu ile seçmiş olduğu aracı gösterin. Odeyeceği toplam miktari yazdirin. Onaylar ise, müşteri bilgilerini almak için devam edin.
            -   musteriBilgileri() metodu ile müşteri ile ilgili bilgileri aliniz. AdSoyad, ID, yaş ve telefon.
            -   OdemeBilgieri() metodu ile odeme bilgilerini alacaginiz bir method create ediniz. Kart numarası uzunluğu 12 olmalıdır, kontrol ediniz.
    */
    Scanner scan = new Scanner(System.in);
    int toplamGun;
    Araba secilenAraba;
    int aracUcret;


    public void aracBilgisi() {

        List<Araba> arabaList = new ArrayList<>();
        List<Araba> rezerveList = new ArrayList<>();
        int aracSecim;
        Araba araba1 = new Araba("Toyota", "Corolla", "Benzin", "Duzvites", 500);
        Araba araba2 = new Araba("Honda", "Civic", "Dizel", "Otomatik", 700);
        Araba araba3 = new Araba("Mitsubishi", "Colt", "LPG", "Duzvites", 400);
        Araba araba4 = new Araba("Fiat", "Albea", "Dizel", "Otomatik", 750);
        Araba araba5 = new Araba("Toyota", "Corona", "Hybrid", "Otomatik", 750);
        arabaList.add(araba1);
        arabaList.add(araba2);
        arabaList.add(araba3);
        arabaList.add(araba4);
        arabaList.add(araba5);

        do {scan.nextLine();
            System.out.println(arabaList);
            System.out.println("Lutfen yukaridaki araclardan birisini seciniz\n" +
                    "Toyota Corolla icin 1\n" +
                    "Honda icin 2\n" +
                    "Mitsubishi icin 3\n" +
                    "Fiat icin 4\n" +
                    "Toyata Corona icin 5\n" +
                    "i tuslayiniz");
            aracSecim = scan.nextInt();

            if (aracSecim < 1 || aracSecim > 4) {
                System.out.println("Yanlis rakam girdiniz. Lutfen listedeki araclardan birisinin numarasini giriniz");
            }
        }while (aracSecim<1||aracSecim>4);

        secilenAraba=arabaList.get(aracSecim - 1);

        System.out.println("Sectiginiz arac : " + arabaList.get(aracSecim - 1));
        rezerveList.add(arabaList.get(aracSecim - 1));
        arabaList.remove(aracSecim - 1);
        aracUcret = secilenAraba.getGunlukUcret();


    }

    public void musteriBilgileri() {
        String adSoyad;
        String tcNo;
        String telefon;
        int yas;
        Scanner inp = new Scanner(System.in);

        do {
            System.out.println("Lutfen ad ve soyadinizi arada bir bosluk olacak sekilde giriniz:");

            adSoyad = inp.nextLine().trim();
            if (!adSoyad.contains(" ")){

            }
        }while (!adSoyad.contains(" "));

        do {
            System.out.println("Lutfen 11 haneli TC kimlik numaranizi bosluk birakmadan giriniz:");
            tcNo = inp.nextLine().replaceAll(" ", "").trim();
            if (tcNo.length() != 11) {
                System.out.println("Yanlis giris yaptini. Lutfen tekrar giris yapiniz");
            }
        } while (tcNo.length() != 11);

        do {
            System.out.println("Lutfen yasinizi giriniz:");

            yas = inp.nextInt();
            if (yas < 18 || yas > 80) {
                System.out.println("Yanlis yas girdiniz. Yeniden giriniz.");
            }
        } while (yas < 18 || yas > 80);

        do {inp.nextLine();
            System.out.println("Lutfen telefon numaranizi basinda sifir olmadan giriniz:");
            telefon = inp.nextLine().replaceAll(" ", "").trim();
            if (telefon.length() != 10) {
                System.out.println("Yanlis sekilde giris yaptiniz. Lutfen yeniden giriniz.");
            }
        } while (telefon.length() != 10);

        System.out.println("Ad-Soyad: " + adSoyad + "\nTC no: " + tcNo + "\nYas: " + yas + "\nTelefon: " + telefon);
    }

    public int ucret() {
        Tarih obj = new Tarih();
        int toplamGun1 = obj.toplamGun;
        int ucret = toplamGun1 * aracUcret;
        System.out.println(toplamGun1 + " gunluk arac kiralama bedeli " + ucret + " liradir");
        return ucret;
    }

}
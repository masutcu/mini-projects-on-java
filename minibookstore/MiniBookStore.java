package mini_projects.minibookstore;

import java.util.Scanner;

/*
    Proje: Mini Book Store
    Online bir kitap market için ürün yönetim uygulaması yapınız.
    Kitap markette kitap ve defter satışı olacak, ancak ileride yeni ürün çeşidi eklenebilir olmalı.

    Kitap özellikleri: id, isim, birim fiyat, stok, yazar adı, yayınevi,isbn no
    Defter özellikleri: id, isim, birim fiyat, stok, marka, yaprak sayısı,ürün kodu

    Kullanıcı ilgili kategorideki ürünleri listeleyebilmeli
    Kullanıcı kategoriye göre ürün ekleyebilmeli,ürün mevcutsa uyarı verilmeli
    Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli.
    Kullanıcı ürünleri marka(defter) veya yayınevi(kitap) yayınevine göre filtreleyip listeleyebilmeli.
            */
public class MiniBookStore {
    public static void main(String[] args) {
        enter();
    }
   //product class ı olsun book ve notebook ortak özellikleri burada olsun.
    public static void enter(){
        Scanner inp=new Scanner(System.in);
        int select;
        System.out.println("========= mini book store ========");
        do{
            System.out.println("ürün yönetim paneli");
            System.out.println("1-Kitaplar\n2-Defterler \n0-Çıkış \nSeçiminiz :  \n");
            select=inp.nextInt();
            inp.nextLine();
            ProductService service;//interface class


            switch (select){
                case 1:
                    service=new BookService();
                    service.processMenu();
                    break;
                case 2:
                    service=new NotebookService();
                    service.processMenu();
                    break;
                case 0:
                    System.out.println("iyi günler");
                    break;
                default:
                    System.out.println("hatalı giriş");
                    break;
            }


        }while (select!=0);

    }


}

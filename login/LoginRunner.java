package mini_projects.login;

import java.util.Scanner;

public class LoginRunner {
    public static void main(String[] args) {
        /*
        Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.
                menü: kullanıcıya işlem seçimi için menü gösterilir.
        üye olma(register): kullanıcıdan ad-soyad, kullanıcı adı, email ve şifre bilgileri alınız.
        kullanıcı adı, email ve şifre birer listede tutulur.
                aynı kullanıcı adı veya email kabul edilmez.
        giriş(login): kullanıcı adı/email ve şifre girilir.
        kullanıcı adı veya email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
                kullanıcı adı/email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.
                email validation: boşluk içermemeli
                            : @ içermeli
                            : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                            : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.
                            password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli   */

        start();


    }
    public static void start(){
        UserService userService=new UserService();
        Scanner scanner=new Scanner(System.in);
        int select;
        do{
            userService.showmenu();
            select=scanner.nextInt();
            switch (select){
                case 1:
                   userService.register();
                    break;
                case 2:
                  userService.login();
                    break;
                case 3:
                    System.out.println("Güle güle");
                    break;
                default:
                    System.out.println("hatalı giriş yaptınız. Yeniden deneyiniz");
            }



        }while (select!=3);
    }
}

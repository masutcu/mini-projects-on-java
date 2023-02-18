package mini_projects.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> usernameList=new ArrayList<>();//set yapılabilir di
    List<String> emailList=new ArrayList<>(); //set yapılabilir di
    List<String> passwordList=new ArrayList<>();

   public void showmenu(){
       System.out.println("Tech pro education");
       System.out.println("1-üye ol");
       System.out.println("2-giriş yap");
       System.out.println("3-cıkıs");
       System.out.println("Seçiminizi Giriniz");


   }  public void register(){
       Scanner scanner=new Scanner(System.in);
        System.out.println("Ad soyad giriniz");
        String name =scanner.nextLine();


        String username;
        boolean existUsername;

        do{
            System.out.println("Kullanıcı adını giriniz");
            username= scanner.nextLine();
            existUsername=usernameList.contains(username);
            if(existUsername){
                System.out.println("bu username daha önce kullanılmıştır.Başka bir username deneyin");
            }
        }while(existUsername);

        String email;
        boolean existEmail;
        boolean isValid;

        do{
            System.out.println("e mail giriniz");
            email =scanner.nextLine();
            isValid=validateEmail(email);
            existEmail=emailList.contains(email);
            if(existEmail){
                System.out.println("bu e mail daha önce kullanılmıştır");
                isValid=false;
            }


        }while (!isValid);//valid olmadığı sürece çalışacak

        String password;
        boolean isValidPsw;

        do{
            System.out.println("şifre giriniz");
            password= scanner.nextLine();
            isValidPsw=validatePassword(password);

        }while (!isValidPsw);


        User user = new User(name, username, email, password);
        System.out.println(user);
        usernameList.add(username);
        emailList.add(email);
        passwordList.add(password);
        System.out.println("tebrikler kayıt işleminiz gerçekleşti");
        System.out.println("kullanıcı adı veya şifre ile giriş yapabilirsiniz");

    }

    public void login(){
       Scanner scanner=new Scanner(System.in);
        System.out.println("e mail  yada kullanıcı adı giriniz");

        String usernameOrEmail=scanner.nextLine();
        boolean isEmail=emailList.contains(usernameOrEmail);
        boolean isUsername=usernameList.contains(usernameOrEmail);

       if(isEmail||isUsername){

           while (true) {
               System.out.println("şifre giriniz");
               String password=scanner.nextLine();
               int idx;

               if (isUsername){
                   idx=usernameList.indexOf(usernameOrEmail);

               } else {
                   idx=emailList.indexOf(usernameOrEmail);
               }
               if(passwordList.get(idx).equals(password)){
                   System.out.println("sisteme giriş yaptınız");
                   break;
               }else System.out.println("şifre yanlış tekrar deneyiniz");

           }
       }else {
           System.out.println("sisteme kayıtlı kullanıcı bulunamadı");
           System.out.println("bilgilerinizi kontrol edin veya üye olun");
       }

    }
    public static boolean validateEmail(String email){
       boolean isValid;
       boolean space=email.contains(" ");
       boolean isContainAt=email.contains("@");

       if(space){
           System.out.println("e mail boşluk içermemelidir.");
           isValid=false;
       } else if (!isContainAt) {
           System.out.println("e mail @ içermelidir");
           isValid=false;

       }else {
           String firstPart=email.split("@")[0];
           String secondPart=email.split("@")[1];

           boolean checkFirst=firstPart.replaceAll("[A-Za-z0-9-._]","").length()==0;
           boolean checkSecond=secondPart.equals("gmail.com")||
           secondPart.equals("yahoo.com")||
           secondPart.equals("hotmail.com");

           if(!checkFirst){
               System.out.println("e mail büyük küçük harf  rakam yada sembol içermelidir ");
           } else if (!checkSecond) {
               System.out.println("e mail olarak bitmeli ");
           }

           isValid = checkFirst && checkSecond;


       }

        return isValid;
    }
    public static boolean validatePassword(String password){
       boolean isValid;

       boolean space=password.contains(" ");
       boolean lenghtGt6=password.length()>=6;
       boolean existUpper=password.replaceAll("[^A-Z]","").length()>0;
       boolean existLower=password.replaceAll("[^a-z]","").length()>0;
       boolean existDigit=password.replaceAll("[^0-9]","").length()>0;
       boolean existSymbol=password.replaceAll("[]\\P{Punct}]","").length()>0;

       if(space){
           System.out.println("şifre boşluk içermez");

       } else if (!lenghtGt6) {
           System.out.println("şifre en az altı karakter içermelidir.");

       } else if (!existUpper) {
           System.out.println("şifre en az bir büyük harf içermelidir");
       } else if (!existLower) {
           System.out.println("şifre en az bir büyük harf içermelidir");
       } else if (!existDigit) {
           System.out.println("şifre en az bir rakam içermelidir");
       } else if (!existSymbol) {
           System.out.println("şifre en az bir symbol içermelidir");
       }
       isValid=!space && lenghtGt6 && existUpper && existLower && existDigit && existSymbol;

        return isValid;
    }
}

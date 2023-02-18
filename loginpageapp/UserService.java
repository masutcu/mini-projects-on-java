package mini_projects.loginpageapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    //kullanıcıları saklamam lazım. list oluşturacağız.data tipi User
    List<User> userList = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    //username veya email ile giriş yapılacak.
    private User getUser(String usernameOrEmail) {
        for (User user : userList) {
            if (user.getUsername().equals(usernameOrEmail)) {
                return user;
            } else if (user.getEmail().equals(usernameOrEmail)) {
                return user;
            }
        }
        return null;
    }

    //email validation işlemi için method
    private static boolean validateEmail(String email) {
        boolean isValid;
        boolean isExistsSpace = email.contains(" ");
        boolean isContainAt = email.contains("@");
        if (isExistsSpace) {
            System.out.println("email boşluk içeremez");
            isValid = false;
        } else if (!isContainAt) {
            System.out.println("email @ senbolünü içermelidir");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            boolean valid = firstPart.replaceAll("[a-zA-Z0-9_.-]", "").isEmpty();
            boolean checkStart = valid && firstPart.length() > 0;

            boolean checkEnd = secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");

            if (!checkStart) {
                System.out.println("meilin kullanıcı adı bölümü en az bir karakter ve sadece büyük küçük harf  -_. içerebilir.");
            }
            if (!checkEnd) {
                System.out.println(" email belirli mail adresleri olabilir.");
            }
            isValid = checkStart && checkEnd;
        }
        if (!isValid) {
            System.out.println("tekrar deneyiniz");

        }

        return isValid;
    }

    private static boolean validatePassword(String password) {//ASdf12*-
        boolean isValid;
        boolean isExistsSpace = password.contains(" ");
        boolean isLengthGtSix = password.length() >= 6;
        boolean isExistUpperLetter = password.replaceAll("[^A-Z]", "").length() > 0;//AS
        boolean isExistLowerLetter = password.replaceAll("[^a-z]", "").length() > 0;//df
        boolean isExistsDigit = password.replaceAll("[\\D]", "").length() > 0;//12
        boolean isExistsSymbol = password.replaceAll("[\\P{Punct}]", "").length() > 0;
        if (isExistsSpace) {
            System.out.println("Şifre boşluk içeremez.");
        } else if (!isLengthGtSix) {
            System.out.println("Şifre en az 6 karakter içermelidir.");
        } else if (!isExistUpperLetter) {
            System.out.println("Şifre en az 1 tane büyük harf içermelidir.");
        } else if (!isExistLowerLetter) {
            System.out.println("Şifre en az 1 tane küçük harf içermelidir.");
        } else if (!isExistsDigit) {
            System.out.println("Şifre en az 1 tane rakam içermelidir.");
        } else if (!isExistsSymbol) {
            System.out.println("Şifre en az 1 tane sembol içermelidir.");
        }
        isValid = !isExistsSpace && isExistUpperLetter && isLengthGtSix && isExistLowerLetter && isExistsDigit && isExistsSymbol;
        if (!isValid) {
            System.out.println("Geçersiz şifre, tekrar deneyiniz.");
        }
        return isValid;
    }

    public void register() {
        System.out.println("ad - soyad : ");
        String name = input.nextLine();
        String username = getUserName();
        String email=getEmail();
        String password=getPassword();
        User user=new User(name,username,email,password);
        this.userList.add(user);
        System.out.println("tebrikler işleminiz başarıyla gerçekleştirildi");
        System.out.println("Kullanıcı adı (veya email) ve şifrenizle giriş yapabilirsiniz.");

    }

    private String getUserName() {
        String username;
        boolean existusername;
        do {
            System.out.println("kullanıcı adı giriniz");
            username = input.next();
            existusername = getUser(username) != null;
            if (existusername) {
                System.out.println("bu username kullanılmış, farklı bir username deneyiniz.");
            }
        } while (existusername);

        return username;
    }

    private String getEmail() {
        String email;
        boolean isValid;
        boolean existEmail;
        do {
            System.out.println("e mail giriniz");
            email=input.next();
            isValid=validateEmail(email);//geçerli ama unique mi?
            existEmail=getUser(email)!=null;
            if(existEmail){
                System.out.println("bu email zaten kayıtlı farklı bir email deneyiniz");
            }
        } while (!isValid);
        return email;

    }
    private String getPassword(){
        String passw;
        boolean isValidPass;
        do{
            System.out.println("şifrenizi giriniz");
            passw=input.next();
            isValidPass=validatePassword(passw);

        }while (!isValidPass);
        return passw;
    }

    public void login(){
        System.out.println("lütfen kullanıcı adı veya email giriniz: ");
        String userNameOrEmail=input.next();
        if(getUser(userNameOrEmail)!=null){
            User user=getUser(userNameOrEmail);
            boolean isWrong=true;
            while (isWrong){
                System.out.println("şifrenizi giriniz");
                String password=input.next();
                if(user.getPassword().equals(password)){
                    System.out.println("sisteme giriş yaptınız");
                    isWrong=false;
                }else{
                    System.out.println("şifre yanlış tekrar deneyiniz");
                }
            }

        }else {
            System.out.println("sistemde kayıtlı üye bulunamadı");
            System.out.println("Üyeyseniz bilgilerinizi kontrol ederek tekrar deneyiniz, üye değilseniz lütfen üye olunuz.");
        }

    }
}




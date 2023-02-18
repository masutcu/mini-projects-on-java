package mini_projects.aracsigorta;

import java.util.Scanner;

public class Arac {
    //tipi, primi lazım

    public  String type;   //field veya feature diyoruz
    public int prim;

    public void countPrim(int term){
        switch (this.type){
            case "otomobil":
                this.prim= term==1 ? 2000 : 2500 ; //ternary
                break;
            case "kamyon":
                this.prim= term==1 ? 3000 : 3500 ;
                break;
            case "motosiklet":
                this.prim= term==1 ? 1500 : 1750 ;
                break;
            case "otobüs":
                countPrimBus(term);
                break;
            default:
                System.out.println("Hatalı giriş!!");
                this.prim=0;
        }

    }

    private  void countPrimBus(int term){
        Scanner scan=new Scanner(System.in);
        System.out.println("otobüs tipini giriniz");
        System.out.println("1 için 18-30 koltuk arası");
        System.out.println("2 için 30 koltuk üstü");
        int busType=scan.nextInt();
        switch (busType){
            case 1:
                this.prim= term==1 ? 4000 : 4500;
                break;
            case 2:
                this.prim= term==1 ? 5000 : 5500;
                break;
            default:
                System.out.println("Hatalı giriş");
                this.prim=0;
                break;
        }
    }
}

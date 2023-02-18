package mini_projects.biletrezervasyon;

public class Bilet {
    //mesafe, yolculuk tipi, ücreti, koltuk ne
    public double distance;
    public int typeNo;
    public double price;
    public int seatNo;

    public void printBilet(Bus bus){
        System.out.println("Toplam tutar : "+this.price);
        System.out.println("Bilet detayı");
        System.out.println("otobüs plaka : "+bus.numberPlate);
        System.out.println("Mesafe : "+this.distance);
        System.out.println("Yolculuk tipi : " + (this.typeNo==1 ? "tek yön" : "Gidiş-dönüş"));
        System.out.println("Koltuk no     :"+this.seatNo);
        System.out.println("Keyifli yolculuklar dileriz...");
    }


}

package mini_projects.arabakiralama;

import java.util.Arrays;
import java.util.Scanner;

public class SehirSec {
    static boolean sehirKontrol;
    public static void aractalep() {
        Scanner scan = new Scanner(System.in);
        String[] sehirler = {"Ankara", "Istanbul", "Adana", "Izmir", "Ardahan"};
        System.out.println(Arrays.toString(sehirler));
        System.out.println("Araci almak istediginiz sehri seciniz: ");
        String teslimAlinacakSehir = scan.nextLine().trim().toLowerCase();
        sehirKontrol = Arrays.toString(sehirler).toLowerCase().contains(teslimAlinacakSehir);
        if (!sehirKontrol) {
            System.out.println("Lutfen listedeki sehirlerden birini seciniz!..");
            aractalep();
        }
        System.out.println(Arrays.toString(sehirler));
        System.out.println("Araci teslim etmek istediginiz sehri seciniz: ");
        String teslimEdilecekSehir = scan.nextLine().trim().toLowerCase();
        sehirKontrol = Arrays.toString(sehirler).toLowerCase().contains(teslimEdilecekSehir);
        if (!sehirKontrol) {
            System.out.println("Lutfen listedeki sehirlerden birini seciniz");
            aractalep();
        }
    }
}
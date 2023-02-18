package mini_projects.arabakiralama;

import java.text.ParseException;

public class Runner {
    public static void main(String[] args) throws ParseException {
        SehirSec obj=new SehirSec();
        obj.aractalep();
        MusteriveAracBilgileri user = new MusteriveAracBilgileri();


        user.aracBilgisi();
        user.musteriBilgileri();
        Tarih objtrh = new Tarih();
        objtrh.tarih();
        user.ucret();

    }

}
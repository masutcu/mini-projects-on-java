package mini_projects.biletrezervasyon;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    public String numberPlate;
    public List<String> seats=new ArrayList<>();
    public Bus(String numberPlate){
        this.numberPlate=numberPlate;
        for(int i=1; i<=32; i++){
            this.seats.add(i+"");//String.valueOf()
        }
    }
}

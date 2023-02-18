package mini_projects.arabakiralama;

public class Araba {
    private String marka = "";
    private String model = "";
    private String yakitTipi = "";
    private String vites="";
    private int gunlukUcret;

    public Araba(String marka, String model, String yakitTipi, String vites, int gunlukUcret) {
        this.marka = marka;
        this.model = model;
        this.yakitTipi = yakitTipi;
        this.vites = vites;
        this.gunlukUcret = gunlukUcret;
    }
    public String getMarka() {
        return marka;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getYakitTipi() {
        return yakitTipi;
    }
    public void setYakitTipi(String yakitTipi) {
        this.yakitTipi = yakitTipi;
    }
    public String getVites() {
        return vites;
    }
    public void setVites(String  vites) {
        this.vites = vites;
    }
    public int getGunlukUcret() {
        return gunlukUcret;
    }

    public void setGunlukUcret() {
        this.gunlukUcret=gunlukUcret;
    }
    @Override
    public String toString() {
        return "Araba{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", yakitTipi='" + yakitTipi + '\'' +
                ", vites='" + vites + '\'' +
                ", gunlukUcret=" + gunlukUcret +
                '}'+'\n';
    }
}
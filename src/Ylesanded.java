public class Ylesanded {
    private String nimi;
    private String aine;
    private String kuupäev;
    private boolean üksi;

    public Ylesanded(String nimi, String aine, String date, boolean üksi) {
        this.nimi = nimi;
        this.aine = aine;
        this.kuupäev = date;
        this.üksi = üksi;
    }

    public String getKuupäev() {
        return kuupäev;
    }

    public void setKuupäev(String kuupäev) {
        this.kuupäev = kuupäev;
    }

    public String getAine() {
        return aine;
    }

    public String getNimi() {
        return nimi;
    }

    @Override
    public String toString() {
        if (üksi == true) {
            return  aine + ". " + nimi +  " tähtaeg: " + kuupäev + ", iseseisev töö";
        }
        else return aine + ". " + nimi + " tähtaeg: " + kuupäev + " rühmatöö";
    }
}

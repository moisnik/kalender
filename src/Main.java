/**************************************************
 * Objektorienteeritud programmeerimine LTAT.03.003
 * Rühmatöö.
 * Teema: kalender
 *
 * Koostajad:
 * Mia Mõisnik
 * Emma Lauren Laikmaa
 ***************************************************/

import java.time.LocalDate;
import java.util.*;


public class Main {
    /**
     * Väljastab kõik ülesanded, mis on etteantud kuupäeva tähtajaga
     * @param kalender - ülesannete list
     * @param kuupäev - kuupäev mille ülesandeid otsime ja väljastame
     */
    public static void kuupäevajärgi(List<Ylesanded> kalender,  String kuupäev) {
        boolean prinditi = false;
        for (Ylesanded yl : kalender) {
            if (yl.getKuupäev().equals(kuupäev)) {
                System.out.println(yl);
                prinditi = true;
            }
        }
        if (!prinditi) System.out.println("Kuupäeval " + kuupäev + " ülesandeid ei ole!");
    }

    /**
     * Väljstame kõik antud aine ülesnded
     * @param kalender - ülesannete list
     * @param aine - õppeaine mille ülesandeid otsime ja väljastame
     */
    public static void ainejärgi(List<Ylesanded> kalender, String aine){
        boolean prinditi = false;
        if(aine.equals("1")){
            aine= "OOP";
        } else if (aine.equals("2")){
            aine= "Programmeerimine II";
        } else if (aine.equals("3")){
            aine= "Andmeturve";
        }else if (aine.equals("4")){
            aine= "Andmebaasid";
        }else if (aine.equals("5")){
            aine= "MMP";
        }
        for (Ylesanded yl : kalender) {
            if (yl.getAine().equals(aine)) {
                System.out.println(yl);
                prinditi = true;
            }
        }
        if (!prinditi) System.out.println("Antud aines ülesandeid ei ole!");
    }

    /**
     * Kasutades meetodit kuupäevajärgi() väljastame tsüklina mitme päeva ülesanded
     * @param kordused - mitme päeva ylesandeid väljastama hakkame
     * @param täna - võtab tänase kuupäeva, et sellest edasi ülesandeid väljastada
     * @param kalender - ülesannete list
     */
    public static void mitmepäevakaupa(int kordused, LocalDate täna, List<Ylesanded> kalender) {
        for (int i = 0; i < kordused; i++) {
            LocalDate kuupäev = täna.plusDays(i);
            kuupäevajärgi(kalender, kuupäev.toString());
        }
    }

    public static void suvaline(List<Ylesanded> kalender){
        int pikkus = kalender.size();
        int suvaline = (int) (Math.random()* pikkus);
        System.out.println(kalender.get(suvaline));
    }

    public static void lisa(List<Ylesanded> kalender, Scanner scanner){
        boolean üksi;
        System.out.println("Ülesande lisamine:");
        System.out.print("Sisesta ülesande nimi: ");
        String nimi = scanner.nextLine();
        System.out.print("Sisesta õppeaine: ");
        String aine = scanner.nextLine();
        System.out.print("Sisesta ülesande tähtaeg kujul 'YYYY-MM-DD':");
        String tähtaeg = scanner.nextLine();
        System.out.print("Kas ülesanne on individuaalne? (y/n)");
        String vastus = scanner.nextLine();
        if (vastus.equals("y")){
            üksi = true;}
        else {üksi = false;}
        Ylesanded yl = new Ylesanded(nimi, aine, tähtaeg, üksi);
        kalender.add(yl);
        System.out.println("Ülesanne lisatud!");
    }

    /**
     * Eemaldame ülesande kalendrist
     * @param kalender - ülesannete list
     * @param scanner - loeb kasutaja sisendit
     */
    public static void eemalda(List<Ylesanded> kalender, Scanner scanner){
        boolean leitud = false;
        System.out.println("Ülesande eemaldamine:");
        System.out.print("Sisesta ülesande nimi: ");
        String nimi = scanner.nextLine();
        System.out.print("Sisesta õppeaine: ");
        String aine = scanner.nextLine();
        System.out.print("Sisesta ülesande tähtaeg kujul 'YYYY-MM-DD':");
        String tähtaeg = scanner.nextLine();
        for (Ylesanded ylesanne : kalender) {
            if(ylesanne.getNimi().equals(nimi) && ylesanne.getAine().equals(aine) && ylesanne.getKuupäev().equals(tähtaeg)){
                kalender.remove(ylesanne);
                System.out.println("Ülesanne eemaldatud!");
            }

        }
        if(!leitud) System.out.println("Sellist ülesannet ei leitud.");
    }

    /**
     * Muudame kalendris ülesande kuupäeva
     * @param kalender - ülesannete list
     * @param scanner - loeb kasutaja sisendit
     */
    public static void muuda(List<Ylesanded> kalender, Scanner scanner){
        boolean leitud = false;
        System.out.println("Ülesande kuupäeva muutmine:");
        System.out.print("Sisesta ülesande nimi: ");
        String nimi = scanner.nextLine();
        System.out.print("Sisesta õppeaine: ");
        String aine = scanner.nextLine();
        System.out.print("Sisesta ülesande praegune tähtaeg kujul 'YYYY-MM-DD': ");
        String tähtaeg = scanner.nextLine();
        for (Ylesanded ylesanne : kalender) {
            if(ylesanne.getNimi().equals(nimi) && ylesanne.getAine().equals(aine) && ylesanne.getKuupäev().equals(tähtaeg)){
                System.out.print("Sisesta ülesande uus tähtaeg kujul 'YYYY-MM-DD': ");
                String uus = scanner.nextLine();
                ylesanne.setKuupäev(uus);
                System.out.println("Ülesanne muudetud!");
                leitud = true;
            }
        }
        if(!leitud) System.out.println("Sellist ülesannet ei leitud.");
    }


    public static void main(String[] args) {

        boolean jätka = true;
        LocalDate täna = LocalDate.now(); //YYYY-MM-DD

        Ylesanded yl1 = new Ylesanded("OOP projekt", "OOP", "2025-03-20", false);
        Ylesanded yl2 = new Ylesanded("Kontrolltöö", "Andmebaasid", "2025-03-11", true);
        Ylesanded yl3 = new Ylesanded("Kontrolltöö", "MMP", "2025-04-01", true);
        Ylesanded[] algne = {yl1, yl2, yl3};
        List<Ylesanded> kalender = new ArrayList<>(List.of(yl1, yl2, yl3));




        while (jätka) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("0 - Kuva kõik ülesanded.");
            System.out.println("1 - Kuva tänased ülesanded.");
            System.out.println("2 - Otsi ülesandeid kuupäeva järgi.");
            System.out.println("3 - Otsi ülesandeid õppeaine järgi.");
            System.out.println("4 - Kuva järgneva nädala ülesanded.");
            System.out.println("5 - Kuva järgneva kuu ülesanded.");
            System.out.println("6 - Anna juhuslik ülesanne.");
            System.out.println("7 - Lisa ülesanne");
            System.out.println("8 - Muuda ülesande kuupäeva.");
            System.out.println("9 - Eemalda ülesanne.");
            System.out.println("Lõpetamiseks sisesta 'lõpp'.");
            System.out.print("Sisesta toimingu number, mida soovid teostada: ");
            String sisend = scanner.nextLine();  // Loeme sisestatud rea


            if (sisend.equals("0")){
                for (Ylesanded ylesanded : kalender) {
                    System.out.println(ylesanded);
                }
            }
            else if (sisend.equals("1")) {
                kuupäevajärgi(kalender, täna.toString());}

            else if (sisend.equals("2")){
                System.out.print("Sisesta soovitud kuupäev kujul 'YYYY-MM-DD': ");
                String kuupäev = scanner.nextLine();
                kuupäevajärgi(kalender, kuupäev);
            }
            else if (sisend.equals("3")){
                System.out.println("Vali õppeaine:");
                System.out.println("1 - OOP");
                System.out.println("2 - Programmeerimine II");
                System.out.println("3 - Andmeturve");
                System.out.println("4 - Andmebaasid");
                System.out.println("5 - MMP");
                String õppeaine = scanner.nextLine();
                ainejärgi(kalender, õppeaine);
            }
            else if (sisend.equals("4")){
                mitmepäevakaupa(7, täna, kalender);
            }
            else if (sisend.equals("5")){
                mitmepäevakaupa(30, täna, kalender);
            }
            else if (sisend.equals("6")){
                suvaline(kalender);
            }
            else if (sisend.equals("7")){
                lisa(kalender, scanner);
            }
            else if (sisend.equals("8")){
                muuda(kalender, scanner);
            }
            else if (sisend.equals("9")){
                eemalda(kalender, scanner);
            }
            else if (sisend.equals("lõpp")){
                scanner.close();
                break;
            }

            System.out.println("Jätkamiseks vajuta ENTER! ");
            String edasi = scanner.nextLine();
            if (edasi !="") break;
        }
    }
}
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Random;


public class Main {
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

    public static void mitmepäevakaupa(int kordused, LocalDate täna, List<Ylesanded> kalender) {
        for (int i = 0; i < kordused; i++) {
            LocalDate kuupäev = täna.plusDays(i);
            kuupäevajärgi(kalender, kuupäev.toString());
        }
    }

    public static void suvaline(List<Ylesanded> kalender){
        int pikkus;
    }



    public static void main(String[] args) {

        boolean jätka = true;
        LocalDate täna = LocalDate.now(); //YYYY-MM-DD

        Ylesanded yl1 = new Ylesanded("OOP projekt", "OOP", "2025-03-20", false);
        Ylesanded yl2 = new Ylesanded("Kontrolltöö", "Andmebaasid", "2025-03-11", true);
        Ylesanded yl3 = new Ylesanded("Kontrolltöö", "MMP", "2025-04-01", true);
        Ylesanded[] algne = {yl1, yl2, yl3};
        List<Ylesanded> kalender = Arrays.asList(algne);
        for (Ylesanded ylesanded : kalender) {
            System.out.println(ylesanded);
        }



        while (jätka) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - Kuva tänased ülesanded.");
            System.out.println("2 - Otsi ülesandeid kuupäeva järgi.");
            System.out.println("3 - Otsi ülesandeid õppeaine järgi.");
            System.out.println("4 - Kuva järgneva nädala ülesanded.");
            System.out.println("5 - Kuva järgneva kuu ülesanded.");
            System.out.println("6 - Anna juhuslik ülesanne.");
            System.out.println("7 - Lisa ülesanne");
            System.out.println("8 - Muuda ülesannet.");
            System.out.println("9 - Eemalda ülesanne.");
            System.out.println("Lõpetamiseks sisesta 'lõpp'.");
            System.out.print("Sisesta toimingu number,mida soovid teostada: ");
            String sisend = scanner.nextLine();  // Loeme sisestatud rea


            if (sisend.equals("1")) {
                System.out.println("tsau");

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

            }
            else if (sisend.equals("7")){}
            else if (sisend.equals("8")){}
            else if (sisend.equals("9")){}
            else if (sisend.equals("lõpp")){
                scanner.close();
                break;
            }

            System.out.println("Jätkamiseks vajuta ENTER! ");
            String sisend = scanner.nextLine();
            if (sisend !="") break;
        }
    }
}
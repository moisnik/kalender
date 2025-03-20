import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void kuupäevajärgi(List<Ylesanded> kalender,  String kuupäev) {
        boolean prinditi = false;
        for (Ylesanded yl : kalender) {
            if (yl.getKuupäev().equals(kuupäev)) {
                System.out.println(yl);
                prinditi = true;
            }

        }
        if (!prinditi) System.out.println("Antud kuupäeval ülesandeid ei ole!");

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
            }
            else if (sisend.equals("4")){}
            else if (sisend.equals("5")){}
            else if (sisend.equals("6")){}
            else if (sisend.equals("7")){}
            else if (sisend.equals("8")){}
            else if (sisend.equals("9")){}
            else if (sisend.equals("lõpp")){
                scanner.close();
                break;

            }





        }

    }
}
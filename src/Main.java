import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void  kuupäevajärgi(ArrayList kalender; LocalDate kuupäev) {
        for (Ylesanded yl : kalender) {
            if (yl.getKuupäev.equals(kuupäev)) {
                System.out.println(yl.toString());
            }

        }

    }

    public static void main(String[] args) {

        boolean jätka = true;
        LocalDate täna = LocalDate.now(); //YYYY-MM-DD

        Ylesanded yl1 = Ylesanded("OOP projekt", "OOP", "2025-03-22", false);
        Ylesanded yl2 = Ylesanded("Kontrolltöö", "Andmebaasid", "2025-03-11", true);
        Ylesanded yl3 = Ylesanded("Kontrolltöö", "MMP", "2025-04-01", true);
        ArrayList<Ylesanded> kalender = [yl1, yl2, yl3];



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
            scanner.close();

            if (sisend.equals("1")) {
                kuupäevajärgi(täna);



        }

        }

    }
}
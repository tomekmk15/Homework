import java.util.Scanner;

public class SzewcProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj dzień tygodnia, w którym oddałeś buty (numer od 1 do 7): ");
        int dzienOddania = scanner.nextInt();

        System.out.print("Podaj ilość dni, przez ile trwa naprawa: ");
        int dniNaprawy = scanner.nextInt();

        int dzienOdbioru = (dzienOddania + dniNaprawy - 1) % 7; // Odejmujemy 1, ponieważ niedziela to dzień 7, a nie 0.

        System.out.println("Buty będą gotowe do odbioru w dniu (numer): " + (dzienOdbioru + 1));

        // Wersja z wypisaniem dnia tygodnia słownie
        String dzienTygodnia = null;
        switch (dzienOdbioru) {
            case 0:
                dzienTygodnia = "poniedziałek";
                break;
            case 1:
                dzienTygodnia = "wtorek";
                break;
            case 2:
                dzienTygodnia = "środa";
                break;
            case 3:
                dzienTygodnia = "czwartek";
                break;
            case 4:
                dzienTygodnia = "piątek";
                break;
            case 5:
                dzienTygodnia = "sobota";
                break;
            case 6:
                dzienTygodnia = "niedziela";
                break;
        }

        System.out.println("Buty będą gotowe do odbioru w dniu (słownie): " + dzienTygodnia);

        scanner.close();
    }
}

import jdk.jshell.SnippetEvent;

import java.util.Scanner;

public class ButyNaprawa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj numer dnia tygodnia w ktorym chesz oddac buty (  1 do 7):  ");
        int dziennOddania = scanner.nextInt();

        System.out.println("Ile bedzie trwala naprawa:  " );
        int iloscDniNaprawy = scanner.nextInt();

        int dzienOdbioru = (dziennOddania + iloscDniNaprawy -1)%7;

        System.out.println("Buty sa gotowe do odebrania " + (dzienOdbioru + 1));

        String  dzienTygodnia = null;
        switch (dzienOdbioru) {

            case 0:
                dzienTygodnia = "Monday";
                break;
            case 1:
                dzienTygodnia = "Tuesday";
                break;
            case 2:
                dzienTygodnia = "Wednesdsy";
                break;
            case 3:
                dzienTygodnia = "Thursdsy";
                break;
            case 4:
                dzienTygodnia = "Friday";
                break;
            case 5:
                dzienTygodnia = "Saturday";
                break;
            case 6:
                dzienTygodnia = "Sunday";

        }

        System.out.println("Buty sa gotowe do odebrania " + (dzienTygodnia));


        }



    }

